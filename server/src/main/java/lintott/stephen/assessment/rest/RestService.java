/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lintott.stephen.assessment.rest;

import java.util.ArrayList;
import java.util.List;
import lintott.stephen.assessment.entity.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kideo
 */
@RestController
public class RestService {
   
    private static List<Employee> data = new ArrayList<Employee>();
    static {
        Employee employee = new Employee();
        employee.setName("John");
        employee.setSurname("Smith");
        employee.setAge(39);
        employee.setJobTitle("Developer");
        data.add(employee);
        
        employee = new Employee();
        employee.setName("Sara");
        employee.setSurname("Nel");
        employee.setAge(29);
        employee.setJobTitle("Business Analyst");
        data.add(employee);
        
        employee = new Employee();
        employee.setName("Sam");
        employee.setSurname("Johnston");
        employee.setAge(20);
        employee.setJobTitle("Intern");
        data.add(employee);
        
        employee = new Employee();
        employee.setName("Michelle");
        employee.setSurname("van Wyk");
        employee.setAge(29);
        employee.setJobTitle("Manager");
        data.add(employee);
        
        employee = new Employee();
        employee.setName("Vicus");
        employee.setSurname("van Wyk");
        employee.setAge(55);
        employee.setJobTitle("Manager");
        data.add(employee);
        
        employee = new Employee();
        employee.setName("Jan");
        employee.setSurname("Venter");
        employee.setAge(50);
        employee.setJobTitle("Manager");
        data.add(employee);
        
        employee = new Employee();
        employee.setName("Johannes");
        employee.setSurname("van Vuuren");
        employee.setAge(45);
        employee.setJobTitle("Electrical Engineer");
        data.add(employee);
        
        employee = new Employee();
        employee.setName("Carel");
        employee.setSurname("Cronje");
        employee.setAge(40);
        employee.setJobTitle("Travel Agent");
        data.add(employee);
        
        employee = new Employee();
        employee.setName("Karl");
        employee.setSurname("Zwonnikoff");
        employee.setAge(39);
        employee.setJobTitle("Solutions Architect");
        data.add(employee);
        
        employee = new Employee();
        employee.setName("Sanet");
        employee.setSurname("Donk");
        employee.setAge(40);
        employee.setJobTitle("Data Analyst");
        data.add(employee);
        
        employee = new Employee();
        employee.setName("Jeanne");
        employee.setSurname("van Niekerk");
        employee.setAge(37);
        employee.setJobTitle("Financial Advisor");
        data.add(employee);
        
        employee = new Employee();
        employee.setName("Lana");
        employee.setSurname("van Niekerk");
        employee.setAge(37);
        employee.setJobTitle("Sales");
        data.add(employee);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/data")
    public ResponseEntity<List<Employee>> getData() {
       return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
