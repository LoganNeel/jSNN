package jsnn.jsnn;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The `MainApplication` class serves as the entry point for the JavaFX application.
 * It extends the `Application` class and is responsible for initializing and displaying
 * the main application window.
 */
public class MainApplication extends Application {

    /**
     * Starts the JavaFX application by setting up the primary stage.
     *
     * @param stage The primary stage for this application.
     * @throws IOException If an error occurs during loading the FXML file.
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Load the FXML file for the main view.
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);

        // Set the minimum size of the application window.
        stage.setMinWidth(800);
        stage.setMinHeight(600);

        // Load and apply the CSS stylesheet.
        scene.getStylesheets().add(MainApplication.class.getResource("/styles/main.css").toExternalForm());

        // Set the scene and display the stage.
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main method serves as the entry point for the application.
     *
     * @param args Command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        launch();
    }
}