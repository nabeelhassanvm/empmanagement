package com.sample.empmanagement;

public class Department {

	private int id;
	private String name;
	private boolean active;

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", active=" + active + "]";
	}

	/**
	 *
	 */
	public Department() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 * @param active
	 */
	public Department(int id, String name, boolean active) {
		super();
		this.id = id;
		this.name = name;
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
}
