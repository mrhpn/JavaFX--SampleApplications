package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class MyNumber {
	private IntegerProperty number;

	public Integer getNumber() {
		return number.get();
	}

	public void setNumber(Integer number) {
		this.numberProperty().set(number);
	}
	
	public final IntegerProperty numberProperty() {
		if (number == null)
			this.number = new SimpleIntegerProperty(0);
		
		return number;
	}
}
