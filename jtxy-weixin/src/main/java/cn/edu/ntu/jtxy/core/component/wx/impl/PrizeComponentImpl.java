package cn.edu.ntu.jtxy.core.component.wx.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import cn.edu.ntu.jtxy.core.component.wx.PointComponent;
import cn.edu.ntu.jtxy.core.component.wx.PrizeComponent;
import cn.edu.ntu.jtxy.core.component.wx.result.PointOperateResult;
import cn.edu.ntu.jtxy.core.model.BaseResult;
import cn.edu.ntu.jtxy.core.model.wx.PointDo.PointTypeEnum;
import cn.edu.ntu.jtxy.core.model.wx.PriceRecordDo;
import cn.edu.ntu.jtxy.core.model.wx.PriceRecordDo.PriceTypeEnum;
import cn.edu.ntu.jtxy.core.repository.ResultCodeEnum;
import cn.edu.ntu.jtxy.core.repository.wx.PriceRecordRepository;

public class PrizeComponentImpl implements PrizeComponent {

    private static final Logger   logger = LoggerFactory.getLogger(PrizeComponentImpl.class);

    @Autowired
    private PriceRecordRepository priceRecordRepository;

    @Autowired
    private PointComponent        pointComponent;

    @Autowired
    private TransactionTemplate   transactionTemplate;

    /** 
     * @see cn.edu.ntu.jtxy.core.component.wx.PrizeComponent#addPrice(cn.edu.ntu.jtxy.core.model.wx.PriceRecordDo)
     */
    @Override
    public BaseResult addPrice(final PriceRecordDo priceRecordDo) {
        logger.info("中奖增加  -积分增加    priceRecordDo={}", priceRecordDo);
        final BaseResult result = new BaseResult();
        if (priceRecordDo == null) {
            result.setSuccess(false);
            result.setCode(ResultCodeEnum.ILLEGAL_ARGUMENT.getCode());
            return result;
        }

        return transactionTemplate.execute(new TransactionCallback<BaseResult>() {

            @Override
            public BaseResult doInTransaction(TransactionStatus status) {

                try {
                    //同步方法，加了sync
                    priceRecordRepository.add(priceRecordDo);

                    int pointAmount = getPoint(priceRecordDo.getPriceLevel());

                    PointOperateResult operateResult = pointComponent.add(priceRecordDo.getUid(),
                        pointAmount, PointTypeEnum.PRIZE);

                    if (!operateResult.isSuccess()) {
                        status.setRollbackOnly();
                        result.setSuccess(false);
                        result.setCode(operateResult.getCode());
                        return result;
                    }
                } catch (Exception e) {
                    logger.error(String.format("中奖增加 -积分增加异常  priceRecordDo=%s", priceRecordDo), e);
                    status.setRollbackOnly();
                    result.setSuccess(false);
                    return result;
                }
                result.setSuccess(true);
                return result;
            }
        });
    }

    private int getPoint(String priceLevel) {
        PriceTypeEnum typeEnum = PriceTypeEnum.getByCode(priceLevel);
        if (typeEnum != null) {
            return typeEnum.getPoint();
        }
        return 0;
    }
}