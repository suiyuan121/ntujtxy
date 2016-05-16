package cn.edu.ntu.jtxy.core.repository.mng;

import java.util.List;

import cn.edu.ntu.jtxy.core.model.mng.NewsDo;
import cn.edu.ntu.jtxy.core.repository.mng.cond.NewsPageQueryCond;
import cn.edu.ntu.jtxy.core.repository.wx.pagelist.PageList;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: NewsRepository.java, v 0.1 2016年5月1日 上午11:49:59 zhangjinntu@163.com Exp $
 */
public interface NewsRepository {

    /**
     * 
     * @param cond
     * @return
     */
    public PageList<String> pageQuery(NewsPageQueryCond cond);

    /**
     * 
     * @param newsDo
     * @return
     */
    public long add(NewsDo newsDo);

    /**
     * 
     * @param item
     * @return
     */
    public List<NewsDo> getByMediaId(String mediaId);

    /**
     * 
     * @param cond
     * @return
     */
    public PageList<NewsDo> pageQueryAll(NewsPageQueryCond cond);

    /**
     * 
     * @param id
     * @return
     */
    public boolean updateViewCountById(int id);
}
