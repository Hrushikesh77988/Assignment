package com.example.MindBowserChallenge.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.MindBowserChallenge.data.Employee;


public interface EmployeeRepository extends CrudRepository<Employee,Long> {

}
