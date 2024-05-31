/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment1.controller;

import com.algonquin.cst8288.assignment1.persistence.PersistenceService;
import com.algonquin.cst8288.assignment1.emoloyee.Employee;
import com.algonquin.cst8288.assignment1.persistence.Formatter;
import java.io.IOException;

public class EmployeeController {
    private final EmployeeValidator employeeValidator;
    private final PersistenceService persistenceService;

    public EmployeeController(EmployeeValidator employeeValidator, PersistenceService persistenceService) {
        this.employeeValidator = employeeValidator;
        this.persistenceService = persistenceService;
    }
    
    public String processEmployee(Employee employee, String filename, Formatter formatter) throws IOException {
        // Validate data
        if (!employeeValidator.isValidEmployee(employee)) {
                return "FALIED";
        }


        // Store data
        persistenceService.saveEmployee(employee, filename, formatter);
        return "SUCCESS";
	}
}
