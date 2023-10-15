package com.employees.employeeslist.service;

import com.employees.employeeslist.model.Employee;

import java.util.Collection;

public interface EmployeeService{
    Employee add (String fistName, String lastName);
    Employee remove ( String fistName, String lastName);
    Employee find ( String fistName, String lastName);


    Collection<Employee> getEmployees(String firstName, String lastName);
}
