package com.employees.employeeslist.service;

import com.employees.employeeslist.exception.EmployeeAlreadyAddedException;
import com.employees.employeeslist.exception.EmployeeNotFoundException;
import com.employees.employeeslist.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employeeList;

    public EmployeeServiceImpl() {
        this.employeeList = new ArrayList<>(Arrays.asList(
                        new Employee("Василий", "Пупкин"),
                        new Employee("Анна", "Трубецкая"),
                        new Employee("Петр", " Корабелкин"),
                        new Employee("Ирина", "Иванова"),
                        new Employee("Семен", "Крупский"),
                        new Employee("Алексей", "Шабанов"),
                        new Employee("Зинаида", "Семенова"),
                        new Employee("Давид", "Мартиросян"),
                        new Employee("Анастасия", "Турцкевич"),
                        new Employee("Лидия", "Разумихина")
                )
                );
    }

    @Override
    public Employee add(String fistName, String lastName) {
        Employee employee = new Employee(fistName, lastName);
        if (employeeList.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeList.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String fistName, String lastName) {
        Employee employee = new Employee(fistName, lastName);
        if (employeeList.contains(employee)) {
            employeeList.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();

    }

    @Override
    public Employee find(String fistName, String lastName) {
        Employee employee = new Employee(fistName, lastName);
        if (employeeList.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> getEmployees(String firstName, String lastName) {
        return Collections.unmodifiableList(employeeList);
    }


}


