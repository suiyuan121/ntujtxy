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

import cn.edu.ntu.jtxy.core.model.mng.NewsDo;
import cn.edu.ntu.jtxy.core.repository.mng.NewsRepository;
import cn.edu.ntu.jtxy.core.repository.mng.cond.NewsPageQueryCond;
import cn.edu.ntu.jtxy.core.repository.wx.ImagesRepository;
import cn.edu.ntu.jtxy.core.repository.wx.pagelist.PageList;
import cn.edu.ntu.jtxy.web.SystemConstants;
import cn.edu.ntu.jtxy.web.controller.mng.form.NewsQueryForm;
import cn.edu.ntu.jtxy.web.controller.wx.ajax.response.NewsQueryAjaxResponse;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: NewsQueryAjax.java, v 0.1 2016年5月15日 下午2:51:16 zhangjinntu@163.com Exp $
 */
@Controller
@RequestMapping(value = "newsQuery.json")
public class NewsQueryAjax implements SystemConstants {
    /**  */
    private static final Logger logger = LoggerFactory.getLogger(NewsQueryAjax.class);

    @Autowired
    private ImagesRepository    imagesRepository;

    @Autowired
    private NewsRepository      newsRepository;

    @RequestMapping(method = RequestMethod.GET)
    public NewsQueryAjaxResponse doGet(ModelMap map, NewsQueryForm newsQueryForm,
                                       HttpServletRequest request) {
        logger.info("新闻查询  doPost   newsQueryForm={}", newsQueryForm);
        NewsDo.NewsTypeEnum newsTypeEnum = NewsDo.NewsTypeEnum.getByCode(newsQueryForm.getType());
        NewsQueryAjaxResponse ajaxResponse = new NewsQueryAjaxResponse();

        NewsPageQueryCond cond = new NewsPageQueryCond();
        cond.setCurrentPage(newsQueryForm.getCurrentPage());
        cond.setPageSize(PAGE_SIZE);
        cond.setType(newsTypeEnum == null ? NewsDo.NewsTypeEnum.其他种类.getCode() : newsTypeEnum
            .getCode());

        PageList<NewsDo> pageList = newsRepository.pageQueryAll(cond);
        List<NewsDo> list = pageList.getResultList();
        if (!CollectionUtils.isEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                //讲存储在磁盘上的文件转成临时文件目录
                list.get(i)
                    .setThumbMediaId(getTempImageUrl(list.get(i).getThumbMediaId(), request));
            }
        }
        map.addAttribute("pageList", pageList);

        newsQueryForm.setCurrentPage(pageList.getCurrentPage());
        newsQueryForm.setPageNum(pageList.getPageNum());
        logger.info("积分排行 doPost 结果 pageList={}", pageList);

        map.addAttribute("newsQueryForm", newsQueryForm);
        ajaxResponse.setList(pageList.getResultList());
        return ajaxResponse;
    }

    private String getTempImageUrl(String iamgePath, HttpServletRequest request) {

        if (StringUtils.isBlank(iamgePath)) {
            return null;
        }

        File logoFile = new File(iamgePath);
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
