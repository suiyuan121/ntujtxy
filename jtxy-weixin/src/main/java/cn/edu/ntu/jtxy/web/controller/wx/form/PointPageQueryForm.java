package cn.edu.ntu.jtxy.web.controller.wx.form;

import cn.edu.ntu.jtxy.core.model.BaseModel;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: PointPageQueryForm.java, v 0.1 2016年5月6日 上午10:54:37 zhangjinntu@163.com Exp $
 */
public class PointPageQueryForm extends BaseModel {

    /**  */
    private static final long serialVersionUID = -6841334437666235414L;

    private int               currentPage      = 1;

    private int               pageNum;

    private String            stuNo;

    private String            stuName;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

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
