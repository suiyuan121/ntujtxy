package cn.edu.ntu.jtxy.core.repository.mng;

import cn.edu.ntu.jtxy.core.model.mng.DailyQuestionDo;
import cn.edu.ntu.jtxy.core.model.mng.DailyQuestionDo.StatusEnum;
import cn.edu.ntu.jtxy.core.repository.mng.cond.DaliyQuestionPageQueryCond;
import cn.edu.ntu.jtxy.core.repository.wx.pagelist.PageList;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: DaliyQuestionRepository.java, v 0.1 2016年5月5日 下午3:15:37 zhangjinntu@163.com Exp $
 */
public interface DaliyQuestionRepository {

    /**
     * 
     * @param dailyQuestionDo
     * @return
     */
    public long add(DailyQuestionDo dailyQuestionDo);

    /**
     * 
     * @param cond
     * @return
     */
    public PageList<DailyQuestionDo> pageQuery(DaliyQuestionPageQueryCond cond);

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
     * 获取最先的一条记录，可用状态
     * @return
     */
    public DailyQuestionDo getLast();

    /**
     * 
     * @param disenable
     * @return
     */
    public boolean updateLastStatus(StatusEnum status);
}
