/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andile.hrsystem.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

/**
 *
 * @author S2026080
 */
@Entity
@Table(name = "admin_sett")
@Getter
@Setter
public class AdminSettings extends BaseEntity {

    @Column(name = "sys_user")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean users;

    @Column(name = "sys_user_role")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean userRole;

    @Column(name = "employee")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean employee;
    
    
    public AdminSettings() {
        users = Boolean.FALSE;
        userRole = Boolean.FALSE;
        employee = Boolean.FALSE;
    }
    public boolean isAdministrator() {
        return this.users || this.userRole || this.employee;
    }
}
