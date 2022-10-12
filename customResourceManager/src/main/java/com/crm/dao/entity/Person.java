package com.crm.dao.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 客户表
 * </p>
 *
 * @author yuzhe
 * @since 2022-10-12
 */
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

      private Integer id;

    private String name;

    private String phoneNumber;

    /**
     * 职位
     */
    private String position;

    /**
     * 部门
     */
    private String department;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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
        return "Person{" +
        "id=" + id +
        ", name=" + name +
        ", phoneNumber=" + phoneNumber +
        ", position=" + position +
        ", department=" + department +
        ", state=" + state +
        ", createdBy=" + createdBy +
        ", createdTime=" + createdTime +
        ", updatedTime=" + updatedTime +
        ", updatedBy=" + updatedBy +
        "}";
    }
}
