package com.pojo;

import java.util.Date;

public class Production {
    private Integer productionId;

    private String productionName;

    private String productionType;

    private String productionAuthor;

    private String exhibitionTime;

    private String exhibition;

    private String updateTime;

    private String photographyLink;

    private String productionLink;

    private String createTime;

    private String authorSharing;

    private String productionBrief;

    public Integer getProductionId() {
        return productionId;
    }

    public void setProductionId(Integer productionId) {
        this.productionId = productionId;
    }

    public String getProductionName() {
        return productionName;
    }

    public void setProductionName(String productionName) {
        this.productionName = productionName == null ? null : productionName.trim();
    }

    public String getProductionType() {
        return productionType;
    }

    public void setProductionType(String productionType) {
        this.productionType = productionType == null ? null : productionType.trim();
    }

    public String getProductionAuthor() {
        return productionAuthor;
    }

    public void setProductionAuthor(String productionAuthor) {
        this.productionAuthor = productionAuthor == null ? null : productionAuthor.trim();
    }

    public String getExhibitionTime() {
        return exhibitionTime;
    }

    public void setExhibitionTime(String exhibitionTime) {
        this.exhibitionTime = exhibitionTime;
    }

    public String getExhibition() {
        return exhibition;
    }

    public void setExhibition(String exhibition) {
        this.exhibition = exhibition == null ? null : exhibition.trim();
    }

    public String getUpStringTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getPhotographyLink() {
        return photographyLink;
    }

    public void setPhotographyLink(String photographyLink) {
        this.photographyLink = photographyLink == null ? null : photographyLink.trim();
    }

    public String getProductionLink() {
        return productionLink;
    }

    public void setProductionLink(String productionLink) {
        this.productionLink = productionLink == null ? null : productionLink.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getAuthorSharing() {
        return authorSharing;
    }

    public void setAuthorSharing(String authorSharing) {
        this.authorSharing = authorSharing == null ? null : authorSharing.trim();
    }

    public String getProductionBrief() {
        return productionBrief;
    }

    public void setProductionBrief(String productionBrief) {
        this.productionBrief = productionBrief == null ? null : productionBrief.trim();
    }



    @Override
    public String toString() {
        return "Production{" +
                "productionId=" + productionId +
                ", productionName='" + productionName + '\'' +
                ", productionType='" + productionType + '\'' +
                ", productionAuthor='" + productionAuthor + '\'' +
                ", exhibitionTime=" + exhibitionTime +
                ", exhibition='" + exhibition + '\'' +
                ", updateTime=" + updateTime +
                ", photographyLink='" + photographyLink + '\'' +
                ", productionLink='" + productionLink + '\'' +
                ", createTime=" + createTime +
                ", authorSharing='" + authorSharing + '\'' +
                ", productionBrief='" + productionBrief + '\'' +
                '}';
    }
}