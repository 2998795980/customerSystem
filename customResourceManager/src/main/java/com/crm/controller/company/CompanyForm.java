package com.crm.controller.company;

import org.springframework.beans.BeanUtils;

import com.crm.dao.entity.Company;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CompanyForm {

    @NotBlank(message = "公司id不能为空")
    private String companyId;

    @NotBlank(message = "公司名称不能为空")
    private String companyName;

    @NotBlank(message = "公司地址不能为空" )
    private String address;

    public CompanyForm(String companyId, String companyName, String address) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.address = address;
    }

    @Override
    public String toString() {
        return "CompanyForm{" + "companyId='" + companyId + '\'' + ", companyName='" + companyName + '\''
            + ", address='" + address + '\'' + '}';
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

    public Company copyCompany(Company company) {
        BeanUtils.copyProperties(this, company);
        return company;
    }

}
