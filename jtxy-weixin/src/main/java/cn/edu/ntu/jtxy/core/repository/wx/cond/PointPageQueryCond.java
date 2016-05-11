package cn.edu.ntu.jtxy.core.repository.wx.cond;

import cn.edu.ntu.jtxy.core.repository.wx.pagelist.cond.BasePageQueryCond;

public class PointPageQueryCond extends BasePageQueryCond {

    /**  */
    private static final long serialVersionUID = 9133922671800498248L;

    private String            stuNo;

    private String            stuName;

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

}
