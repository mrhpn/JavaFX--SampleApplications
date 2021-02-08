package main;

import java.text.DecimalFormat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatorController {

	@FXML
	private Label lblResult;
	
	private boolean isStart = true;
	private String operator = "";
	private double operand1 = 0;
	private double operand2 = 0;
	private final CalculatorModel calculatorModel = new CalculatorModel();
	
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
		String value = ((Button)event.getSource()).getText();
		
		if (!value.equals("=")) {
			if (!operator.isEmpty()) return;
			
			this.operand1 = Double.parseDouble(lblResult.getText());
			this.operator = value;
			lblResult.setText("");
		} else {
			if (operator.isEmpty()) return;
			
			this.operand2 = Double.parseDouble(lblResult.getText());
			double result = calculatorModel.calculate(this.operand1, this.operand2, this.operator);
			lblResult.setText(String.valueOf(new DecimalFormat("#.###").format(result)));
			
			this.operator = "";
			isStart = true;
		}
	}
	
	@FXML
	void processAC() {
		this.isStart = true;
		this.operand1 = 0;
		this.operand2 = 0;
		this.operator = "";
		lblResult.setText("0");
	}

}
