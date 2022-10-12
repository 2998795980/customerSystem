package com.crm.dao.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 客户公司表
 * </p>
 *
 * @author yuzhe
 * @since 2022-10-12
 */
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String companyId;

    private String companyName;

    private String address;

    private Integer state;

    private Integer createdBy;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;

    private Integer updatedBy;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public String toString() {
        return "Company{" + "id=" + id + ", companyId=" + companyId + ", companyName=" + companyName + ", address=" + address + ", state=" + state + ", createdBy=" + createdBy + ", createdTime=" + createdTime + ", updatedTime=" + updatedTime + ", updatedBy=" + updatedBy + "}";
    }
}
