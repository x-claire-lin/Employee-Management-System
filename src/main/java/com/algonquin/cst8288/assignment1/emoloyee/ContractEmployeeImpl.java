/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.algonquin.cst8288.assignment1.emoloyee;

import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author feish
 */
public class ContractEmployeeImpl implements EmployeeService{
    @Override
    public void calculateTotalCompensation(Employee employee){
        employee.setTotalCompensation(employee.getSalary());
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date renewalDate = calendar.getTime();
        employee.setRenewalDate(renewalDate);
    };
}
