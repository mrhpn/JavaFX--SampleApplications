package application;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class MyNumber {
	private DoubleProperty number;

	public Double getNumber() {
		return number.get();
	}

	public void setNumber(Double number) {
		this.numberProperty().set(number);
	}
	
	public final DoubleProperty numberProperty() {
		if (number == null)
			this.number = new SimpleDoubleProperty(0);
		
		return number;
	}

	@Override
	public String toString() {
		return "MyNumber [number=" + number + "]";
	}
}
