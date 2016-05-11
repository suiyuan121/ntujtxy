package cn.edu.ntu.jtxy.core.model.wx;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import cn.edu.ntu.jtxy.core.model.BaseModel;

public class AnswerRecordsDo extends BaseModel {

    /**  */
    private static final long serialVersionUID = 4913412587132708666L;

    private long              id;

    private String            uid;

    private long              questionId;

    private String            result;

    private Date              createTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public static enum ResultEnum {

        correct("c", "正确"),

        wrong("w", "错误");

        private String code;

        private String desc;

        private ResultEnum(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        /**
         * Getter method for property <tt>code</tt>.
         * 
         * @return property value of code
         */
        public String getCode() {
            return code;
        }

        /**
         * Setter method for property <tt>code</tt>.
         * 
         * @param code value to be assigned to property code
         */
        public void setCode(String code) {
            this.code = code;
        }

        /**
         * Getter method for property <tt>desc</tt>.
         * 
         * @return property value of desc
         */
        public String getDesc() {
            return desc;
        }

        /**
         * Setter method for property <tt>desc</tt>.
         * 
         * @param desc value to be assigned to property desc
         */
        public void setDesc(String desc) {
            this.desc = desc;
        }

        public static ResultEnum getByCode(String code) {
            if (StringUtils.isEmpty(code)) {
                return null;
            }
            for (ResultEnum item : values()) {
                if (StringUtils.equals(item.getCode(), code)) {
                    return item;
                }
            }
            return null;
        }
    }
}
