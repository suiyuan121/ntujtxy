package cn.edu.ntu.jtxy.web.controller.wx;

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
import cn.edu.ntu.jtxy.web.controller.wx.form.PointPageQueryForm;

/**
 * 积分排行榜
 * @author zhangjinntu@163.com
 * @version $Id: PointSortController.java, v 0.1 2016年5月6日 上午10:43:52 zhangjinntu@163.com Exp $
 */
@Controller
@RequestMapping(value = "pointSort.htm")
public class PointSortController implements SystemConstants {
    /**  */
    private static final Logger logger          = LoggerFactory
                                                    .getLogger(PointSortController.class);

    private static final String page_point_sort = "wx/pointSort";

    @Autowired
    private PointRepository     pointRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(ModelMap map, PointPageQueryForm pointPageQueryForm) {
        logger.info("积分排行    doGet  pointPageQueryForm={}", pointPageQueryForm);

        this.doPost(pointPageQueryForm, map);
        return page_point_sort;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(PointPageQueryForm pointPageQueryForm, ModelMap map) {
        logger.info("积分排行 doPost queryStuInfoForm={}");

        PointPageQueryCond cond = new PointPageQueryCond();
        cond.setCurrentPage(pointPageQueryForm.getCurrentPage());
        cond.setStuNo(pointPageQueryForm.getStuNo());
        cond.setStuName(pointPageQueryForm.getStuName());
        cond.setPageSize(PAGE_SIZE);

        PageList<PointInfo> pageList = pointRepository.pageQuery(cond);

        pointPageQueryForm.setCurrentPage(pageList.getCurrentPage());
        pointPageQueryForm.setPageNum(pageList.getPageNum());
        map.addAttribute("pointPageQueryForm", pointPageQueryForm);
        logger.info("积分排行 doPost 结果 pageList={}", pageList);
        map.addAttribute("pageList", pageList);
        return page_point_sort;
    }

}
