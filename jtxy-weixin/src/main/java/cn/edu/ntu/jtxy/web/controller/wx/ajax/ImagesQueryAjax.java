package cn.edu.ntu.jtxy.web.controller.wx.ajax;

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
import cn.edu.ntu.jtxy.core.repository.wx.pagelist.PageList;
import cn.edu.ntu.jtxy.web.SystemConstants;
import cn.edu.ntu.jtxy.web.controller.wx.ajax.response.ImagesQueryAjaxResponse;
import cn.edu.ntu.jtxy.web.controller.wx.form.ImagesPageQueryForm;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: ImagesQueryAjax.java, v 0.1 2016年5月12日 上午10:17:15 zhangjinntu@163.com Exp $
 */
@Controller
@RequestMapping(value = "imagesQuery.json")
public class ImagesQueryAjax implements SystemConstants {
    /**  */
    private static final Logger logger = LoggerFactory.getLogger(ImagesQueryAjax.class);

    @Autowired
    private ImagesRepository    imagesRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ImagesQueryAjaxResponse doGet(ModelMap map, ImagesPageQueryForm imagesPageQueryForm,
                                         HttpServletRequest request) {
        logger.info("作品查询  doPost   imagesPageQueryForm={}", imagesPageQueryForm);

        ImagesQueryAjaxResponse ajaxResponse = new ImagesQueryAjaxResponse();

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

        logger.info("作品查询 doPost 结果 pageList={}", pageList);
        map.addAttribute("pageList", pageList);

        imagesPageQueryForm.setCurrentPage(pageList.getCurrentPage());
        imagesPageQueryForm.setPageNum(pageList.getPageNum());
        logger.info("积分排行 doPost 结果 pageList={}", pageList);

        map.addAttribute("imagesPageQueryForm", imagesPageQueryForm);
        ajaxResponse.setList(pageList.getResultList());
        return ajaxResponse;
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
