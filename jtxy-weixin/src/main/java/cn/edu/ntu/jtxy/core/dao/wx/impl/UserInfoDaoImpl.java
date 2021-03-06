package cn.edu.ntu.jtxy.core.dao.wx.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import cn.edu.ntu.jtxy.core.dao.wx.UserInfoDao;
import cn.edu.ntu.jtxy.core.model.wx.SeqDo;
import cn.edu.ntu.jtxy.core.model.wx.UserInfoDo;
import cn.edu.ntu.jtxy.core.repository.UserInfoFull;

/**
 * 
 * @author {jin.zhang@witontek.com}
 * @version $Id: UserInfoDao.java, v 0.1 2016年3月28日 下午3:56:15 {jin.zhang@witontek.com} Exp $
 */
public class UserInfoDaoImpl extends SqlSessionDaoSupport implements UserInfoDao {

    private static final Logger logger    = LoggerFactory.getLogger(UserInfoDaoImpl.class);

    private static final String NAMESPACE = UserInfoDao.class.getName();

    @Override
    public long add(UserInfoDo userInfoDo) {
        logger.info("新增用户   userInfoDo={}", userInfoDo);
        getSqlSession().insert(NAMESPACE + ".add", userInfoDo);
        return userInfoDo.getId();
    }

    @Override
    public List<UserInfoDo> getByCond(String stuNo, String openId, String status) {
        logger.info("用户查询    stuNo={},openId={}", stuNo, openId);
        Map<String, String> map = new HashMap<String, String>();
        map.put("openId", openId);
        map.put("stuNo", stuNo);
        map.put("status", status);
        return getSqlSession().selectList(NAMESPACE + ".getByCond", map);
    }

    @Override
    public long getSeq() {
        logger.info("uid 获取seq");
        SeqDo seqDo = new SeqDo();
        seqDo.setMemo("a");
        int size = getSqlSession().insert(NAMESPACE + ".getSeq", seqDo);
        Assert.isTrue(size == 1, String.format("insert error. do={}", seqDo));
        return seqDo.getId();
    }

    @Override
    public boolean unBind(String openId) {
        logger.info("用户解绑   openId={}", openId);
        return getSqlSession().update(NAMESPACE + ".unBindOpenId", openId) == 1;
    }

    @Override
    public boolean updateOpenIdAndStatusByUid(String openId, String uid, String status) {
        logger.info("用户更新  openId={}，uid={},status={}", openId, uid, status);
        Map<String, String> map = new HashMap<String, String>();
        map.put("openId", openId);
        map.put("uid", uid);
        map.put("status", status);
        return getSqlSession().update(NAMESPACE + ".updateOpenIdAndStatusByUid", map) == 1;
    }

    @Override
    public UserInfoDo getByUid(String uid) {
        logger.info("用户查询  uid={}", uid);
        return getSqlSession().selectOne(NAMESPACE + ".getByUid", uid);
    }

    /** 
     * @see cn.edu.ntu.jtxy.core.dao.wx.UserInfoDao#getAllUserInfoByCond(java.lang.String)
     */
    @Override
    public List<UserInfoFull> getAllUserInfoByCond(String uid) {
        logger.info("查询用户全部信息    uid={}", uid);
        Map<String, String> map = new HashMap<String, String>();
        map.put("uid", uid);
        return getSqlSession().selectList("getAllUserInfoByCond", map);
    }
}
