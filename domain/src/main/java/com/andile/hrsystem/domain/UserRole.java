/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andile.hrsystem.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author S2026080
 */
@Entity
@Table(name = "user_role")
@Getter
@Setter
public class UserRole extends BaseEntity {

    @Column(name = "description")
    private String description;

    @OneToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "admin_sett_id")
    public AdminSettings administrationSettings;

    @OneToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "user_perm_id")
    private UserPermission userPermission;

}
