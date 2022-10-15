package com.crm.common.context;

public class PersonContext {

    /**
     * 账号id
     */
    private Integer accountId;

    /**
     * 账号
     */
    private String accountNumber;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
