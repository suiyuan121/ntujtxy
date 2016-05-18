/**
 * Witontek.com.
 * Copyright (c) 2012-2014 All Rights Reserved.
 */
package cn.edu.ntu.jtxy.web.controller.mng;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.ntu.jtxy.web.SystemConstants;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: LogoutContoller.java, v 0.1 2014年9月23日 下午2:34:12 song.li@witontek.com Exp $
 */
@Controller
@RequestMapping("/logout.htm")
public class LogoutController implements SystemConstants {
    /**
    * Logger for this class
    */
    private static final Logger logger     = LoggerFactory.getLogger(LogoutController.class);

    private static final String page_index = "mng/index";

    @RequestMapping(method = RequestMethod.GET)
    public String logout(ModelMap modelMap, HttpServletRequest request) {
        logger.info("登出");
        request.getSession().removeAttribute(USER_INFO);
        request.getSession().removeAttribute(UID);
        return page_index;
    }
}
