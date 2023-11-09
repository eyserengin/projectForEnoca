package com.example.projectenoca.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Department {

    @JsonProperty("departmentName")
    String departmentName;

    @JsonProperty("departmentCode")
    Integer departmentCode;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(Integer departmentCode) {
        this.departmentCode = departmentCode;
    }
}
