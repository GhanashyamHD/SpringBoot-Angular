package com.wolken.wolkenapp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wolken.wolkenapp.entity.EmployeeEntity;
import com.wolken.wolkenapp.repository.EmployeeRepo;

@Service
@Component
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepo repo;
    Logger logger = Logger.getLogger(EmployeeServiceImpl.class);

	@Override
	public List<EmployeeEntity> validateAndFindAll() {
		// TODO Auto-generated method stub
		logger.info("Inside service FindAll");
		return repo.findAll();
	}

	@Override
	public String validateAndSave(EmployeeEntity employeeEntity) {
		// TODO Auto-generated method stub
		if(employeeEntity != null) {
			logger.info("Inside service save method if cond");
	     repo.save(employeeEntity);
	     logger.info("Inside service save method saving entity");
	     return "Data Saved";
			
		}
		else {
			return "Data not saved";
		}
		
	
	}

	@Override
	public EmployeeEntity validateAndUpdate(String emailId,EmployeeEntity entity) {
		EmployeeEntity employeeEntity = repo.findByEmailId(emailId);
		// TODO Auto-generated method stub
		if(entity!=null && emailId != null) {
			logger.info("Inside service Update");
			employeeEntity.setPhoneNo(entity.getPhoneNo());
			logger.info("Inside service Update setting phoneNo");
			employeeEntity.setDob(entity.getDob());
			logger.info("Inside service Update settting dob");
			employeeEntity.setEmailId(entity.getEmailId());
			logger.info("Inside service Update emailId");
			employeeEntity.setFirstName(entity.getFirstName());
			logger.info("Inside service Update firstName");
			employeeEntity.setLastName(entity.getLastName());
			logger.info("Inside service Update lastName");
			repo.save(employeeEntity);
			logger.info("Inside service Update save entity");
			return employeeEntity;
		}
		else {
			return null;
	}
	}

	@Override
	public Map<String, Boolean> validateAndDelete(String emailId) {
		EmployeeEntity employeeEntity = repo.findByEmailId(emailId);
		// TODO Auto-generated method stub
		if(employeeEntity != null) {
			logger.info("Inside service delete if cond");
			repo.delete(employeeEntity);
			logger.info("Inside service delete from repo");
			Map<String,Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
		}
		else {
			return null;
		}
		
	}

	@Override
	public List<EmployeeEntity> validateAndSearch(String emailId) {
		// TODO Auto-generated method stub
		logger.info("Inside service Search");
		return repo.findByFirstName(emailId);
	
	}
	

}
