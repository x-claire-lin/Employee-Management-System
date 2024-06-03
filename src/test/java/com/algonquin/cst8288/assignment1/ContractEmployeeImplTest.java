/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment1;

import com.algonquin.cst8288.assignment1.emoloyee.Employee;
import com.algonquin.cst8288.assignment1.emoloyee.ContractEmployeeImpl;
import org.junit.Assert;
import org.junit.Test;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author feish
 */
public class ContractEmployeeImplTest {
        private static final double EPSILON = 1E-12;
    
    /**
    * Testing the ContractEmployeeImpl functionalities.
    * Assertion: salary = 2000, numberOfServiceYear = 5
    * totalCompensation = 2000
    * renewalDate = one year after today
    */
    @Test
    public void testPermanentEmployee(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date expectedDate = calendar.getTime();
        
        Employee contractEmployee = new Employee();
        contractEmployee.setName("Brett");
        contractEmployee.setEmail("brett@gmail.com");
        contractEmployee.setAddress("QC");
        contractEmployee.setSalary(2000.0);
        contractEmployee.setNumberOfServiceYear(5);
        
        ContractEmployeeImpl contractEmployeeService = new ContractEmployeeImpl();
        contractEmployeeService.calculateTotalCompensation(contractEmployee);
        
        Assert.assertEquals(2000.0, contractEmployee.getTotalCompensation(), EPSILON);
        Assert.assertEquals(expectedDate, contractEmployee.getRenewalDate());
    };
}
    
