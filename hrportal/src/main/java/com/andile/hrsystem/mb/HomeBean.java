/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andile.hrsystem.mb;

import com.andile.hrsystem.domain.User;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author S2026080
 */
@ManagedBean
@RequestScoped
public class HomeBean extends BaseBean<User>{
       private static final String LANDING_PAGE = "/landing.xhtml";
    private static final String EXPIRY_PAGE = "/expired.xhtml?faces-redirect=true";

    public String routeToAdministration() {
        if (getActiveUser() != null) {
            getActiveUser().setModuleWelcomeMessage("Welcome To HR Portal Which allows System User To Enhance Employee Management. On This Portal A System user can Add/Update/Delete Employee and System Users");
            getActiveUser().getRouter().reset().setAdministrator(true);
            return LANDING_PAGE;
        }
        return EXPIRY_PAGE;
    }
  
}
