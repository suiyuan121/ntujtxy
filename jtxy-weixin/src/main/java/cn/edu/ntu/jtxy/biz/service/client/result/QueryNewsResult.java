package cn.edu.ntu.jtxy.biz.service.client.result;

import java.util.List;
import java.util.Map;

import cn.edu.ntu.jtxy.biz.service.client.model.wx.NewsInfo;
import cn.edu.ntu.jtxy.core.model.BaseResult;

/**
 * 
 * @author {jin.zhang@witontek.com}
 * @version $Id: QueryNewsResult.java, v 0.1 2016年4月29日 下午3:47:12 {jin.zhang@witontek.com} Exp $
 */
public class QueryNewsResult extends BaseResult {

    /**  */
    private static final long           serialVersionUID = 2241710594214255022L;

    private Map<String, List<NewsInfo>> news;

    private int                         item_count;

    private int                         total_count;

    public Map<String, List<NewsInfo>> getNews() {
        return news;
    }

    public void setNews(Map<String, List<NewsInfo>> news) {
        this.news = news;
    }

    public int getItem_count() {
        return item_count;
    }

    public void setItem_count(int item_count) {
        this.item_count = item_count;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

}
