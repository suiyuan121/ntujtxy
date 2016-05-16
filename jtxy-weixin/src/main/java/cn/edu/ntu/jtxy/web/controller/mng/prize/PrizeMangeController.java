package cn.edu.ntu.jtxy.web.controller.mng.prize;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.ntu.jtxy.core.repository.wx.PriceRecordRepository;
import cn.edu.ntu.jtxy.core.repository.wx.cond.PrizePageQueryCond;
import cn.edu.ntu.jtxy.core.repository.wx.model.PrizeInfo;
import cn.edu.ntu.jtxy.core.repository.wx.pagelist.PageList;
import cn.edu.ntu.jtxy.web.SystemConstants;
import cn.edu.ntu.jtxy.web.controller.mng.form.QueryPrizeInfoForm;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: PrizeMangeController.java, v 0.1 2016年5月14日 下午8:52:23 zhangjinntu@163.com Exp $
 */
@Controller
@RequestMapping(value = "prizeInfo.htm")
public class PrizeMangeController implements SystemConstants {

    private static final Logger   logger = LoggerFactory.getLogger(PrizeMangeController.class);

    private static final String   page   = "mng/prize/prizeInfo";

    @Autowired
    private PriceRecordRepository priceRecordRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(QueryPrizeInfoForm queryPrizeInfoForm, ModelMap map) {
        logger.info("奖品信息  doGet  pointInfoQueryForm={} ", queryPrizeInfoForm);
        doPost(queryPrizeInfoForm, map);
        return page;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(QueryPrizeInfoForm queryPrizeInfoForm, ModelMap map) {
        logger.info("积分信息  doPost  queryPrizeInfoForm={} ", queryPrizeInfoForm);

        PrizePageQueryCond cond = new PrizePageQueryCond();
        cond.setCurrentPage(queryPrizeInfoForm.getCurrentPage());
        cond.setStuName(queryPrizeInfoForm.getStuName());
        cond.setStuNo(queryPrizeInfoForm.getStuNo());
        cond.setPageSize(PAGE_SIZE);

        PageList<PrizeInfo> pageList = priceRecordRepository.pageQuery(cond);

        queryPrizeInfoForm.setCurrentPage(pageList.getCurrentPage());
        map.addAttribute("queryPrizeInfoForm", queryPrizeInfoForm);
        logger.info("用户奖品信息查询  doPost 结果 pageList={}", pageList);

        map.addAttribute("pageList", pageList);

        return page;
    }

}
