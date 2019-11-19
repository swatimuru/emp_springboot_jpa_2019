package com.springboot.jpa.angular.employee.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jpa.angular.employee.dao.EmployeeDao;
import com.springboot.jpa.angular.employee.model.Employee;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeDao employeeDAO;
	
	@GetMapping("/employee")
	public List<Employee> get(){
//		return employeeDAO.findAll();
		
		Sort sort = Sort.by(Direction.DESC, "id");
		return employeeDAO.findAll(sort);
	}
	
	@PostMapping("/employee")
	public Employee save(@RequestBody Employee employeeObj) {
		return employeeDAO.save(employeeObj);
	}
	
	@GetMapping("/employee/{id}")
	public Employee get(@PathVariable int id) {
		Optional<Employee> employee = employeeDAO.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}else {
			throw new RuntimeException("Employee not found for the id "+id);
		}
	}
	
	@DeleteMapping("/employee/{id}")
	public String delete(@PathVariable int id) {
		Optional<Employee> employee = employeeDAO.findById(id);
		if(employee.isPresent()) {
			employeeDAO.delete(employee.get());
			return "Employee is deleted with id "+id;
		}else {
			throw new RuntimeException("Employee not found for the id "+id);
		}
	}
	
	@PutMapping("/employee")
	public Employee update(@RequestBody Employee employeeObj) {
		return employeeDAO.save(employeeObj);
	}
	
	@GetMapping(produces = "application/json")
	@RequestMapping({ "/validateLogin" })
	public String validateLogin() {
		return "User successfully authenticated";
	}
}
