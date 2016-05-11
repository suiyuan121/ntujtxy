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
@RequestMapping(value = "daliyQuestionUpdate.htm")
public class DaliyQuestionUpdateController implements SystemConstants {
    /**  */
    private static final Logger     logger = LoggerFactory
                                               .getLogger(DaliyQuestionUpdateController.class);

    private static final String     page   = "mng/question/daliyQuestionUpdate";

    @Autowired
    private DaliyQuestionRepository daliyQuestionRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(ModelMap map, long id) {
        logger.info("每日一题信息更新 doGet id={}", id);
        DailyQuestionDo dailyQuestionDo = daliyQuestionRepository.getById(id);
        AddDaliyQuestionForm questionUpdateForm = new AddDaliyQuestionForm();
        questionUpdateForm.setId(dailyQuestionDo.getId());
        questionUpdateForm.setAnswerCorrect(dailyQuestionDo.getAnswerCorrect());
        questionUpdateForm.setAnswerOne(dailyQuestionDo.getAnswerOne());
        questionUpdateForm.setAnswerThree(dailyQuestionDo.getAnswerThree());
        questionUpdateForm.setAnswerTwo(dailyQuestionDo.getAnswerTwo());
        questionUpdateForm.setContent(dailyQuestionDo.getContent());
        questionUpdateForm.setPointValue(dailyQuestionDo.getPointValue());
        questionUpdateForm.setType(dailyQuestionDo.getType());
        map.addAttribute("questionUpdateForm", questionUpdateForm);

        return page;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(AddDaliyQuestionForm questionUpdateForm, ModelMap map) {
        logger.info("每日一题更新  doPost questionAddForm={}", questionUpdateForm);

        DailyQuestionDo dailyQuestionDo = new DailyQuestionDo();
        dailyQuestionDo.setAnswerCorrect(questionUpdateForm.getAnswerCorrect());
        dailyQuestionDo.setAnswerOne(questionUpdateForm.getAnswerOne());
        dailyQuestionDo.setAnswerThree(questionUpdateForm.getAnswerThree());
        dailyQuestionDo.setAnswerTwo(questionUpdateForm.getAnswerTwo());
        dailyQuestionDo.setContent(questionUpdateForm.getContent());
        dailyQuestionDo.setPointValue(questionUpdateForm.getPointValue());
        dailyQuestionDo.setType(questionUpdateForm.getType());
        dailyQuestionDo.setId(questionUpdateForm.getId());
        boolean ret = daliyQuestionRepository.update(dailyQuestionDo);
        if (ret) {
            map.addAttribute("msg", "更新成功");
        } else {
            map.addAttribute("msg", "更新失败");
        }
        map.addAttribute("questionUpdateForm", questionUpdateForm);

        return page;
    }

}