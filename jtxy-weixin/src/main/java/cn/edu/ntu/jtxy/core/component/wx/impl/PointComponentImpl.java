package cn.edu.ntu.jtxy.core.component.wx.impl;

import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import cn.edu.ntu.jtxy.core.component.wx.PointComponent;
import cn.edu.ntu.jtxy.core.component.wx.result.PointOperateResult;
import cn.edu.ntu.jtxy.core.model.wx.PointDo;
import cn.edu.ntu.jtxy.core.model.wx.PointDo.PointTypeEnum;
import cn.edu.ntu.jtxy.core.model.wx.PointRecordDo;
import cn.edu.ntu.jtxy.core.repository.ResultCodeEnum;
import cn.edu.ntu.jtxy.core.repository.wx.PointRecordRepository;
import cn.edu.ntu.jtxy.core.repository.wx.PointRepository;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: PointComponentImpl.java, v 0.1 2016年5月4日 下午5:42:00 zhangjinntu@163.com Exp $
 */
public class PointComponentImpl implements PointComponent {

    private static final Logger   logger = LoggerFactory.getLogger(PointComponentImpl.class);

    @Autowired
    private PointRepository       pointRepository;

    @Autowired
    private PointRecordRepository pointRecordRepository;

    @Autowired
    private TransactionTemplate   transactionTemplate;

    /** 
     * @see cn.edu.ntu.jtxy.core.component.wx.PointComponent#add(java.lang.String, int)
     */
    @Override
    public PointOperateResult add(final String uid, final int amount,
                                  final PointDo.PointTypeEnum poinType) {
        logger.info("用户积分新增  uid={},amout={}", uid, amount);
        final PointOperateResult result = new PointOperateResult();
        if (amount <= 0 || poinType == null || StringUtils.isBlank(uid)) {
            result.setSuccess(false);
            result.setCode(ResultCodeEnum.ILLEGAL_ARGUMENT.getCode());
            return result;
        }

        final PointDo pointDo = pointRepository.getByUidAndType(uid, poinType);
        transactionTemplate.execute(new TransactionCallback<PointOperateResult>() {

            @Override
            public PointOperateResult doInTransaction(TransactionStatus status) {

                try {
                    long id = 0;
                    PointDo pointForUpdate = pointDo;
                    if (pointForUpdate == null) {
                        //无此类型积分，新增.此时积分个数为0
                        pointForUpdate = new PointDo();
                        pointForUpdate.setPointAmout(amount);
                        pointForUpdate.setPointType(poinType.getCode());
                        pointForUpdate.setStatus(PointDo.StatusEnum.ENABLE.getCode());
                        pointForUpdate.setUid(uid);
                        id = pointRepository.add(pointForUpdate);
                    } else {
                        //存在此类积分
                        id = pointForUpdate.getId();
                    }

                    //锁定数据库行
                    PointDo pointInfo = pointRepository.lockById(id);

                    PointRecordDo pointRecordDo = new PointRecordDo();
                    pointRecordDo.setAmout(amount);
                    pointRecordDo.setOperType(PointRecordDo.OperTypeEnum.ADD.getCode());
                    pointRecordDo.setOrderNo(UUID.randomUUID().toString());
                    pointRecordDo.setPointAcId(id);
                    pointRecordDo.setUid(uid);
                    pointRecordRepository.add(pointRecordDo);

                    int amout = amount + pointForUpdate.getPointAmout();
                    pointInfo.setPointAmout(amout);
                    pointRepository.update(pointInfo);
                    result.setSuccess(true);
                } catch (DuplicateKeyException exception) {
                    status.setRollbackOnly();
                    result.setCode(ResultCodeEnum.DUPLICATEKEY.getCode());
                    logger.error(String.format("用户积分增加  -主键冲突 uid=%s.pointType=%s,amount=%s", uid,
                        poinType, amount), exception);
                    result.setSuccess(true);

                } catch (Exception e) {
                    logger.error(String.format("用户积分增加   uid=%s.pointType=%s,amount=%s", uid,
                        poinType, amount), e);
                    status.setRollbackOnly();
                    result.setSuccess(false);
                    result.setCode(ResultCodeEnum.系统错误.getCode());
                }
                return result;
            }

        });

        result.setPointDo(pointRepository.getByUidAndType(uid, poinType));
        return result;
    }

    @Override
    public PointOperateResult use(final String uid, final int amount, final PointTypeEnum poinType) {
        logger.info("用户积分使用   uid={},amout={}", uid, amount);
        final PointOperateResult result = new PointOperateResult();
        if (amount <= 0 || poinType == null || StringUtils.isBlank(uid)) {
            result.setSuccess(false);
            result.setCode(ResultCodeEnum.ILLEGAL_ARGUMENT.getCode());
            return result;
        }

        transactionTemplate.execute(new TransactionCallback<PointOperateResult>() {
            @Override
            public PointOperateResult doInTransaction(TransactionStatus status) {
                try {
                    PointDo pointForUpdate = pointRepository.getByUidAndType(uid, poinType);
                    if (pointForUpdate == null) {
                        //无此类型积分f,结束返回
                        result.setSuccess(false);
                        result.setCode(ResultCodeEnum.用户没有此类积分.getCode());
                        return result;
                    }

                    //存在此类积分
                    //锁定数据库行
                    long id = pointForUpdate.getId();
                    PointDo pointInfo = pointRepository.lockById(id);
                    if (pointInfo.getPointAmout() < amount) {
                        result.setSuccess(false);
                        result.setCode(ResultCodeEnum.用户此类积分不足.getCode());
                        return result;
                    }

                    PointRecordDo pointRecordDo = new PointRecordDo();
                    pointRecordDo.setAmout(amount);
                    pointRecordDo.setOperType(PointRecordDo.OperTypeEnum.USE.getCode());
                    pointRecordDo.setOrderNo(UUID.randomUUID().toString());
                    pointRecordDo.setPointAcId(id);
                    pointRecordDo.setUid(uid);
                    pointRecordRepository.add(pointRecordDo);

                    int amout = amount + pointForUpdate.getPointAmout();
                    pointInfo.setPointAmout(amout);
                    pointRepository.update(pointInfo);
                    result.setSuccess(true);
                } catch (DuplicateKeyException exception) {
                    status.setRollbackOnly();
                    result.setCode(ResultCodeEnum.DUPLICATEKEY.getCode());
                    logger.error(String.format("用户积分使用 -主键冲突 uid=%s.pointType=%s,amount=%s", uid,
                        poinType, amount), exception);
                    result.setSuccess(true);

                } catch (Exception e) {
                    logger.error(String.format("用户积分使用   uid=%s.pointType=%s,amount=%s", uid,
                        poinType, amount), e);
                    status.setRollbackOnly();
                    result.setSuccess(false);
                    result.setCode(ResultCodeEnum.系统错误.getCode());
                }
                return result;
            }

        });

        result.setPointDo(pointRepository.getByUidAndType(uid, poinType));
        return result;
    }
}