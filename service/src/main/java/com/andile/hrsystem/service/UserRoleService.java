/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andile.hrsystem.service;

import com.andile.hrsystem.domain.UserRole;
import com.andile.hrsystem.persistence.UserRoleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author S2026080
 */
@Service
@Transactional
public class UserRoleService implements UserRoleServiceLocal {

    

    @Autowired
    private UserRoleRepository userRepository;

    @Override
    public UserRole save(UserRole userRole) {
        return userRepository.save(userRole);
    }

    @Override
    public UserRole findById(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                "The requested id [" + id
                + "] does not exist."));
    }

    @Override
    public UserRole update(UserRole userRole) {
        return userRepository.save(userRole);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public UserRole deleteById(Long id) {
        UserRole userRole = findById(id);
        if (userRole != null) {
            userRepository.delete(userRole);
        }
        return userRole;
    }

    @Override
    public List<UserRole> listAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean isExist(UserRole userRole) {
        return userRepository.findByDescription(userRole.getDescription()) != null;
    }

    @Override
    public UserRole findByDescription(String descripiton) {
        return userRepository.findByDescription(descripiton);
    }
}
