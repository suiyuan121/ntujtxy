package cn.edu.ntu.jtxy.web.controller.mng.form;

import cn.edu.ntu.jtxy.core.model.BaseModel;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: QueryPrizeInfoForm.java, v 0.1 2016年5月14日 下午8:53:55 zhangjinntu@163.com Exp $
 */
public class QueryPrizeInfoForm extends BaseModel {

    /**  */
    private static final long serialVersionUID = -7951241368005224511L;

    private String            stuNo;

    private String            stuName;

    /** 默认第一页 */
    private int               currentPage      = 1;

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

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

}
