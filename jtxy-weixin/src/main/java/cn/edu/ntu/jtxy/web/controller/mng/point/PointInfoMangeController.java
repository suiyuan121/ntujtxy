package cn.edu.ntu.jtxy.web.controller.mng.point;

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
import cn.edu.ntu.jtxy.web.controller.mng.form.PointInfoQueryForm;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: PointInfoMangeController.java, v 0.1 2016年5月14日 下午7:38:20 zhangjinntu@163.com Exp $
 */
@Controller
@RequestMapping(value = "pointInfo.htm")
public class PointInfoMangeController implements SystemConstants {

    private static final Logger logger = LoggerFactory.getLogger(PointInfoMangeController.class);

    private static final String page   = "mng/point/pointInfo";

    @Autowired
    private PointRepository     pointRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(PointInfoQueryForm pointInfoQueryForm, ModelMap map) {
        logger.info("积分信息  doGet  pointInfoQueryForm={} ", pointInfoQueryForm);
        doPost(pointInfoQueryForm, map);
        return page;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(PointInfoQueryForm pointInfoQueryForm, ModelMap map) {
        logger.info("积分信息  doPost  pointInfoQueryForm={} ", pointInfoQueryForm);

        PointPageQueryCond cond = new PointPageQueryCond();
        cond.setCurrentPage(pointInfoQueryForm.getCurrentPage());
        cond.setStuName(pointInfoQueryForm.getStuName());
        cond.setStuNo(pointInfoQueryForm.getStuNo());
        cond.setPageSize(PAGE_SIZE);

        PageList<PointInfo> pageList = pointRepository.pageQuery(cond);

        pointInfoQueryForm.setCurrentPage(pageList.getCurrentPage());
        map.addAttribute("pointInfoQueryForm", pointInfoQueryForm);
        logger.info("用户积分查询  doPost 结果 pageList={}", pageList);

        map.addAttribute("pageList", pageList);

        return page;
    }

}
