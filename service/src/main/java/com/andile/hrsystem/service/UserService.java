/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andile.hrsystem.service;

import com.andile.hrsystem.domain.User;
import com.andile.hrsystem.persistence.UserRepository;
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
public class UserService implements UserServiceLocal{

   @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                                "The requested id [" + id
                                + "] does not exist."));
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public User deleteById(Long id) {
        User user = findById(id);
        if (user != null) {
            userRepository.delete(user);
        }
        return user;
    }

    @Override
    public List<User> listAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByEmpID(String empID) {
        return userRepository.findByEmpID(empID);
    }

    @Override
    public boolean isExist(User user) {
        return userRepository.findById(user.getId()) != null;
    }

    @Override
    public List<User> searchForSystemUsers(String searchParam) {
        return userRepository.findByEmpIDOrFullNames(searchParam, searchParam);
    }

    @Override
    public List<User> findByUserRole(String description) {
        return userRepository.findByUserRole(description);
    }

   
 


}
