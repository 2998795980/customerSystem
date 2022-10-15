package com.crm.dao.entity;

import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 账号表
 * </p>
 *
 * @author yuzhe
 * @since 2022-10-12
 */
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 状态 -1 删除 0 禁用 1 可用
     */
    private Integer state;

    private LocalDateTime createdTime;

    private Integer createdBy;

    private Integer updatedBy;

    private LocalDateTime updatedTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = DigestUtil.sha1Hex(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public String toString() {
        return "Account{" +
        "id=" + id +
        ", username=" + username +
        ", account=" + account +
        ", password=" + password +
        ", email=" + email +
        ", state=" + state +
        ", createdTime=" + createdTime +
        ", createdBy=" + createdBy +
        ", updatedBy=" + updatedBy +
        ", updatedTime=" + updatedTime +
        "}";
    }

    public Account() {
    }

    public Account(Integer id, String username, String account, String password, String email, Integer state, LocalDateTime createdTime, Integer createdBy, Integer updatedBy, LocalDateTime updatedTime) {
        this.id = id;
        this.username = username;
        this.account = account;
        this.password = password;
        this.email = email;
        this.state = state;
        this.createdTime = createdTime;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.updatedTime = updatedTime;
    }

    public Account(String username, String account, String password, String email, Integer state, LocalDateTime createdTime) {
        this.username = username;
        this.account = account;
        this.password = password;
        this.email = email;
        this.state = state;
        this.createdTime = createdTime;
    }

    public Account(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public Account(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }
}
