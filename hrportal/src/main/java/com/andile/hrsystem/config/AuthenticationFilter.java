/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andile.hrsystem.config;

import com.andile.hrsystem.mb.ActiveUser;
import java.io.IOException;
import javax.faces.application.ResourceHandler;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author S2026080
 */
public class AuthenticationFilter implements Filter{
    
    private static final String LOGIN_PAGE = "/login.xhtml";

    @Override
    public void init(FilterConfig fc) throws ServletException {

    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);

        ActiveUser activeUser = (session != null) ? (ActiveUser) session.getAttribute("activeUser") : null;
        boolean loggedIn = activeUser != null && activeUser.isUserLoginIndicator();

        StringBuilder loginFilterUrl = new StringBuilder(request.getContextPath());
        loginFilterUrl.append(LOGIN_PAGE);
        boolean loginRequest = request.getRequestURI().contains(loginFilterUrl.toString());
        boolean resourceRequest = request.getRequestURI().contains(request.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER);
        
        if (loggedIn || resourceRequest || loginRequest) {
            if (!resourceRequest) {
                response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
                response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
                response.setDateHeader("Expires", 0); // Proxies.
            }
            filterChain.doFilter(request, response);
        } else {
            StringBuilder builder = new StringBuilder(request.getContextPath());
            builder.append(LOGIN_PAGE);
            response.sendRedirect(builder.toString());
        }
    }

    @Override
    public void destroy() {

    }
}
