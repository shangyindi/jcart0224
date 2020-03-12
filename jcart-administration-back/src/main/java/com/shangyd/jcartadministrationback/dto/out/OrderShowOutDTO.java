package com.shangyd.jcartadministrationback.dto.out;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class OrderShowOutDTO {
    private Long orderId;
    private Integer customerId;
    private Double totalPrice;
    @JsonIgnore
    private Date createTime;
    private Long createTimestamp;
    @JsonIgnore
    private Date updateTime;
    private Long updateTimestamp;
    private String email;
    private String mobile;
    private String realName;
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Long getCreateTimestamp() {
        return this.createTime == null ? null : this.createTime.getTime();
    }

    public Long getUpdateTimestamp() {
        return this.updateTime == null ? null : this.updateTime.getTime();
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setCreateTimestamp(Long createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setUpdateTimestamp(Long updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }
}
