package cn.edu.ntu.jtxy.core.repository.mng;

import cn.edu.ntu.jtxy.core.model.wx.AnswerRecordsDo;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: AnswerRecordsRepository.java, v 0.1 2016年5月10日 上午9:10:06 zhangjinntu@163.com Exp $
 */
public interface AnswerRecordsRepository {

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
