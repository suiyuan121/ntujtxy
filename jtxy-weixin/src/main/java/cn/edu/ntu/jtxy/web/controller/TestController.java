package cn.edu.ntu.jtxy.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.ntu.jtxy.web.SystemConstants;

/**
 * 测试
 * @author zhangjinntu@163.com
 * @version $Id: TestController.java, v 0.1 2016年5月13日 下午5:57:16 zhangjinntu@163.com Exp $
 */
@Controller
@RequestMapping(value = "test.htm")
public class TestController implements SystemConstants {
    /**  */
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    private static final String test   = "test";

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(ModelMap map) {
        logger.info("测试   ");
        return test;
    }
}
