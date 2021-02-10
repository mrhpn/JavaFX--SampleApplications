package main;

import java.net.URL;
import java.util.ResourceBundle;

import application.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class MainController implements Initializable {

	@FXML
	private CheckBox cb1;

	@FXML
	private CheckBox cb2;

	@FXML
	private CheckBox cb3;

	@FXML
	private CheckBox cb4;

	@FXML
	private CheckBox cb5;

	@FXML
	private CheckBox cb6;

	@FXML
	private Label lblItem;

	@FXML
	private Label lblTotal;

	@FXML
	private Label lblEmail;

	@FXML
	private Label lblRole;

	@FXML
	private Label lblGender;

	@FXML
	void processCheck(ActionEvent event) {
		int total = 0;
		int count = 0;

		if (cb1.isSelected()) {
			String cbLabel = cb1.getText();
			int spaceIndex = cbLabel.indexOf(" ");
			int price = Integer.parseInt(cbLabel.substring(spaceIndex).trim());

			total += price;
			count++;
		}

		if (cb2.isSelected()) {
			String cbLabel = cb2.getText();
			int spaceIndex = cbLabel.indexOf(" ");
			int price = Integer.parseInt(cbLabel.substring(spaceIndex).trim());

			total += price;
			count++;
		}

		if (cb3.isSelected()) {
			String cbLabel = cb3.getText();
			int spaceIndex = cbLabel.indexOf(" ");
			int price = Integer.parseInt(cbLabel.substring(spaceIndex).trim());

			total += price;
			count++;
		}

		if (cb4.isSelected()) {
			String cbLabel = cb4.getText();
			int spaceIndex = cbLabel.indexOf(" ");
			int price = Integer.parseInt(cbLabel.substring(spaceIndex).trim());

			total += price;
			count++;
		}

		if (cb5.isSelected()) {
			String cbLabel = cb5.getText();
			int spaceIndex = cbLabel.indexOf(" ");
			int price = Integer.parseInt(cbLabel.substring(spaceIndex).trim());

			total += price;
			count++;
		}

		if (cb6.isSelected()) {
			String cbLabel = cb6.getText();
			int spaceIndex = cbLabel.indexOf(" ");
			int price = Integer.parseInt(cbLabel.substring(spaceIndex).trim());

			total += price;
			count++;
		}

		lblItem.setText(String.valueOf(count));

		lblTotal.setText(String.valueOf(total));

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblEmail.setText(User.getEmail());

		lblGender.setText(User.getGender());

		lblRole.setText(User.getRole());

	}

}
