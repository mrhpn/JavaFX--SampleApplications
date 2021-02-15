package application;

import java.io.File;
import java.util.List;

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

		// Defining default path for file chooser
		fileChooser.setInitialDirectory(new File("C:\\Users\\GIC\\Documents"));

		// Defining extensions
		ExtensionFilter imageFilter = new ExtensionFilter("Choose Images...", "*.png", "*.jpg", "*.jpeg");
		ExtensionFilter videoFilter = new ExtensionFilter("Choose Videos...", "*.mp4", "*.mkv", "*.ogg");
		ExtensionFilter documentFilter = new ExtensionFilter("Choose Documents...", "*.pdf", "*.docx");
		// Adding multiple extension filters
		fileChooser.getExtensionFilters().addAll(imageFilter, videoFilter, documentFilter);

		File file = fileChooser.showOpenDialog(null);

		if (file != null)
			lvFile.getItems().add(file.getName());
	}

	@FXML
	void processBrowseFiles(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();

		// Defining default path for file chooser
		fileChooser.setInitialDirectory(new File("C:\\Users\\GIC\\Documents"));

		// Defining extensions
		ExtensionFilter imageFilter = new ExtensionFilter("Choose Images...", "*.png", "*.jpg", "*.jpeg");
		ExtensionFilter videoFilter = new ExtensionFilter("Choose Videos...", "*.mp4", "*.mkv", "*.ogg");
		ExtensionFilter documentFilter = new ExtensionFilter("Choose Documents...", "*.pdf", "*.docx");
		// Adding multiple extension filters
		fileChooser.getExtensionFilters().addAll(imageFilter, videoFilter, documentFilter);

		List<File> files = fileChooser.showOpenMultipleDialog(null);
		if (files != null)
			files.stream().forEach(file -> lvFile.getItems().add(file.getAbsolutePath()));
	}

}
