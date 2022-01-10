package com.sample.empmanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmpManagementControllerimpl implements EmpManagementController {
	
	@Autowired
	private EmpManagementService service;

	@GetMapping("/activedepartments")
	@Override
	public ResponseEntity<List<Department>> findActiveDepartments() {
		List<Department> depList = service.findActiveDepartments();
		return new ResponseEntity<List<Department>>(depList, HttpStatus.OK);
	}

	@GetMapping("/departmentwithmaxemployees")
	@Override
	public ResponseEntity<Department> findDepartmentWithMaxEmployees() {
		Department department = service.findDepartmentWithMaxEmployees();
		return new ResponseEntity<Department>(department, HttpStatus.OK);
	}

	@GetMapping("/oldestemployee")
	@Override
	public ResponseEntity<String> findOldestEmployee() {
		String result = service.findOldestEmployee();
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

}
