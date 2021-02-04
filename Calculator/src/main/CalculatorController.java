package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatorController {

	@FXML
	private Label lblResult;
	
	private boolean isStart = true;

	@FXML
	void processNumber(ActionEvent event) {
		if (isStart) {
			lblResult.setText("");
			isStart = false;
		}
		
		String value = ((Button)event.getSource()).getText();
		lblResult.setText(lblResult.getText() + value);
	}

	@FXML
	void processOperator(ActionEvent event) {

	}

}
