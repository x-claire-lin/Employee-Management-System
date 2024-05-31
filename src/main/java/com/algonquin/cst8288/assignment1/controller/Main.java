package com.algonquin.cst8288.assignment1.controller;

import com.algonquin.cst8288.assignment1.emoloyee.ContractEmployeeImpl;
import com.algonquin.cst8288.assignment1.emoloyee.Employee;
import com.algonquin.cst8288.assignment1.emoloyee.PermanentEmployeeImpl;
import com.algonquin.cst8288.assignment1.persistence.JSONFormatter;
import com.algonquin.cst8288.assignment1.persistence.PersistenceService;
import com.algonquin.cst8288.assignment1.persistence.TextFormatter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Create necessary services
        EmployeeValidator employeeValidator = new EmployeeValidator();
        PersistenceService persistenceService = new PersistenceService();

        // Create the EmployeeController
        EmployeeController employeeController = new EmployeeController(employeeValidator, persistenceService);

        // Create Employee objects
        Employee contractEmployee = new Employee();
        contractEmployee.setName("Adam");
        contractEmployee.setEmail("adam@gmail.com");
        contractEmployee.setAddress("ON");
        contractEmployee.setSalary(1500.0);
        contractEmployee.setNumberOfServiceYear(3);

        Employee permanentEmployee = new Employee();
        permanentEmployee.setName("Bob");
        permanentEmployee.setEmail("bob@gmail.com");
        permanentEmployee.setAddress("QC");
        permanentEmployee.setSalary(2000.0);
        permanentEmployee.setNumberOfServiceYear(5);

        // Create EmployeeService instances
        ContractEmployeeImpl contractEmployeeService = new ContractEmployeeImpl();
        PermanentEmployeeImpl permanentEmployeeService = new PermanentEmployeeImpl();

        // Calculate data for employees
        contractEmployeeService.calculateTotalCompensation(contractEmployee);
        permanentEmployeeService.calculateTotalCompensation(permanentEmployee);

        // Process and save employees using EmployeeController
        employeeController.processEmployee(contractEmployee, "json_employee_data.txt", new JSONFormatter());
        employeeController.processEmployee(contractEmployee, "text_employee_data.txt", new TextFormatter());
        employeeController.processEmployee(permanentEmployee, "json_employee_data.txt", new JSONFormatter());
        employeeController.processEmployee(permanentEmployee, "text_employee_data.txt", new TextFormatter());

        // Output data to console
        System.out.println(new JSONFormatter().format(contractEmployee));
        System.out.println(new TextFormatter().format(contractEmployee));
        System.out.println(new JSONFormatter().format(permanentEmployee));
        System.out.println(new TextFormatter().format(permanentEmployee));
    }
}
