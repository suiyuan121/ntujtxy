package cn.edu.ntu.jtxy.web.controller.wx;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.ntu.jtxy.core.repository.UserInfoFull;
import cn.edu.ntu.jtxy.core.repository.wx.PointRepository;
import cn.edu.ntu.jtxy.core.repository.wx.UserInfoRepository;
import cn.edu.ntu.jtxy.core.repository.wx.cond.UserInfoCond;
import cn.edu.ntu.jtxy.web.SystemConstants;
import cn.edu.ntu.jtxy.web.filter.OperationContex;

/**
 * 用户信息
 * @author {jin.zhang@witontek.com}
 * @version $Id: UserInfoController.java, v 0.1 2016年4月25日 上午11:12:40 {jin.zhang@witontek.com} Exp $
 */
@Controller
@RequestMapping(value = "userInfo.htm")
public class UserInfoController implements SystemConstants {
    /**  */
    private static final Logger logger        = LoggerFactory.getLogger(UserInfoController.class);

    private static final String page_userInfo = "userInfoDetail";

    @Autowired
    private UserInfoRepository  userInfoRepository;

    @Autowired
    private PointRepository     pointRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(ModelMap map) {
        logger.info("用户信息   doGet  ");
        String uid = OperationContex.getUid();
        //        String uid = "103040000000017";
        UserInfoCond cond = new UserInfoCond();
        cond.setUid(uid);
        List<UserInfoFull> list = userInfoRepository.getAllUserInfoByCond(cond);
        if (CollectionUtils.isEmpty(list)) {
            return ERROR_PAGE;
        }

        int totalPoint = pointRepository.getTotalByUid(uid);

        map.addAttribute("userInfoFull", list.get(0));
        map.addAttribute("totalPoint", totalPoint);
        return page_userInfo;
    }
}
