package Homework2;

import Homework1.Course;
import Homework1.EnglishCourse;
import Homework1.HistoryCourse;
import Homework1.MathCourse;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * Class: GUI
 *
 * @author Kevin Figueroa
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Written: February 14, 2021
 * <p>
 * This class extends from the Application class, which means that it contains methods from JavaFX such as the start()
 * method while also containing the main() method itself.
 * <p>
 * Purpose: This class creates both an arraylist to hold temporary Course data and a listView to create the main
 * screen of the GUI. It also contains methods for reading binary data and creating new windows with specific Course
 * information depending on what item the user double clicks.
 */
public class GUI extends Application {
    //actual courseList data
    private ArrayList<Course> courseList = readFile();

    /**
     * This method makes the program easier to run.
     *
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }

    /**
     * This is the primary method that starts the JavaFX application. It contains JavaFX elements such as labels, VBoxes,
     * and ListViews. It also creates new windows according to user button clicks by using a handler for such mouse
     * events.
     *
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        //Create a listview to display the list of Courses in the main window
        ListView<String> listView = new ListView<>();

        //Call to method that populates the listview with the necessary Course information
        populateListView(listView);

        //Makes the items in the listview be selected as a single object and not multiple
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        //Create a handler for the double click mouse event
        listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //Selects the specific Course depending on the position of the mouse
                Course selectedCourse = courseList.get(listView.getSelectionModel().getSelectedIndex());

                //Crete labels for the common attributes
                Label courseName = new Label("Name: " + selectedCourse.getCourseName());
                Label courseCrn = new Label("CRN: " + selectedCourse.getCourseCrn());

                //Check to see if the user clicked two times
                if (mouseEvent.getClickCount() == 2) {
                    if (selectedCourse.getCourseDiscipline().equalsIgnoreCase("English")) {
                        EnglishCourse engl = (EnglishCourse) selectedCourse;

                        //Create Labels specific to English Course
                        Label courseClassification = new Label("Classification: " + engl.getClassification());
                        Label hasReading = new Label("Has Reading: " + engl.hasReading());
                        Label hasWriting = new Label("Has Writing: " + engl.hasWriting());

                        //Create a container for the labels
                        VBox englishBox = new VBox();

                        //Populate container
                        englishBox.getChildren().addAll(courseName, courseCrn, courseClassification, hasReading, hasWriting);

                        //Call to method that creates a new window with specific English Course information
                        createCourseWindow(englishBox, engl);
                    } else if (selectedCourse.getCourseDiscipline().equalsIgnoreCase("Math")) {
                        MathCourse math = (MathCourse) selectedCourse;

                        //Create labels specific to Math Course
                        Label stem = new Label("STEM Related: " + math.isSTEM());
                        Label type = new Label("Format: " + math.getInstructionType());

                        //Create a container for the labels
                        VBox mathBox = new VBox();

                        //Populate container
                        mathBox.getChildren().addAll(courseName, courseCrn, stem, type);

                        //Call to method that creates a new window with specific Math Course information
                        createCourseWindow(mathBox, math);
                    } else {
                        HistoryCourse hist = (HistoryCourse) selectedCourse;

                        //Create labels specific to History Course
                        Label areaE = new Label("Area E Eligible: " + hist.isAreaE_Eligible());
                        Label type = new Label("Format: " + hist.getInstructionType());

                        //Create a container for the labels
                        VBox histBox = new VBox();

                        //Populate container
                        histBox.getChildren().addAll(courseName, courseCrn, areaE, type);

                        //Call to method that creates a new window with specific History Course information
                        createCourseWindow(histBox, hist);
                    }
                }
            }
        });

        //Call to method that creates the main window containing the course library
        createMainWindow(primaryStage, listView);
    }

    /**
     * This method creates and sets the necessary components to create the main window for the Course Library
     *
     * @param mainStage Stage object that refers to the primary stage of the Application
     * @param listView  JavaFX object that will be displayed in the main window
     */
    public void createMainWindow(Stage mainStage, ListView<String> listView) {
        //Create top level label for the main window
        Label listLabel = new Label("Course List");

        //Create container and scene for main window that adds the label and list
        VBox vBox = new VBox(listLabel, listView);
        Scene scene = new Scene(vBox, 400, 200);

        //Sets the title and scene for the main window
        mainStage.setTitle("Course Library");
        mainStage.setScene(scene);

        //Displays the window to the screen
        mainStage.show();

    }

    /**
     * This method sets the scene and stage of a specific Course object and opens it in a new window
     *
     * @param box    Container that is used to arrange the JavaFx components in a vertical fashion
     * @param course Objected needed to get the required category for the title of the window
     */
    public void createCourseWindow(VBox box, Course course) {
        //Create a scene and stage for the new course window
        Scene courseScene = new Scene(box, 300, 100);
        Stage courseStage = new Stage();

        //Sets the title and scene of the course window
        courseStage.setTitle(course.getCourseDiscipline());
        courseStage.setScene(courseScene);

        //Displays the window to the screen
        courseStage.show();
    }

    /**
     * This method iterates through the class's arraylist of Course objects and adds them to the listview object
     *
     * @param listView JavaFX object that will display the course library in a new window
     */
    public void populateListView(ListView<String> listView) {
        //Iterate through the courseList to add course information to the listview
        for (Course c : courseList) {
            listView.getItems().add(c.getCourseDiscipline() + ", " +
                    c.getCourseName() + ", " +
                    c.getCourseCrn());
        }
    }

    /**
     * This method reads Course object data from a binary file and then adds it to an arraylist.
     *
     * @return an arraylist object containing Course data
     */
    public ArrayList<Course> readFile() {
        //Create an arraylist to store course data
        ArrayList<Course> courseList = new ArrayList<>();

        //Open an input stream
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(
                    new FileInputStream("C:\\Users\\kevin\\IntelliJIDEAProjects\\ITEC3150\\courses.dat"));

            //Add all course objects from the binary file to the arraylist until it reaches the EndOfFile
            try {
                while (true) {
                    courseList.add((Course) ois.readObject());
                }
            } catch (EOFException e) {
                System.out.println();
            }

            //Close the stream
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return courseList;
    }
}
