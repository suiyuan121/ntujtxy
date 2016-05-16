package cn.edu.ntu.jtxy.web.controller.mng.form;

import cn.edu.ntu.jtxy.core.model.BaseModel;

public class NewsQueryForm extends BaseModel {

    /**  */
    private static final long serialVersionUID = -2811783030798987540L;

    private int               currentPage      = 1;

    private int               pageNum;

    private String            title;

    private String            type;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
