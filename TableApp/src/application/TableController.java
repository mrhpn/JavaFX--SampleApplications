package application;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableController implements Initializable {

    @FXML
    private TableView<Employee> tbEmployee;

    @FXML
    private TableColumn<Employee, Integer> employeeId;

    @FXML
    private TableColumn<Employee, String> employeeFName;

    @FXML
    private TableColumn<Employee, String> employeeLName;

    @FXML
    private TableColumn<Employee, String> employeeEmail;

    @FXML
    private TableColumn<Employee, String> employeePhone;

    @FXML
    private Slider slider;

    @FXML
    private TextField tfSlider;
    
    private final EmployeeDataUtils employeeDataUtils = new EmployeeDataUtils();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		employeeId.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("employeeId"));
		employeeFName.setCellValueFactory(new PropertyValueFactory<Employee, String>("employeeFName"));
		employeeLName.setCellValueFactory(new PropertyValueFactory<Employee, String>("employeeLName"));
		employeeEmail.setCellValueFactory(new PropertyValueFactory<Employee, String>("employeeEmail"));
		employeePhone.setCellValueFactory(new PropertyValueFactory<Employee, String>("employeePhone"));
		
		tbEmployee.setItems(employeeDataUtils.getEmployeeList());
		
		tfSlider.textProperty().bindBidirectional(slider.valueProperty(), NumberFormat.getInstance());
	}
}
