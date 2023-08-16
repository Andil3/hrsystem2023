/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.andile.hrsystem.service;

import com.andile.hrsystem.domain.User;
import java.util.List;

/**
 *
 * @author S2026080
 */
public interface UserServiceLocal {

    User save(User user);

    User findByEmpID(String empId);

    User findById(Long id);

    User update(User user);

    User deleteById(Long id);

    List<User> listAll();

    boolean isExist(User user);

    List<User> findByUserRole(String description);
    
    List<User> searchForSystemUsers(String searchParam);

}
