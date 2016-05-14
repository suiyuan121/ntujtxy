package cn.edu.ntu.jtxy.web.controller.wx;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.ntu.jtxy.core.model.wx.ImagesDo;
import cn.edu.ntu.jtxy.core.repository.wx.ImagesRepository;
import cn.edu.ntu.jtxy.util.DateUtil;
import cn.edu.ntu.jtxy.web.SystemConstants;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: ShowWorksContentController.java, v 0.1 2016年5月12日 下午8:10:24 zhangjinntu@163.com Exp $
 */
@Controller
@RequestMapping(value = "showWorksContent.htm")
public class ShowWorksContentController implements SystemConstants {
    /**  */
    private static final Logger logger            = LoggerFactory
                                                      .getLogger(ShowWorksContentController.class);

    private static final String page_work_content = "wx/workContent";

    @Autowired
    private ImagesRepository    imagesRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(ModelMap map, int id, HttpServletRequest request) {
        logger.info("显示作品详情  doGet  id={}", id);
        ImagesDo imagesDo = imagesRepository.getById(id);
        if (imagesDo == null) {
            logger.warn("作品查看 异常");
        }
        imagesDo.setUrl(getTempImageUrl(imagesDo, request));
        map.addAttribute("imagesDo", imagesDo);
        map.addAttribute("date", DateUtil.getWebString(imagesDo.getCreateTime()));
        return page_work_content;
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
