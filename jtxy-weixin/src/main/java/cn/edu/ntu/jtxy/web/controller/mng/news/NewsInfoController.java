package cn.edu.ntu.jtxy.web.controller.mng.news;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.ntu.jtxy.core.model.mng.NewsDo;
import cn.edu.ntu.jtxy.core.repository.mng.NewsRepository;
import cn.edu.ntu.jtxy.core.repository.mng.cond.NewsPageQueryCond;
import cn.edu.ntu.jtxy.core.repository.wx.pagelist.PageList;
import cn.edu.ntu.jtxy.web.SystemConstants;
import cn.edu.ntu.jtxy.web.controller.mng.form.NewsQueryForm;

/**
 * 
 * @author {jin.zhang@witontek.com}
 * @version $Id: NewsInfoController.java, v 0.1 2016年4月29日 下午1:57:42 {jin.zhang@witontek.com} Exp $
 */
@Controller
@RequestMapping(value = "newsInfo.htm")
public class NewsInfoController implements SystemConstants {
    /**  */
    private static final Logger logger = LoggerFactory.getLogger(NewsInfoController.class);

    private static final String page   = "mng/news/newsInfo";

    @Autowired
    private NewsRepository      newsRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(NewsQueryForm newsQueryForm, ModelMap map) {
        logger.info("新闻信息 doGet  queryForm={}", newsQueryForm);
        doPost(newsQueryForm, map);
        return page;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(NewsQueryForm newsQueryForm, ModelMap map) {
        logger.info("用户信息 doPost queryStuInfoForm={}");

        NewsPageQueryCond cond = new NewsPageQueryCond();
        cond.setCurrentPage(newsQueryForm.getCurrentPage());
        cond.setTitle(newsQueryForm.getTitle());
        cond.setPageSize(PAGE_SIZE);

        PageList<String> pageList = newsRepository.pageQuery(cond);
        logger.info("用户信息 doPost 结果 pageList={}", pageList);

        List<String> listMediaId = pageList.getResultList();
        Map<String, List<NewsDo>> resultMap = new HashMap<String, List<NewsDo>>();
        for (String item : listMediaId) {
            resultMap.put(item, newsRepository.getByMediaId(item));
        }
        //防止页数大于总页数的时候出现
        newsQueryForm.setCurrentPage(pageList.getCurrentPage());
        map.addAttribute("newsQueryForm", newsQueryForm);
        map.addAttribute("pageList", pageList);
        map.addAttribute("resultMap", resultMap);

        return page;
    }
}