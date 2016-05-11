package cn.edu.ntu.jtxy.core.repository.mng.cond;

import cn.edu.ntu.jtxy.core.repository.wx.pagelist.cond.BasePageQueryCond;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: DaliyQuestionPageQueryCond.java, v 0.1 2016年5月5日 下午4:32:07 zhangjinntu@163.com Exp $
 */
public class DaliyQuestionPageQueryCond extends BasePageQueryCond {

    /**  */
    private static final long serialVersionUID = 7920150980010453801L;

    private String            content;

    private String            status;

    private int               value;

    private String            type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
