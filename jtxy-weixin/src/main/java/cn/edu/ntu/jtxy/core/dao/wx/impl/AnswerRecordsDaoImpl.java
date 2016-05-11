package cn.edu.ntu.jtxy.core.dao.wx.impl;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.ntu.jtxy.core.dao.wx.AnswerRecordsDao;
import cn.edu.ntu.jtxy.core.model.wx.AnswerRecordsDo;

public class AnswerRecordsDaoImpl extends SqlSessionDaoSupport implements AnswerRecordsDao {

    private static final Logger logger    = LoggerFactory.getLogger(AnswerRecordsDaoImpl.class);

    private static final String NAMESPACE = AnswerRecordsDao.class.getName();

    @Override
    public AnswerRecordsDo getByUidAndQuestionId(String uid, long questionId) {
        logger.info("问题回答记录   uid={},questionId={}", uid, questionId);

        Map<String, String> map = new HashMap<String, String>();
        map.put("uid", uid);
        map.put("questionId", String.valueOf(questionId));
        return getSqlSession().selectOne(NAMESPACE + ".getByUidAndQuestionId", map);
    }

    @Override
    public long add(AnswerRecordsDo answerRecordsDo) {
        logger.info("问题回答新增   answerRecordsDo={}", answerRecordsDo);
        return getSqlSession().insert(NAMESPACE + ".add", answerRecordsDo);
    }
}
