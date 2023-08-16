/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.andile.hrsystem.service;

import com.andile.hrsystem.domain.UserRole;
import java.util.List;

/**
 *
 * @author S2026080
 */
public interface UserRoleServiceLocal {

    UserRole findByDescription(String descripiton);

    UserRole save(UserRole userRole);

    UserRole findById(Long id);

    public void deleteAll();

    UserRole update(UserRole userRole);

    UserRole deleteById(Long id);

    List<UserRole> listAll();

    boolean isExist(UserRole userRole);
}
