package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LoginController {

	@FXML
	private TextField tfEmail;

	@FXML
	private PasswordField pfPassword;

	@FXML
	private RadioButton rbMale;

	@FXML
	private ToggleGroup tgGender;

	@FXML
	private RadioButton rbFemale;

	@FXML
	private Label lblStatus;

	@FXML
	private ComboBox<String> cobRole;

	private String gender;

	@FXML
	void processGender(ActionEvent event) {
		if (rbMale.isSelected()) {
			this.gender = rbMale.getText();
		}

		if (rbFemale.isSelected()) {
			this.gender = rbFemale.getText();
		}
	}

	@FXML
	void processLogin(ActionEvent event) throws IOException {

		lblStatus.setVisible(true);

		if (tfEmail.getText().trim().equals("admin") && pfPassword.getText().equals("11111")) {

			lblStatus.setTextFill(Color.GREEN);
			lblStatus.setText("Login Success");

			User.setEmail(tfEmail.getText());
			User.setRole(cobRole.getValue());
			User.setGender(this.gender);

			Stage mainStage = new Stage();
			BorderPane mainParent = (BorderPane) FXMLLoader.load(getClass().getResource("../main/MainUI.fxml"));
			Scene scene = new Scene(mainParent);
			mainStage.setScene(scene);
			mainStage.show();
			mainStage.setTitle("MainUI");
		} else {
			lblStatus.setTextFill(Color.RED);
			lblStatus.setText("Incorrect email or password");
		}

	}

}
