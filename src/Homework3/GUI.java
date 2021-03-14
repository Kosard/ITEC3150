package Homework3;

/**
 * Class: GUI
 *
 * @author Kevin Figueroa
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Date Written: 3/11/2021
 * <p>
 * This class: now describe what the class does
 * <p>
 * Purpose: Describe the purpose of this class
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GUI extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ArraySumHolder holder = new ArraySumHolder();
        final int INCREMENT = holder.getNUM_OF_ARRAYS() / 10;

        double[][] splitArray = holder.getSplitArray();
        ExecutorService pool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < splitArray.length; i++) {
            AddRunnable addable = new AddRunnable(holder, splitArray[i]);
            pool.execute(addable);
        }

        pool.shutdown();

        TextField textField = new TextField("The current sum is...");
        textField.setEditable(false);
        TextField sumField = new TextField();
        sumField.textProperty().addListener(((observable, oldValue, newValue) -> {

        }));
        sumField.setEditable(false);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(textField, sumField);

        Scene scene = new Scene(hBox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
