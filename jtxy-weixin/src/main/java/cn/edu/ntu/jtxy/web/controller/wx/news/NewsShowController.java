package cn.edu.ntu.jtxy.web.controller.wx.news;

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
import cn.edu.ntu.jtxy.core.repository.wx.pagelist.PageList;
import cn.edu.ntu.jtxy.web.SystemConstants;
import cn.edu.ntu.jtxy.web.controller.mng.form.NewsQueryForm;

/**
 * 学院新闻展示
 * @author zhangjinntu@163.com
 * @version $Id: NewsShowController.java, v 0.1 2016年5月15日 上午11:26:15 zhangjinntu@163.com Exp $
 */
@Controller
@RequestMapping(value = "newsShow.htm")
public class NewsShowController implements SystemConstants {
    /**  */
    private static final Logger logger         = LoggerFactory.getLogger(NewsShowController.class);

    private static final String page_news_show = "wx/newsList";

    @Autowired
    private NewsRepository      newsRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(ModelMap map, NewsQueryForm newsQueryForm, HttpServletRequest request) {
        logger.info("新闻列表   doGet -newsQueryForm={}", newsQueryForm);
        this.doPost(map, newsQueryForm, request);
        return page_news_show;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(ModelMap map, NewsQueryForm newsQueryForm, HttpServletRequest request) {
        logger.info("新闻列表 doPost  newsQueryForm={}", newsQueryForm);
        NewsDo.NewsTypeEnum newsTypeEnum = NewsDo.NewsTypeEnum.getByCode(newsQueryForm.getType());

        NewsPageQueryCond cond = new NewsPageQueryCond();
        cond.setCurrentPage(newsQueryForm.getCurrentPage());
        cond.setPageSize(PAGE_SIZE);
        cond.setType(newsTypeEnum == null ? NewsDo.NewsTypeEnum.其他种类.getCode() : newsTypeEnum
            .getCode());

        PageList<NewsDo> pageList = newsRepository.pageQueryAll(cond);
        logger.info("新闻列表 doPost结果   pageList={}", pageList);

        List<NewsDo> list = pageList.getResultList();
        if (!CollectionUtils.isEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                //讲存储在磁盘上的文件转成临时文件目录
                list.get(i)
                    .setThumbMediaId(getTempImageUrl(list.get(i).getThumbMediaId(), request));
            }
        }
        //防止页数大于总页数的时候出现
        newsQueryForm.setCurrentPage(pageList.getCurrentPage());
        newsQueryForm.setPageNum(pageList.getPageNum());
        map.addAttribute("newsQueryForm", newsQueryForm);
        map.addAttribute("pageList", pageList);

        return page_news_show;
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
