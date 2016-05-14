package cn.edu.ntu.jtxy.core.repository.wx.cond;

import cn.edu.ntu.jtxy.core.repository.wx.pagelist.cond.BasePageQueryCond;

public class PriceRecordPageQueryCond extends BasePageQueryCond {

    /**  */
    private static final long serialVersionUID = -593142599680932861L;

    private String            uid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

}
