package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmployeeDataUtils {
	public ObservableList<Employee> getEmployeeList() {
		ObservableList<Employee> employeeList = FXCollections.observableArrayList();
		
		employeeList.add(new Employee(1, "A", "Kyaw", "mmk@gmail.com", "0934343"));
		employeeList.add(new Employee(2, "B", "Kyaw", "mmk@gmail.com", "0934343"));
		employeeList.add(new Employee(3, "C", "Kyaw", "mmk@gmail.com", "0934343"));
		employeeList.add(new Employee(4, "D", "Kyaw", "mmk@gmail.com", "0934343"));
		employeeList.add(new Employee(5, "E", "Kyaw", "mmk@gmail.com", "0934343"));
		employeeList.add(new Employee(6, "F", "Kyaw", "mmk@gmail.com", "0934343"));
		employeeList.add(new Employee(7, "G", "Kyaw", "mmk@gmail.com", "0934343"));
		
		return employeeList;
	}
}
