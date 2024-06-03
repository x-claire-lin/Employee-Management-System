/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment1;

import com.algonquin.cst8288.assignment1.emoloyee.Employee;
import com.algonquin.cst8288.assignment1.emoloyee.PermanentEmployeeImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author feish
 */
public class PermanentEmployeeImplTest {
    private static final double EPSILON = 1E-12;
    
    /**
    * Testing the PermanentEmployeeImpl functionalities.
    * Assertion: salary = 2000, numberOfServiceYear = 5
    * pension = 2000 * 1% = 20
    * bonus = 2000 * 2.5% * 5 = 250
    * totalCompensation = 2000 + 250 = 2250
    */
    @Test
    public void testPermanentEmployee(){
        Employee permanentEmployee = new Employee();
        permanentEmployee.setName("Adam");
        permanentEmployee.setEmail("adam@gmail.com");
        permanentEmployee.setAddress("QC");
        permanentEmployee.setSalary(2000.0);
        permanentEmployee.setNumberOfServiceYear(5);
        
        PermanentEmployeeImpl permanentEmployeeService = new PermanentEmployeeImpl();
        permanentEmployeeService.calculateTotalCompensation(permanentEmployee);
        
        Assert.assertEquals(250.0, permanentEmployee.getBonus(), EPSILON);
        Assert.assertEquals(20.0, permanentEmployee.getPension(), EPSILON);
        Assert.assertEquals(2250.0, permanentEmployee.getTotalCompensation(), EPSILON);
    }
    
}
