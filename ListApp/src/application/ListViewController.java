package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

public class ListViewController implements Initializable {

	@FXML
	private ListView<String> lvCountry;

	@FXML
	private Button btnCountry;

	@FXML
	private ComboBox<String> cobCountry;

	@FXML
	private Label lblList;

	private ObservableList<String> countryList1 = FXCollections.observableArrayList("Myanmar", "Japan", "Thailand",
			"Singapore", "New Zeland");

	private ObservableList<String> countryList2 = FXCollections.observableArrayList("UK", "USA", "Russia", "Laos",
			"Malaysia");

	@FXML
	void processAdd(ActionEvent event) {
		// lvCountry.getItems().add(cobCountry.getValue());
		
		// Single select
		// String selectedCountry = lvCountry.getSelectionModel().getSelectedItem();
		// lblList.setText(selectedCountry);
		
		// Multiple select
		ObservableList<String> selectedCountryList = lvCountry.getSelectionModel().getSelectedItems();
		var countryList = "";
		for (String country : selectedCountryList) {
			countryList += country + "\n";
		}
		
		lblList.setText(countryList);
		
	}

	@FXML
	void processCombo(ActionEvent event) {
		// lvCountry.getItems().addAll(countryList2);
		
		// this.countryList1.addAll(countryList2);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lvCountry.setItems(countryList1);
		cobCountry.setItems(countryList2);
		
		lvCountry.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}

}
