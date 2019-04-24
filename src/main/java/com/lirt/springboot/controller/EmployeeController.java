package com.lirt.springboot.controller;

import com.lirt.springboot.entity.Employee;
import com.lirt.springboot.service.EmployeeService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lirt
 * @Description:
 * @Date: Created in 18:53 2019/4/23
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("emp/{id}")
    public Employee getEmpoyee(@PathVariable("id")Integer id) {
        return employeeService.getEmpById(id);
    }

    @GetMapping("emp")
    public Employee updateEmp(Employee employee) {
        return employeeService.updateEmp(employee);
    }

    @GetMapping("delemp")
    public String deleteEmp(Integer id) {
        employeeService.deleteEmpById(id);
        return "success";
    }
}
