/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andile.hrsystem.mb;

import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author S2026080
 */
@ManagedBean
@RequestScoped
public class MenuBean extends BaseBean{
     private static final Logger LOG = Logger.getLogger(MenuBean.class.getName());

    @PostConstruct
    public void init() {

    }
    
    public String route(String page) {
        System.out.println("selected page =" + page);
        return defaultRouter(page);
    }

    public String routing(String page) {
        if (page.equalsIgnoreCase("/employee")) {
            getActiveUser().getRouter().reset().setAdministrator(true);
        }
        
     
        return defaultRouter(page);
    }

    public String routeToAdmin(String page) {
        getActiveUser().setModuleWelcomeMessage("Welcome to Administration Page");
        getActiveUser().getRouter().reset().setAdministrator(true);
        return defaultRouter(page);
    }

   
}
