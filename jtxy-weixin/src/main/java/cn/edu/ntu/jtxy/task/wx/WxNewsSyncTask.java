package cn.edu.ntu.jtxy.task.wx;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import cn.edu.ntu.jtxy.biz.service.client.WxClient;
import cn.edu.ntu.jtxy.biz.service.client.model.wx.NewsInfo;
import cn.edu.ntu.jtxy.biz.service.client.result.GetImageResult;
import cn.edu.ntu.jtxy.biz.service.client.result.QueryNewsResult;
import cn.edu.ntu.jtxy.core.model.mng.NewsDo;
import cn.edu.ntu.jtxy.core.model.mng.NewsDo.NewsTypeEnum;
import cn.edu.ntu.jtxy.core.model.wx.AppConfig;
import cn.edu.ntu.jtxy.core.repository.mng.NewsRepository;
import cn.edu.ntu.jtxy.core.repository.wx.RefreshTokenRepository;
import cn.edu.ntu.jtxy.core.repository.wx.WxAppConfigRepository;
import cn.edu.ntu.jtxy.task.Task;

/**
 * 同步微信素材定时任务
 * @author {jin.zhang@witontek.com}
 * @version $Id: WxNewsSyncTask.java, v 0.1 2016年4月29日 下午3:36:59 {jin.zhang@witontek.com} Exp $
 */
public class WxNewsSyncTask implements Task {

    /**  */
    private static final Logger    logger = LoggerFactory.getLogger(WxNewsSyncTask.class);

    private static int             offset = 0;

    private static int             count  = 5;

    @Autowired
    private WxClient               wxClient;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Autowired
    private WxAppConfigRepository  wxAppConfigRepository;

    @Autowired
    private NewsRepository         newsRepository;

    @Override
    public void execute() {
        logger.info("微信图文同步  start.......");

        AppConfig appConfig = wxAppConfigRepository.getDefault();
        if (appConfig == null) {
            logger.warn("微信刷新token 获取微信配置信息失败");
            return;
        }
        //每次同步前五个，最新的五个
        QueryNewsResult result = wxClient.getLatestNews(offset, count);
        logger.info("微信图文查询结果   result={}", result);
        if (!result.isSuccess()) {
            return;
        }
        Map<String, List<NewsInfo>> map = result.getNews();
        if (CollectionUtils.isEmpty(map)) {
            return;
        }

        Set<String> sets = map.keySet();
        logger.info("微信图文同步   sets={}", sets);
        for (String item : sets) {
            List<NewsDo> list = newsRepository.getByMediaId(item);
            List<NewsInfo> infos = map.get(item);
            logger.info("微信图文同步   list.size={}，infos.size={}", list.size(), infos.size());

            //如果数据库存在，并且图文个数没有变化，则不更新了
            if (!CollectionUtils.isEmpty(list) && list.size() == infos.size()) {
                continue;
            }
            //增加
            for (NewsInfo news : infos) {

                //这里作者表示类型
                NewsTypeEnum newsTypeEnum = NewsDo.NewsTypeEnum.getByCode(StringUtils
                    .trimWhitespace(news.getAuthor()));

                String thumb_media_id = news.getThumb_media_id();
                GetImageResult imageResult = wxClient.getImage(thumb_media_id);

                if (imageResult.isSuccess()) {

                    NewsDo newsDo = new NewsDo();
                    newsDo.setMedia_id(item);
                    newsDo.setAuthor(news.getAuthor());
                    newsDo.setDigest(news.getDigest());
                    newsDo.setTitle(news.getTitle());
                    newsDo.setUpdateTime(news.getUpdate_time());
                    newsDo.setUrl(news.getUrl());
                    newsDo.setThumbMediaId(imageResult.getImagePath());
                    newsDo.setType(newsTypeEnum == null ? NewsDo.NewsTypeEnum.其他种类.getCode()
                        : newsTypeEnum.getCode());
                    newsRepository.add(newsDo);
                } else {
                    logger.info("微信图文同步出错  imageResult={}   ", imageResult);
                }
            }

        }
        logger.info("微信图文同步   end.......");
    }
}
