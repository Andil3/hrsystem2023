/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andile.hrsystem.mb;

import com.andile.hrsystem.domain.AdminSettings;
import com.andile.hrsystem.domain.User;
import com.andile.hrsystem.domain.UserPermission;
import com.andile.hrsystem.domain.UserRole;
import com.andile.hrsystem.service.UserRoleServiceLocal;
import com.andile.hrsystem.service.UserServiceLocal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author S2026080
 */
@ManagedBean
@ViewScoped
public class UserRoleBean extends BaseBean<UserRole> {

    @Autowired
    private UserRoleServiceLocal userRoleService;
    @Autowired
    private UserServiceLocal userService;
    private final List<UserRole> userRoles = new ArrayList<>();
    private String panelTitle;

    @PostConstruct
    public void init() {
        reset().setList(true);
        setPanelTitle("User Roles");
        addCollections(userRoleService.listAll());
    }

    public void addOrUpdate(UserRole userRole) {
        reset().setAdd(true);
        if (userRole != null) {
            setPanelTitle("Update User Role");
            userRole.setUpdatedBy(getActiveUser().getEmpID());
            userRole.setUpdatedDate(new Date());
        } else {
            userRole = new UserRole();
            setPanelTitle("Add User Role");
            userRole.setCreatedBy(getActiveUser().getEmpID());
            userRole.setCreatedDate(new Date());

            AdminSettings administrationSettings = new AdminSettings();
            administrationSettings.setCreatedBy(getActiveUser().getEmpID());
            administrationSettings.setCreatedDate(new Date());
            userRole.setAdministrationSettings(administrationSettings);

            UserPermission permission = new UserPermission();
            permission.setCreatedBy(getActiveUser().getEmpID());
            permission.setCreatedDate(new Date());
            userRole.setUserPermission(permission);

            addCollection(userRole);
        }
        addEntity(userRole);
    }

    public void save(UserRole userRole) {
        if (userRole.getId() != null) {
            userRoleService.update(userRole);
            addInformationMessage("User Role was successfully updated.");
        } else {
            userRoleService.save(userRole);
            addInformationMessage("User Role was successfully created.");
        }
        reset().setList(true);
        setPanelTitle("User Roles");
    }

    public void cancel(UserRole userRole) {
        if (userRole.getId() == null && getUserRoles().contains(userRole)) {
            remove(userRole);
        }
        reset().setList(true);
        setPanelTitle("User Roles");
    }

    public void delete(UserRole userRole) {
        boolean isDelete = true;
        for (User user : userService.listAll()) {
            if (user.getUserRole().equals(userRole)) {
                isDelete = false;
                break;
            }
        }
        if (isDelete == false) {
            addWarningMessage("This Role cannot be deleted because it is being used by other Users");
            return;
        }
        userRoleService.deleteById(userRole.getId());
        remove(userRole);
        addInformationMessage("UserRole was successfully deleted");
        reset().setList(true);
        setPanelTitle("User Roles");
    }

    public List<UserRole> getUserRoles() {
        return this.getCollections();
    }

    public String getPanelTitle() {
        return panelTitle;
    }

    public void setPanelTitle(String panelTitle) {
        this.panelTitle = panelTitle;
    }
}
