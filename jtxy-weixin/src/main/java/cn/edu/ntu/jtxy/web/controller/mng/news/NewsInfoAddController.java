package cn.edu.ntu.jtxy.web.controller.mng.news;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.ntu.jtxy.core.repository.wx.StudentInfoRepository;

/**
 * 
 * @author {jin.zhang@witontek.com}
 * @version $Id: NewsInfoAddController.java, v 0.1 2016年4月29日 下午2:02:24 {jin.zhang@witontek.com} Exp $
 */
@Controller
@RequestMapping(value = "newsInfoAdd.htm")
public class NewsInfoAddController {
    /**  */
    private static final Logger   logger = LoggerFactory.getLogger(NewsInfoAddController.class);

    private static final String   page   = "mng/news/newsInfoAdd";

    @Autowired
    private StudentInfoRepository studentInfoRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String doGet() {
        logger.info("新闻信息新增  doGet  ");

        return page;
    }

}