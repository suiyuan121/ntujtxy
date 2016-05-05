package cn.edu.ntu.jtxy.core.repository.mng;

import cn.edu.ntu.jtxy.core.model.mng.DailyQuestionDo;

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
}
