/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.andile.hrsystem.persistence;

import com.andile.hrsystem.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author S2026080
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long>{
    UserRole findByDescription(String description);
}
