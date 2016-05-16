package cn.edu.ntu.jtxy.core.repository.wx.cond;

import cn.edu.ntu.jtxy.core.repository.wx.pagelist.cond.BasePageQueryCond;

public class PrizePageQueryCond extends BasePageQueryCond {

    /**  */
    private static final long serialVersionUID = -2117800548469148394L;

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
