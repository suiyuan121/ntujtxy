package cn.edu.ntu.jtxy.core.component.wx.MsgExecutor.event;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.ntu.jtxy.core.component.wx.WeiXinUserComponent;
import cn.edu.ntu.jtxy.core.component.wx.MsgExecutor.WxEventMsgExecutor.WxEventTypeEnum;
import cn.edu.ntu.jtxy.core.component.wx.MsgExecutor.result.WxMsgResult;
import cn.edu.ntu.jtxy.core.component.wx.impl.WxMsgComponentImpl.WxMsgTypeEnum;

/**
 * 
 * @author {jin.zhang@witontek.com}
 * @version $Id: WxEventMsgExecutor.java, v 0.1 2016年4月15日 下午1:28:03 {jin.zhang@witontek.com} Exp $
 */
public class WxSubscribeEventMsgExecutor extends EventMsgExecutor {

    private static final Logger logger = LoggerFactory.getLogger(WxSubscribeEventMsgExecutor.class);

    @Autowired
    private WeiXinUserComponent weiXinUserComponent;

    private static final String hello  = "感谢关注！请点击菜单绑定学号！如出现学号不存在的情况，请务必联系我。微信：18362156503";

    @Override
    public WxMsgResult process(Map<String, String> xmlParams) {
        logger.info("微信订阅事件消息处理器   xmlParams={} ", xmlParams);

        String openId = xmlParams.get("FromUserName");
        //不用关心订阅结果
        weiXinUserComponent.subscribe(openId);

        WxMsgResult result = new WxMsgResult();
        result.setWxMsgType(WxMsgTypeEnum.EVENT);
        result.setContent(hello);
        return result;
    }

    /** 
     * @see cn.edu.ntu.jtxy.core.component.wx.MsgExecutor.WxMsgExecutor#getMsgType()
     */
    @Override
    public WxMsgTypeEnum getMsgType() {
        return WxMsgTypeEnum.EVENT;
    }

    /** 
     * @see cn.edu.ntu.jtxy.core.component.wx.MsgExecutor.event.EventMsgExecutor#getEventType()
     */
    public WxEventTypeEnum getEventType() {
        return WxEventTypeEnum.SUBSCRIBE;
    }
}
