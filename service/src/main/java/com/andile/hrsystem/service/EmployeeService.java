/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andile.hrsystem.service;

import com.andile.hrsystem.domain.Employee;
import com.andile.hrsystem.domain.User;
import com.andile.hrsystem.persistence.EmployeeRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author S2026080
 */
@Service
public class EmployeeService implements EmployeeServiceLocal {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(
                "The requested id [" + id + "] does not exist"));
    }

    @Override
    public Employee deleteById(Long id) {
        Employee employee = findById(id);
        if (employee != null) {
            employeeRepository.delete(employee);
        }
        return employee;
    }

    @Override
    public List<Employee> listAll() {
        return employeeRepository.findAll();
    }

    @Override
    public boolean isExist(Employee employee) {
        return employeeRepository.findById(employee.getId()) != null;
    }

    @Override
    public Employee findByEmpID(String empID) {
        return employeeRepository.findByEmpID(empID);
    }

    @Override
    public List<Employee> searchForEmployees(String searchParam) {
        return employeeRepository.findByEmpIDContainingOrFullNamesContaining(searchParam, searchParam);
    }

    @Override
    public User getEmployeeByEmpID(String empID) {
        User user = null;
        user = new User();
        user.setCreatedBy(empID);
        user.setCreatedDate(new Date());

        user.setEmployee(new Employee());
        user.getEmployee().setCreatedBy(empID);
        user.getEmployee().setCreatedDate(new Date());
        user.getEmployee().setEmpID(empID);
       return user;
    }
}
