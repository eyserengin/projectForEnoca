package com.example.projectenoca.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
public class Employee {
    @JsonProperty("name")
    String name;

    @JsonProperty("surname")
    String surname;

    @JsonProperty("identityNo")
    String identityNo;

    @JsonProperty("departmentCode")
    Integer departmentCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIdentityNo() {
        return identityNo;
    }

    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo;
    }

    public Integer getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(Integer departmentCode) {
        this.departmentCode = departmentCode;
    }
}
