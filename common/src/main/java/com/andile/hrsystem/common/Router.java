/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andile.hrsystem.common;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author S2026080
 */
@Getter
@Setter
public class Router implements Serializable{
    public boolean administrator;
    public boolean employeeManagement;

    
     public Router reset() {
        setAdministrator((boolean) Boolean.FALSE);
        setEmployeeManagement((boolean) Boolean.FALSE);
      
        return this;
    }
}
