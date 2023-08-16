/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andile.hrsystem.mb;

import com.andile.hrsystem.common.UserStatus;
import com.andile.hrsystem.domain.User;
import com.andile.hrsystem.service.UserServiceLocal;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author S2026080
 */
@ManagedBean
@RequestScoped
public class LoginBean extends BaseBean<User>{
    @Autowired
    private UserServiceLocal userService;
    private String empIdParam;

    public void signIn() {
        User user = userService.findByEmpID(empIdParam);
        if(user == null){
            addErrorMessage("Please Enter employee ID number");
        }
        if (user != null && user.getUserRole() != null) {
            if (user.getUserStatus().equals(UserStatus.ACTIVE)) {
                getActiveUser().setLogonUserSession(user);                
                redirect("home");
            } else{
                addErrorMessage("System user with employee ID number", empIdParam, " is not active");
            }
        } else {
            addErrorMessage("System user with employee ID number", empIdParam, "does not exist");
        }
    }

    public String getEmpIdParam() {
        return empIdParam;
    }

    public void setEmpIdParam(String empIdParam) {
        this.empIdParam = empIdParam;
    } 
}
