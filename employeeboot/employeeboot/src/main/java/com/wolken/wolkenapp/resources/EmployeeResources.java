package com.wolken.wolkenapp.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolken.wolkenapp.entity.EmployeeEntity;
import com.wolken.wolkenapp.service.EmployeeService;


@Controller
@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:8080")
public class EmployeeResources {
	
	Logger logger = Logger.getLogger(EmployeeResources.class);
	
	@Autowired
	EmployeeService  service;
	
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/getEmployee")
	public List<EmployeeEntity> getAll(){
		logger.info("Inside getMap");
		
		return service.validateAndFindAll();
		
	}
	@GetMapping("getEmployeeId/{emailId}")
	public List<EmployeeEntity> search(@RequestBody EmployeeEntity employeeEntity){
		
		logger.info("Inside getEmployeeId");
		return service.validateAndSearch(employeeEntity.getEmailId());
		
	}
	@PostMapping("/postEmployee")
	public String save(@RequestBody EmployeeEntity employeeEntity) {
		logger.info("Inside PostEmployeeId");
		return service.validateAndSave(employeeEntity);
		
	}

	@PutMapping("/updateEmployee/{emailId}")
	public EmployeeEntity update(@PathVariable String emailId,@RequestBody EmployeeEntity employeeEntity) {
		logger.info("Inside updateEmployeeId");
		return service.validateAndUpdate(emailId , employeeEntity);
		
	}
	
	@DeleteMapping("/deletEmployee/{emailId}")
	public Map<String, Boolean>delete(@PathVariable String emailId){
		logger.info("Inside deleteEmployeeId");
		Map<String,Boolean> response = new HashMap<>();
		logger.info("response object created");
		response= service.validateAndDelete(emailId);
		logger.info("response object created");
		return response;
	}
	
	

}
