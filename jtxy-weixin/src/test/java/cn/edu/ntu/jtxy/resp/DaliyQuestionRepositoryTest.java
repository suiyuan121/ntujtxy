package cn.edu.ntu.jtxy.resp;

import org.junit.Test;

import cn.edu.ntu.jtxy.BaseTest;
import cn.edu.ntu.jtxy.core.model.mng.DailyQuestionDo;
import cn.edu.ntu.jtxy.core.repository.mng.DaliyQuestionRepository;
import cn.edu.ntu.jtxy.core.repository.mng.cond.DaliyQuestionPageQueryCond;
import cn.edu.ntu.jtxy.core.repository.wx.pagelist.PageList;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: NewsRepositoryTest.java, v 0.1 2016年5月1日 下午2:17:26 zhangjinntu@163.com Exp $
 */
public class DaliyQuestionRepositoryTest extends BaseTest {

    @Test
    public void test_add() {
        DaliyQuestionRepository resp = getContext().getBean(DaliyQuestionRepository.class);
        DailyQuestionDo dailyQuestionDo = new DailyQuestionDo();
        dailyQuestionDo.setAnswerCorrect("correct");
        dailyQuestionDo.setAnswerOne("one");
        dailyQuestionDo.setAnswerThree("three");
        dailyQuestionDo.setAnswerTwo("two");
        dailyQuestionDo.setContent("1+1=?");
        dailyQuestionDo.setPointValue(2);
        dailyQuestionDo.setStatus(DailyQuestionDo.StatusEnum.ENABLE.getCode());
        dailyQuestionDo.setType(DailyQuestionDo.TypeEnum.COMMON.getCode());

        long ret = resp.add(dailyQuestionDo);
        logger.info("xxxxxxxxxxxxxxxxxret={}", ret);

    }

    @Test
    public void test_pageQuery() {
        DaliyQuestionRepository resp = getContext().getBean(DaliyQuestionRepository.class);

        DaliyQuestionPageQueryCond cond = new DaliyQuestionPageQueryCond();
        cond.setPageSize(5);
        cond.setCurrentPage(1);
        PageList<DailyQuestionDo> pageList = resp.pageQuery(cond);
        logger.info("zxxxxpageList={}", pageList);
    }

    @Test
    public void test_() {
        DaliyQuestionRepository resp = getContext().getBean(DaliyQuestionRepository.class);
        boolean ret = resp.updateLastStatus(DailyQuestionDo.StatusEnum.DISENABLE);
        logger.info("ret={}", ret);
    }

}
