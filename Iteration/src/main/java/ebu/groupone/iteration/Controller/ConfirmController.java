package ebu.groupone.iteration.Controller;

import ebu.groupone.iteration.Control.BookingDataControl;
import ebu.groupone.iteration.Control.Validation;
import ebu.groupone.iteration.Main;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Class of Controller to JavaFx FXML Confirm Page
 * @author  ebu6304.groupone
 * @version 5.0 2022/5/29 14:19
 */
public class ConfirmController implements Initializable {
    /**
     * Parameter application
     */
    private Main application;
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
     * JavaFx Parameter BookingNumber
     */
    @FXML
    private Label BookingNumber;
    /**
     * JavaFx Parameter BookingNumber_split
     */
    @FXML
    private Label BookingNumber_split;
    /**
     * JavaFx Parameter CB_Confirm
     */
    @FXML
    private CheckBox CB_Confirm;
    /**
     * JavaFx Parameter Cabin
     */
    @FXML
    private Label Cabin;
    /**
     * JavaFx Parameter Cabin_split
     */
    @FXML
    private Label Cabin_split;
    /**
     * JavaFx Parameter CheckInTime
     */
    @FXML
    private Label CheckInTime;
    /**
     * JavaFx Parameter DepartureTime
     */
    @FXML
    private Label DepartureTime;
    /**
     * JavaFx Parameter DepartureTime_split
     */
    @FXML
    private Label DepartureTime_split;
    /**
     * JavaFx Parameter Destination
     */
    @FXML
    private Label Destination;
    /**
     * JavaFx Parameter Flight
     */
    @FXML
    private Label Flight;
    /**
     * JavaFx Parameter Gate
     */
    @FXML
    private Label Gate;
    /**
     * JavaFx Parameter Gate_split
     */
    @FXML
    private Label Gate_split;
    /**
     * JavaFx Parameter IDNumber
     */
    @FXML
    private Label IDNumber;
    /**
     * JavaFx Parameter Seat
     */
    @FXML
    private Label Seat;
    /**
     * JavaFx Parameter Seat_split
     */
    @FXML
    private Label Seat_split;
    /**
     * JavaFx Parameter Surname
     */
    @FXML
    private Label Surname;
    /**
     * JavaFx Parameter Payment
     */
    @FXML
    private AnchorPane Payment;
    /**
     * JavaFx Parameter CreditCard
     */
    @FXML
    private TextField CreditCard;
    /**
     * JavaFx Parameter Continue
     */
    @FXML
    private Button Continue;
    /**
     * JavaFx Parameter Label_Seat
     */
    @FXML
    private Label Label_Seat;
    /**
     * JavaFx Parameter Label_Meal
     */
    @FXML
    private Label Label_Meal;
    /**
     * JavaFx Parameter Fee_Seat
     */
    @FXML
    private Label Fee_Seat;
    /**
     * JavaFx Parameter Fee_Meal
     */
    @FXML
    private Label Fee_Meal;
    /**
     * JavaFx Parameter Keyboard
     */
    @FXML
    private BorderPane Keyboard;
    /**
     * JavaFx Parameter KB
     */
    @FXML
    private ImageView KB;
    /**
     * Parameter HasClicked
     */
    private boolean HasClicked = false;

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
        application.gotomealdrink();
    }

    /**
     * Go to Next Page
     * @param event JavaFx ActionEvent of Button Next
     */
    @FXML
    private void Next(ActionEvent event) {
        if (CB_Confirm.isSelected()) {
            Keyboard.setVisible(false);
            application.gotoprint();
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
        if (Additional_payment()) {
            Payment.setVisible(true);
        } else {
            Payment.setVisible(false);
        }
        LoadInformation();
        showTime();
        Keyboard.setVisible(false);
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
        if (CB_Confirm.isSelected()) {
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
        if (CB_Confirm.isSelected()) {
            Button_Next.setText("Next");
        } else {
            Button_Next.setText("Please Confirm it");
        }
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
     * Load the retrieve information from IO methods at once
     */
    private void LoadInformation() {
        BookingDataControl bookingDataControl = new BookingDataControl();
        String Current_BookingNumber = IdentifyController.getCurrent_User_BookingNumber();
        BookingNumber.setText(Current_BookingNumber);
        BookingNumber_split.setText(Current_BookingNumber);
        Flight.setText(bookingDataControl._GetFlightNumber(Current_BookingNumber));
        IDNumber.setText(bookingDataControl._GetIDNumber(Current_BookingNumber));
        Surname.setText(bookingDataControl._GetSurName(Current_BookingNumber));
        DepartureTime.setText(bookingDataControl._GetDepartureTime(Current_BookingNumber));
        DepartureTime_split.setText(bookingDataControl._GetDepartureTime(Current_BookingNumber));
        CheckInTime.setText(bookingDataControl._GetBookingTime(Current_BookingNumber));
        Destination.setText(bookingDataControl._GetLocation(Current_BookingNumber));
        Gate.setText(bookingDataControl._GetGate(Current_BookingNumber));
        Gate_split.setText(bookingDataControl._GetGate(Current_BookingNumber));
        Cabin.setText(bookingDataControl._GetSeatClass(Current_BookingNumber));
        Cabin_split.setText(bookingDataControl._GetSeatClass(Current_BookingNumber));
        Seat.setText(bookingDataControl._GetLocate(Current_BookingNumber));
        Seat_split.setText(bookingDataControl._GetLocate(Current_BookingNumber));
    }

    /**
     * Control and change the display of Additional Payment
     * @param event MouseEvent of Validate and continue
     */
    @FXML
    private void Clicked_Continue(MouseEvent event) {
        if (Validation()) {
            Payment.setVisible(false);
            Keyboard.setVisible(false);
        }
    }

    /**
     * Validation of Credit Card Input Information
     * @return boolean
     */
    private boolean Validation() {
        Validation validation = new Validation();
        if (!CreditCard.getText().isEmpty()) {
            if (validation.validateCreditCard_Characters(CreditCard.getText())) {
                if (validation.validateCreditCard_Length(CreditCard.getText())) {
                    return true;
                } else {
                    Alert("CreditCard length should be within 13~19");
                    return false;
                }
            } else {
                Alert("CreditCard should be all numbers");
                return false;
            }
        } else {
            Alert("Please insert your credit card to continue the check-in");
            return false;
        }
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
     * Additional_payment control and display
     * @return boolean
     */
    private boolean Additional_payment() {
        boolean Seat_Additional = false;
        boolean Meal_Additional = false;
        BookingDataControl bookingDataControl = new BookingDataControl();
        String Seat = bookingDataControl._GetSeatClass(IdentifyController.getCurrent_User_BookingNumber());
        String Meal = bookingDataControl._GetMeal(IdentifyController.getCurrent_User_BookingNumber());
        Label_Seat.setText(Seat);
        Label_Meal.setText(Meal);

        String[] split = Meal.split("-");

        switch (Seat) {
            case "First-Class-Windows-Seat":
            case "First-Class-Middle-Seat":
            case "First-Class-Asile-Seat":
                Fee_Seat.setText("Pounds " + " 200");
                Seat_Additional = true;
                break;
            case "Business-Windows-Seat":
            case "Business-Middle-Seat":
            case "Business-Asile-Seat":
                Fee_Seat.setText("Pounds " + " 100");
                Seat_Additional = true;
                break;
            default:
                Fee_Seat.setText("Pounds " + " 0");
                Seat_Additional = false;
                break;
        }

        int Meal_Drink = 0;
        switch (split[0]) {
            case "Rice":
                Meal_Drink += 5;
                Meal_Additional = true;
                break;
            case "Noodle":
                Meal_Drink += 5;
                Meal_Additional = true;
                break;
            case "Sushi":
                Meal_Drink += 10;
                Meal_Additional = true;
                break;
            case "Roll":
                Meal_Drink += 10;
                Meal_Additional = true;
                break;
            case "Reserved":
                Meal_Drink += 0;
                Meal_Additional = false;
                break;
            case "Hamburger":
                Meal_Drink += 15;
                Meal_Additional = true;
                break;
            default:
                Meal_Drink += 0;
                Meal_Additional = false;
        }

        switch (split[1]) {
            case "Pork":
                Meal_Drink += 5;
                Meal_Additional = true;
                break;
            case "Beef":
                Meal_Drink += 8;
                Meal_Additional = true;
                break;
            case "Chicken":
                Meal_Drink += 3;
                Meal_Additional = true;
                break;
            case "Fish":
                Meal_Drink += 10;
                Meal_Additional = true;
                break;
            case "Reserved_Dishes":
                Meal_Drink += 0;
                Meal_Additional = false;
                break;
            default:
                Meal_Drink += 0;
                Meal_Additional = false;
        }

        switch (split[2]) {
            case "Water":
                Meal_Drink += 0;
                Meal_Additional = false;
                break;
            case "Juice":
                Meal_Drink += 5;
                Meal_Additional = true;
                break;
            case "Coffee":
                Meal_Drink += 10;
                Meal_Additional = true;
                break;
            case "Tea":
                Meal_Drink += 5;
                Meal_Additional = true;
                break;
            case "Coke":
                Meal_Drink += 3;
                Meal_Additional = true;
                break;
            case "Reserved_Drinks":
                Meal_Drink += 0;
                Meal_Additional = false;
                break;
            default:
                Meal_Drink += 0;
                Meal_Additional = false;
        }
        Fee_Meal.setText("Pounds " + Integer.toString(Meal_Drink));
        if (Seat_Additional || Meal_Additional)
            return true;
        else
            return false;

    }

    /**
     * Display Keyboard and enable double click to alter status
     * @param event MouseEvent of Button Keyboard
     */
    @FXML
    private void ShowKB(MouseEvent event) {
        if (!HasClicked) {
            Keyboard.setVisible(true);
            LowerCase(CreditCard);
            HasClicked = true;
        } else {
            Keyboard.setVisible(false);
            HasClicked = false;
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

}