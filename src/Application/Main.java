/*
 * Daniel Fuhrmann
 * CSCE 314-598
 * Final Project
 */

package Application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application{
    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Design.fxml"));
            Scene scene = new Scene(root, 500, 700);
            scene.getStylesheets().add(getClass().getResource("DesignCSS.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                public void handle(WindowEvent e) {
                    Controller.log.closeLog();
                }
            });
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
