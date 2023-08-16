/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andile.hrsystem.mb;

import com.andile.hrsystem.common.AddressType;
import com.andile.hrsystem.domain.Address;
import com.andile.hrsystem.domain.ContactDetails;
import com.andile.hrsystem.domain.Employee;
import com.andile.hrsystem.domain.User;
import com.andile.hrsystem.service.EmployeeServiceLocal;
import com.andile.hrsystem.service.UserServiceLocal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
public class EmployeeBean extends BaseBean<Employee> {

    @Autowired
    private EmployeeServiceLocal employeeService;
    @Autowired
    private UserServiceLocal userService;
    private List<Employee> employees = new ArrayList<>();
    private Employee employee;

    private String templateTitle;
    private String empID;

    @PostConstruct
    public void init() {
        reset().setList(true);
        setTemplateTitle("Employees");
        addCollections(employeeService.listAll());
    }

    public void addOrUpdate(Employee employee) {
        reset().setAdd(true);
        if (employee != null) {
            employee.setUpdatedBy(getActiveUser().getEmpID());
            employee.setUpdatedDate(new Date());
            setTemplateTitle("Update Employee");
        } else {
            employee = new Employee();
            employee.setCreatedBy(getActiveUser().getEmpID());
            employee.setCreatedDate(new Date());

            Address physicalAddress = new Address();
            physicalAddress.setCreatedBy(getActiveUser().getEmpID());
            physicalAddress.setCreatedDate(new Date());
            physicalAddress.setAddressType(AddressType.RESIDENTIAL);
            employee.addAddress(physicalAddress);

            Address postalAddress = new Address();
            postalAddress.setCreatedBy(getActiveUser().getEmpID());
            postalAddress.setCreatedDate(new Date());
            postalAddress.setAddressType(AddressType.POSTAL);
            employee.addAddress(postalAddress);

            ContactDetails contactDetails = new ContactDetails();
            contactDetails.setCreatedBy(getActiveUser().getEmpID());
            contactDetails.setCreatedDate(new Date());
            employee.addContactDetailses(contactDetails);

            addCollection(employee);
            setTemplateTitle("Add Employee");
        }
        addEntity(employee);
    }

    public void save(Employee employee) {
        reset().setList(true);
        if (employee.getId() != null) {
            employeeService.update(employee);
        } else {
            employeeService.save(employee);
        }
        setTemplateTitle("Employees");
        addInformationMessage("Employee saved successfully");
    }

    public void synchronize(Employee employee) {
        Iterator<Employee> employeeList = getCollections().iterator();
        while (employeeList.hasNext()) {
            if (employeeList.next().getId().equals(employee.getId())) {
                employeeList.remove();
            }
        }
    }

    public void delete(Employee employee) {
        User user = userService.findByEmpID(empID);
        if (user != null) {
            addInformationMessage("The employee with employee ID of ", empID, "  exist as a System User and cannot be Deleted");
         
        }else{
            reset().setList(true);
            employeeService.deleteById(employee.getId());
            
            synchronize(employee);
            setTemplateTitle("Employees");
            addInformationMessage("Employee deleted successfully");
        }
        }

    

    

    public void cancel(Employee employee) {
        reset().setList(true);
        if (employee.getId() == null) {
            if (getCollections().contains(employee)) {
                getCollections().remove(employee);
            }
        }
        setTemplateTitle("Employees");
    }

    public List<Employee> getEmployees() {
        return this.getCollections();
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getTemplateTitle() {
        return templateTitle;
    }

    public void setTemplateTitle(String templateTitle) {
        this.templateTitle = templateTitle;
    }
}
