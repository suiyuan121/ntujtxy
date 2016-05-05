package cn.edu.ntu.jtxy.core.dao.mng;

import java.util.List;

import cn.edu.ntu.jtxy.core.model.mng.NewsDo;
import cn.edu.ntu.jtxy.core.repository.wx.pagelist.PageList;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: NewsDao.java, v 0.1 2016年5月1日 下午1:34:04 zhangjinntu@163.com Exp $
 */
public interface NewsDao {

    /**
     * 
     * @param currentPage
     * @param pagesize
     * @param title
     * @return
     */
    public PageList<String> pageQuery(int currentPage, int pagesize, String title);

    /**
     * 
     * @param mediaId
     */
    public List<NewsDo> getByMediaId(String mediaId);

    /**
     * 
     * @param newsDo
     * @return
     */
    public long add(NewsDo newsDo);

}
