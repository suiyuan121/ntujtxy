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
import cn.edu.ntu.jtxy.core.repository.mng.cond.DaliyQuestionPageQueryCond;
import cn.edu.ntu.jtxy.core.repository.wx.pagelist.PageList;
import cn.edu.ntu.jtxy.web.SystemConstants;
import cn.edu.ntu.jtxy.web.controller.mng.form.QueryDaliyQuestionInfoForm;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: DaliyQuestionController.java, v 0.1 2016年5月5日 下午4:17:29 zhangjinntu@163.com Exp $
 */
@Controller
@RequestMapping(value = "daliyQuestionInfo.htm")
public class DaliyQuestionInfoController implements SystemConstants {
    /**  */
    private static final Logger     logger = LoggerFactory.getLogger(DaliyQuestionInfoController.class);

    private static final String     page   = "mng/question/daliyQuestionInfo";

    @Autowired
    private DaliyQuestionRepository daliyQuestionRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(QueryDaliyQuestionInfoForm questionForm, ModelMap map) {
        logger.info("每日一题信息 doGet  form={}", questionForm);
        doPost(questionForm, map);
        return page;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(QueryDaliyQuestionInfoForm questionForm, ModelMap map) {
        logger.info("每日一题信息 doPost form={}", questionForm);

        DaliyQuestionPageQueryCond cond = new DaliyQuestionPageQueryCond();
        cond.setCurrentPage(questionForm.getCurrentPage());
        cond.setPageSize(PAGE_SIZE);
        cond.setContent(questionForm.getContent());
        cond.setStatus(questionForm.getStatus());
        cond.setType(questionForm.getType());
        cond.setValue(questionForm.getValue());
        cond.setPageSize(PAGE_SIZE);

        PageList<DailyQuestionDo> pageList = daliyQuestionRepository.pageQuery(cond);

        questionForm.setCurrentPage(pageList.getCurrentPage());
        map.addAttribute("questionForm", questionForm);
        logger.info("用户信息 doPost 结果 pageList={}", pageList);

        map.addAttribute("pageList", pageList);

        return page;
    }

}