package com.example.projectenoca;


import com.example.projectenoca.entity.Department;
import com.example.projectenoca.entity.Employee;
import com.example.projectenoca.service.DatabaseManager;
import com.example.projectenoca.service.MySqlDatabase;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/project")
public class Controller {
    MySqlDatabase mySqlDatabase = new MySqlDatabase();
    @GetMapping("/listEmployees")
    public List<Employee> listEmployee() throws SQLException {
        return mySqlDatabase.listEmployees();
    }

    @GetMapping("/listEmployeeByIdentityNo/{identityNo}")
    public Employee listEmployeeByIdentityNo(@PathVariable String identityNo) throws SQLException{
        return mySqlDatabase.listEmployeeByIdentityNo(identityNo);
    }
    @GetMapping("/listDepartments")
    public List<Department> listDepartment() throws SQLException {
        return mySqlDatabase.listDepartment();
    }
    @GetMapping("/listDepartmentByDepartmentCode/{departmentCode}")
    public Department listDepartmentByDepartmentCode(@PathVariable int departmentCode) throws SQLException {
        return mySqlDatabase.listDepartmentByDepartmentCode(departmentCode);
    }
    @PostMapping("/newEmployee")
    public Employee newEmployee(@RequestBody Employee employee) throws SQLException {
        mySqlDatabase.addEmployee(employee);
        return employee;
    }
    @PostMapping("/newDepartment")
    public Department newDepartment(@RequestBody Department department) throws SQLException {
        mySqlDatabase.addDepartment(department);
        return department;
    }
    @DeleteMapping("/deleteEmployeeByIdentityNo/{identityNo}")
    public String deleteEmployeeByIdentityNo(@PathVariable String identityNo) throws SQLException {
        return mySqlDatabase.deleteEmployeeByIdentityNo(identityNo);
    }
    @DeleteMapping("/deleteDepartmentByDepartmentCode/{departmentCode}")
    public String deleteDepartmentByDepartmentCode(@PathVariable int departmentCode) throws SQLException {
        return mySqlDatabase.deleteDepartmentByDepartmentCode(departmentCode);
    }
    @PutMapping("/updateEmployeeByIdentityNo/{identityNo}")
    public Employee updateEmployeeByIdentityNo(@RequestBody Employee employee, @PathVariable String identityNo) throws SQLException {
        employee.setIdentityNo(identityNo);
        return mySqlDatabase.updateEmployeeByIdentityNo(employee);
    }

    @PutMapping("/updateDepartmentByDepartmentCode/{departmentCode}")
    public Department updateDepartmentByDepartmentCode(@RequestBody Department department,@PathVariable int departmentCode) throws SQLException {
        department.setDepartmentCode(departmentCode);
        return mySqlDatabase.updateDepartmentByDepartmentCode(department);
    }
}
