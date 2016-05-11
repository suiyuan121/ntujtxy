package cn.edu.ntu.jtxy.core.dao.mng;

import cn.edu.ntu.jtxy.core.model.mng.DailyQuestionDo;
import cn.edu.ntu.jtxy.core.repository.wx.pagelist.PageList;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: DaliyQuestionDao.java, v 0.1 2016年5月5日 下午3:41:44 zhangjinntu@163.com Exp $
 */
public interface DaliyQuestionDao {

    /**
    * 
    * @param dailyQuestionDo
    * @return
    */
    public long add(DailyQuestionDo dailyQuestionDo);

    /**
     * 
     * @param pageSize
     * @param currentPage
     * @param content
     * @param status
     * @param value
     * @param type
     * @return
     */
    public PageList<DailyQuestionDo> pageQuery(int pageSize, int currentPage, String content,
                                               String status, int value, String type);

    /**
     * 
     * @param id
     * @return
     */
    public DailyQuestionDo getById(long id);

    /**
     * 
     * @param dailyQuestionDo
     * @return
     */
    public boolean update(DailyQuestionDo dailyQuestionDo);

    /**
     * 
     * @return
     */
    public DailyQuestionDo getLast();

    /**
     * 
     * @param code
     * @return
     */
    public boolean updateLastStatus(String status);

}
