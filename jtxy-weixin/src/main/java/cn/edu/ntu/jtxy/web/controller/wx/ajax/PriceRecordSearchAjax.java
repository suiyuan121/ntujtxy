package cn.edu.ntu.jtxy.web.controller.wx.ajax;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.ntu.jtxy.core.model.wx.PriceRecordDo;
import cn.edu.ntu.jtxy.core.model.wx.PriceRecordDo.PriceTypeEnum;
import cn.edu.ntu.jtxy.core.repository.wx.PriceRecordRepository;
import cn.edu.ntu.jtxy.web.SystemConstants;
import cn.edu.ntu.jtxy.web.controller.wx.ajax.response.PriceRecordsAjaxResponse;
import cn.edu.ntu.jtxy.web.filter.OperationContex;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: PriceRecordSearchAjax.java, v 0.1 2016年5月13日 上午8:39:25 zhangjinntu@163.com Exp $
 */
@Controller
@RequestMapping(value = "priceRecord.json")
public class PriceRecordSearchAjax implements SystemConstants {
    /**  */
    private static final Logger   logger = LoggerFactory.getLogger(PriceRecordSearchAjax.class);

    @Autowired
    private PriceRecordRepository priceRecordRepository;

    @RequestMapping(method = RequestMethod.GET)
    public PriceRecordsAjaxResponse doGet(ModelMap map) {
        String uid = OperationContex.getUid();
        logger.info("作品查询  doPost uid={}", uid);
        PriceRecordsAjaxResponse ajaxResponse = new PriceRecordsAjaxResponse();

        List<PriceRecordDo> list = priceRecordRepository.getByUid(uid);

        if (!CollectionUtils.isEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                PriceTypeEnum priceTypeEnum = PriceRecordDo.PriceTypeEnum.getByCode(list.get(i)
                    .getPriceLevel());
                list.get(i).setPriceLevel(priceTypeEnum == null ? null : priceTypeEnum.toString());
            }
        }
        ajaxResponse.setList(list);
        return ajaxResponse;
    }
}
