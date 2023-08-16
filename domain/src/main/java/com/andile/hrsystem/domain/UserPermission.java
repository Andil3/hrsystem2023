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
@Table(name = "user_perm")
@Getter
@Setter
public class UserPermission extends BaseEntity{
    @Column(name = "view_record")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean view;

    @Column(name = "update_record")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean update;

    @Column(name = "delete_record")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean delete;

    @Column(name = "search_record")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean search;

    @Column(name = "add_record")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean add;

    @Column(name = "print_record")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean print;

    public UserPermission() {
        this.view = Boolean.FALSE;
        this.update = Boolean.FALSE;
        this.delete = Boolean.FALSE;
        this.search = Boolean.FALSE;
        this.print = Boolean.FALSE;

    }

    public UserPermission reset() {
        this.setDelete(false);
        this.setView(false);
        this.setUpdate(false);
        this.setSearch(false);
        this.setAdd(false);
        this.setPrint(false);
        return this;
    }
}
