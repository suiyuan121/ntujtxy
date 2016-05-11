package cn.edu.ntu.jtxy.core.repository.wx.cond;

import org.apache.commons.lang.StringUtils;

import cn.edu.ntu.jtxy.core.repository.wx.pagelist.cond.BasePageQueryCond;

public class ImagesPageQueryCond extends BasePageQueryCond {

    /**  */
    private static final long serialVersionUID = -7900987124940428647L;

    private String            uid;

    private String            orderType;

    private String            type;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static enum OrderTypeEnum {

        amount("amount", "按照被点赞次数"),

        create_time("create_time", "创建时间");

        private String code;

        private String desc;

        private OrderTypeEnum(String code, String desc) {
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

        public static OrderTypeEnum getByCode(String code) {
            if (StringUtils.isEmpty(code)) {
                return null;
            }
            for (OrderTypeEnum item : values()) {
                if (StringUtils.equals(item.getCode(), code)) {
                    return item;
                }
            }
            return null;
        }
    }
}
