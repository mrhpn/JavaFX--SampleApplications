package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Label;

public class ChartController {

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private AreaChart<String, Integer> areaChart;

    @FXML
    private Label lblBarValue;

    @FXML
    private Label lblAreaValue;

    @FXML
    void processAreaLoad(ActionEvent event) {
		areaChart.getData().clear();
		
    	Series<String, Integer> areaSeries = new Series<String, Integer>();
    	areaSeries.getData().add(new Data<String, Integer>("Mon", 1));
    	areaSeries.getData().add(new Data<String, Integer>("Tue", 3));
    	areaSeries.getData().add(new Data<String, Integer>("Wed", 2));
    	areaSeries.getData().add(new Data<String, Integer>("Thu", 4));
    	areaSeries.getData().add(new Data<String, Integer>("Fri", 3));
    	areaSeries.getData().add(new Data<String, Integer>("Sat", 3));
    	areaSeries.getData().add(new Data<String, Integer>("Sun", 10));
    	areaChart.getData().add(areaSeries);
    }

    @FXML
    void processBarLoad(ActionEvent event) {
		barChart.getData().clear();
    	Series<String, Integer> barSeries = new Series<String, Integer>();
    	barSeries.getData().add(new Data<String, Integer>("Mon", 1));
    	barSeries.getData().add(new Data<String, Integer>("Tue", 3));
    	barSeries.getData().add(new Data<String, Integer>("Wed", 2));
    	barSeries.getData().add(new Data<String, Integer>("Thu", 4));
    	barSeries.getData().add(new Data<String, Integer>("Fri", 3));
    	barSeries.getData().add(new Data<String, Integer>("Sat", 3));
    	barSeries.getData().add(new Data<String, Integer>("Sun", 10));
    	barChart.getData().add(barSeries);
    }

}
