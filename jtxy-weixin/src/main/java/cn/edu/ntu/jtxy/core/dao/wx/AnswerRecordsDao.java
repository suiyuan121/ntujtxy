package cn.edu.ntu.jtxy.core.dao.wx;

import cn.edu.ntu.jtxy.core.model.wx.AnswerRecordsDo;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: AnswerRecordsDao.java, v 0.1 2016年5月9日 下午10:01:53 zhangjinntu@163.com Exp $
 */
public interface AnswerRecordsDao {

    /**
     * 
     * @param uid
     * @param questionId
     * @return
     */
    public AnswerRecordsDo getByUidAndQuestionId(String uid, long questionId);

    /**
     * 
     * @param answerRecordsDo
     * @return
     */
    public long add(AnswerRecordsDo answerRecordsDo);
}
