/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andile.hrsystem.test;

import com.andile.hrsystem.common.AddressType;
import com.andile.hrsystem.common.UserStatus;
import com.andile.hrsystem.domain.Address;
import com.andile.hrsystem.domain.AdminSettings;
import com.andile.hrsystem.domain.ContactDetails;
import com.andile.hrsystem.domain.Employee;
import com.andile.hrsystem.domain.User;
import com.andile.hrsystem.domain.UserPermission;
import com.andile.hrsystem.domain.UserRole;
import java.util.Date;

/**
 *
 * @author S2026080
 */
public class BootStrapHelper {

    public static UserRole getUserRole(String description) {
        UserRole userRole = new UserRole();
        userRole.setCreatedBy("Andile");
        userRole.setDescription(description);
        userRole.setCreatedDate(new Date());

        AdminSettings administrationSettings = new AdminSettings();
        administrationSettings.setCreatedBy("Andile");
        administrationSettings.setCreatedDate(new Date());
        administrationSettings.setUserRole(true);
        administrationSettings.setUsers(true);
        administrationSettings.setEmployee(true);
        userRole.setAdministrationSettings(administrationSettings);

        UserPermission permission = new UserPermission();
        permission.setAdd(true);
        permission.setDelete(true);
        permission.setUpdate(true);
        permission.setView(true);
        permission.setPrint(true);
        permission.setSearch(true);
        permission.setCreatedBy("Andile");
        permission.setCreatedDate(new Date());
        userRole.setUserPermission(permission);

        return userRole;
    }

    public static User getUser(Employee employee, UserStatus userStatus) {
        User user = new User();
        user.setCreatedBy("Andile");
        user.setCreatedDate(new Date());
        user.setEmployee(employee);
        user.setUserStatus(userStatus);
        return user;
    }

    public static Employee getEmployee(String firstName, String lastName, String empID) {
        Employee employee = new Employee();
        employee.setCreatedBy("Andile");
        employee.setCreatedDate(new Date());
        employee.setFullNames(firstName + " " + lastName);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setEmpID(empID);

        Address address = new Address();
        address.setCreatedBy("Andile");
        address.setCreatedDate(new Date());
        address.setAddressLine1("190 schielding Street");
        address.setAddressLine2("Bosman Station");
        address.setAddressType(AddressType.POSTAL);
        address.setArea("Pretoria");
        address.setCode("1002");
        employee.addAddress(address);

        Address address1 = new Address();
        address1.setCreatedBy("Andile");
        address1.setCreatedDate(new Date());
        address1.setAddressLine1("190 schielding Street");
        address1.setAddressLine2("Bosman Station");
        address1.setAddressType(AddressType.RESIDENTIAL);
        address1.setArea("Pretoria");
        address1.setCode("1002");
        employee.addAddress(address1);

        ContactDetails contactDetails = new ContactDetails();
        contactDetails.setCreatedBy("Andile");
        contactDetails.setCreatedDate(new Date());
        contactDetails.setEmailAddress("qumbisaanathy@gmail.com");
        contactDetails.setLandLine("01241208946");
        contactDetails.setMobileNumber("0733366310");
        contactDetails.setFacebookHandle("facebook handle");
        contactDetails.setInstagram("@Intagram");
        contactDetails.setLinkedIn("LinkedIn Account");
        contactDetails.setTwitterHandle("@Twitter_handle");
        contactDetails.setWhatsapp("0733366310");
        employee.addContactDetailses(contactDetails);
        return employee;
    }
}
