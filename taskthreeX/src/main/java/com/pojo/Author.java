package com.pojo;

import java.util.Date;

public class Author {
    private Integer auhorId;

    private String authorName;

    private String authorIntroduce;

    private String authorProduction;

    private String createBy;

    private Date createTime;

    private Date updateTime;

    private String updateBy;

    public Integer getAuhorId() {
        return auhorId;
    }

    public void setAuhorId(Integer auhorId) {
        this.auhorId = auhorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName == null ? null : authorName.trim();
    }

    public String getAuthorIntroduce() {
        return authorIntroduce;
    }

    public void setAuthorIntroduce(String authorIntroduce) {
        this.authorIntroduce = authorIntroduce == null ? null : authorIntroduce.trim();
    }

    public String getAuthorProduction() {
        return authorProduction;
    }

    public void setAuthorProduction(String authorProduction) {
        this.authorProduction = authorProduction == null ? null : authorProduction.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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