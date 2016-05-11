package cn.edu.ntu.jtxy.task.wx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.ntu.jtxy.core.model.mng.DailyQuestionDo;
import cn.edu.ntu.jtxy.core.repository.mng.DaliyQuestionRepository;
import cn.edu.ntu.jtxy.task.Task;

/**
 * 每日一题定时任务，把最老的一条记录设置为失效
 * @author zhangjinntu@163.com
 * @version $Id: DaliyQuestionTask.java, v 0.1 2016年5月10日 下午1:07:07 zhangjinntu@163.com Exp $
 */
public class DaliyQuestionTask implements Task {

    /**  */
    private static final Logger     logger = LoggerFactory.getLogger(DaliyQuestionTask.class);

    @Autowired
    private DaliyQuestionRepository daliyQuestionRepository;

    @Override
    public void execute() {
        logger.info("每日一题定时任务   start.......");

        boolean ret = daliyQuestionRepository
            .updateLastStatus(DailyQuestionDo.StatusEnum.DISENABLE);

        logger.info("每日一题定时任务   结果={}", ret);
        logger.info("每日一题定时任务  end.......");
    }
}
