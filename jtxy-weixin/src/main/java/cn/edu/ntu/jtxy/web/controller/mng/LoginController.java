package cn.edu.ntu.jtxy.web.controller.mng;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.ntu.jtxy.core.model.wx.UserInfoDo;
import cn.edu.ntu.jtxy.core.model.wx.UserInfoDo.StatusEnum;
import cn.edu.ntu.jtxy.core.repository.UserInfoConvertor;
import cn.edu.ntu.jtxy.core.repository.wx.UserInfoRepository;
import cn.edu.ntu.jtxy.core.repository.wx.cond.UserInfoCond;
import cn.edu.ntu.jtxy.util.PwdUtils;
import cn.edu.ntu.jtxy.util.SessionUtil;
import cn.edu.ntu.jtxy.web.SystemConstants;
import cn.edu.ntu.jtxy.web.controller.mng.form.LoginForm;

/**
 * 
 * @author {jin.zhang@witontek.com}
 * @version $Id: LoginController.java, v 0.1 2016年4月18日 上午10:47:29 {jin.zhang@witontek.com} Exp $
 */
@Controller
@RequestMapping(value = "login.htm")
public class LoginController implements SystemConstants {

    private static final Logger logger     = LoggerFactory.getLogger(LoginController.class);

    private static String       page_index = "mng/index";

    private static String       page_menu  = "mng/menu";

    @Autowired
    private UserInfoRepository  userInfoRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String doGet() {
        logger.info("用户登录 doGet()");
        return page_index;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(LoginForm loginForm, ModelMap modelMap, HttpServletRequest request) {
        logger.info("用户登录 doPost  loginForm={} ", loginForm);

        String userName = loginForm.getLogonName();
        String password = loginForm.getPassword();
        String verifyCode = loginForm.getVerifyCode();

        String sessionVerifyCode = (String) SessionUtil.get(request, VERTFY_CODE);
        logger.info("正确的验证码是    sessionVerifyCode={}", sessionVerifyCode);
        if (!StringUtils.equalsIgnoreCase(verifyCode, sessionVerifyCode)) {
            modelMap.addAttribute("errorTips", "验证码错误");
            modelMap.addAttribute("loginForm", loginForm);
            return page_index;
        }

        UserInfoCond userInfoCond = new UserInfoCond();
        userInfoCond.setStuNo(userName);
        userInfoCond.setStatus(StatusEnum.ENABLE);
        List<UserInfoDo> list = userInfoRepository.getByCond(userInfoCond);
        if (CollectionUtils.isEmpty(list)) {
            logger.info("用户登录 失败 用户不存在  userInfoCond={} ", userInfoCond);
            modelMap.addAttribute("errorTips", "用户名不存在");
            modelMap.addAttribute("loginForm", loginForm);
            return page_index;
        }
        UserInfoDo userInfoDo = list.get(0);
        if (!StringUtils.equals(userInfoDo.getStatus(), UserInfoDo.StatusEnum.ENABLE.getCode())
            || !StringUtils.equals(userInfoDo.getUserType(),
                UserInfoDo.UserTypeEnum.ADMIN.getCode())) {
            logger.info("用户登录 失败  用户状态不可用或此用户非管理员  userInfoDo={} ", userInfoDo);
            modelMap.addAttribute("errorTips", "用户状态不可用或此用户非管理员");
            modelMap.addAttribute("loginForm", loginForm);
            return page_index;
        }

        String pwdHash = userInfoDo.getPwdHash();
        String pwdSalt = userInfoDo.getPwdSalt();
        String pwdHashTemp = PwdUtils.hashPassword(password, pwdSalt);
        if (!StringUtils.equals(pwdHash, pwdHashTemp)) {
            logger.info("用户登录 失败  密码错误  userInfoDo={} ", userInfoDo);
            modelMap.addAttribute("errorTips", "用户密码错误");
            modelMap.addAttribute("loginForm", loginForm);
            return page_index;
        }
        //登录成功
        SessionUtil.setUserInfo(request, UserInfoConvertor.getUserInfo(userInfoDo));
        return page_menu;
    }
}
