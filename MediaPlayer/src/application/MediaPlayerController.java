package application;

import java.io.File;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.Duration;

public class MediaPlayerController {

	@FXML
	private MediaView mediaView;

	@FXML
	private Slider seekSlider;

	@FXML
	private Slider volumeSlider;
	
	private Media media;
	private MediaPlayer mediaPlayer;

	@FXML
	void processBrowseVideo(ActionEvent event) {
		FileChooser videoChooser = new FileChooser();
		
		// Setting default initial dictory
		videoChooser.setInitialDirectory(new File("C:\\Users\\GIC\\Videos"));
		
		// Setting extension filter
		videoChooser.getExtensionFilters().add(new ExtensionFilter("Video Files", "*.mp4", "*.mkv", "*.webm", "*.flv"));
		
		// Opening dialog
		File videoFile = videoChooser.showOpenDialog(null); // open in current window
		
		// Setting media player to media view
		String videoPath = videoFile.toURI().toString(); 
		if (videoPath != null) {
			this.media = new Media(videoPath);
			this.mediaPlayer = new MediaPlayer(media);
			// this.mediaPlayer.setAutoPlay(true);
			
			this.mediaView .setMediaPlayer(mediaPlayer);
			
			// Setting sence to video's width and height
			DoubleProperty width = mediaView.fitWidthProperty();
			DoubleProperty height = mediaView.fitHeightProperty();
			width.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
			height.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));
			
			// media player's volume is 0 - 1.
			volumeSlider.setValue(mediaPlayer.getVolume() * 100);
			volumeSlider.valueProperty().addListener(new InvalidationListener() {
				
				@Override
				public void invalidated(Observable arg0) {
					mediaPlayer.setVolume(volumeSlider.getValue() / 100); // Volume slider is 0 - 100.
				}
			});
			
			mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {

				@Override
				public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
					seekSlider.setValue(newValue.toSeconds());
					
				}
			});
			
			mediaPlayer.setOnReady(new Runnable() {
				
				@Override
				public void run() {
					Duration total = media.getDuration();
					seekSlider.setMax(total.toSeconds());
				}
			});
			
			// Adding click action to seek slider
			seekSlider.setOnMousePressed(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent arg0) {
					mediaPlayer.seek(Duration.seconds(seekSlider.getValue()));
				}
			});
			
			// Adding drug action to seek slider
			seekSlider.setOnMouseDragged(new EventHandler<MouseEvent>() {
				
				@Override
				public void handle(MouseEvent arg0) {
					mediaPlayer.seek(Duration.seconds(seekSlider.getValue()));
				}
			});
			
			
			// start play on browse
			mediaPlayer.play();
		}
		
	}

	@FXML
	void processMinus10s(ActionEvent event) {
		this.mediaPlayer.seek(mediaPlayer.getCurrentTime().subtract(Duration.seconds(10)));
	}

	@FXML
	void processMinus2x(ActionEvent event) {
		this.mediaPlayer.setRate(0.5);
	}

	@FXML
	void processPause(ActionEvent event) {
		this.mediaPlayer.pause();
	}

	@FXML
	void processPlay(ActionEvent event) {
		this.mediaPlayer.play();
		this.mediaPlayer.setRate(1);
	}

	@FXML
	void processPlus10s(ActionEvent event) {
		this.mediaPlayer.seek(mediaPlayer.getCurrentTime().add(Duration.seconds(10)));
	}

	@FXML
	void processPlus2x(ActionEvent event) {
		this.mediaPlayer.setRate(2);
	}

	@FXML
	void processStop(ActionEvent event) {
		this.mediaPlayer.stop();
	}

}
