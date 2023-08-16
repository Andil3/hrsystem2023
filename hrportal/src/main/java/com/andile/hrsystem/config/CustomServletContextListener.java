/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andile.hrsystem.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author S2026080
 */
public class CustomServletContextListener implements ServletContextListener{
    
     @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        servletContext.setInitParameter("BootsFaces_THEME", "default");
        servletContext.setInitParameter("BootsFaces_USETHEME", "cerulean");
        servletContext.setInitParameter("primefaces.UPLOADER", "commons");
        servletContext.setInitParameter("primefaces.FONT_AWESOME", "true");
        servletContext.setInitParameter("primefaces.THEME", "nova-light");
        servletContext.setInitParameter("net.bootsfaces.blockUI", "true");
        servletContext.setInitParameter("primefaces.CSP", "true");
        servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Production");
        servletContext.setInitParameter("javax.faces.DATETIMECONVERTER_DEFAULT_TIMEZONE_IS_SYSTEM_TIMEZONE", "true");
        servletContext.setInitParameter("com.sun.faces.numberOfViewsInSession", "3");
        servletContext.setInitParameter("com.sun.faces.numberOfLogicalViews", "10");
        //servletContext.setInitParameter("org.omnifaces.SOCKET_ENDPOINT_ENABLED", "true");

        //servletContext.setInitParameter("org.omnifaces.SOCKET_ENDPOINT_ENABLED", "true");
        //servletContext.setInitParameter("org.omnifaces.COMBINED_RESOURCE_ACTIVATE_RESOURCE_CACHING", "false");
        //servletContext.setInitParameter("org.omnifaces.CACHE_SETTING_APPLICATION_TTL", "0");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
