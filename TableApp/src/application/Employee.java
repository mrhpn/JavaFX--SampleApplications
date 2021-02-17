package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Employee {
	private SimpleIntegerProperty employeeId;
	private SimpleStringProperty employeeFName;
	private SimpleStringProperty employeeLName;
	private SimpleStringProperty employeeEmail;
	private SimpleStringProperty employeePhone;

	public Employee(Integer employeeId, String employeeFName, String employeeLName, String employeeEmail,
			String employeePhone) {
		super();
		this.employeeId = new SimpleIntegerProperty(employeeId);
		this.employeeFName = new SimpleStringProperty(employeeFName);
		this.employeeLName = new SimpleStringProperty(employeeLName);
		this.employeeEmail = new SimpleStringProperty(employeeEmail);
		this.employeePhone = new SimpleStringProperty(employeePhone);
	}

	public Integer getEmployeeId() {
		return employeeId.get();
	}

	public String getEmployeeFName() {
		return employeeFName.get();
	}

	public String getEmployeeLName() {
		return employeeLName.get();
	}

	public String getEmployeeEmail() {
		return employeeEmail.get();
	}

	public String getEmployeePhone() {
		return employeePhone.get();
	}

}
