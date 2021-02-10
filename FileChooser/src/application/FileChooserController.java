package application;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class FileChooserController {

	@FXML
	private ListView<String> lvFile;

	@FXML
	void processBrowseFile(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setInitialDirectory(new File("C:\\Users\\GIC\\Documents"));
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Choose Images...", "*.png", "*.jpg", "*.jpeg"));
		File file = fileChooser.showOpenDialog(null);

		if (file != null)
			lvFile.getItems().add(file.getName());
	}

	@FXML
	void processBrowseFiles(ActionEvent event) {

	}

}
