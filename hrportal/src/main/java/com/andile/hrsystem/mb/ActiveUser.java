/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andile.hrsystem.mb;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import lombok.Getter;
import lombok.Setter;
import com.andile.hrsystem.common.Router;
import com.andile.hrsystem.domain.Employee;
import com.andile.hrsystem.domain.User;
import com.andile.hrsystem.domain.UserRole;



/**
 *
 * @author S2026080
 */
@ManagedBean
@SessionScoped
@Getter
@Setter
public class ActiveUser implements Serializable  {
    
     private String empID;
    private Router router = new Router();
    private boolean userLoginIndicator;
    private UserRole userRole;
    private String moduleWelcomeMessage;
    private String registrationNumber;
    private String identityNumber;
    private String organizationName;
    private String loggedOnUserFullName;
    private String fullName;
    private Employee employee;

    public ActiveUser() {
        userLoginIndicator = Boolean.FALSE;
        
    }
    public void setLogonUserSession(User user) {
        
        this.setFullName(user.getEmployee().getFullNames());
        this.setIdentityNumber(user.getEmployee().getEmpID());
        this.setUserRole(user.getUserRole());
        this.setLoggedOnUserFullName(user.getEmployee().getFullNames());
        this.setUserLoginIndicator(true);
        this.setEmpID(user.getEmployee().getEmpID());
        this.setEmployee(user.getEmployee());
    }
}
