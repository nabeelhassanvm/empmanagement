package com.sample.empmanagement;

import org.springframework.http.ResponseEntity;

public interface EmpManagementController {

	ResponseEntity<?> findActiveDepartments();
	
	ResponseEntity<?> findDepartmentWithMaxEmployees();
	
	ResponseEntity<?> findOldestEmployee();
}
