package cn.edu.ntu.jtxy.core.model.mng;

import java.util.Date;

import cn.edu.ntu.jtxy.core.model.BaseModel;

public class NewsDo extends BaseModel {

    /**  */
    private static final long serialVersionUID = -3624478298190336985L;

    private long              id;

    private String            media_id;

    private String            title;

    private String            author;

    private String            digest;

    private String            url;

    private String            updateTime;

    private Date              createTime;

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}