package ebu.groupone.iteration.Controller;

import ebu.groupone.iteration.Control.Generator;
import ebu.groupone.iteration.Main;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import static ebu.groupone.iteration.Control.Generator.MAX_GENERATE;
import static ebu.groupone.iteration.Control.Generator.counter;

/**
 * Class of Controller to JavaFx FXML Main Page
 * @author  ebu6304.groupone 
 * @version 5.0 2022/5/29 14:33
 */ 
public class MainController implements Initializable {
    /**
     * JavaFx Parameter
     */
    @FXML
    private Button Button_Next;
    /**
     * Parameter
     */
    private Main application;//set text for Button Button_Time, which is attribute of class MainController
    /**
     * JavaFx Parameter
     */
    @FXML
    private Button Button_Time;
    /**
     * JavaFx Parameter
     */
    @FXML
    private AnchorPane Functon_AnchorPane;//AnchorPane extends Pane. Its basic attributes are the same as Pane
    /**
     * JavaFx Parameter
     */
    @FXML
    private ImageView Image_Background;//ImageView is used to display image
    /**
     * JavaFx Parameter
     */
    @FXML
    private Label Progress;
    /**
     * JavaFx Parameter
     */
    @FXML
    private Label Progress_Data;
    /**
     * JavaFx Parameter
     */
    @FXML
    private ImageView Generate_Data;//ImageView is used to display image
    /**
     * JavaFx Parameter
     */
    @FXML
    private ImageView Admin;//ImageView is used to display image


    /**
     * Settling this very Page
     * @param application The Current running JavaFx Application
     */
    public void setApp(Main application) {
        this.application = application;
    }

    /**
     * Go to Next Page
     * @param event JavaFx ActionEvent of Button Next
     */
    @FXML
    private void Next(ActionEvent event) {
        application.gotoidentify();//go to Identify Page
    }

    /**
     * The initialization of the current page, which will be run everytime this page is being accessed
     * @param url The location used to resolve relative paths for the root object, or
     *            {@code null} if the location is not known.
     * @param rb  The resources used to localize the root object, or {@code null} if
     *            the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {//override the initialize method defined by Initializable interface
        showTime();//Initialization operations after the main interface is opened
    }

    /**
     * Display the progress in percentage and numbers for visualize the process
     */
    public void progress() {
        Double progress = ((double) counter) / ((double) MAX_GENERATE);
        DecimalFormat df = new DecimalFormat("0");//Is A concrete subclass of A used to format decimal numbers. Here is used to round up without keeping decimals
        String return_String = df.format(progress * 100) + "%";//round up progress * 100 without keeping decimals, and then generate a string with %
        Progress.setText(return_String);//set text for label Progress, which is attribute of class MainController
        Progress_Data.setText(Integer.toString(counter) + "/" + Integer.toString(MAX_GENERATE));//set text for label Progress_Data, which is attribute of class MainController
    }

    /**
     * Trigger of the generator Thread
     * @param event MouseEvent of Generating
     */
    @FXML
    private void Generating(MouseEvent event) {
        Generator generator = new Generator();//Generator is class of generating random data for running the kiosk application. It is the subclass of Thread.
        generator.start();//start the generator thread to generate data for running the kiosk application
    }

    /**
     * Time control and display of Timer Button
     */
    private void showTime() {
        EventHandler<ActionEvent> eventHandler = event -> {
            Date date = new Date();//Date class often used to deal with date and time
            SimpleDateFormat Current_format = new SimpleDateFormat("HH:mm:ss");//SimpleDateFormat often used to format and parse dates in a locale-sensitive manner
            Button_Time.setText("UTC/GMT " + Current_format.format(new Date()));//set text for Button Button_Time, which is attribute of class MainController
            progress();//display the progress in percentage and numbers for visualize the process
        };
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1), eventHandler));//Timeline is the basic tool used to implement animation in JavafX
        timeline.setCycleCount(Timeline.INDEFINITE);//Set the number of times the animation is executed. Timeline.INDEFINITE means random.
        timeline.play();//start the animation
    }

    /**
     * Button Display Control of Check-in of Entering
     * @param event MouseEvent 0f Next
     */
    @FXML
    private void Enter_Highlight(MouseEvent event) {
        Button_Next.setText(">>>");//set text for Button Button_Next, which is attribute of class MainController
    }

    /**
     * Button Display Control of Check-in of Exiting
     * @param event MouseEvent 0f Next
     */
    @FXML
    private void Exit_Highlight(MouseEvent event) {
        Button_Next.setText("Fast-Checkin");//set text for Button Button_Next, which is attribute of class MainController
    }

    /**
     * Blur Effect Exiting the Label
     * @param event MouseEvent of Label
     */
    @FXML
    private void Exit_Label(MouseEvent event) {
        Image_Background.setEffect(null);//ImageView is used to display image
    }

    /**
     * Blur Effect Entering the Label
     * @param event MouseEvent of Label
     */
    @FXML
    private void Enter_Label(MouseEvent event) {
        BoxBlur boxBlur = new BoxBlur();//BoxBlur class is used to Blur image
        Image_Background.setEffect(boxBlur);//set blur effect to background image
    }

    /**
     * Blur Effect Entering the AnchorPane
     * @param event MouseEvent of AnchorPane
     */
    @FXML
    private void Enter_AnchorPane(MouseEvent event) {
        BoxBlur boxBlur = new BoxBlur();//BoxBlur class is used to Blur image
        Image_Background.setEffect(boxBlur);//set blur effect to background image
    }

    /**
     * Blur Effect Exiting the AnchorPane
     * @param event MouseEvent of AnchorPane
     */
    @FXML
    private void Exit_AnchorPane(MouseEvent event) {
        //BoxBlur boxBlur = new BoxBlur();
        Image_Background.setEffect(null);
    }

    /**
     * Go to Admin Page
     * @param event MouseEvent of Identify_Admin
     */
    @FXML
    private void Identify_Admin(MouseEvent event) {
        application.gotoadmin();//go to Main Page
    }


}
