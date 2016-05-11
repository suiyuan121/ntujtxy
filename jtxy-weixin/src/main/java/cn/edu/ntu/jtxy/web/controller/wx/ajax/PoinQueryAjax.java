package cn.edu.ntu.jtxy.web.controller.wx.ajax;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.ntu.jtxy.core.repository.wx.PointRepository;
import cn.edu.ntu.jtxy.core.repository.wx.cond.PointPageQueryCond;
import cn.edu.ntu.jtxy.core.repository.wx.model.PointInfo;
import cn.edu.ntu.jtxy.core.repository.wx.pagelist.PageList;
import cn.edu.ntu.jtxy.web.SystemConstants;
import cn.edu.ntu.jtxy.web.controller.wx.ajax.response.PointQueryAjaxResponse;
import cn.edu.ntu.jtxy.web.controller.wx.form.PointPageQueryForm;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: PoinQueryAjax.java, v 0.1 2016年5月6日 下午10:16:48 zhangjinntu@163.com Exp $
 */
@Controller
@RequestMapping(value = "pointQuery.json")
public class PoinQueryAjax implements SystemConstants {
    /**  */
    private static final Logger logger = LoggerFactory.getLogger(PoinQueryAjax.class);

    @Autowired
    private PointRepository     pointRepository;

    @RequestMapping(method = RequestMethod.GET)
    public PointQueryAjaxResponse doGet(ModelMap map, PointPageQueryForm pointPageQueryForm) {
        logger.info(" 积分排行查询   doGet  pointPageQueryForm={}", pointPageQueryForm);
        PointQueryAjaxResponse response = new PointQueryAjaxResponse();
        PointPageQueryCond cond = new PointPageQueryCond();
        cond.setCurrentPage(pointPageQueryForm.getCurrentPage());
        cond.setStuNo(pointPageQueryForm.getStuNo());
        cond.setStuName(pointPageQueryForm.getStuName());
        cond.setPageSize(PAGE_SIZE);

        PageList<PointInfo> pageList = pointRepository.pageQuery(cond);

        pointPageQueryForm.setCurrentPage(pageList.getCurrentPage());
        pointPageQueryForm.setPageNum(pageList.getPageNum());
        logger.info("积分排行 doPost 结果 pageList={}", pageList);
        map.addAttribute("pointPageQueryForm", pointPageQueryForm);
        response.setList(pageList.getResultList());
        return response;
    }
}
