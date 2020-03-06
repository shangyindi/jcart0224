package com.shangyd.jcartstoreback.dto.out;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CustomerListOutDTO {

    private Integer customerId;

    private String customerName;

    private String email;

    private Byte status;

    @DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    private Date createTime;

    @DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    private Date uploadTime;

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
