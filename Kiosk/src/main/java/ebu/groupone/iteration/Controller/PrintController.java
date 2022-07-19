package ebu.groupone.iteration.Controller;

import ebu.groupone.iteration.Control.BookingDataControl;
import ebu.groupone.iteration.Main;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Class of Controller to JavaFx FXML Print Page
 * @author  ebu6304.groupone
 * @version 5.0 2022/5/29 15:01
 */ 
public class PrintController implements Initializable {
    /**
     * Parameter application
     */
    private Main application;
    /**
     * Parameter finished
     */
    private boolean finished = false;
    /**
     * JavaFx Parameter Button_Time
     */
    @FXML
    private Button Button_Time;
    /**
     * JavaFx Parameter Button_Next
     */
    @FXML
    private Button Button_Next;
    /**
     * JavaFx Parameter Button_Return
     */
    @FXML
    private Button Button_Return;
    /**
     * JavaFx Parameter Stage1
     */
    @FXML
    private AnchorPane Stage1;
    /**
     * JavaFx Parameter Stage2
     */
    @FXML
    private AnchorPane Stage2;
    /**
     * JavaFx Parameter Stage3
     */
    @FXML
    private AnchorPane Stage3;
    /**
     * JavaFx Parameter IMG_NEXT1
     */
    @FXML
    private ImageView IMG_NEXT1;
    /**
     * JavaFx Parameter IMG_NEXT2
     */
    @FXML
    private ImageView IMG_NEXT2;
    /**
     * JavaFx Parameter print_status
     */
    private boolean print_status = false;
    /**
     * JavaFx Parameter Script
     */
    @FXML
    private AnchorPane Script;
    /**
     * JavaFx Parameter Warning
     */
    @FXML
    private AnchorPane Warning;
    /**
     * JavaFx Parameter Confirm
     */
    @FXML
    private CheckBox Confirm;
    /**
     * JavaFx Parameter Confirmed
     */
    @FXML
    private Button Confirmed;
    /**
     * JavaFx Parameter Flight
     */
    @FXML
    private Label Flight;
    /**
     * JavaFx Parameter Passenger
     */
    @FXML
    private Label Passenger;
    /**
     * JavaFx Parameter Luggage_Code
     */
    @FXML
    private Label Luggage_Code;


    /**
     * Settling this very Page
     * @param application The Current running JavaFx Application
     */
    public void setApp(Main application) {
        this.application = application;
    }

    /**
     * Return to Previous Page
     * @param event JavaFx ActionEvent of Button Return
     */
    @FXML
    private void Return(ActionEvent event) {
        application.gotoconfirm();
    }

    /**
     * Finish the check-in process and go back to main
     * @param event ActionEvent of Button Finish
     */
    @FXML
    private void Finish(ActionEvent event) {
        if (finished) {
            BookingDataControl bookingDataControl = new BookingDataControl();
            bookingDataControl._SetStatus(IdentifyController.getCurrent_User_BookingNumber(), "Checked");
            application.gotomain();
        }
    }

    /**
     * The initialization of the current page, which will be run everytime this page is being accessed
     * @param url The location used to resolve relative paths for the root object, or
     *            {@code null} if the location is not known.
     * @param rb  The resources used to localize the root object, or {@code null} if
     *            the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Stage1.setVisible(true);
        Stage2.setVisible(false);
        Stage3.setVisible(false);
        Script.setVisible(false);
        Warning.setVisible(false);

        showTime();
    }

    /**
     * Time control and display of Timer Button
     */
    private void showTime() {
        EventHandler<ActionEvent> eventHandler = event -> {
            Date date = new Date();
            SimpleDateFormat Current_format = new SimpleDateFormat("HH:mm:ss");
            Button_Time.setText("UTC/GMT " + Current_format.format(new Date()));
        };
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), eventHandler));   //永久动画
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    /**
     * Effects of Entering Button Next
     * @param event MouseEvent of Button Next
     */
    @FXML
    private void Enter_Next(MouseEvent event) {
        if (print_status)
            Button_Next.setText("Finished");
        else
            Button_Next.setText("X");
    }

    /**
     * Effects of Exiting Button Next
     * @param event MouseEvent of Button Next
     */
    @FXML
    private void Exit_Next(MouseEvent event) {
        if (print_status)
            Button_Next.setText("Finish");
        else
            Button_Next.setText("Processing");
    }

    /**
     * Effects of Entering Button Return
     * @param event MouseEvent of Button Return
     */
    @FXML
    private void Enter_Return(MouseEvent event) {
        Button_Return.setText("<<<");
    }

    /**
     * Effects of Exiting Button Return
     * @param event MouseEvent of Button Return
     */
    @FXML
    private void Exit_Return(MouseEvent event) {
        Button_Return.setText("Return");
    }

    /**
     * Control and Display of Next Step - Stage 2
     * @param event MouseEvent of FC_NEXT1
     */
    @FXML
    private void FC_NEXT1(MouseEvent event) {
        Stage1.setVisible(false);
        Stage2.setVisible(false);
        Script.setVisible(false);
        Warning.setVisible(true);
        BookingDataControl bookingDataControl = new BookingDataControl();
        Flight.setText(bookingDataControl._GetFlightNumber(IdentifyController.getCurrent_User_BookingNumber()));
        Passenger.setText(bookingDataControl._GetSurName(IdentifyController.getCurrent_User_BookingNumber()));
        Luggage_Code.setText(bookingDataControl._GetBelongings(IdentifyController.getCurrent_User_BookingNumber()));
    }

    /**
     * Control and Display of Next Step - Stage 3
     * @param event MouseEvent of FC_NEXT2
     */
    @FXML
    private void FC_NEXT2(MouseEvent event) {
        Stage2.setVisible(false);
        Stage3.setVisible(true);
        Script.setVisible(false);
        print_status = true;
        finished = true;
    }

    /**
     * Control and Display of Next Step - Warning acknowledgement
     * @param event MouseEvent of Confirmed_Next
     */
    @FXML
    private void Confirmed_Next(MouseEvent event) {
        if (Confirm.isSelected()) {
            Warning.setVisible(false);
            Stage2.setVisible(true);
            Script.setVisible(true);
        } else {
            Alert();
        }
    }

    /**
     * Alert Box Display and Requires further confirmation to proceed
     */
    private void Alert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Warning");
        alert.setContentText("Invalid Action");
        alert.setHeaderText("Please read and confirm the notice to proceed.");
        alert.showAndWait();
    }

}