package main;

public class CalculatorModel {
	
	public double calculate(double operand1, double operand2, String operator) {
		
		switch(operator) {
		case "+":
			return operand1 + operand2;
		case "-":
			return operand1 - operand2;
		case "*":
			return operand1 * operand2;
		case "/":
			if (operand2 == 0) return 0;
			return operand1 / operand2;
		default:
			return 0;
		}
	}
}
