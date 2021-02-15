package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class PropertyController implements Initializable {

    @FXML
    private Label lblResult;
    
    private final MyNumber myNumber = new MyNumber();

    @FXML
    void processAdd(ActionEvent event) {
    	myNumber.setNumber(myNumber.getNumber() + 1);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		myNumber.numberProperty().addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<? extends Object> observableValue, Object oldValue, Object newValue) {
				lblResult.setText(String.valueOf(myNumber.getNumber()));
				
			}
		});
	}

}
