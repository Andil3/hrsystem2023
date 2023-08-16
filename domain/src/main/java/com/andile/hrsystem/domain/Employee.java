package com.andile.hrsystem.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author S2026080
 */
@Entity
@Table(name = "employee")
@Getter
@Setter
public class Employee extends BaseEntity {

    @Column(name = "emp_id")
    private String empID;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "full_names")
    private String fullNames;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "employee")
    private List<Address> addresses = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "employee")
    private List<ContactDetails> contactDetailses = new ArrayList<>();

    public void addAddress(Address address) {
        addresses.add(address);
    }

    public void removeAddress(Address address) {
        addresses.remove(address);
    }

    public void addContactDetailses(ContactDetails contactDetail) {
        contactDetailses.add(contactDetail);
    }

    public void removeContactDetailses(ContactDetails contactDetail) {
        contactDetailses.remove(contactDetail);
    }
}
