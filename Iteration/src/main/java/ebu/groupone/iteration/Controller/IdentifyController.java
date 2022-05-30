package ebu.groupone.iteration.Controller;

import ebu.groupone.iteration.Control.BookingDataControl;
import ebu.groupone.iteration.Control.Validation;
import ebu.groupone.iteration.Main;
import ebu.groupone.iteration.Model.Flight;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Class of Controller to JavaFx FXML Identify Page
 * @author  ebu6304.groupone 
 * @version 5.0 2022/5/29 14:22
 */ 
public class IdentifyController implements Initializable {
    /**
     * Parameter Current_User_BookingNumber
     */
    private static String Current_User_BookingNumber = null;
    /**
     * Parameter Current_User_Surname
     */
    private static String Current_User_Surname = null;
    /**
     * Parameter Current_User_IDNumber
     */
    private static String Current_User_IDNumber = null;
    /**
     * Parameter application
     */
    private Main application;
    /**
     * Parameter Verification_Status
     */
    private boolean Verification_Status = false;
    /**
     * Parameter ID_visable
     */
    private boolean ID_visable = false;
    /**
     * Parameter Manual_visable
     */
    private boolean Manual_visable = false;
    /**
     * Parameter Flight_visable
     */
    private boolean Flight_visable = false;
    /**
     * Parameter Scan_visable
     */
    private boolean Scan_visable = false;
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
     * JavaFx Parameter FullName
     */
    @FXML
    private TextField FullName;
    /**
     * JavaFx Parameter FlightInfo
     */
    @FXML
    private TextField FlightInfo;
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
     * JavaFx Parameter Button_Time
     */
    @FXML
    private Button Button_Time;
    /**
     * JavaFx Parameter Button_Verify
     */
    @FXML
    private Button Button_Verify;
    /**
     * JavaFx Parameter Button_Search
     */
    @FXML
    private Button Button_Search;
    /**
     * JavaFx Parameter Label_FN
     */
    @FXML
    private Label Label_FN;
    /**
     * JavaFx Parameter Label_IN
     */
    @FXML
    private Label Label_IN;
    /**
     * JavaFx Parameter Label_FLN
     */
    @FXML
    private Label Label_FLN;
    /**
     * JavaFx Parameter Label_Notice
     */
    @FXML
    private Label Label_Notice;
    /**
     * JavaFx Parameter Label_Help
     */
    @FXML
    private Label Label_Help;
    /**
     * JavaFx Parameter ID_AnchorPane
     */
    @FXML
    private AnchorPane ID_AnchorPane;
    /**
     * JavaFx Parameter Manual_AnchorPane
     */
    @FXML
    private AnchorPane Manual_AnchorPane;
    /**
     * JavaFx Parameter Flight_AnchorPane
     */
    @FXML
    private AnchorPane Flight_AnchorPane;
    /**
     * JavaFx Parameter Scan_AnchorPane
     */
    @FXML
    private AnchorPane Scan_AnchorPane;
    /**
     * JavaFx Parameter ID_Extended
     */
    @FXML
    private AnchorPane ID_Extended;
    /**
     * JavaFx Parameter Manual_Extended
     */
    @FXML
    private AnchorPane Manual_Extended;
    /**
     * JavaFx Parameter Flight_Extended
     */
    @FXML
    private AnchorPane Flight_Extended;
    /**
     * JavaFx Parameter Scan_Extended
     */
    @FXML
    private AnchorPane Scan_Extended;
    /**
     * JavaFx Parameter Help_icon
     */
    @FXML
    private ImageView Help_icon;
    /**
     * Parameter validation
     */
    private Validation validation = new Validation();
    /**
     * JavaFx Parameter Border_Flight
     */
    @FXML
    private BorderPane Border_Flight;
    /**
     * JavaFx Parameter Functions
     */
    @FXML
    private AnchorPane Functions;
    /**
     * JavaFx Parameter Keyboard
     */
    @FXML
    private BorderPane Keyboard;
    /**
     * Parameter BNK_Clicked
     */
    private boolean BNK_Clicked = false;
    /**
     * Parameter IDK_Clicked
     */
    private boolean IDK_Clicked = false;
    /**
     * Parameter SNK_Clicked
     */
    private boolean SNK_Clicked = false;

    /**
     * Obtain user's input and set the Booking Number global for further usage
     * @return String
     */
    public static String getCurrent_User_BookingNumber() {
        return Current_User_BookingNumber;
    }

    /**
     * Set the Global Booking Number Param
     * @param current_User_BookingNumber Input Parameter BookingNumber
     */
    public static void setCurrent_User_BookingNumber(String current_User_BookingNumber) {
        Current_User_BookingNumber = current_User_BookingNumber;
    }

    /**
     * Obtain user's input and set the Surname global for further usage
     * @return String
     */
    public static String getCurrent_User_Surname() {
        return Current_User_Surname;
    }

    /**
     * Set the Global Surname Param
     * @param current_User_Surname Input Parameter Surname
     */
    public static void setCurrent_User_Surname(String current_User_Surname) {
        Current_User_Surname = current_User_Surname;
    }

    /**
     * Obtain user's input and set the ID Number global for further usage
     * @return String
     */
    public static String getCurrent_User_IDNumber() {
        return Current_User_IDNumber;
    }

    /**
     * Set the Global ID Number Param
     * @param current_User_IDNumber Input Parameter IDNumber
     */
    public static void setCurrent_User_IDNumber(String current_User_IDNumber) {
        Current_User_IDNumber = current_User_IDNumber;
    }

    /**
     * Settling this very Page
     * @param application The Current running JavaFx Application
     */
    @FXML
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
     * Go to Next Page
     * @param event JavaFx ActionEvent of Button Next
     */
    @FXML
    private void Next(ActionEvent event) {
        if (Verification_Status) {
            setCurrent_User_IDNumber(IDNumber.getText());
            setCurrent_User_BookingNumber(FlightNumber.getText());
            setCurrent_User_Surname(FullName.getText());
            application.gotoseat();
        } else {
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
        ID_Extended.setVisible(false);
        Manual_Extended.setVisible(false);
        Flight_Extended.setVisible(false);
        Scan_Extended.setVisible(false);
        Keyboard.setVisible(false);
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

            if (Verification_Status) {
                Functions.setVisible(false);
            } else {
                Functions.setVisible(true);
            }
        };
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), eventHandler));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    /**
     * Button Display Control of Next of Entering
     * @param event MouseEvent 0f Next
     */
    @FXML
    private void Enter_Next(MouseEvent event) {
        if (Verification_Status) {
            Button_Next.setText(">>>");
        } else {
            Button_Next.setText("X");
        }
    }

    /**
     * Button Display Control of Next of Exiting
     * @param event MouseEvent 0f Next
     */
    @FXML
    private void Exit_Next(MouseEvent event) {
        if (Verification_Status) {
            Button_Next.setText("Next");
        } else {
            Button_Next.setText("Not Verified");
        }
    }

    /**
     * Button Display Control of Return of Entering
     * @param event MouseEvent 0f Return
     */
    @FXML
    private void Enter_Return(MouseEvent event) {
        Button_Return.setText("<<<");
    }

    /**
     * Button Display Control of Return of Exiting
     * @param event MouseEvent 0f Return
     */
    @FXML
    private void Exit_Return(MouseEvent event) {
        Button_Return.setText("Return");
    }

    /**
     * Control and Display of ID_Extension AnchorPane
     * @param event MouseEvent of ID_Extension
     */
    @FXML
    private void ID_Extension(MouseEvent event) {
        if (ID_visable) {
            ID_Extended.setVisible(false);
            Label_Help.setVisible(true);
            Label_Notice.setVisible(true);
            Help_icon.setVisible(true);
            ID_visable = false;
        } else {
            ID_Extended.setVisible(true);
            Flight_Extended.setVisible(false);
            Manual_Extended.setVisible(false);
            Scan_Extended.setVisible(false);
            Label_Help.setVisible(false);
            Label_Notice.setVisible(false);
            Help_icon.setVisible(false);
            ID_visable = true;
        }
    }

    /**
     * Control and Display of Manual_Extension AnchorPane
     * @param event MouseEvent of Manual_Extension
     */
    @FXML
    private void Manual_Extension(MouseEvent event) {
        if (Manual_visable) {
            Manual_Extended.setVisible(false);
            Label_Help.setVisible(true);
            Label_Notice.setVisible(true);
            Help_icon.setVisible(true);
            FlightNumber.setText("");
            IDNumber.setText("");
            FullName.setText("");
            Manual_visable = false;
        } else {
            Manual_Extended.setVisible(true);
            Flight_Extended.setVisible(false);
            Scan_Extended.setVisible(false);
            ID_Extended.setVisible(false);
            Label_Help.setVisible(false);
            Label_Notice.setVisible(false);
            Help_icon.setVisible(false);
            Manual_visable = true;
        }
    }

    /**
     * Control and Display of Flight_Extension AnchorPane
     * @param event MouseEvent of Flight_Extension
     */
    @FXML
    private void Flight_Extension(MouseEvent event) {
        if (Flight_visable) {
            Flight_Extended.setVisible(false);
            Label_Help.setVisible(true);
            Label_Notice.setVisible(true);
            Help_icon.setVisible(true);
            FlightInfo.setText("");
            Flight_visable = false;
        } else {
            Flight_Extended.setVisible(true);
            Manual_Extended.setVisible(false);
            Scan_Extended.setVisible(false);
            ID_Extended.setVisible(false);
            Label_Help.setVisible(false);
            Label_Notice.setVisible(false);
            Help_icon.setVisible(false);
            Flight_visable = true;
        }
    }

    /**
     * Control and Display of Scan_Extension AnchorPane
     * @param event MouseEvent of Scan_Extension
     */
    @FXML
    private void Scan_Extension(MouseEvent event) {
        if (Scan_visable) {
            Scan_Extended.setVisible(false);
            Label_Help.setVisible(true);
            Label_Notice.setVisible(true);
            Help_icon.setVisible(true);
            Scan_visable = false;
        } else {
            Scan_Extended.setVisible(true);
            Flight_Extended.setVisible(false);
            Manual_Extended.setVisible(false);
            ID_Extended.setVisible(false);
            Label_Help.setVisible(false);
            Label_Notice.setVisible(false);
            Help_icon.setVisible(false);
            Scan_visable = true;
        }
    }

    /**
     * Go to Help Page
     * @param event MouseEvent of Help_Extended
     */
    @FXML
    public void Help_Extended(MouseEvent event) {
        application.gotohelp();
    }

    /**
     * Alert Box Display and Requires further confirmation to proceed
     * @param Warning Warning Message
     */
    private void Alert(String Warning) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Warning");
        alert.setContentText("Invalid Input");
        alert.setHeaderText(Warning);
        alert.showAndWait();
    }

    /**
     * Verify the inserted information with robust tolerance
     * @param event MouseEvent of Verify
     */
    @FXML
    public void Verify(MouseEvent event) {
        if (FlightNumber.getText().isEmpty()) {
        } else {
            if (!validation.validateBookingNumber_Characters(FlightNumber.getText()))
                Alert("Booking Number: Inputs should be in full of numbers form");
            if (!validation.validateBookingNumber_Length(FlightNumber.getText()))
                Alert("Booking Number: Inputs range from 8-12");
        }

        if (IDNumber.getText().isEmpty()) {
        } else {
            if (!validation.validateIDNumber_Characters(IDNumber.getText()))
                Alert("IDNumber: Inputs should be in full of numbers form");
            if (!validation.validateIDNumber_Length(IDNumber.getText()))
                Alert("IDNumber: Inputs range from 7-9");
        }

        if (FullName.getText().isEmpty()) {
        } else {
            if (!validation.validateSurname_Characters(FullName.getText()))
                Alert("Surname: Inputs should be in full of characters(a-z/A-Z) form");
            if (!validation.validateSurname_Length(FullName.getText()))
                Alert("Surname: Inputs range from 1-30");
        }

        if (FlightNumber.getText().isEmpty() && IDNumber.getText().isEmpty() && FullName.getText().isEmpty())
            Alert("No any valid input is inserted");

        if (validation.IDNumberValidation(IDNumber.getText()))
            Label_IN.setText("1");
        else
            Label_IN.setText("0");
        if (validation.SurnameValidation(FullName.getText()))
            Label_FN.setText("1");
        else
            Label_FN.setText("0");
        if (validation.BookingNumberValidation(FlightNumber.getText()))
            Label_FLN.setText("1");
        else
            Label_FLN.setText("0");
        if (validation.IDNumberValidation(IDNumber.getText()) ||
                validation.SurnameValidation(FullName.getText()) ||
                validation.BookingNumberValidation(FlightNumber.getText())) {

            if (validation.CheckInValidationByIDNumber(IDNumber.getText()) ||
                    validation.CheckInValidationByBookingNumber(FlightNumber.getText()) ||
                    validation.CheckInValidationBySurname(FullName.getText())) {
                Alert("You have already checked-in.");
            } else {
                Verification_Status = true;
                EventHandler<ActionEvent> eventHandler_success = event_success -> {
                    Button_Verify.setText("Success !");
                    Button_Next.setVisible(false);
                };
                EventHandler<ActionEvent> eventHandler_success_change = event_success_change -> {
                    Button_Verify.setText("Verify");
                    Button_Next.setVisible(true);
                    Button_Next.setText("Next");
                };
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), eventHandler_success),
                        new KeyFrame(Duration.millis(1000), eventHandler_success_change));
                timeline.play();
            }
        } else {
            EventHandler<ActionEvent> eventHandler = event_fail -> {
                Button_Verify.setText("Failed !");
                Button_Next.setVisible(false);
            };
            EventHandler<ActionEvent> eventHandler_fail_change = event_fail_change -> {
                Button_Verify.setText("Verify");
                Button_Next.setVisible(true);
            };
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), eventHandler),
                    new KeyFrame(Duration.millis(2000), eventHandler_fail_change));
            timeline.play();
        }
        EventHandler<ActionEvent> eventHandler = event_success_change -> {
            Label_FLN.setText("");
            Label_FN.setText("");
            Label_IN.setText("");
        };
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(2000), eventHandler));
        timeline.play();
    }

    /**
     * Validate Search Info and Display results in TableView
     * @param event MouseEvent of Search
     */
    @FXML
    public void Search(MouseEvent event) {
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

//        TableColumn<Flight, String> column7 = new TableColumn<>("PassengerList");
//        column7.setCellValueFactory(new PropertyValueFactory<>("PassengerList"));

        tableView2.getColumns().add(column1);
        tableView2.getColumns().add(column2);
        tableView2.getColumns().add(column3);
        tableView2.getColumns().add(column4);
        tableView2.getColumns().add(column5);
        tableView2.getColumns().add(column6);
//        tableView2.getColumns().add(column7);

        BookingDataControl bookingDataControl = new BookingDataControl();
        ArrayList<String> FlightList = bookingDataControl.getFlightList();

        for (int i = 0; i < FlightList.size(); i++) {
            Flight flight = new Flight();
            flight.intialize(FlightList.get(i));
            if (flight.getFlightNumber().equals(FlightInfo.getText()))
                tableView2.getItems().add(flight);
        }

        Border_Flight.setCenter(tableView2);
    }

    /**
     * Control and Display of KeyBoard for Input_FlightNumber
     * @param event MouseEvent of Input_FlightNumber
     */
    @FXML
    public void Input_FlightNumber(MouseEvent event) {
        if (!BNK_Clicked) {
            Keyboard.setVisible(true);
            LowerCase(FlightNumber);
            BNK_Clicked = true;
        } else {
            Keyboard.setVisible(false);
            BNK_Clicked = false;
        }
    }

    /**
     * Keyboard Change to UpperCase Mode
     * @param textfield The textfield to insert information
     */
    private void UpperCase(TextField textfield) {
        VBox vBox = new VBox(5);
        HBox hBox1 = new HBox(5);
        HBox hBox2 = new HBox(5);
        HBox hBox3 = new HBox(5);
        HBox hBox4 = new HBox(5);

        Button blankspace1 = new Button(" ");
        blankspace1.setVisible(false);
        hBox1.getChildren().add(blankspace1);

        String[] H1 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "BackSpace"};
        for (int i = 0; i < 10; i++) {
            String text = H1[i];
            Button button_H1 = new Button(text);
            button_H1.setOnAction(actionEvent -> {
                textfield.setText(textfield.getText() + text);
            });
            hBox1.getChildren().add(button_H1);
        }
        Button button_H1_BlankSpace = new Button(H1[10]);
        button_H1_BlankSpace.setOnAction(actionEvent -> {
            String Current = textfield.getText();
            if (Current.isEmpty()) {
                textfield.setText("");
            } else {
                textfield.setText(Current.substring(0, Current.length() - 1));
            }
        });
        hBox1.getChildren().add(button_H1_BlankSpace);

        Button blankspace2 = new Button(" ");
        blankspace2.setVisible(false);
        hBox2.getChildren().add(blankspace2);

        String[] H2 = {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P"};
        for (int i = 0; i < 10; i++) {
            String text = H2[i];
            Button button_H2 = new Button(text);
            button_H2.setOnAction(actionEvent -> {
                textfield.setText(textfield.getText() + text);
            });
            hBox2.getChildren().add(button_H2);
        }

        String[] H3 = {"Caps", "A", "S", "D", "F", "G", "H", "J", "K", "L"};

        Button button_H3_Caps = new Button(H3[0]);
        button_H3_Caps.setOnAction(actionEvent -> {
            LowerCase(textfield);
        });
        hBox3.getChildren().add(button_H3_Caps);

        for (int i = 1; i < 10; i++) {
            String text = H3[i];
            Button button_H3 = new Button(text);
            button_H3.setOnAction(actionEvent -> {
                textfield.setText(textfield.getText() + text);
            });
            hBox3.getChildren().add(button_H3);
        }

        Button blankspace4 = new Button("              ");
        blankspace4.setVisible(false);
        hBox4.getChildren().add(blankspace4);

        String[] H4 = {"Z", "X", "C", "V", "B", "N", "M"};
        for (int i = 0; i < 7; i++) {
            String text = H4[i];
            Button button_H4 = new Button(text);
            button_H4.setOnAction(actionEvent -> {
                textfield.setText(textfield.getText() + text);
            });
            hBox4.getChildren().add(button_H4);
        }

        vBox.getChildren().add(hBox1);
        vBox.getChildren().add(hBox2);
        vBox.getChildren().add(hBox3);
        vBox.getChildren().add(hBox4);

        Keyboard.setCenter(vBox);
    }

    /**
     * Keyboard Change to LowerCase Mode
     * @param textfield The textfield to insert information
     */
    private void LowerCase(TextField textfield) {
        VBox vBox = new VBox(5);
        HBox hBox1 = new HBox(5);
        HBox hBox2 = new HBox(5);
        HBox hBox3 = new HBox(5);
        HBox hBox4 = new HBox(5);

        Button blankspace1 = new Button(" ");
        blankspace1.setVisible(false);
        hBox1.getChildren().add(blankspace1);

        String[] H1 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "BackSpace"};
        for (int i = 0; i < 10; i++) {
            String text = H1[i];
            Button button_H1 = new Button(text);
            button_H1.setOnAction(actionEvent -> {
                textfield.setText(textfield.getText() + text);
            });
            hBox1.getChildren().add(button_H1);
        }
        Button button_H1_BlankSpace = new Button(H1[10]);
        button_H1_BlankSpace.setOnAction(actionEvent -> {
            String Current = textfield.getText();
            if (Current.isEmpty()) {
                textfield.setText("");
            } else {
                textfield.setText(Current.substring(0, Current.length() - 1));
            }
        });
        hBox1.getChildren().add(button_H1_BlankSpace);

        Button blankspace2 = new Button(" ");
        blankspace2.setVisible(false);
        hBox2.getChildren().add(blankspace2);

        String[] H2 = {"q", "w", "e", "r", "t", "y", "u", "i", "o", "p"};
        for (int i = 0; i < 10; i++) {
            String text = H2[i];
            Button button_H2 = new Button(text);
            button_H2.setOnAction(actionEvent -> {
                textfield.setText(textfield.getText() + text);
            });
            hBox2.getChildren().add(button_H2);
        }

        String[] H3 = {"Caps", "a", "s", "d", "f", "g", "h", "j", "k", "l"};

        Button button_H3_Caps = new Button(H3[0]);
        button_H3_Caps.setOnAction(actionEvent -> {
            UpperCase(textfield);
        });
        hBox3.getChildren().add(button_H3_Caps);

        for (int i = 1; i < 10; i++) {
            String text = H3[i];
            Button button_H3 = new Button(text);
            button_H3.setOnAction(actionEvent -> {
                textfield.setText(textfield.getText() + text);
            });
            hBox3.getChildren().add(button_H3);
        }

        Button blankspace4 = new Button("              ");
        blankspace4.setVisible(false);
        hBox4.getChildren().add(blankspace4);

        String[] H4 = {"z", "x", "c", "v", "b", "n", "m"};
        for (int i = 0; i < 7; i++) {
            String text = H4[i];
            Button button_H4 = new Button(text);
            button_H4.setOnAction(actionEvent -> {
                textfield.setText(textfield.getText() + text);
            });
            hBox4.getChildren().add(button_H4);
        }

        vBox.getChildren().add(hBox1);
        vBox.getChildren().add(hBox2);
        vBox.getChildren().add(hBox3);
        vBox.getChildren().add(hBox4);

        Keyboard.setCenter(vBox);
    }

    /**
     * Control and Display of KeyBoard for Input_IDNumber
     * @param event MouseEvent of Input_IDNumber
     */
    @FXML
    public void Input_IDNumber(MouseEvent event) {
        if (!IDK_Clicked) {
            Keyboard.setVisible(true);
            LowerCase(IDNumber);
            IDK_Clicked = true;
        } else {
            Keyboard.setVisible(false);
            IDK_Clicked = false;
        }
    }

    /**
     * Control and Display of KeyBoard for Input_FullName
     * @param event MouseEvent of Input_FullName
     */
    @FXML
    public void Input_FullName(MouseEvent event) {
        if (!SNK_Clicked) {
            Keyboard.setVisible(true);
            LowerCase(FullName);
            SNK_Clicked = true;
        } else {
            Keyboard.setVisible(false);
            SNK_Clicked = false;
        }
    }


}
