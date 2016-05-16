package cn.edu.ntu.jtxy.web.controller.mng.form;

import cn.edu.ntu.jtxy.core.model.BaseModel;

public class PointInfoQueryForm extends BaseModel {

    /**  */
    private static final long serialVersionUID = -3882060402477415280L;
    /** 默认第一页 */
    private int               currentPage      = 1;

    private String            type;

    private String            stuName;

    private String            stuNo;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

}
