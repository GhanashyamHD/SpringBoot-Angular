package com.wolken.wolkenapp.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.wolken.wolkenapp.entity.EmployeeEntity;




public interface EmployeeService  {
	public List<EmployeeEntity> validateAndFindAll();
	public String validateAndSave(EmployeeEntity employeeEntity);
	public EmployeeEntity validateAndUpdate( String emailId,EmployeeEntity entity);
	public Map<String, Boolean> validateAndDelete(String emailId);
	public List<EmployeeEntity> validateAndSearch(String emailId);

	
}
