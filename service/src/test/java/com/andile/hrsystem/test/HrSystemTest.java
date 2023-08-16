/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andile.hrsystem.test;

import com.andile.hrsystem.common.UserStatus;
import com.andile.hrsystem.domain.Employee;
import com.andile.hrsystem.domain.User;
import com.andile.hrsystem.domain.UserRole;
import com.andile.hrsystem.persistence.TestDataSourceConfiguration;
import com.andile.hrsystem.service.EmployeeServiceLocal;
import com.andile.hrsystem.service.UserRoleServiceLocal;
import com.andile.hrsystem.service.UserServiceLocal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author S2026080
 */
@EnableJpaAuditing
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestDataSourceConfiguration.class)
public class HrSystemTest {
    
     @Autowired
    private UserServiceLocal userService;

    @Autowired
    private UserRoleServiceLocal userRoleService;
    
     @Autowired
    private EmployeeServiceLocal employeeService;

    public HrSystemTest() {
    }
     
      @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    
    

      @Test
    public void testScenarioB() {

        UserRole adminRole = BootStrapHelper.getUserRole("Admin");
        userRoleService.save(adminRole);
         UserRole employeeRole = BootStrapHelper.getUserRole("Employee");
        userRoleService.save(employeeRole);
    }
    
     @Test
    public void testScenarioC() {
        Employee employee1 = BootStrapHelper.getEmployee("Andile", "Qumbisa", "emp-202308");
        employeeService.save(employee1);

        Employee employee2 = BootStrapHelper.getEmployee("Griffiths", "Jiyeza", "emp-202307");
        employeeService.save(employee2);

        UserRole adminRole = userRoleService.findByDescription("Admin");
        UserRole employeeRole = userRoleService.findByDescription("Employee");


        User user = BootStrapHelper.getUser(employee1, UserStatus.ACTIVE);
        user.setUserRole(adminRole);
        userService.save(user);

        User user1 = BootStrapHelper.getUser(employee2, UserStatus.ACTIVE);
        user1.setUserRole(employeeRole);
        userService.save(user1);


    }
}
