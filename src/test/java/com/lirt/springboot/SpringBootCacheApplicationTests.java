package com.lirt.springboot;

import com.lirt.springboot.entity.Employee;
import com.lirt.springboot.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootCacheApplicationTests {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    StringRedisTemplate stringRedisTemplate; //k-v 都是字符串

    @Autowired
    RedisTemplate redisTemplate; //k-v都是对象的

    @Autowired
    RedisTemplate<Object, Employee> employeeRedisTemplate;

    @Test
    public void contextLoads() {
        Employee employee = employeeService.getEmpById(1);
        employeeRedisTemplate.opsForValue().set("emp-01", employee);
    }

}
