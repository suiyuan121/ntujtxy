package cn.edu.ntu.jtxy.web.controller.mng.student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.ntu.jtxy.core.model.wx.StudentInfoDo;
import cn.edu.ntu.jtxy.core.repository.wx.StudentInfoRepository;
import cn.edu.ntu.jtxy.core.repository.wx.pagelist.PageList;
import cn.edu.ntu.jtxy.core.repository.wx.pagelist.cond.StuInfoPageCond;
import cn.edu.ntu.jtxy.web.SystemConstants;
import cn.edu.ntu.jtxy.web.controller.mng.form.QueryStuInfoForm;

/**
 * 
 * @author {jin.zhang@witontek.com}
 * @version $Id: StuManageController.java, v 0.1 2016年4月26日 上午9:34:03 {jin.zhang@witontek.com} Exp $
 */
@Controller
@RequestMapping(value = "stuInfo.htm")
public class StuInfoController implements SystemConstants {
    /**  */
    private static final Logger   logger = LoggerFactory.getLogger(StuInfoController.class);

    private static final String   page   = "mng/student/stuInfo";

    @Autowired
    private StudentInfoRepository studentInfoRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(QueryStuInfoForm queryStuInfoForm, ModelMap map) {
        logger.info("用户信息 doGet  queryStuInfoForm={}");
        doPost(queryStuInfoForm, map);
        return page;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(QueryStuInfoForm queryStuInfoForm, ModelMap map) {
        logger.info("用户信息 doPost queryStuInfoForm={}");

        StuInfoPageCond cond = new StuInfoPageCond();
        cond.setCurrentPage(queryStuInfoForm.getCurrentPage());
        cond.setIdNo(queryStuInfoForm.getIdNo());
        cond.setPageSize(PAGE_SIZE);
        cond.setPhoneNo(queryStuInfoForm.getPhoneNo());
        cond.setStuName(queryStuInfoForm.getStuName());
        cond.setStuNo(queryStuInfoForm.getStuNo());

        PageList<StudentInfoDo> pageList = studentInfoRepository.pageQuery(cond);

        queryStuInfoForm.setCurrentPage(pageList.getCurrentPage());
        map.addAttribute("queryStuInfoForm", queryStuInfoForm);
        logger.info("用户信息 doPost 结果 pageList={}", pageList);

        map.addAttribute("pageList", pageList);

        return page;
    }

}