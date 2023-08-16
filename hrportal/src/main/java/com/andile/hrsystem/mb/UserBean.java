/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andile.hrsystem.mb;

import com.andile.hrsystem.common.UserStatus;
import com.andile.hrsystem.domain.Employee;
import com.andile.hrsystem.domain.User;
import com.andile.hrsystem.domain.UserRole;
import com.andile.hrsystem.service.EmployeeServiceLocal;
import com.andile.hrsystem.service.UserRoleServiceLocal;
import com.andile.hrsystem.service.UserServiceLocal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class UserBean extends BaseBean<User> {

    @Autowired
    private UserServiceLocal userService;
    @Autowired
    private UserRoleServiceLocal userRoleService;
    @Autowired
    private EmployeeServiceLocal employeeService;

    private List<UserRole> userRoles = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();
    private List<UserStatus> userStatus = new ArrayList<>();

    private static final Logger LOG = Logger.getLogger(UserBean.class.getName());
    private String userTitle;
    private String searchParameter;
    private String empID;

    public void UserBean() {
    }

    @PostConstruct
    public void init() {
        //LOG.log(Level.INFO, "Initialization - UserBean");
        reset().setList(true);
        setUserTitle("Users");
        addCollections(userService.listAll());
        userRoles.addAll(userRoleService.listAll());
        userStatus = Arrays.asList(UserStatus.values());
        employees.addAll(employeeService.listAll());

    }

    public void addOrUpdate(User usr) {
        reset().setAdd(true);
        if (usr != null) {
            setUserTitle("Update User");
            usr.setUpdatedBy(getActiveUser().getEmpID());
            usr.setCreatedDate(new Date());
            this.addInfomation("User updated successfully");
        }
        addEntity(usr);
    }

    public void addUser(String empID) {
        User user = userService.findByEmpID(empID);
        if (user != null) {
            setUserTitle("Add User");
            user.setCreatedBy(getActiveUser().getEmpID());
            user.setCreatedDate(new Date());
            addCollection(user);
        }
        this.addInfomation("User added successfully");
    }

//    public void addEmployeeAsUser(String empID) {
//
//        if (empID.isEmpty()) {
//            addWarningMessage("Please enter the employee ID");
//            return;
//        }
//
//        User user = userService.findByEmpID(empID);
//        if (user != null) {
//            addInformationMessage("The employee with employee ID of ", empID, " already exist as a User");
//            return;
//        } else {
//            user = employeeService.getEmployeeByEmpID(empID);
//        }
//
//        if (user == null) {
//            addInformationMessage("The employee with employee ID of ", empID, " does not exist");
//            return;
//        }
//        user.getEmployee().getFirstName();
//        user.getEmployee().getLastName();
//        user.setCreatedBy(getActiveUser().getEmpID());
//        user.setCreatedDate(new Date());
//
//        addCollection(user);
//        addEntity(user);
//
//        reset().setAdd(true);
//        setUserTitle("Add User");
//    }
      public void searchEmployee() {
        if (this.empID.equals("") || this.empID == null) {
            addWarningMessage("Please enter the employee S-ID");
            return;
        }
        User existingUser = userService.findByEmpID(empID);

        if (existingUser != null) {
            addWarningMessage("An employee with an Employee ID of " + empID + " already exist as a user");
            return;
        }

        Employee emp = employeeService.findByEmpID(this.empID);
        

        if (emp == null) {
            addWarningMessage("The employee with Employee ID of " + empID + " does not exist, please check the Employee ID and try again");
            return;
        }
        User user = new User();
        user.setCreatedBy(getActiveUser().getEmpID());
        user.setCreatedDate(new Date());
        user.setEmployee(emp);
        addCollection(user);
        addEntity(user);
        reset().setAdd(true);
        setUserTitle("Add User");
    }

    public void save(User usr) {
        try {
            if (usr.getId() != null) {
                userService.update(usr);
                addInformationMessage("User successfully updated");
            } else {
                userService.save(usr);
                addInformationMessage("User successfully saved");
            }

        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage());
        }
        reset().setList(true);
        setUserTitle("Users");
    }

    public void cancel(User usr) {
        if (usr.getId() == null && getUsers().contains(usr)) {
            remove(usr);
        }
        reset().setList(true);
        setUserTitle("Users");
    }

    public void delete(User usr) {
        try {
            userService.deleteById(usr.getId());
            remove(usr);
            addInformationMessage("The content of Sid with the name", usr.getEmployee().getEmpID(), "was successfully deleted");
            reset().setList(true);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage());
        }
    }

    public void onSystemUserSearchListener() {
        if (searchParameter.isEmpty()) {
            addInformationMessage("Enter search criteria");
            return;
        }
        addCollections(userService.searchForSystemUsers(searchParameter));
        setUserTitle("Users");
    }

    public void back() {
        reset().setList(true);
        setUserTitle("Users");
    }

    public void searchToAdd() {
        setUserTitle("Search Employees");
        reset().setSearch(true);
    }

    public List<User> getUsers() {
        return this.getCollections();
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public List<UserStatus> getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(List<UserStatus> userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle;
    }

    public String getSearchParameter() {
        return searchParameter;
    }

    public void setSearchParameter(String searchParameter) {
        this.searchParameter = searchParameter;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

}
