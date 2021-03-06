/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package cn.edu.ntu.jtxy.web.controller.wx;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.ntu.jtxy.core.model.wx.RefreshTokenDo;
import cn.edu.ntu.jtxy.core.repository.wx.RefreshTokenRepository;
import cn.edu.ntu.jtxy.core.repository.wx.WxAppConfigRepository;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

@Controller
@RequestMapping("/wx/menu/init.json")
public class WxMenuInitController {
    /**
    * Logger for this class
    */
    private static final Logger    logger      = LoggerFactory
                                                   .getLogger(WxMenuInitController.class);

    public static final String     EMPTY_STR   = "{}";

    public static final String     serverUrl   = "http://www.ntujtxy.top/ntujtxy";

    private static final String    history_url = "http://mp.weixin.qq.com/mp/getmasssendmsg?__biz=MzI4NTAzMTg0NQ==#wechat_webview_type=1&wechat_redirect";

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Autowired
    private WxAppConfigRepository  wxAppConfigRepository;

    /**
     * 
     * @param modelMap
     * @param type
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String doGet(ModelMap modelMap, String type, String password) {
        logger.info("type={}", type);
        if (StringUtils.equals("query", type)) {
            return query();
        } else if (StringUtils.equals("create", type)) {
            return create();
        } else if (StringUtils.equals("delete", type)) {
            if (StringUtils.equals("ntujtxywx", password)) {
                return delete();
            }
        } else if (StringUtils.equals("update", type)) {
            logger.info("del={}", delete());
            return create();
        }
        return EMPTY_STR;
    }

    /**
     * 
     * @return
     */
    private String query() {
        try {

            String appId = wxAppConfigRepository.getDefault().getAppId();
            RefreshTokenDo refreshTokenDo = refreshTokenRepository.getLastRecord(appId);

            String url = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=%s";
            Client c = Client.create();
            WebResource r = c.resource(String.format(url, refreshTokenDo.getAccessToken()));
            String restResult = r.get(String.class);

            logger.info("{}", restResult);
            return restResult;
        } catch (Exception e) {
            logger.error("", e);
            return EMPTY_STR;
        }
    }

    private String create() {
        try {

            JSONObject menu = new JSONObject();
            List<JSONObject> buttons = new ArrayList<JSONObject>();

            JSONObject button_1 = new JSONObject();
            {
                button_1.put("name", "新闻资讯");
                JSONObject sub_button_1 = new JSONObject();
                {
                    sub_button_1.put("type", "view");
                    sub_button_1.put("name", "群发通知");
                    sub_button_1.put("url", history_url);
                }
                JSONObject sub_button_2 = new JSONObject();
                {
                    sub_button_2.put("type", "view");
                    sub_button_2.put("name", "学院新闻");
                    sub_button_2.put("url", serverUrl + "/newsShow.htm?type=xyxw");
                }
                JSONObject sub_button_3 = new JSONObject();
                {
                    sub_button_3.put("type", "view");
                    sub_button_3.put("name", "通知公告");
                    sub_button_3.put("url", serverUrl + "/newsShow.htm?type=tzgg");
                }
                JSONObject sub_button_4 = new JSONObject();
                {
                    sub_button_4.put("type", "view");
                    sub_button_4.put("name", "学工动态");
                    sub_button_4.put("url", serverUrl + "/newsShow.htm?type=xgdt");
                }
                JSONObject sub_button_5 = new JSONObject();
                {
                    sub_button_5.put("type", "view");
                    sub_button_5.put("name", "教务信息");
                    sub_button_5.put("url", serverUrl + "/newsShow.htm?type=jwxx");
                }

                List<JSONObject> sub_buttons = new ArrayList<JSONObject>();
                sub_buttons.add(sub_button_1);
                sub_buttons.add(sub_button_2);
                sub_buttons.add(sub_button_3);
                sub_buttons.add(sub_button_4);
                sub_buttons.add(sub_button_5);
                button_1.put("sub_button", sub_buttons);
            }

            JSONObject button_2 = new JSONObject();
            {
                button_2.put("name", "娱乐互动");
                JSONObject sub_button_1 = new JSONObject();
                {
                    sub_button_1.put("type", "view");
                    sub_button_1.put("name", "幸运抽奖");
                    sub_button_1.put("url", serverUrl + "/lottery.htm?scopeType=full");
                }
                JSONObject sub_button_2 = new JSONObject();
                {
                    sub_button_2.put("type", "view");
                    sub_button_2.put("name", "每日一题");
                    sub_button_2.put("url", serverUrl + "/daliyQuestionShow.htm?scopeType=full");
                }
                JSONObject sub_button_3 = new JSONObject();
                {
                    sub_button_3.put("type", "view");
                    sub_button_3.put("name", "积分排行");
                    sub_button_3.put("url", serverUrl + "/pointSort.htm?scopeType=full");
                }

                JSONObject sub_button_4 = new JSONObject();
                {
                    sub_button_4.put("type", "view");
                    sub_button_4.put("name", "点赞作品");
                    sub_button_4.put("url", serverUrl + "/worksList.htm?scopeType=full");
                }
                JSONObject sub_button_5 = new JSONObject();
                {
                    sub_button_5.put("type", "view");
                    sub_button_5.put("name", "上传作品");
                    sub_button_5.put("url", serverUrl + "/uploadWorks.htm?scopeType=full");
                }

                List<JSONObject> sub_buttons = new ArrayList<JSONObject>();
                sub_buttons.add(sub_button_1);
                sub_buttons.add(sub_button_2);
                sub_buttons.add(sub_button_3);
                sub_buttons.add(sub_button_4);
                sub_buttons.add(sub_button_5);
                button_2.put("sub_button", sub_buttons);
            }
            JSONObject button_3 = new JSONObject();
            {
                button_3.put("name", "个人中心");
                JSONObject sub_button_1 = new JSONObject();
                {
                    sub_button_1.put("type", "view");
                    sub_button_1.put("name", "个人信息");
                    sub_button_1.put("url", serverUrl + "/userInfo.htm?scopeType=full");
                }
                JSONObject sub_button_3 = new JSONObject();
                {
                    sub_button_3.put("type", "view");
                    sub_button_3.put("name", "解绑学号");
                    sub_button_3.put("url", serverUrl + "/unBind.htm?scopeType=full");
                }
                JSONObject sub_button_4 = new JSONObject();
                {
                    sub_button_4.put("type", "click");
                    sub_button_4.put("name", "问题反馈");
                    sub_button_4.put("key", "feedBack");
                }

                List<JSONObject> sub_buttons = new ArrayList<JSONObject>();
                sub_buttons.add(sub_button_1);
                sub_buttons.add(sub_button_3);
                sub_buttons.add(sub_button_4);
                //                sub_buttons.add(sub_button_3);
                //                sub_buttons.add(sub_button_4);
                //                sub_buttons.add(sub_button_5);
                button_3.put("sub_button", sub_buttons);
            }

            buttons.add(button_1);
            buttons.add(button_2);
            buttons.add(button_3);
            menu.put("button", buttons);

            logger.info("menu={}", menu.toString());

            // --------

            String appId = wxAppConfigRepository.getDefault().getAppId();
            RefreshTokenDo refreshTokenDo = refreshTokenRepository.getLastRecord(appId);

            String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=%s";
            Client c = Client.create();

            WebResource r = c.resource(String.format(url, refreshTokenDo.getAccessToken()));

            String restResult = r.entity(menu.toString(), MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON).post(String.class);
            logger.info("{}", restResult);

            return restResult;
        } catch (Exception e) {
            logger.error("", e);
            return EMPTY_STR;
        }
    }

    public String delete() {
        try {
            String appId = wxAppConfigRepository.getDefault().getAppId();
            RefreshTokenDo refreshTokenDo = refreshTokenRepository.getLastRecord(appId);
            String url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=%s";

            Client c = Client.create();
            WebResource r = c.resource(String.format(url, refreshTokenDo.getAccessToken()));
            String restResult = r.get(String.class);

            logger.warn("deleteResult = {}", restResult);
            return restResult;
        } catch (Exception e) {
            logger.error("", e);
            return EMPTY_STR;
        }
    }
}
