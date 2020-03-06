package com.shangyd.jcartadministrationback.dto.in;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class AdministrationUploadInDTO {
    private Integer administrationId;
    private String username;
    private String email;
    private Byte status;
    @DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    private Date createTime;
    private String realName;

    public AdministrationUploadInDTO() {
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAdministrationId() {
        return administrationId;
    }

    public void setAdministrationId(Integer administrationId) {
        this.administrationId = administrationId;
    }
}
