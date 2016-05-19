package cn.edu.ntu.jtxy.core.repository.wx.model;

import java.util.Date;

import cn.edu.ntu.jtxy.core.model.BaseModel;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: PointInfo.java, v 0.1 2016年5月6日 上午11:21:57 zhangjinntu@163.com Exp $
 */
public class PrizeInfo extends BaseModel {

    /**  */
    private static final long serialVersionUID = 8830496702316801138L;

    private long              id;

    private String            uid;

    private String            prizeType;

    private String            stuNo;

    private String            realName;

    private Date              createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPrizeType() {
        return prizeType;
    }

    public void setPrizeType(String prizeType) {
        this.prizeType = prizeType;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

}
