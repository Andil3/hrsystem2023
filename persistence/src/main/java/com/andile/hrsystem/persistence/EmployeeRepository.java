/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.andile.hrsystem.persistence;

import com.andile.hrsystem.domain.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author S2026080
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
     Employee findByEmpID(String empID);
    
    List<Employee> findByEmpIDContainingOrFullNamesContaining(String empID, String fullNames);
}
