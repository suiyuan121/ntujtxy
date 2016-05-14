package cn.edu.ntu.jtxy.core.dao.wx;

import java.util.List;

import cn.edu.ntu.jtxy.core.model.wx.UserInfoDo;
import cn.edu.ntu.jtxy.core.repository.UserInfoFull;

/**
 * 
 * @author {jin.zhang@witontek.com}
 * @version $Id: UserInfoDao.java, v 0.1 2016年3月28日 下午3:56:15 {jin.zhang@witontek.com} Exp $
 */
public interface UserInfoDao {

    /**
     * 
     * @param userInfoDo
     * @return
     */
    public long add(UserInfoDo userInfoDo);

    /**
     * 
     * @param userInfoCond
     * @return
     */
    public List<UserInfoDo> getByCond(String stuNo, String openId, String status);

    /**
     * 
     * @return
     */
    public long getSeq();

    /**
     * 
     * @param openId
     * @return
     */
    public boolean unBind(String openId);

    /**
     * 
     * @param userInfoDo
     * @return
     */
    public boolean updateOpenIdAndStatusByUid(String openId, String uid, String status);

    /**
     * 
     * @param uid
     * @return
     */
    public UserInfoDo getByUid(String uid);

    /**
     * 
     * @param uid
     * @return
     */
    public List<UserInfoFull> getAllUserInfoByCond(String uid);
}
