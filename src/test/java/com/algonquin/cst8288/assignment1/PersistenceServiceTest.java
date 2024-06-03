/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment1;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.algonquin.cst8288.assignment1.emoloyee.Employee;
import com.algonquin.cst8288.assignment1.persistence.PersistenceService;
import com.algonquin.cst8288.assignment1.persistence.JSONFormatter;
import com.algonquin.cst8288.assignment1.persistence.TextFormatter;

/**
 *
 * @author feish
 */
public class PersistenceServiceTest {

    private PersistenceService persistenceService;
    private Employee employee;

    @Mock
    private JSONFormatter jsonFormatter;

    @Mock
    private TextFormatter textFormatter;

    private Path tempJSONFile;
    private Path tempTextFile;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        persistenceService = new PersistenceService();
        employee = new Employee();
        employee.setName("John Doe");
        employee.setSalary(50000);

        // Set up mock behavior
        when(jsonFormatter.format(employee)).thenReturn("Formatted JSON Employee Data");
        when(textFormatter.format(employee)).thenReturn("Formatted Text Employee Data");

        // Create temporary files
        tempJSONFile = Files.createTempFile("testJSON", ".txt");
        tempTextFile = Files.createTempFile("testText", ".txt");
    }

    @Test
    public void testJSONSaveEmployee() throws IOException {
        String filename = tempJSONFile.toString();
        persistenceService.saveEmployee(employee, filename, jsonFormatter);

        // Verify the contents of the file
        String fileContents = new String(Files.readAllBytes(tempJSONFile));
        String normalizedFileContents = fileContents.replace("\n", "").replace("\r", "");
        assertEquals("Formatted JSON Employee Data", normalizedFileContents);
    }

    @Test
    public void testTextSaveEmployee() throws IOException {
        String filename = tempTextFile.toString();
        persistenceService.saveEmployee(employee, filename, textFormatter);

        // Verify the contents of the file
        String fileContents = new String(Files.readAllBytes(tempTextFile));
        String normalizedFileContents = fileContents.replace("\n", "").replace("\r", "");
        assertEquals("Formatted Text Employee Data", normalizedFileContents);
    }

    @Test(expected = IOException.class)
    public void testSaveJSONEmployeeThrowsIOException() throws IOException {
        String invalidFilename = "/invalid/path/to/file.txt";
        persistenceService.saveEmployee(employee, invalidFilename, jsonFormatter);
    }

    @Test(expected = IOException.class)
    public void testSaveTextEmployeeThrowsIOException() throws IOException {
        String invalidFilename = "/invalid/path/to/file.txt";
        persistenceService.saveEmployee(employee, invalidFilename, textFormatter);
    }
}

