package com.example.projectenoca.service;

import com.example.projectenoca.entity.Department;
import com.example.projectenoca.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlDatabase implements DatabaseManager {

    String url = "jdbc:mysql://localhost:3306/proje";
    String user = "root";
    String password = "eyser123..";

    @Override
    public Connection connectDatabase() throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    @Override
    public void addEmployee(Employee employee) throws SQLException {
        String insertEmployee = "INSERT INTO employee (name, surname, departmentCode, identityNo) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connectDatabase().prepareStatement(insertEmployee);
        preparedStatement.setString(1, employee.getName());
        preparedStatement.setString(2, employee.getSurname());
        preparedStatement.setInt(3, employee.getDepartmentCode());
        preparedStatement.setString(4, employee.getIdentityNo());
        preparedStatement.executeUpdate();
    }

    @Override
    public void addDepartment(Department department) throws SQLException {
        String insertDepartment = "INSERT INTO departmant (departmentName, departmentCode) VALUES (?, ?)";
        PreparedStatement preparedStatement = connectDatabase().prepareStatement(insertDepartment);
        preparedStatement.setString(1, department.getDepartmentName());
        preparedStatement.setInt(2, department.getDepartmentCode());
        preparedStatement.executeUpdate();
    }

    @Override
    public Employee updateEmployeeByIdentityNo(Employee employee) throws SQLException {
        String query = "UPDATE employee SET name = ?, surname = ?, departmentCode = ? WHERE  identityNo = '" + employee.getIdentityNo() + "' ";
        PreparedStatement preparedStatement = connectDatabase().prepareStatement(query);
        preparedStatement.setString(1,employee.getName());
        preparedStatement.setString(2,employee.getSurname());
        preparedStatement.setInt(3,employee.getDepartmentCode());
        preparedStatement.executeUpdate();

        return employee;
    }

    @Override
    public Department updateDepartmentByDepartmentCode(Department department) throws SQLException {
        String query = "UPDATE departmant SET departmentName = ? WHERE  departmentCode = '" + department.getDepartmentCode() + "' ";
        PreparedStatement preparedStatement = connectDatabase().prepareStatement(query);
        preparedStatement.setString(1,department.getDepartmentName());
        preparedStatement.executeUpdate();
        return department;
    }

    @Override
    public String deleteEmployeeByIdentityNo(String identityNO) throws SQLException {
        String deleteEmployee = "DELETE FROM employee where identityNo ='" + identityNO + "'";
        PreparedStatement preparedStatement = connectDatabase().prepareStatement(deleteEmployee);
        preparedStatement.executeUpdate();
        return "Employee deleted";
    }

    @Override
    public String deleteDepartmentByDepartmentCode(int departmentCode) throws SQLException {
        String deleteDepartment = "DELETE FROM departmant where departmentCode = " + departmentCode + " ";
        PreparedStatement preparedStatement = connectDatabase().prepareStatement(deleteDepartment);
        preparedStatement.executeUpdate();
        return "Department deleted";
    }

    @Override
    public List<Employee> listEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String listEmployee = "SELECT * FROM employee";
        Statement stmt = connectDatabase().createStatement();
        ResultSet rs = stmt.executeQuery(listEmployee);
        while (rs.next()) {
            Employee employee = new Employee();
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            int departmentCode = rs.getInt("departmentCode");
            String identityNo = rs.getString("identityNo");
            employee.setName(name);
            employee.setSurname(surname);
            employee.setDepartmentCode(departmentCode);
            employee.setIdentityNo(identityNo);
            employees.add(employee);
        }
        return employees;
    }

    @Override
    public List<Department> listDepartment() throws SQLException {
        List<Department> departments = new ArrayList<>();
        String listDepartment = "SELECT * FROM departmant";
        Statement stmt = connectDatabase().createStatement();
        ResultSet rs = stmt.executeQuery(listDepartment);
        while (rs.next()) {
            Department department = new Department();
            String departmentName = rs.getString("departmentName");
            int departmentCode = rs.getInt("departmentCode");
            department.setDepartmentCode(departmentCode);
            department.setDepartmentName(departmentName);
            departments.add(department);
        }
        return departments;
    }

    @Override
    public Employee listEmployeeByIdentityNo(String identityNo) throws SQLException {
        Employee employee = new Employee();
        String query = "SELECT * FROM employee where identityNo = '" + identityNo + "'";
        Statement stmt = connectDatabase().createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            int departmentCode = rs.getInt("departmentCode");
            employee.setName(name);
            employee.setSurname(surname);
            employee.setDepartmentCode(departmentCode);
            employee.setIdentityNo(identityNo);
        }

        return employee;
    }

    @Override
    public Department listDepartmentByDepartmentCode(int departmentCode) throws SQLException {
        Department department = new Department();
        String query = "SELECT * FROM departmant where departmentCode = " + departmentCode + "";
        Statement stmt = connectDatabase().createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            String name = rs.getString("departmentName");
            department.setDepartmentName(name);
            department.setDepartmentCode(departmentCode);
        }
        return department;
    }
}
