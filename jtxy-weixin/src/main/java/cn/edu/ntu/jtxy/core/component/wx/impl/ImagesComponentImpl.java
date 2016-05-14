package cn.edu.ntu.jtxy.core.component.wx.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import cn.edu.ntu.jtxy.core.component.wx.ImagesComponent;
import cn.edu.ntu.jtxy.core.component.wx.PointComponent;
import cn.edu.ntu.jtxy.core.component.wx.result.PointOperateResult;
import cn.edu.ntu.jtxy.core.model.BaseResult;
import cn.edu.ntu.jtxy.core.model.wx.ImagesDo;
import cn.edu.ntu.jtxy.core.model.wx.PointDo.PointTypeEnum;
import cn.edu.ntu.jtxy.core.repository.ResultCodeEnum;
import cn.edu.ntu.jtxy.core.repository.wx.ImagesRepository;

public class ImagesComponentImpl implements ImagesComponent {

    private static final Logger logger             = LoggerFactory
                                                       .getLogger(ImagesComponentImpl.class);

    private final int           upload_works_point = 10;
    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private ImagesRepository    imagesRepository;

    @Autowired
    private PointComponent      pointComponent;

    @Override
    public BaseResult addImage(final ImagesDo imagesDo) {
        logger.info("上传作品添加    imagesDo={}", imagesDo);
        final BaseResult result = new BaseResult();
        if (imagesDo == null) {
            result.setSuccess(false);
            result.setCode(ResultCodeEnum.ILLEGAL_ARGUMENT.getCode());
            return result;
        }

        return transactionTemplate.execute(new TransactionCallback<BaseResult>() {

            @Override
            public BaseResult doInTransaction(TransactionStatus status) {

                try {
                    //同步方法，加了sync
                    imagesRepository.add(imagesDo);
                    PointOperateResult operateResult = pointComponent.add(imagesDo.getUid(),
                        upload_works_point, PointTypeEnum.UPLOAD_WORK);

                    if (!operateResult.isSuccess()) {
                        status.setRollbackOnly();
                        result.setSuccess(false);
                        result.setCode(operateResult.getCode());
                        return result;
                    }
                } catch (Exception e) {
                    logger.error(String.format("中奖增加 -积分增加异常  imagesDo=%s", imagesDo), e);
                    status.setRollbackOnly();
                    result.setSuccess(false);
                    return result;
                }
                result.setSuccess(true);
                return result;
            }
        });
    }

}