package cn.edu.ntu.jtxy.web.controller.mng.news;

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
import cn.edu.ntu.jtxy.core.model.wx.StudentInfoDo.GradeTypeEnum;
import cn.edu.ntu.jtxy.core.model.wx.WeiXinUserDo.GroupIdEnum;
import cn.edu.ntu.jtxy.web.SystemConstants;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: TextPushController.java, v 0.1 2016年5月4日 下午12:54:53 zhangjinntu@163.com Exp $
 */
@Controller
@RequestMapping(value = "textPush.htm")
public class TextPushController implements SystemConstants {
    /**  */
    private static final Logger logger = LoggerFactory.getLogger(TextPushController.class);

    private static final String page   = "mng/news/textPush";

    @Autowired
    private WxClient            wxClient;

    @RequestMapping(method = RequestMethod.GET)
    public String doGet() {
        logger.info("文本推送doGet ");
        return page;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(String year, String content, ModelMap map) {
        logger.info("文本推送  doPost year={},content={},", year, content);
        if (StringUtils.isBlank(content)) {
            map.addAttribute("msg", "文本内容不能为空");
        } else {
            boolean is_to_all = false;
            //如果all，则群发
            if (GradeTypeEnum.getByCode(year) == null) {
                is_to_all = true;
            }
            String group_id = getGroupId(GradeTypeEnum.getByCode(year));
            BaseResult result = wxClient.pushText(is_to_all, group_id, content);
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
        return page;
    }

    private String getGroupId(GradeTypeEnum grade) {
        if (grade == null) {
            return null;
        }
        switch (grade) {
            case year_12:
                return GroupIdEnum.year_12.getCode();
            case year_13:
                return GroupIdEnum.year_13.getCode();
            case year_14:
                return GroupIdEnum.year_14.getCode();
            case year_15:
                return GroupIdEnum.year_15.getCode();
            case year_16:
                return GroupIdEnum.year_16.getCode();
            case graduation:
                return GroupIdEnum.graduation.getCode();
            default:
                return null;
        }
    }
}