package cn.edu.ntu.jtxy.core.repository.mng.cond;

import cn.edu.ntu.jtxy.core.repository.wx.pagelist.cond.BasePageQueryCond;

public class NewsPageQueryCond extends BasePageQueryCond {

    /**  */
    private static final long serialVersionUID = 7920150980010453801L;

    private String            title;

    private String            type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
