package ebu.groupone.iteration.Controller;

import ebu.groupone.iteration.BackEnd.BookingIO;
import ebu.groupone.iteration.Control.BookingDataControl;
import ebu.groupone.iteration.Main;
import ebu.groupone.iteration.Model.Booking;
import ebu.groupone.iteration.Model.Flight;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Class of Controller to JavaFx FXML Admin Page
 * @author  ebu6304.groupone
 * @version 5.0 2022/5/29 14:19
 */
public class AdminController implements Initializable {
    /**
     * Parameter counter for progress control
     */
    public int counter = 0;
    /**
     * Parameter Total for progress control
     */
    public int Total = 0;
    /**
     * Parameter application of Javafx Application from Main
     */
    private Main application;
    /**
     * JavaFx Parameter Button_Time for Time Display
     */
    @FXML
    private Button Button_Time;
    /**
     * JavaFx Parameter Button_Return
     */
    @FXML
    private Button Button_Return;
    /**
     * JavaFx Parameter Passenger
     */
    @FXML
    private Button Passenger;
    /**
     * JavaFx Parameter Flight
     */
    @FXML
    private Button Flight;
    /**
     * JavaFx Parameter Identify
     */
    @FXML
    private AnchorPane Identify;
    /**
     * JavaFx Parameter Function
     */
    @FXML
    private AnchorPane Function;
    /**
     * JavaFx Parameter Account
     */
    @FXML
    private TextField Account;
    /**
     * JavaFx Parameter Password
     */
    @FXML
    private TextField Password;
    /**
     * JavaFx Parameter BookingNumber
     */
    @FXML
    private TextField BookingNumber;
    /**
     * JavaFx Parameter FlightNumber
     */
    @FXML
    private TextField FlightNumber;
    /**
     * JavaFx Parameter IDNumber
     */
    @FXML
    private TextField IDNumber;
    /**
     * JavaFx Parameter Surname
     */
    @FXML
    private TextField Surname;
    /**
     * JavaFx Parameter Login
     */
    @FXML
    private Button Login;
    /**
     * JavaFx Parameter Search
     */
    @FXML
    private Button Search;
    /**
     * JavaFx Parameter Border
     */
    @FXML
    private BorderPane Border;
    /**
     * JavaFx Parameter Percentage_Data
     */
    @FXML
    private Label Percentage_Data;
    /**
     * JavaFx Parameter Percentage
     */
    @FXML
    private Label Percentage;


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
        application.gotomain();
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
        Identify.setVisible(true);
        Function.setVisible(false);
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
            progress();
        };
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), eventHandler));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    /**
     * Button Display Control of Return of Entering
     * @param event MouseEvent 0f Next
     */
    @FXML
    private void Enter_Return(MouseEvent event) {
        Button_Return.setText("<<<");
    }

    /**
     * Button Display Control of Return of Exiting
     * @param event MouseEvent 0f Next
     */
    @FXML
    private void Exit_Return(MouseEvent event) {
        Button_Return.setText("Return");
    }

    /**
     * Admin validation login and control pane display
     * @param event MouseEvent 0f Admin_Check
     */
    @FXML
    private void Admin_Check(MouseEvent event) {
        if (validate()) {
            Identify.setVisible(false);
            Function.setVisible(true);
        }
    }

    /**
     * Display the searched result based on the input textfield
     * @param event MouseEvent 0f SearchInfo
     */
    @FXML
    private void SearchInfo(MouseEvent event) {
        TableView tableView3 = new TableView();

        TableColumn<Booking, String> column1 = new TableColumn<>("BookingNumber");
        column1.setCellValueFactory(new PropertyValueFactory<>("BookingNumber"));

        TableColumn<Booking, String> column2 = new TableColumn<>("Surname");
        column2.setCellValueFactory(new PropertyValueFactory<>("Surname"));

        TableColumn<Booking, String> column3 = new TableColumn<>("IDNumber");
        column3.setCellValueFactory(new PropertyValueFactory<>("IDNumber"));

        TableColumn<Booking, String> column4 = new TableColumn<>("BookingTime");
        column4.setCellValueFactory(new PropertyValueFactory<>("BookingTime"));

        TableColumn<Booking, String> column5 = new TableColumn<>("Cabin&Seat");
        column5.setCellValueFactory(new PropertyValueFactory<>("SeatClass"));

        TableColumn<Booking, String> column6 = new TableColumn<>("Meal&Drink");
        column6.setCellValueFactory(new PropertyValueFactory<>("Meal"));

        TableColumn<Booking, String> column7 = new TableColumn<>("FlightNumber");
        column7.setCellValueFactory(new PropertyValueFactory<>("FlightNumber"));

        TableColumn<Booking, String> column8 = new TableColumn<>("Gate");
        column8.setCellValueFactory(new PropertyValueFactory<>("Gate"));

        TableColumn<Booking, String> column9 = new TableColumn<>("DepartureTime");
        column9.setCellValueFactory(new PropertyValueFactory<>("DepartureTime"));

        TableColumn<Booking, String> column10 = new TableColumn<>("Departure");
        column10.setCellValueFactory(new PropertyValueFactory<>("Departure"));

        TableColumn<Booking, String> column11 = new TableColumn<>("Destination");
        column11.setCellValueFactory(new PropertyValueFactory<>("Location"));

        TableColumn<Booking, String> column12 = new TableColumn<>("Belongings");
        column12.setCellValueFactory(new PropertyValueFactory<>("Belongings"));

        TableColumn<Booking, String> column13 = new TableColumn<>("Status");
        column13.setCellValueFactory(new PropertyValueFactory<>("Status"));

        TableColumn<Booking, String> column14 = new TableColumn<>("Locate");
        column14.setCellValueFactory(new PropertyValueFactory<>("Locate"));

        tableView3.getColumns().add(column1);
        tableView3.getColumns().add(column2);
        tableView3.getColumns().add(column3);
        tableView3.getColumns().add(column4);
        tableView3.getColumns().add(column5);
        tableView3.getColumns().add(column6);
        tableView3.getColumns().add(column7);
        tableView3.getColumns().add(column8);
        tableView3.getColumns().add(column9);
        tableView3.getColumns().add(column10);
        tableView3.getColumns().add(column11);
        tableView3.getColumns().add(column12);
        tableView3.getColumns().add(column13);
        tableView3.getColumns().add(column14);

        BookingIO bookingIO = new BookingIO();
        ArrayList<Object> Data = bookingIO.ReadAll();

        counter = 1;//Step Over the first and second initialization account
        Total = Data.size();
        for (int i = 1; i < Data.size(); i++) {//Step Over the first and second initialization account
            Booking booking = (Booking) Data.get(i);
            boolean BookingNumber_selected = false;
            boolean FlightNumber_selected = false;
            boolean Surname_selected = false;
            boolean IDNumber_selected = false;
            BookingNumber_selected = BookingNumber.getText().isEmpty() || BookingNumber.getText().equals(booking.getBookingNumber());
            FlightNumber_selected = FlightNumber.getText().isEmpty() || FlightNumber.getText().equals(booking.getFlightNumber());
            Surname_selected = Surname.getText().isEmpty() || Surname.getText().equals(booking.getSurname());
            IDNumber_selected = IDNumber.getText().isEmpty() || IDNumber.getText().equals(booking.getIDNumber());

            if (BookingNumber_selected)
                if (FlightNumber_selected)
                    if (Surname_selected)
                        if (IDNumber_selected)
                            tableView3.getItems().add(booking);

            counter++;
        }
        Border.setCenter(tableView3);
    }

    /**
     * Validate the admin access authorization
     * @return boolean
     */
    private boolean validate() {
        if ((Account.getText().equals("")) && (Password.getText().equals(""))) {
            return true;
        } else {
            Alert();
            return false;
        }
    }


    /**
     * Alert Box Display and Requires further confirmation to proceed
     */
    private void Alert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Warning");
        alert.setContentText("Invalid Account and Password Combination");
        alert.setHeaderText("Please input valid information for access");
        alert.showAndWait();
    }

    /**
     * Display the flight information
     * @param event MouseEvent 0f SearchInfo
     */
    @FXML
    private void showFlight(MouseEvent event) {
        TableView tableView2 = new TableView();

        TableColumn<Flight, String> column1 = new TableColumn<>("FlightNumber");
        column1.setCellValueFactory(new PropertyValueFactory<>("FlightNumber"));

        TableColumn<Flight, String> column2 = new TableColumn<>("Airways");
        column2.setCellValueFactory(new PropertyValueFactory<>("Airways"));

        TableColumn<Flight, String> column3 = new TableColumn<>("Departure");
        column3.setCellValueFactory(new PropertyValueFactory<>("Departure"));

        TableColumn<Flight, String> column4 = new TableColumn<>("Destination");
        column4.setCellValueFactory(new PropertyValueFactory<>("Destination"));

        TableColumn<Flight, String> column5 = new TableColumn<>("Gate");
        column5.setCellValueFactory(new PropertyValueFactory<>("Gate"));

        TableColumn<Flight, String> column6 = new TableColumn<>("DepartureTime");
        column6.setCellValueFactory(new PropertyValueFactory<>("DepartureTime"));

        TableColumn<Flight, String> column7 = new TableColumn<>("PassengerList");
        column7.setCellValueFactory(new PropertyValueFactory<>("PassengerList"));

        TableColumn<Flight, String> column8 = new TableColumn<>("Percentage");
        column8.setCellValueFactory(new PropertyValueFactory<>("Percentage"));

        tableView2.getColumns().add(column1);
        tableView2.getColumns().add(column2);
        tableView2.getColumns().add(column3);
        tableView2.getColumns().add(column4);
        tableView2.getColumns().add(column5);
        tableView2.getColumns().add(column6);
        tableView2.getColumns().add(column7);
        tableView2.getColumns().add(column8);

        BookingDataControl bookingDataControl = new BookingDataControl();
        ArrayList<String> FlightList = bookingDataControl.getFlightList();

        counter = 0;
        Total = FlightList.size();

        for (int i = 0; i < FlightList.size(); i++) {
            //System.out.println(FlightList.get(i));
            Flight flight = new Flight();
            flight.intialize(FlightList.get(i));
            tableView2.getItems().add(flight);
            counter++;
        }

        Border.setCenter(tableView2);
    }

    /**
     * The progress display of searching and processing the data
     */
    public void progress() {
        Double progress = ((double) this.counter) / ((double) this.Total);
        DecimalFormat df = new DecimalFormat("0");
        String return_String = df.format(progress * 100) + "%";
        Percentage.setText(return_String);
        Percentage_Data.setText(this.counter + "/" + this.Total);
    }

    /**
     * Display the flight information
     * @param event MouseEvent 0f SearchInfo
     */
    @FXML
    private void showPassenger(MouseEvent event) {
        TableView tableView1 = new TableView();

        TableColumn<Booking, String> column1 = new TableColumn<>("BookingNumber");
        column1.setCellValueFactory(new PropertyValueFactory<>("BookingNumber"));

        TableColumn<Booking, String> column2 = new TableColumn<>("Surname");
        column2.setCellValueFactory(new PropertyValueFactory<>("Surname"));

        TableColumn<Booking, String> column3 = new TableColumn<>("IDNumber");
        column3.setCellValueFactory(new PropertyValueFactory<>("IDNumber"));

        TableColumn<Booking, String> column4 = new TableColumn<>("BookingTime");
        column4.setCellValueFactory(new PropertyValueFactory<>("BookingTime"));

        TableColumn<Booking, String> column5 = new TableColumn<>("Cabin&Seat");
        column5.setCellValueFactory(new PropertyValueFactory<>("SeatClass"));

        TableColumn<Booking, String> column6 = new TableColumn<>("Meal&Drink");
        column6.setCellValueFactory(new PropertyValueFactory<>("Meal"));

        TableColumn<Booking, String> column7 = new TableColumn<>("FlightNumber");
        column7.setCellValueFactory(new PropertyValueFactory<>("FlightNumber"));

        TableColumn<Booking, String> column8 = new TableColumn<>("Gate");
        column8.setCellValueFactory(new PropertyValueFactory<>("Gate"));

        TableColumn<Booking, String> column9 = new TableColumn<>("DepartureTime");
        column9.setCellValueFactory(new PropertyValueFactory<>("DepartureTime"));

        TableColumn<Booking, String> column10 = new TableColumn<>("Departure");
        column10.setCellValueFactory(new PropertyValueFactory<>("Departure"));

        TableColumn<Booking, String> column11 = new TableColumn<>("Destination");
        column11.setCellValueFactory(new PropertyValueFactory<>("Location"));

        TableColumn<Booking, String> column12 = new TableColumn<>("Belongings");
        column12.setCellValueFactory(new PropertyValueFactory<>("Belongings"));

        TableColumn<Booking, String> column13 = new TableColumn<>("Status");
        column13.setCellValueFactory(new PropertyValueFactory<>("Status"));

        TableColumn<Booking, String> column14 = new TableColumn<>("Locate");
        column14.setCellValueFactory(new PropertyValueFactory<>("Locate"));

        tableView1.getColumns().add(column1);
        tableView1.getColumns().add(column2);
        tableView1.getColumns().add(column3);
        tableView1.getColumns().add(column4);
        tableView1.getColumns().add(column5);
        tableView1.getColumns().add(column6);
        tableView1.getColumns().add(column7);
        tableView1.getColumns().add(column8);
        tableView1.getColumns().add(column9);
        tableView1.getColumns().add(column10);
        tableView1.getColumns().add(column11);
        tableView1.getColumns().add(column12);
        tableView1.getColumns().add(column13);
        tableView1.getColumns().add(column14);

        BookingIO bookingIO = new BookingIO();
        ArrayList<Object> Data = bookingIO.ReadAll();

        counter = 1;
        Total = Data.size();

        for (int i = 1; i < Data.size(); i++) {//Step Over the first and second initialization account
            Booking booking = (Booking) Data.get(i);
            tableView1.getItems().add(booking);
            counter++;
        }

        Border.setCenter(tableView1);
    }


}
