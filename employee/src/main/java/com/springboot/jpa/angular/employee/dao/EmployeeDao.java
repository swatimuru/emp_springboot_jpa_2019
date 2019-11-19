package com.springboot.jpa.angular.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.jpa.angular.employee.model.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
