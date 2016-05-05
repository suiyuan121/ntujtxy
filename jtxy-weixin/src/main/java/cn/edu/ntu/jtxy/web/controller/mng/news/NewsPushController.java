package cn.edu.ntu.jtxy.web.controller.mng.news;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.ntu.jtxy.biz.service.client.WxClient;
import cn.edu.ntu.jtxy.core.model.BaseResult;
import cn.edu.ntu.jtxy.core.model.mng.NewsDo;
import cn.edu.ntu.jtxy.core.model.wx.WeiXinUserDo.GroupIdEnum;
import cn.edu.ntu.jtxy.core.repository.mng.NewsRepository;
import cn.edu.ntu.jtxy.core.repository.mng.cond.NewsPageQueryCond;
import cn.edu.ntu.jtxy.core.repository.wx.pagelist.PageList;
import cn.edu.ntu.jtxy.web.SystemConstants;
import cn.edu.ntu.jtxy.web.controller.mng.form.NewsQueryForm;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: NewsPushController.java, v 0.1 2016年5月1日 下午6:38:59 zhangjinntu@163.com Exp $
 */
@Controller
@RequestMapping(value = "newsPush.htm")
public class NewsPushController implements SystemConstants {
    /**  */
    private static final Logger logger = LoggerFactory.getLogger(NewsPushController.class);

    private static final String page   = "mng/news/newsPush";

    @Autowired
    private NewsRepository      newsRepository;

    @Autowired
    private WxClient            wxClient;

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(NewsQueryForm newsQueryForm, ModelMap map) {
        logger.info("新闻推送doGet ");
        this.doPost(newsQueryForm, map);
        return page;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(NewsQueryForm newsQueryForm, ModelMap map) {
        logger.info("新闻信息 doPost queryStuInfoForm={}");
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

    @RequestMapping(method = RequestMethod.POST, params = "type=push")
    public String doPushNews(NewsQueryForm newsQueryForm, String year, String mediaId, ModelMap map) {
        logger.info("新闻推送  doPost year={},mediaId={}", year, mediaId);
        if (StringUtils.isBlank(mediaId)) {
            map.addAttribute("msg", "群发失败，请稍后再试！");
        } else {
            boolean is_to_all = false;
            //如果all，则群发
            if (GroupIdEnum.getByCode(year) == null) {
                is_to_all = true;
            }
            BaseResult result = wxClient.pushNews(is_to_all, year, mediaId);
            if (result.isSuccess()) {
                map.addAttribute("msg", "群发成功！");
            } else {
                //每天只能发送一次全发，否则返回45028
                if (StringUtils.equals(result.getCode(), "45028")) {
                    map.addAttribute("msg", "每日只能群发一次，今天次数已经用完！，请明天再试");
                } else {
                    map.addAttribute("msg", "系统异常，群发失败 ，请稍后重试！");
                }
            }
        }
        this.doPost(newsQueryForm, map);
        return page;
    }
}