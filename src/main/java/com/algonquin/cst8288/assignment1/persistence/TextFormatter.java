/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment1.persistence;

import com.algonquin.cst8288.assignment1.emoloyee.Employee;
import java.io.IOException;

/**
 *
 * @author feish
 */
public class TextFormatter implements Formatter{
    @Override
    public String format(Employee employee) throws IOException{
        return employee.toString();
    }
}
