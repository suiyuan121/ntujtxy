package cn.edu.ntu.jtxy.core.repository.mng.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.ntu.jtxy.core.dao.mng.DaliyQuestionDao;
import cn.edu.ntu.jtxy.core.model.mng.DailyQuestionDo;
import cn.edu.ntu.jtxy.core.repository.mng.DaliyQuestionRepository;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: DaliyQuestionRepositoryImpl.java, v 0.1 2016年5月5日 下午3:17:00 zhangjinntu@163.com Exp $
 */
public class DaliyQuestionRepositoryImpl implements DaliyQuestionRepository {

    private static final Logger logger = LoggerFactory.getLogger(DaliyQuestionRepositoryImpl.class);

    @Autowired
    private DaliyQuestionDao    daliyQuestionDao;

    /** 
     * @see cn.edu.ntu.jtxy.core.repository.mng.DaliyQuestionRepository#add(cn.edu.ntu.jtxy.core.model.mng.DailyQuestionDo)
     */
    @Override
    public long add(DailyQuestionDo dailyQuestionDo) {
        logger.info("每日一题新增  dailyQuestionDo={} ", dailyQuestionDo);
        if (dailyQuestionDo == null) {
            return -1;
        }
        return daliyQuestionDao.add(dailyQuestionDo);
    }
}
