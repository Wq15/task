package com.pojo;

import java.util.Date;

public class Comment {
    private Integer visitorId;

    private String nickname;

    private Long createTime;

    private String visitorComment;

    private Integer productionId;

    private Integer status;

    private Date updateTime;

    private String updateBy;

    private String commentBest;



    public Integer getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Integer visitorId) {
        this.visitorId = visitorId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getVisitorComment() {
        return visitorComment;
    }

    public void setVisitorComment(String visitorComment) {
        this.visitorComment = visitorComment;
    }

    public Integer getProductionId() {
        return productionId;
    }

    public void setProductionId(Integer productionId) {
        this.productionId = productionId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        this.updateBy = updateBy;
    }

    public String getCommentBest() {
        return commentBest;
    }

    public void setCommentBest(String commentBest) {
        this.commentBest = commentBest;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "visitorId=" + visitorId +
                ", nickname='" + nickname + '\'' +
                ", createTime=" + createTime +
                ", visitorComment='" + visitorComment + '\'' +
                ", productionId=" + productionId +
                ", status=" + status +
                ", updateTime=" + updateTime +
                ", updateBy='" + updateBy + '\'' +
                ", commentBest='" + commentBest + '\'' +
                '}';
    }
}