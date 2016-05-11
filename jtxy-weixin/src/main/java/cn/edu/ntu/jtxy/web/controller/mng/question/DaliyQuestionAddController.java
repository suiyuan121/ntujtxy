package cn.edu.ntu.jtxy.web.controller.mng.question;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.ntu.jtxy.core.model.mng.DailyQuestionDo;
import cn.edu.ntu.jtxy.core.repository.mng.DaliyQuestionRepository;
import cn.edu.ntu.jtxy.web.SystemConstants;
import cn.edu.ntu.jtxy.web.controller.mng.form.AddDaliyQuestionForm;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: DaliyQuestionAddController.java, v 0.1 2016年5月5日 下午6:25:48 zhangjinntu@163.com Exp $
 */
@Controller
@RequestMapping(value = "daliyQuestionAdd.htm")
public class DaliyQuestionAddController implements SystemConstants {
    /**  */
    private static final Logger     logger = LoggerFactory
                                               .getLogger(DaliyQuestionAddController.class);

    private static final String     page   = "mng/question/daliyQuestionAdd";

    @Autowired
    private DaliyQuestionRepository daliyQuestionRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(ModelMap map) {
        logger.info("每日一题信息新增 doGet ");
        return page;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(AddDaliyQuestionForm questionAddForm, ModelMap map) {
        logger.info("每日一题新增 doPost questionAddForm={}", questionAddForm);

        DailyQuestionDo dailyQuestionDo = new DailyQuestionDo();
        dailyQuestionDo.setAnswerCorrect(questionAddForm.getAnswerCorrect());
        dailyQuestionDo.setAnswerOne(questionAddForm.getAnswerOne());
        dailyQuestionDo.setAnswerThree(questionAddForm.getAnswerThree());
        dailyQuestionDo.setAnswerTwo(questionAddForm.getAnswerTwo());
        dailyQuestionDo.setContent(questionAddForm.getContent());
        dailyQuestionDo.setPointValue(questionAddForm.getPointValue());
        dailyQuestionDo.setType(questionAddForm.getType());
        dailyQuestionDo.setStatus(DailyQuestionDo.StatusEnum.ENABLE.getCode());

        long id = daliyQuestionRepository.add(dailyQuestionDo);
        if (id <= 0) {
            map.addAttribute("msg", "新增失败");
        } else {
            map.addAttribute("msg", "新增成功");
        }
        map.addAttribute("questionAddForm", questionAddForm);

        return page;
    }

}