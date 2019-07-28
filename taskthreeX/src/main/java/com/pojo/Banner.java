package com.pojo;

import java.util.Date;

public class Banner {
    private Integer bannerId;

    private String bannerName;

    private String type;

    private Date createTime;

    private String createBy;

    private String exhibitionTime;

    private Date updateTime;

    private String updateBy;

    private String productionLink;

    private Integer Status;

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }



    public Integer getBannerId() {
        return bannerId;
    }

    public void setBannerId(Integer bannerId) {
        this.bannerId = bannerId;
    }

    public String getBannerName() {
        return bannerName;
    }

    public void setBannerName(String bannerName) {
        this.bannerName = bannerName == null ? null : bannerName.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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

    public String getExhibitionTime() {
        return exhibitionTime;
    }

    public void setExhibitionTime(String exhibitionTime) {
        this.exhibitionTime = exhibitionTime == null ? null : exhibitionTime.trim();
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

    public String getProductionLink() {
        return productionLink;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "bannerId=" + bannerId +
                ", bannerName='" + bannerName + '\'' +
                ", type='" + type + '\'' +
                ", createTime=" + createTime +
                ", createBy='" + createBy + '\'' +
                ", exhibitionTime='" + exhibitionTime + '\'' +
                ", updateTime=" + updateTime +
                ", updateBy='" + updateBy + '\'' +
                ", productionLink='" + productionLink + '\'' +
                ", Status=" + Status +
                '}';
    }

    public void setProductionLink(String productionLink) {
        this.productionLink = productionLink == null ? null : productionLink.trim();

    }
}