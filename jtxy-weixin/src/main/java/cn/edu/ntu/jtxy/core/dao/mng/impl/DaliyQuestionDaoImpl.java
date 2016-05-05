package cn.edu.ntu.jtxy.core.dao.mng.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.ntu.jtxy.core.dao.mng.DaliyQuestionDao;
import cn.edu.ntu.jtxy.core.model.mng.DailyQuestionDo;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: DaliyQuestionDaoImpl.java, v 0.1 2016年5月5日 下午3:14:43 zhangjinntu@163.com Exp $
 */
public class DaliyQuestionDaoImpl extends SqlSessionDaoSupport implements DaliyQuestionDao {

    private static final Logger logger    = LoggerFactory.getLogger(DaliyQuestionDaoImpl.class);

    private static final String NAMESPACE = DaliyQuestionDao.class.getName();

    /** 
     * @see cn.edu.ntu.jtxy.core.dao.mng.DaliyQuestionDao#add(cn.edu.ntu.jtxy.core.model.mng.DailyQuestionDo)
     */
    @Override
    public long add(DailyQuestionDo dailyQuestionDo) {
        logger.info("每日一题新增    dailyQuestionDo={}", dailyQuestionDo);
        getSqlSession().insert(NAMESPACE + ".insert", dailyQuestionDo);
        return dailyQuestionDo.getId();
    }
}
