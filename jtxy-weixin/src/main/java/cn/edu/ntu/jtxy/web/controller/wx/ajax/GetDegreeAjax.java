package cn.edu.ntu.jtxy.web.controller.wx.ajax;

import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.ntu.jtxy.core.component.wx.PrizeComponent;
import cn.edu.ntu.jtxy.core.model.BaseResult;
import cn.edu.ntu.jtxy.core.model.wx.PriceRecordDo;
import cn.edu.ntu.jtxy.web.SystemConstants;
import cn.edu.ntu.jtxy.web.filter.OperationContex;

/**
 * 幸运转盘得到度数
 * @author {jin.zhang@witontek.com}
 * @version $Id: GetDegreeAjax.java, v 0.1 2016年4月20日 下午9:05:15 {jin.zhang@witontek.com} Exp $
 */
@Controller
@RequestMapping(value = "getdegree.json")
public class GetDegreeAjax implements SystemConstants {
    /**  */
    private static final Logger logger = LoggerFactory.getLogger(GetDegreeAjax.class);

    @Autowired
    private PrizeComponent      prizeComponent;

    @RequestMapping(method = RequestMethod.GET)
    public void doGet(ModelMap map) {
        logger.info("抽奖得到度数 doGet");
        String uid = OperationContex.getUid();
        if (uid == null) {
            map.addAttribute("errMsg", "fail");
            return;
        }
        int degree = new Random().nextInt(360);
        logger.info("抽奖得到度数    degree={},uid={}", degree, uid);

        PriceRecordDo priceRecordDo = new PriceRecordDo();
        priceRecordDo.setUid(uid);
        if (45 < degree && degree < 90) {
            //二等奖
            priceRecordDo.setPriceLevel(PriceRecordDo.PriceTypeEnum.二等奖.getCode());
        } else if (135 < degree && degree < 180) {
            //三等奖
            priceRecordDo.setPriceLevel(PriceRecordDo.PriceTypeEnum.三等奖.getCode());
        } else if (225 < degree && degree < 270) {
            //一等奖
            priceRecordDo.setPriceLevel(PriceRecordDo.PriceTypeEnum.一等奖.getCode());
        } else if (315 < degree && degree < 360) {
            //幸运奖
            priceRecordDo.setPriceLevel(PriceRecordDo.PriceTypeEnum.幸运奖.getCode());
        } else {
            //未中奖
        }

        boolean isPrize = false;
        BaseResult result = new BaseResult();
        if (StringUtils.isBlank(priceRecordDo.getPriceLevel())) {
            //未中奖的
            isPrize = true;
        } else {
            //            中奖的
            result = prizeComponent.addPrice(priceRecordDo);
        }
        if (result.isSuccess() || isPrize) {
            map.addAttribute("degree", degree);
            map.addAttribute("errMsg", "success");
        } else {
            map.addAttribute("errMsg", "fail");
        }
    }
}
