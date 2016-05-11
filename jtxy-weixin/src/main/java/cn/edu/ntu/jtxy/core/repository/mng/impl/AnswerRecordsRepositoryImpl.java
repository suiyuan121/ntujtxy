package cn.edu.ntu.jtxy.core.repository.mng.impl;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.ntu.jtxy.core.dao.wx.AnswerRecordsDao;
import cn.edu.ntu.jtxy.core.model.wx.AnswerRecordsDo;
import cn.edu.ntu.jtxy.core.repository.mng.AnswerRecordsRepository;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: AnswerRecordsRepositoryImpl.java, v 0.1 2016年5月10日 上午9:14:03 zhangjinntu@163.com Exp $
 */
public class AnswerRecordsRepositoryImpl implements AnswerRecordsRepository {

    private static final Logger logger = LoggerFactory.getLogger(AnswerRecordsRepositoryImpl.class);

    @Autowired
    private AnswerRecordsDao    answerRecordsDao;

    /** 
     * @see cn.edu.ntu.jtxy.core.repository.mng.AnswerRecordsRepository#getByUidAndQuestionId(java.lang.String, long)
     */
    @Override
    public AnswerRecordsDo getByUidAndQuestionId(String uid, long questionId) {
        logger.info("问题回答记录  uid={}，questionId={} ", uid, questionId);
        if (StringUtils.isBlank(uid) || questionId <= 0) {
            return null;
        }
        return answerRecordsDao.getByUidAndQuestionId(uid, questionId);
    }

    @Override
    public long add(AnswerRecordsDo answerRecordsDo) {
        logger.info("问题回答记录  新增, answerRecordsDo={}", answerRecordsDo);
        if (answerRecordsDo == null) {
            return -1;
        }
        return answerRecordsDao.add(answerRecordsDo);
    }

}
