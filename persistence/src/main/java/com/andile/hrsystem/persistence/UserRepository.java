/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.andile.hrsystem.persistence;

import com.andile.hrsystem.domain.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author S2026080
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT e FROM User e WHERE e.employee.empID=:empID")
    User findByEmpID(@Param("empID") String empID);

    @Query("SELECT e FROM User e WHERE e.employee.empID LIKE %:empID% OR e.employee.fullNames LIKE %:fullNames%")
    List<User> findByEmpIDOrFullNames(@Param("empID") String empID, @Param("fullNames") String fullNames);

    @Query("SELECT e FROM User e WHERE e.userRole.description=:description")
    List<User> findByUserRole(@Param("description") String description);
}
