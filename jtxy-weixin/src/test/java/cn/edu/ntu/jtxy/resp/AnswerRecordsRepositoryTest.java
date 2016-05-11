package cn.edu.ntu.jtxy.resp;

import org.junit.Test;

import cn.edu.ntu.jtxy.BaseTest;
import cn.edu.ntu.jtxy.core.model.wx.AnswerRecordsDo;
import cn.edu.ntu.jtxy.core.repository.mng.AnswerRecordsRepository;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: NewsRepositoryTest.java, v 0.1 2016年5月1日 下午2:17:26 zhangjinntu@163.com Exp $
 */
public class AnswerRecordsRepositoryTest extends BaseTest {

    @Test
    public void test_add() {
        AnswerRecordsRepository resp = getContext().getBean(AnswerRecordsRepository.class);
        AnswerRecordsDo dailyQuestionDo = new AnswerRecordsDo();
        dailyQuestionDo.setQuestionId(1);
        dailyQuestionDo.setResult(AnswerRecordsDo.ResultEnum.correct.getCode());
        dailyQuestionDo.setUid("q2");
        long ret = resp.add(dailyQuestionDo);
        logger.info("xxxxxxxxxxxxxxxxxret={}", ret);

    }

    @Test
    public void test_getByCond() {
        AnswerRecordsRepository resp = getContext().getBean(AnswerRecordsRepository.class);
        AnswerRecordsDo recordsDo = resp.getByUidAndQuestionId("q2", 1);
        logger.info("recordsDo={}", recordsDo);
    }

}
