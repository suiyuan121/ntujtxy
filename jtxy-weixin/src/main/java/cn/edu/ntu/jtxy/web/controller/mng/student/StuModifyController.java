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
import cn.edu.ntu.jtxy.util.StuNoUtil;
import cn.edu.ntu.jtxy.web.SystemConstants;
import cn.edu.ntu.jtxy.web.controller.mng.form.AddStuForm;

@Controller
@RequestMapping(value = "stuModify.htm")
public class StuModifyController implements SystemConstants {
    /**  */
    private static final Logger   logger = LoggerFactory.getLogger(StuModifyController.class);

    private static final String   page   = "mng/student/stuModify";

    @Autowired
    private StudentInfoRepository studentInfoRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(ModelMap modelMap, String stuNo) {
        logger.info("学生新增 doGet  stuNo={}", stuNo);
        StudentInfoDo studentInfoDo = studentInfoRepository.getByStuNo(stuNo);
        if (studentInfoDo == null) {
            return ERROR_PAGE;
        }
        AddStuForm addStuForm = new AddStuForm();
        addStuForm.setGender(studentInfoDo.getSex());
        addStuForm.setIdNo(studentInfoDo.getIdNo());
        addStuForm.setHomeAddress(studentInfoDo.getAddress());
        addStuForm.setPhoneNum(studentInfoDo.getPhone());
        addStuForm.setStuName(studentInfoDo.getRealName());
        addStuForm.setStuNo(studentInfoDo.getStuNo());
        modelMap.addAttribute("addStuForm", addStuForm);
        return page;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(AddStuForm addStuForm, ModelMap modelMap) {
        logger.info("学生新增 doPost addStuForm={}", addStuForm);
        modelMap.addAttribute("addStuFrom", addStuForm);

        StudentInfoDo studentInfoDo = getStudentInfo(addStuForm);
        boolean ret = studentInfoRepository.updateByStuNo(studentInfoDo);
        if (!ret) {
            modelMap.addAttribute("msg", "error");
        } else {
            modelMap.addAttribute("msg", "success");
        }
        modelMap.addAttribute("addStuForm", addStuForm);
        return page;
    }

    private StudentInfoDo getStudentInfo(AddStuForm addStuForm) {
        StudentInfoDo studentInfoDo = new StudentInfoDo();
        studentInfoDo.setAddress(addStuForm.getHomeAddress());
        studentInfoDo.setGrade(StuNoUtil.getGrade(addStuForm.getStuNo()));
        studentInfoDo.setMemo("update");
        studentInfoDo.setIdNo(addStuForm.getIdNo());
        studentInfoDo.setPhone(addStuForm.getPhoneNum());
        studentInfoDo.setRealName(addStuForm.getStuName());
        studentInfoDo.setStuNo(addStuForm.getStuNo());
        studentInfoDo.setSex(addStuForm.getGender());
        return studentInfoDo;
    }
}
