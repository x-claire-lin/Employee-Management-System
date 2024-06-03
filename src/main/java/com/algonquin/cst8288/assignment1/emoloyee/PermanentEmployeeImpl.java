/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.algonquin.cst8288.assignment1.emoloyee;

import com.algonquin.cst8288.assignment1.controller.Rate;
/**
 *
 * @author feish
 */
public class PermanentEmployeeImpl implements EmployeeService{
    
    @Override
    public void calculateTotalCompensation(Employee employee){
        employee.setPension(employee.getSalary() * Rate.PENSION_PERCENTAGE);
        employee.setBonus(employee.getSalary() * Rate.BONUS_PERCENTAGE * employee.getNumberOfServiceYear());
        employee.setTotalCompensation(employee.getSalary() + employee.getBonus());
    };
}
