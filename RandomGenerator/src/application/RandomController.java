package application;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class RandomController {
	@FXML
	private Label lblResult;

	@FXML
	private void generateRandomNumber(ActionEvent event) {
		Random random = new Random();
		int value = random.nextInt(1000);

		lblResult.setText(String.valueOf(value));
	}
}
