package cn.edu.ntu.jtxy.web.controller.wx;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.ntu.jtxy.core.model.wx.ImagesDo;
import cn.edu.ntu.jtxy.core.repository.wx.ImagesRepository;
import cn.edu.ntu.jtxy.core.repository.wx.cond.ImagesPageQueryCond;
import cn.edu.ntu.jtxy.core.repository.wx.model.UserInfo;
import cn.edu.ntu.jtxy.core.repository.wx.pagelist.PageList;
import cn.edu.ntu.jtxy.web.SystemConstants;
import cn.edu.ntu.jtxy.web.controller.wx.form.ImagesPageQueryForm;
import cn.edu.ntu.jtxy.web.filter.OperationContex;

/**
 * 上传作品列表
 * @author {jin.zhang@witontek.com}
 * @version $Id: UploadWorksController.java, v 0.1 2016年4月28日 下午1:37:48 {jin.zhang@witontek.com} Exp $
 */
@Controller
@RequestMapping(value = "worksList.htm")
public class WorksListController implements SystemConstants {
    /**  */
    private static final Logger logger          = LoggerFactory
                                                    .getLogger(WorksListController.class);

    private static final String page_works_list = "wx/worksList";

    @Autowired
    private ImagesRepository    imagesRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(ModelMap map, ImagesPageQueryForm imagesPageQueryForm,
                        HttpServletRequest request) {
        UserInfo userInfo = OperationContex.getCurrentuserinfo();
        logger.info("作品列表   doGet  userInfo={}", userInfo);
        this.doPost(map, imagesPageQueryForm, request);
        return page_works_list;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(ModelMap map, ImagesPageQueryForm imagesPageQueryForm,
                         HttpServletRequest request) {
        logger.info("作品查询  doPost");
        ImagesPageQueryCond cond = new ImagesPageQueryCond();
        cond.setCurrentPage(imagesPageQueryForm.getCurrentPage());
        cond.setPageSize(PAGE_SIZE);
        cond.setOrderType(ImagesPageQueryCond.OrderTypeEnum.amount.getCode());
        cond.setType(ImagesDo.TypeEnum.WORK.getCode());

        PageList<ImagesDo> pageList = imagesRepository.pageQuery(cond);
        List<ImagesDo> resultList = pageList.getResultList();
        if (!CollectionUtils.isEmpty(resultList)) {
            for (int i = 0; i < resultList.size(); i++) {
                String temp = getTempImageUrl(resultList.get(i), request);
                logger.info("图片临时文件为 url{}", temp);
                //修改路径为临时文件路径
                resultList.get(i).setUrl(temp);
            }
        }

        imagesPageQueryForm.setCurrentPage(pageList.getCurrentPage());
        imagesPageQueryForm.setPageNum(pageList.getPageNum());
        map.addAttribute("imagesPageQueryForm", imagesPageQueryForm);
        logger.info("作品查询 doPost 结果 pageList={}", pageList);
        map.addAttribute("pageList", pageList);

        return page_works_list;
    }

    private String getTempImageUrl(ImagesDo imagesDo, HttpServletRequest request) {

        String imageUrl = imagesDo.getUrl();
        if (StringUtils.isBlank(imageUrl)) {
            return null;
        }

        File logoFile = new File(imageUrl);
        if (logoFile.exists() && logoFile.canRead()) {

            String logoFileName = logoFile.getName();

            String tempViewPath = request.getSession().getServletContext()
                .getRealPath(File.separator + "upload");
            try {
                FileUtils.copyFile(logoFile, new File(tempViewPath, logoFileName));

                return request.getContextPath() + File.separator + "upload" + File.separator
                       + logoFileName;
            } catch (IOException e) {
                logger.error("", e);
            }
        }
        return null;
    }
}
