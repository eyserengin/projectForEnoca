package com.example.projectenoca.service;

import com.example.projectenoca.entity.Department;
import com.example.projectenoca.entity.Employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface DatabaseManager {


    Connection connectDatabase() throws SQLException;

    void addEmployee(Employee employee) throws SQLException;

    void addDepartment(Department department) throws SQLException;

    Employee updateEmployeeByIdentityNo(Employee employee) throws SQLException;

    Department updateDepartmentByDepartmentCode(Department department) throws SQLException;

    String deleteEmployeeByIdentityNo(String identityNO) throws SQLException;

    String deleteDepartmentByDepartmentCode(int departmentCode) throws SQLException;

    List<?> listEmployees() throws SQLException;

    List<?> listDepartment() throws SQLException;

    Employee listEmployeeByIdentityNo(String identityNo) throws SQLException;
    Department listDepartmentByDepartmentCode(int departmentCode) throws SQLException;



}
