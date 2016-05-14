package cn.edu.ntu.jtxy.core.model.wx;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import cn.edu.ntu.jtxy.core.model.BaseModel;

public class PriceRecordDo extends BaseModel {

    /**  */
    private static final long serialVersionUID = 1564404235588716793L;

    private long              id;

    private String            uid;

    private String            priceLevel;

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

    public String getPriceLevel() {
        return priceLevel;
    }

    public void setPriceLevel(String priceLevel) {
        this.priceLevel = priceLevel;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public static enum PriceTypeEnum {

        一等奖("one", 20),

        二等奖("two", 10),

        三等奖("three", 3),

        幸运奖("luck", 1);

        private String code;

        private int    point;

        private PriceTypeEnum(String code, int point) {
            this.code = code;
            this.point = point;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public int getPoint() {
            return point;
        }

        public void setPoint(int point) {
            this.point = point;
        }

        public static PriceTypeEnum getByCode(String code) {
            if (StringUtils.isEmpty(code)) {
                return null;
            }
            for (PriceTypeEnum item : values()) {
                if (StringUtils.equals(item.getCode(), code)) {
                    return item;
                }
            }
            return null;
        }
    }
}
