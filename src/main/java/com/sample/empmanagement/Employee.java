package com.sample.empmanagement;

import java.util.Date;

public class Employee {

	private int id;
	private String name;
	private Department department;
	private Date startDate;
	private boolean active;

	/**
	 *
	 */
	public Employee() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 * @param department
	 * @param startDate
	 * @param active
	 */
	public Employee(int id, String name, Department department, Date startDate, boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.startDate = startDate;
		this.active = active;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date date) {
		this.startDate = date;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", startDate=" + startDate
				+ ", active=" + active + "]";
	}

}
