package com.sample.empmanagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class EmpManagementService {
	
	private List<Employee> employees = new ArrayList<Employee>();

	private EmpManagementService() {
		System.out.println("Populating Datasets");
		addDataSets(employees);
	}

	/**
	 * @return 
	 */
	String findOldestEmployee() {
		Collections.sort(employees, new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				if (o1.getStartDate() == null || o2.getStartDate() == null)
					return 0;
				return o1.getStartDate().compareTo(o2.getStartDate());
			}
		});
		StringBuilder sb = new StringBuilder().append("Oldest employee is ")
				.append(employees.get(0).getName()).append(" and he joined on ")
				.append(new SimpleDateFormat("yyyy-MM-dd").format(employees.get(0).getStartDate()));
		return sb.toString();
	}

	/**
	 * @return 
	 */
	Department findDepartmentWithMaxEmployees() {
		Map<Department, Integer> departmentToEmployeeMap = new HashMap<Department, Integer>();
		for (Employee employee : employees) {
			if (departmentToEmployeeMap.containsKey(employee.getDepartment())) {
				int empCount = departmentToEmployeeMap.get(employee.getDepartment());
				empCount++;
				departmentToEmployeeMap.put(employee.getDepartment(), empCount);
			} else {
				departmentToEmployeeMap.put(employee.getDepartment(), 1);
			}
		}
		Entry<Department, Integer> biggestDepartmentMapEntry = departmentToEmployeeMap.entrySet().stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).findFirst().get();
		return biggestDepartmentMapEntry.getKey();
	}

	/**
	 * @param employees
	 * @return 
	 */
	List<Department> findActiveDepartments() {
		Map<Integer, Department> departmentMap = new HashMap<Integer, Department>();
		for (Employee employee : employees) {
			if (!departmentMap.containsKey(employee.getDepartment().getId())) {
				departmentMap.put(employee.getDepartment().getId(), employee.getDepartment());
			}
		}
		List<Department> activeDepartmentsList = departmentMap.values().stream().filter(dep -> dep.isActive()).collect(Collectors.toList());
		System.out.println("Total Active Departments is " + activeDepartmentsList.size());
		return activeDepartmentsList;
	}

	/** Adding datasets for operation.
         * @param employees 
         * 
         */
    private void addDataSets(List<Employee> employees) {
    	SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd");
    	final Department department1 = new Department(1, "IT", true);
    	final Department department2 = new Department(2, "Finance", true);
    	final Department department3 = new Department(3, "HR", true);
    	final Department department4 = new Department(4, "Admin", true);
    	Employee employee1;
		try {
			employee1 = new Employee(1, "Hello One", department1, formatter.parse("1977-09-03"), true);
			employees.add(employee1);
			final Employee employee2 = new Employee(2, "Hello Two", department2, formatter.parse("1923-09-03"), true);
			employees.add(employee2);
			final Employee employee3 = new Employee(3, "Hello Three", department3, formatter.parse("1926-02-03"), true);
			employees.add(employee3);
			final Employee employee4 = new Employee(4, "Hello Four", department1, formatter.parse("1955-12-03"), true);
			employees.add(employee4);
			final Employee employee5 = new Employee(5, "Hello Five", department4, formatter.parse("1938-06-03"), true);
			employees.add(employee5);
			final Employee employee6 = new Employee(6, "Hello Six", department1, formatter.parse("1962-08-03"), true);
			employees.add(employee6);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
