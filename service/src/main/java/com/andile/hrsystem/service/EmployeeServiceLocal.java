/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.andile.hrsystem.service;

import java.util.List;
import com.andile.hrsystem.domain.Employee;
import com.andile.hrsystem.domain.User;

/**
 *
 * @author S2026080
 */
public interface EmployeeServiceLocal {
   
    Employee save(Employee employee);

    Employee update(Employee employee);

    Employee findById(Long id);

    Employee deleteById(Long id);

    List<Employee> listAll();

    boolean isExist(Employee employee);
    
    Employee findByEmpID(String empID);
    
    User getEmployeeByEmpID(String empID);

    List<Employee> searchForEmployees(String searchParam);
}
