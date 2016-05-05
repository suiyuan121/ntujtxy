package cn.edu.ntu.jtxy.core.dao.wx.impl;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.ntu.jtxy.core.dao.wx.PointDao;
import cn.edu.ntu.jtxy.core.model.wx.PointDo;

/**
 * 
 * @author {jin.zhang@witontek.com}
 * @version $Id: RefreshTokenDaoImpl.java, v 0.1 2016年3月22日 下午2:00:12 {jin.zhang@witontek.com} Exp $
 */
public class PointDaoImpl extends SqlSessionDaoSupport implements PointDao {

    private static final Logger logger    = LoggerFactory.getLogger(PointDaoImpl.class);

    private static final String NAMESPACE = PointDao.class.getName();

    @Override
    public long add(PointDo pointDo) {
        logger.info("积分新增  pointDo={}", pointDo);
        getSqlSession().insert(NAMESPACE + ".add", pointDo);
        return pointDo.getId();
    }

    @Override
    public PointDo lockById(long id) {
        logger.info("加锁    id={}", id);
        return getSqlSession().selectOne(NAMESPACE + ".lockById", id);
    }

    @Override
    public boolean update(PointDo pointInfo) {
        logger.info("更新    pointInfo={}", pointInfo);
        return getSqlSession().update(NAMESPACE + ".update", pointInfo) == 1;
    }

    @Override
    public PointDo getByUidAndType(String uid, String type) {
        logger.info("积分查询   uid={},poinType={}", uid, type);
        Map<String, String> map = new HashMap<String, String>();
        map.put("uid", uid);
        map.put("type", type);
        return getSqlSession().selectOne(NAMESPACE + ".getByUidAndType", map);
    }

}
