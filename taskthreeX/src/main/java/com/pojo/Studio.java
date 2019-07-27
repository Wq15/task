package com.pojo;

import java.util.Date;

public class Studio {
    private Integer studioId;

    private String studioName;

    private String studioIntroduce;

    private String studioConnection;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    public Integer getStudioId() {
        return studioId;
    }

    public void setStudioId(Integer studioId) {
        this.studioId = studioId;
    }

    public String getStudioName() {
        return studioName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName == null ? null : studioName.trim();
    }

    public String getStudioIntroduce() {
        return studioIntroduce;
    }

    public void setStudioIntroduce(String studioIntroduce) {
        this.studioIntroduce = studioIntroduce == null ? null : studioIntroduce.trim();
    }

    public String getStudioConnection() {
        return studioConnection;
    }

    public void setStudioConnection(String studioConnection) {
        this.studioConnection = studioConnection == null ? null : studioConnection.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }
}