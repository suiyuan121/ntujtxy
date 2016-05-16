package cn.edu.ntu.jtxy.web.controller.wx.ajax;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.ntu.jtxy.core.repository.mng.NewsRepository;
import cn.edu.ntu.jtxy.web.SystemConstants;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: AddViewCountAjax.java, v 0.1 2016年5月16日 下午1:07:29 zhangjinntu@163.com Exp $
 */
@Controller
@RequestMapping(value = "addViewCount.json")
public class AddViewCountAjax implements SystemConstants {
    /**  */
    private static final Logger logger = LoggerFactory.getLogger(AddViewCountAjax.class);

    @Autowired
    private NewsRepository      newsRepository;

    @RequestMapping(method = RequestMethod.GET)
    public void doGet(int id) {
        logger.info("浏览量增加    id={}", id);

        boolean ret = newsRepository.updateViewCountById(id);
        logger.info("增加浏览量结果  id={},ret={}", id, ret);
    }
}
