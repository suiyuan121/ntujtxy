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
 * 奖品信息查看
 * @author zhangjinntu@163.com
 * @version $Id: PriceInfoController.java, v 0.1 2016年5月18日 上午10:17:31 zhangjinntu@163.com Exp $
 */
@Controller
@RequestMapping(value = "prizeInfo.htm")
public class PrizeInfoController implements SystemConstants {
    /**  */
    private static final Logger   logger = LoggerFactory.getLogger(PrizeInfoController.class);

    private static final String   page   = "mng/prize/prizeInfo";

    @Autowired
    private PriceRecordRepository priceRecordRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(QueryPrizeInfoForm prizeInfoForm, ModelMap map) {
        logger.info("奖品信息管理 doGet  prizeInfoForm={}", prizeInfoForm);
        doPost(prizeInfoForm, map);
        return page;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(QueryPrizeInfoForm prizeInfoForm, ModelMap map) {
        logger.info("奖品信息管理 doPost prizeInfoForm={}", prizeInfoForm);

        PrizePageQueryCond cond = new PrizePageQueryCond();
        cond.setCurrentPage(prizeInfoForm.getCurrentPage());
        cond.setPageSize(PAGE_SIZE);
        cond.setStuName(prizeInfoForm.getStuName());
        cond.setStuNo(prizeInfoForm.getStuNo());
        cond.setType(prizeInfoForm.getType());

        PageList<PrizeInfo> pageList = priceRecordRepository.pageQuery(cond);

        prizeInfoForm.setCurrentPage(pageList.getCurrentPage());
        map.addAttribute("prizeInfoForm", prizeInfoForm);
        logger.info("奖品信息管理 doPost 结果 pageList={}", pageList);

        map.addAttribute("pageList", pageList);

        return page;
    }

}