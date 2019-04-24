package com.lirt.springboot.service.impl;

import com.lirt.springboot.entity.Employee;
import com.lirt.springboot.mapper.EmployeeMapper;
import com.lirt.springboot.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Author: lirt
 * @Description:
 * @Date: Created in 18:50 2019/4/23
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * cacheManager管理多个cache组件
     * Cacheable的属性
     *  cacheNames/value  缓存组件的名字
     *  key 缓存数据使用的key，可以用它来指定，默认使用方法参数， value方法的返回值
     *      SpEL表达式；#id #a0 #p0 #root.args[0]
     *  keyGenerator  key的生成器与key二选一
     *  cacheManager 缓存管理器或者cacheResolver 缓存解析器
     *  condition 指定符合条件下才缓存
     *  unless 否定缓存，如果unless的条件为true，方法返回值就不会被缓存，可以获取到结果判断
     *  sysc  是否使用异步
     * @param id
     * @return
     */
    @Override
    @Cacheable(cacheNames = "emp") //将结果进行缓存
    public Employee getEmpById(Integer id) {
        logger.info("进行查询"+id+"号员工信息");
        return employeeMapper.getEmpById(id);
    }

    @Override
    @CachePut(value = "emp", key = "#result.id")
    public Employee updateEmp(Employee employee) {
        logger.info("更新 "+employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }

    @Override
    @CacheEvict(value = "emp", key = "#id")
    public void deleteEmpById(Integer id) {
//        employeeMapper.deleteEmpById(id);
        logger.info("删除员工id：" + id);
    }

    @Override
    public void insertEmployee(Employee employee) {
        employeeMapper.insertEmployee(employee);
    }
}
