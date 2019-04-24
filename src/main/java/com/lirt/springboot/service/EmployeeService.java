package com.lirt.springboot.service;

import com.lirt.springboot.entity.Employee;

/**
 * @Author: lirt
 * @Description:
 * @Date: Created in 18:49 2019/4/23
 */
public interface EmployeeService {

    Employee getEmpById(Integer id);

    Employee updateEmp(Employee employee);

    void deleteEmpById(Integer id);

    void insertEmployee(Employee employee);
}
