package cn.edu.ntu.jtxy.web.controller.wx;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.ntu.jtxy.biz.service.ResourceService;
import cn.edu.ntu.jtxy.core.component.wx.ImagesComponent;
import cn.edu.ntu.jtxy.core.model.BaseResult;
import cn.edu.ntu.jtxy.core.model.wx.ImagesDo;
import cn.edu.ntu.jtxy.core.repository.wx.ImagesRepository;
import cn.edu.ntu.jtxy.core.repository.wx.UserInfoRepository;
import cn.edu.ntu.jtxy.core.repository.wx.WeiXinUserRepository;
import cn.edu.ntu.jtxy.core.repository.wx.model.UserInfo;
import cn.edu.ntu.jtxy.util.DateUtil;
import cn.edu.ntu.jtxy.web.SystemConstants;
import cn.edu.ntu.jtxy.web.filter.OperationContex;

/**
 * 上传作品
 * @author {jin.zhang@witontek.com}
 * @version $Id: UploadWorksController.java, v 0.1 2016年4月28日 下午1:37:48 {jin.zhang@witontek.com} Exp $
 */
@Controller
@RequestMapping(value = "uploadWorks.htm")
public class UploadWorksController implements SystemConstants {
    /**  */
    private static final Logger  logger            = LoggerFactory
                                                       .getLogger(UploadWorksController.class);

    private static final String  page_upload_works = "uploadWorks";

    private static final String  works_list_htm    = "worksList.htm";

    @Autowired
    private WeiXinUserRepository weiXinUserRepository;

    @Autowired
    private UserInfoRepository   userInfoRepository;

    @Autowired
    private ImagesRepository     imagesRepository;

    @Autowired
    private ResourceService      resourceService;

    @Autowired
    private ImagesComponent      imagesComponent;

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(ModelMap map, HttpServletRequest request) {
        UserInfo userInfo = OperationContex.getCurrentuserinfo();
        logger.info("上传作品    doGet  userInfo={}", userInfo);

        return page_upload_works;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(@RequestParam(value = "uploadFile", required = false) MultipartFile uploadFile,
                         String workName, String workDesc, ModelMap map, HttpServletRequest request)
                                                                                                    throws IOException {
        logger.info("上传作品    workName={},  workDesc={}", workName, workDesc);
        String uid = OperationContex.getUid();

        String dateOfMonthString = DateUtil.formatMonth(new Date(System.currentTimeMillis()));
        //文件名
        String fileName = uploadFile.getOriginalFilename();
        String fileExtension = fileName.substring(fileName.lastIndexOf(".")); //文件扩展名
        //example: uid_{uuid}.jpg
        String savedFileName = uid + "_" + UUID.randomUUID().toString() + fileExtension;
        //文件夹地址
        String imagePath = resourceService.getImagePath().getURL().getPath();
        String fileLocation = imagePath + dateOfMonthString;

        // save it
        long fileSize = writeToFile(uploadFile.getInputStream(), fileLocation, savedFileName,
            file_size);
        if (fileSize == -1) {
            logger.info("图片新增失败  -超过最大尺寸");
            // delete the file
            new File(fileLocation, savedFileName).delete();
            map.addAttribute("errMsg", "文件尺寸过大");
            return page_upload_works;
        }

        String url = fileLocation + File.separatorChar + savedFileName;
        ImagesDo imagesDo = new ImagesDo();
        imagesDo.setType(ImagesDo.TypeEnum.WORK.getCode());
        imagesDo.setUid(uid);
        imagesDo.setUrl(url);
        imagesDo.setWorkDesc(workDesc);
        imagesDo.setWorkName(workName);
        imagesDo.setMemo("add");
        BaseResult result = imagesComponent.addImage(imagesDo);

        if (!result.isSuccess()) {
            logger.info("上传作品失败   msg+={}", result.getErrMsg());
            return ERROR_PAGE;
        }
        map.addAttribute("errMsg", "上传成功！");
        return "redirect:/" + works_list_htm;
    }

    private long writeToFile(InputStream uploadedInputStream, String fileLocation, String fileName,
                             long maxSize) {
        logger.info(" fileLocation=%s,fileName=%s", fileLocation, fileName);
        long fileSize = 0;

        try {
            File file = new File(fileLocation);
            logger.info("文件是否存在  ={}", file.exists());
            //不存在该文件夹就新建
            if (!file.exists()) {
                file.mkdir();
            }
            int read = 0;
            byte[] bytes = new byte[4096];

            OutputStream out = new FileOutputStream(new File(file, fileName));
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
                fileSize += read;
                if (fileSize > maxSize) {
                    fileSize = -1;
                    break;
                }
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            logger.error(
                String.format("复制文件失败  fileLocation={}，fileName={}", fileLocation, fileName), e);
            return -2;
        }
        return fileSize;
    }
}
