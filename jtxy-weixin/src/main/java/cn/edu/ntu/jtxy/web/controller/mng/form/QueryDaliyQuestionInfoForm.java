package cn.edu.ntu.jtxy.web.controller.mng.form;

import cn.edu.ntu.jtxy.core.model.BaseModel;
import cn.edu.ntu.jtxy.core.model.mng.DailyQuestionDo;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: QueryDaliyQuestionInfoForm.java, v 0.1 2016年5月5日 下午4:19:55 zhangjinntu@163.com Exp $
 */
public class QueryDaliyQuestionInfoForm extends BaseModel {

    /**  */
    private static final long serialVersionUID = -1150626834260893350L;

    private String            content;

    //默认状态为E
    private String            status           = DailyQuestionDo.StatusEnum.ENABLE.getCode();

    private int               value            = 1;

    private int               currentPage      = 1;

    private String            type             = DailyQuestionDo.TypeEnum.COMMON.getCode();

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
