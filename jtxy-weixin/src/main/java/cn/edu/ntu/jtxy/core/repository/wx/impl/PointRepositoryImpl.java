package cn.edu.ntu.jtxy.core.repository.wx.impl;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.ntu.jtxy.core.dao.wx.PointDao;
import cn.edu.ntu.jtxy.core.model.wx.PointDo;
import cn.edu.ntu.jtxy.core.model.wx.PointDo.PointTypeEnum;
import cn.edu.ntu.jtxy.core.repository.wx.PointRepository;
import cn.edu.ntu.jtxy.core.repository.wx.cond.PointPageQueryCond;
import cn.edu.ntu.jtxy.core.repository.wx.model.PointInfo;
import cn.edu.ntu.jtxy.core.repository.wx.pagelist.PageList;

/**
 * 
 * @author {jin.zhang@witontek.com}
 * @version $Id: PointRecordRepository.java, v 0.1 2016年4月14日 下午2:14:24 {jin.zhang@witontek.com} Exp $
 */
public class PointRepositoryImpl implements PointRepository {

    private static final Logger logger = LoggerFactory.getLogger(PointRecordRepositoryImpl.class);

    @Autowired
    private PointDao            pointDao;

    /** 
     * @see cn.edu.ntu.jtxy.core.repository.wx.PointRepository#add(cn.edu.ntu.jtxy.core.model.wx.PointDo)
     */
    @Override
    public long add(PointDo pointDo) {
        logger.info("积分新增 pointDo={}", pointDo);
        if (pointDo == null) {
            return -1;
        }
        return pointDao.add(pointDo);
    }

    /** 
     * @see cn.edu.ntu.jtxy.core.repository.wx.PointRepository#getByUidAndType(java.lang.String, cn.edu.ntu.jtxy.core.model.wx.PointDo.PointTypeEnum)
     */
    @Override
    public PointDo getByUidAndType(String uid, PointTypeEnum poinType) {
        logger.info("积分查询   uid={},poinType={}", uid, poinType);
        if (StringUtils.isBlank(uid) || poinType == null) {
            return null;
        }
        return pointDao.getByUidAndType(uid, poinType.getCode());
    }

    /** 
     * @see cn.edu.ntu.jtxy.core.repository.wx.PointRepository#lockById(long)
     */
    @Override
    public synchronized PointDo lockById(long id) {
        logger.info("枷锁  id={}", id);
        if (id <= 0) {
            return null;
        }
        return pointDao.lockById(id);
    }

    /** 
     * @see cn.edu.ntu.jtxy.core.repository.wx.PointRepository#update(cn.edu.ntu.jtxy.core.model.wx.PointDo)
     */
    @Override
    public boolean update(PointDo pointInfo) {
        logger.info("更新 pointInfo={}", pointInfo);
        if (pointInfo == null) {
            return false;
        }
        return pointDao.update(pointInfo);
    }

    /** 
     * @see cn.edu.ntu.jtxy.core.repository.wx.PointRepository#pageQuery(cn.edu.ntu.jtxy.core.repository.wx.cond.PointPageQueryCond)
     */
    @Override
    public PageList<PointInfo> pageQuery(PointPageQueryCond cond) {
        logger.info("point 分页查询  cond={}", cond);
        return pointDao.pageQuery(cond.getPageSize(), cond.getCurrentPage(), cond.getStuNo(),
            cond.getStuName());
    }

    @Override
    public int getTotalByUid(String uid) {
        logger.info("查询全部积分    uid={}", uid);
        if (StringUtils.isEmpty(uid)) {
            return 0;
        }
        return pointDao.getTotalByUid(uid);
    }
}
