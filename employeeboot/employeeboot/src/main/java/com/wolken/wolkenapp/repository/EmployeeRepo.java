package com.wolken.wolkenapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wolken.wolkenapp.entity.EmployeeEntity;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Integer> {
	public EmployeeEntity findByEmailId(String emailId);
	public List<EmployeeEntity> findByFirstName(String firstName);
	

}
