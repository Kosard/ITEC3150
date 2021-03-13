package Homework3;

/**
 * Class: GUI
 *
 * @author Kevin Figueroa
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Date Written: 3/10/2021
 * <p>
 * This class: now describe what the class does
 * <p>
 * Purpose: Describe the purpose of this class
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUIProto extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Progress Bar");

        ProgressBar pBar = new ProgressBar(0);
        ProgressIndicator indicator = new ProgressIndicator(0);

        for (int i = 0; i < 100; i++) {
            pBar.setProgress(i);
            indicator.setProgress(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        HBox hBox = new HBox(20);
        hBox.getChildren().addAll(pBar, indicator);

        Scene scene = new Scene(hBox, 960, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
