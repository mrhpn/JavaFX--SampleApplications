package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;

public class LieChartController {
	
    @FXML
    private LineChart<String, Double> lineChart;

	@FXML
	private Label lblXValue;

	@FXML
	private Label lblYValue;

	@FXML
	void processLoad(ActionEvent event) {
		lineChart.getData().clear();
		
		Series<String, Double> year1 = new Series<String, Double>();
		year1.getData().add(new Data<String, Double>("Jan", 300000.0));
		year1.getData().add(new Data<String, Double>("Feb", 400000.0));
		year1.getData().add(new Data<String, Double>("Mar", 500000.0));
		year1.getData().add(new Data<String, Double>("April", 700000.0));
		year1.getData().add(new Data<String, Double>("May", 200000.0));
		year1.getData().add(new Data<String, Double>("June", 400000.0));
		year1.getData().add(new Data<String, Double>("July", 300000.0));
		year1.getData().add(new Data<String, Double>("Aug", 300000.0));
		year1.getData().add(new Data<String, Double>("Sep", 300000.0));
		year1.getData().add(new Data<String, Double>("Oct", 600000.0));
		year1.getData().add(new Data<String, Double>("Nov", 800000.0));
		year1.getData().add(new Data<String, Double>("Dec", 900000.0));
		
		@SuppressWarnings("unchecked")
		ObservableList<Data<String, Double>> year2Data = FXCollections.observableArrayList(
				new Data<String, Double>("Jan", 400000.0),
				new Data<String, Double>("Feb", 200000.0),
				new Data<String, Double>("Mar", 100000.0),
				new Data<String, Double>("April", 400000.0),
				new Data<String, Double>("May", 500000.0),
				new Data<String, Double>("June", 600000.0),
				new Data<String, Double>("July", 800000.0),
				new Data<String, Double>("Aug", 700000.0),
				new Data<String, Double>("Sep", 300000.0),
				new Data<String, Double>("Oct", 300000.0),
				new Data<String, Double>("Nov", 300000.0),
				new Data<String, Double>("Dec", 800000.0)
				);
		
		Series<String, Double> year2 = new Series<String, Double>(year2Data);
		
		lineChart.getData().addAll(year1, year2);
		
		for(Data<String, Double> data : year1.getData()) {
			data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {

				@Override
				public void handle(Event arg0) {
					lblXValue.setText(String.valueOf(data.getXValue()));
					lblYValue.setText(String.valueOf(data.getYValue()));
					
					Tooltip.install(data.getNode(), new Tooltip("X: " + data.getXValue() + "\nY: " + data.getYValue()));
				}
			});
		}
		
		for(Data<String, Double> data1 : year2.getData()) {
			data1.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {

				@Override
				public void handle(Event arg0) {
					lblXValue.setText(String.valueOf(data1.getXValue()));
					lblYValue.setText(String.valueOf(data1.getYValue()));
					
					Tooltip.install(data1.getNode(), new Tooltip("X: " + data1.getXValue() + "\nY: " + data1.getYValue()));
				}
			});
		}
	}

}
