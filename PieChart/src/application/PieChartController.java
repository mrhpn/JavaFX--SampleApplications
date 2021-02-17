package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class PieChartController {

	@FXML
	private PieChart piechart;
	
    @FXML
    private Label lblValue;

	@FXML
	void processLoad(ActionEvent event) {
		ObservableList<Data> pieData = FXCollections.observableArrayList(
					new Data("Swimming", 15),
					new Data("Reading", 15),
					new Data("Soccer", 50),
					new Data("Badminton", 15),
					new Data("Gaming", 5)
				);
		
		piechart.setData(pieData);
		
		for(final Data data : piechart.getData()) {
			data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent arg0) {
					lblValue.setText(String.valueOf(data.getPieValue() + "%"));
				}
				
			});
		}
	}
}
