package cn.edu.ntu.jtxy.web.controller.wx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.ntu.jtxy.core.model.mng.DailyQuestionDo;
import cn.edu.ntu.jtxy.core.model.wx.AnswerRecordsDo;
import cn.edu.ntu.jtxy.core.repository.mng.AnswerRecordsRepository;
import cn.edu.ntu.jtxy.core.repository.mng.DaliyQuestionRepository;
import cn.edu.ntu.jtxy.web.SystemConstants;
import cn.edu.ntu.jtxy.web.filter.OperationContex;

/**
 * 每日一题
 * @author zhangjinntu@163.com
 * @version $Id: DaliyQuestionController.java, v 0.1 2016年5月9日 下午1:47:14 zhangjinntu@163.com Exp $
 */
@Controller
@RequestMapping(value = "daliyQuestionShow.htm")
public class DaliyQuestionShowController implements SystemConstants {
    /**  */
    private static final Logger     logger                   = LoggerFactory
                                                                 .getLogger(DaliyQuestionShowController.class);

    private static final String     page_daliy_question_show = "wx/daliyQuestionShow";

    @Autowired
    private DaliyQuestionRepository daliyQuestionRepository;

    @Autowired
    private AnswerRecordsRepository answerRecordsRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(ModelMap map) {
        logger.info("微信每日一题    doGet");
        String uid = OperationContex.getUid();
        if (StringUtils.isBlank(uid)) {
            logger.warn("session uid 为空  ");
            return ERROR_PAGE;
        }

        DailyQuestionDo dailyQuestionDo = daliyQuestionRepository.getLast();
        if (dailyQuestionDo == null) {
            logger.info("微信每日一题 异常，题目获取失败");
            return ERROR_PAGE;
        }

        List<String> answers = getRandomAnswerList(dailyQuestionDo);
        map.addAttribute("answers", answers);
        map.addAttribute("dailyQuestionDo", dailyQuestionDo);
        return page_daliy_question_show;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(ModelMap map, String answer) {
        logger.info("微信每日一题 doPost  choice={}", answer);

        String uid = OperationContex.getUid();
        if (StringUtils.isBlank(uid)) {
            logger.warn("session uid 为空  ");
            return ERROR_PAGE;
        }

        DailyQuestionDo dailyQuestionDo = daliyQuestionRepository.getLast();
        if (dailyQuestionDo == null) {
            logger.info("微信每日一题 异常，题目获取失败");
            return ERROR_PAGE;
        }

        long questionId = dailyQuestionDo.getId();
        AnswerRecordsDo answerRecordsDo = answerRecordsRepository.getByUidAndQuestionId(uid,
            questionId);
        if (answerRecordsDo == null) {
            //未回答过，比较答案，新增答题记录
            AnswerRecordsDo recordsDo = new AnswerRecordsDo();
            recordsDo.setQuestionId(questionId);
            recordsDo.setUid(uid);

            if (StringUtils.equals(dailyQuestionDo.getAnswerCorrect(), answer)) {
                recordsDo.setResult(AnswerRecordsDo.ResultEnum.correct.getCode());
                map.addAttribute("errMsg", "回答正确！");
            } else {
                recordsDo.setResult(AnswerRecordsDo.ResultEnum.wrong.getCode());
                map.addAttribute("errMsg", "回答错误！");
            }
            //新增
            answerRecordsRepository.add(recordsDo);
        } else {
            //已经回答，不能重复回答
            map.addAttribute("errMsg", "您今日已答题，每日答题只有一次机会，请明天再来！");
        }

        // 题目内容表单回显
        List<String> answers = getRandomAnswerList(dailyQuestionDo);
        map.addAttribute("answers", answers);
        map.addAttribute("dailyQuestionDo", dailyQuestionDo);

        return page_daliy_question_show;
    }

    public List<String> getRandomAnswerList(DailyQuestionDo dailyQuestionDo) {
        //把答案放在数组中，随机打乱，前台显示
        List<String> answers = new ArrayList<String>(4);
        answers.add(dailyQuestionDo.getAnswerCorrect());
        answers.add(dailyQuestionDo.getAnswerOne());
        answers.add(dailyQuestionDo.getAnswerThree());
        answers.add(dailyQuestionDo.getAnswerTwo());
        Collections.shuffle(answers, new Random());
        return answers;
    }
}
