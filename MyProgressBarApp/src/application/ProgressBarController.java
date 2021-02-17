package application;

import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;

public class ProgressBarController implements Initializable {

	@FXML
	private ProgressBar progressBar;

	@FXML
	private ProgressIndicator progressIndicator;

	@FXML
	private Label lblProgress;

	@FXML
	private Label lblPercent;
	
	private final MyNumber myNumber = new MyNumber();

	@FXML
	void btnMinus(ActionEvent event) {
		myNumber.setNumber(myNumber.getNumber() - 0.01);
	}

	@FXML
	void btnPlus(ActionEvent event) {
		myNumber.setNumber(myNumber.getNumber() + 0.01);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		myNumber.numberProperty().addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<? extends Object> arg0, Object arg1, Object arg2) {
				lblProgress.setText(new DecimalFormat("#.##").format(myNumber.getNumber()));
				lblPercent.setText(new DecimalFormat("#.##").format(myNumber.getNumber()*100) + "%");
				
				progressBar.progressProperty().bind(myNumber.numberProperty());
				progressIndicator.progressProperty().bind(myNumber.numberProperty());
			}
		});
	}

}
