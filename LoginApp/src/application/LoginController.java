package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class LoginController {

	@FXML
	private TextField tfEmail;

	@FXML
	private PasswordField tfPassword;

	@FXML
	private RadioButton rbMale;

	@FXML
	private ToggleGroup tgGender;

	@FXML
	private RadioButton rbFemale;

	@FXML
	private Label lblStatus;

	@FXML
	void processLogin(ActionEvent event) {
		lblStatus.setVisible(true);

		System.out.println(tfEmail.getText());

		if (tfEmail.getText().trim().equals("admin@gmail.com") && tfPassword.getText().equals("aaaaa"))
			lblStatus.setText("Login success!");
		else
			lblStatus.setText("Login fail!");
	}

}
