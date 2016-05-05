package cn.edu.ntu.jtxy.core.repository.wx.impl;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.ntu.jtxy.core.dao.wx.PointDao;
import cn.edu.ntu.jtxy.core.model.wx.PointDo;
import cn.edu.ntu.jtxy.core.model.wx.PointDo.PointTypeEnum;
import cn.edu.ntu.jtxy.core.repository.wx.PointRepository;

/**
 * 
 * @author {jin.zhang@witontek.com}
 * @version $Id: PointRecordRepository.java, v 0.1 2016年4月14日 下午2:14:24 {jin.zhang@witontek.com} Exp $
 */
public class PointRepositoryImpl implements PointRepository {

    private static final Logger logger = LoggerFactory.getLogger(PointRecordRepositoryImpl.class);

    @Autowired
    private PointDao            pointDao;

    @Override
    public long add(PointDo pointDo) {
        logger.info("积分新增 pointDo={}", pointDo);
        if (pointDo == null) {
            return -1;
        }
        return pointDao.add(pointDo);
    }

    @Override
    public PointDo getByUidAndType(String uid, PointTypeEnum poinType) {
        logger.info("积分查询   uid={},poinType={}", uid, poinType);
        if (StringUtils.isBlank(uid) || poinType == null) {
            return null;
        }
        return pointDao.getByUidAndType(uid, poinType.getCode());
    }

    @Override
    public PointDo lockById(long id) {
        logger.info("枷锁  id={}", id);
        if (id <= 0) {
            return null;
        }
        return pointDao.lockById(id);
    }

    @Override
    public boolean update(PointDo pointInfo) {
        logger.info("更新 pointInfo={}", pointInfo);
        if (pointInfo == null) {
            return false;
        }
        return pointDao.update(pointInfo);
    }
}
