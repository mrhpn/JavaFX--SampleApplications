package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TreeController implements Initializable {

	@FXML
	private TreeView<String> tvProject;

	@FXML
	private DatePicker dpDate;

	@FXML
	private Label lblDate;

	@FXML
	void processClose(ActionEvent event) {

	}

	@FXML
	void processDate(ActionEvent event) {

	}

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Image iconProject = new Image(getClass().getResourceAsStream("/images/iconProject.png"));
		Image iconResourceFolder = new Image(getClass().getResourceAsStream("/images/iconResourceFolder.png"));
		Image iconPackage = new Image(getClass().getResourceAsStream("/images/iconPackage.png"));
		Image iconJavaFile = new Image(getClass().getResourceAsStream("/images/iconJavaFile.png"));
		Image iconLibraryContainer= new Image(getClass().getResourceAsStream("/images/iconLibraryContainer.png"));
		
		TreeItem<String> main = new TreeItem<String>("Calculator", new ImageView(iconProject));
		
		TreeItem<String> sub1 = new TreeItem<String>("src", new ImageView(iconResourceFolder));
		TreeItem<String> sub11 = new TreeItem<String>("main", new ImageView(iconPackage));
		TreeItem<String> sub111 = new TreeItem<String>("CalculatorController", new ImageView(iconJavaFile));
		
		TreeItem<String> sub2 = new TreeItem<String>("JRE System Library", new ImageView(iconLibraryContainer));
		TreeItem<String> sub3 = new TreeItem<String>("JavaFx15", new ImageView(iconLibraryContainer));
		
		sub11.getChildren().add(sub111);
		sub1.getChildren().add(sub11);
		main.getChildren().addAll(sub1, sub2, sub3);
		
		tvProject.setRoot(main);
	}

}
