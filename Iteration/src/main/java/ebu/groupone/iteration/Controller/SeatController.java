package ebu.groupone.iteration.Controller;

import ebu.groupone.iteration.BackEnd.BookingIO;
import ebu.groupone.iteration.Control.BookingDataControl;
import ebu.groupone.iteration.Main;
import ebu.groupone.iteration.Model.Booking;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;

/**
 * Class of Controller to JavaFx FXML Seat Page
 * @author  ebu6304.groupone 
 * @version 5.0 2022/5/29 15:01
 */ 
public class SeatController implements Initializable {
    /**
     * Parameter Cabin
     */
    public String Cabin = "";
    /**
     * Parameter Seat
     */
    public String Seat = "";
    /**
     * Parameter Seat_X_MIN
     */
    public int Seat_X_MIN = 0;
    /**
     * Parameter Seat_X_MAX
     */
    public int Seat_X_MAX = 0;
    /**
     * Parameter Seat_Y_MIN
     */
    public int Seat_Y_MIN = 1;
    /**
     * Parameter Seat_Y_MAX
     */
    public int Seat_Y_MAX = 0;
    /**
     * Parameter FC_X_MIN
     */
    public int FC_X_MIN = 1;
    /**
     * Parameter FC_X_MAX
     */
    public int FC_X_MAX = 4;
    /**
     * Parameter FC_Y
     */
    public int FC_Y = 4;
    /**
     * Parameter BS_X_MIN
     */
    public int BS_X_MIN = 5;
    /**
     * Parameter BS_X_MAX
     */
    public int BS_X_MAX = 12;
    /**
     * Parameter BS_Y
     */
    public int BS_Y = 6;
    /**
     * Parameter EC_X_MIN
     */
    public int EC_X_MIN = 13;
    /**
     * Parameter EC_X_MAX
     */
    public int EC_X_MAX = 50;
    /**
     * Parameter EC_Y
     */
    public int EC_Y = 10;
    /**
     * Parameter Seat_X
     */
    public int Seat_X = 0;
    /**
     * Parameter Seat_Y
     */
    public int Seat_Y = 0;
    /**
     * Parameter application
     */
    private Main application;
    /**
     * Parameter counter_1
     */
    private int counter_1;
    /**
     * Parameter counter_2
     */
    private int counter_2;
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
     * JavaFx Parameter Label_Cabin
     */
    @FXML
    private Label Label_Cabin;
    /**
     * JavaFx Parameter Label_Seat
     */
    @FXML
    private Label Label_Seat;
    /**
     * JavaFx Parameter Radio_FC
     */
    @FXML
    private RadioButton Radio_FC;
    /**
     * JavaFx Parameter Radio_BS
     */
    @FXML
    private RadioButton Radio_BS;
    /**
     * JavaFx Parameter Radio_EC
     */
    @FXML
    private RadioButton Radio_EC;
    /**
     * JavaFx Parameter Radio_WS
     */
    @FXML
    private RadioButton Radio_WS;
    /**
     * JavaFx Parameter Radio_MS
     */
    @FXML
    private RadioButton Radio_MS;
    /**
     * JavaFx Parameter Radio_AS
     */
    @FXML
    private RadioButton Radio_AS;
    /**
     * JavaFx Parameter Hidden_Display
     */
    @FXML
    private BorderPane Hidden_Display;
    /**
     * JavaFx Parameter HIdden_ScrollPane
     */
    @FXML
    private ScrollPane HIdden_ScrollPane;
    /**
     * JavaFx Parameter Display_1
     */
    @FXML
    private Label Display_1;
    /**
     * JavaFx Parameter Display_2
     */
    @FXML
    private Label Display_2;
    /**
     * JavaFx Parameter Display_11
     */
    @FXML
    private Label Display_11;
    /**
     * JavaFx Parameter Display_21
     */
    @FXML
    private Label Display_21;
    /**
     * Parameter Display_Status
     */
    private boolean Display_Status = false;
    /**
     * Parameter group_cabin
     */
    private ToggleGroup group_cabin = new ToggleGroup();
    /**
     * Parameter group_seat
     */
    private ToggleGroup group_seat = new ToggleGroup();
    /**
     * Parameter exit_status
     */
    private boolean exit_status = false;


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
        application.gotoidentify();
    }

    /**
     * Go to Next Page
     * @param event JavaFx ActionEvent of Button Next
     */
    @FXML
    private void Next(ActionEvent event) {
        if (exit_status) {
            BookingDataControl bookingDataControl = new BookingDataControl();

            bookingDataControl._SetSeatClass(IdentifyController.getCurrent_User_BookingNumber(), Cabin + "-" + Seat);
            bookingDataControl._SetLocate(IdentifyController.getCurrent_User_BookingNumber(), Seat_X + Num_To_Alphabet(Seat_Y));
            application.gotomealdrink();
        } else {
            Alert_exit();
        }
    }

    /**
     * Getter of Cabin
     * @return String
     */
    public String getCabin() {
        return Cabin;
    }

    /**
     * Getter of Seat
     * @return String
     */
    public String getSeat() {
        return Seat;
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
        HIdden_ScrollPane.setVisible(false);

        Radio_FC.setToggleGroup(group_cabin);
        Radio_BS.setToggleGroup(group_cabin);
        Radio_EC.setToggleGroup(group_cabin);

        Radio_WS.setToggleGroup(group_seat);
        Radio_MS.setToggleGroup(group_seat);
        Radio_AS.setToggleGroup(group_seat);

        Radio_FC.setSelected(true);
        Radio_WS.setSelected(true);

        showTime_Refresh();

    }

    /**
     * Visualize the progess of proceeding the Scroll_Pane Construction
     */
    public void progress() {
        BookingIO bookingIO = new BookingIO();
        ArrayList<Object> arrayList = bookingIO.ReadAll();
        Double progress = ((double) this.counter_1) / ((double) arrayList.size());
        DecimalFormat df = new DecimalFormat("0");
        String return_String = df.format(progress * 100) + "%";
        Display_1.setText(return_String);
        Display_2.setText(Integer.toString(this.counter_1) + "/" + Integer.toString(arrayList.size()));

        Double progress1 = ((double) this.counter_2) / ((double) 4);
        DecimalFormat df1 = new DecimalFormat("0");
        String return_String1 = df.format(progress1 * 100) + "%";
        Display_11.setText(return_String1);
        Display_21.setText(Integer.toString(this.counter_2) + "/" + Integer.toString(4));
    }

    /**
     * Time control and display of Timer Button with refreshing functions
     */
    private void showTime_Refresh() {
        EventHandler<ActionEvent> eventHandler = event -> {
            Date date = new Date();
            SimpleDateFormat Current_format = new SimpleDateFormat("HH:mm:ss");
            Button_Time.setText("UTC/GMT " + Current_format.format(new Date()));
            if (Radio_FC.isSelected())
                Radio_MS.setVisible(false);
            else
                Radio_MS.setVisible(true);
            StoreSelection();
            progress();

        };
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), eventHandler));   //永久动画
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    /**
     * Constructing the ScrollPane Based on user's selection Combination with selected and not selected
     */
    private void Constructor() {
        counter_2 = 0;
        GridPane gridPane1 = new GridPane();
        GridPane gridPane2 = new GridPane();
        GridPane gridPane3 = new GridPane();
        for (int i = FC_X_MIN; i < FC_X_MAX + 1; i++) {
            for (int j = Seat_Y_MIN; j < FC_Y + 1; j++) {
                String validate = i + Num_To_Alphabet(j);
                BookingDataControl bookingDataControl = new BookingDataControl();
                if ((i == Seat_X) && (j == Seat_Y)) {
                    FileInputStream inputstream = null;
                    try {
                        inputstream = new FileInputStream("Picture/Mine.png");
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    Image image = new Image(inputstream);
                    ImageView thisSeat = new ImageView(image);
                    thisSeat.setFitHeight(30);
                    thisSeat.setFitWidth(30);
                    gridPane1.add(thisSeat, j, i);
                } else if (duplicate_Location(validate, bookingDataControl._GetFlightNumber(IdentifyController.getCurrent_User_BookingNumber()))) {
                    FileInputStream inputstream = null;
                    try {
                        inputstream = new FileInputStream("Picture/Chosen.png");
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    Image image = new Image(inputstream);
                    ImageView OtherSeat = new ImageView(image);
                    OtherSeat.setFitHeight(30);
                    OtherSeat.setFitWidth(30);
                    gridPane1.add(OtherSeat, j, i);
                } else {
                    FileInputStream inputstream = null;
                    if (j == 1 || j == 4) {
                        try {
                            inputstream = new FileInputStream("Picture/Window.png");
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        try {
                            inputstream = new FileInputStream("Picture/Asile.png");
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    Image image = new Image(inputstream);
                    ImageView OtherSeat = new ImageView(image);
                    OtherSeat.setFitHeight(30);
                    OtherSeat.setFitWidth(30);
                    gridPane1.add(OtherSeat, j, i);
                }
            }
        }
        counter_2++;
        for (int i = BS_X_MIN; i < BS_X_MAX + 1; i++) {
            for (int j = Seat_Y_MIN; j < BS_Y + 1; j++) {
                String validate = i + Num_To_Alphabet(j);
                BookingDataControl bookingDataControl = new BookingDataControl();
                if ((i == Seat_X) && (j == Seat_Y)) {
                    FileInputStream inputstream = null;
                    try {
                        inputstream = new FileInputStream("Picture/Mine.png");
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    Image image = new Image(inputstream);
                    ImageView thisSeat = new ImageView(image);
                    thisSeat.setFitHeight(30);
                    thisSeat.setFitWidth(30);
                    gridPane2.add(thisSeat, j, i - FC_X_MAX);
                } else if (duplicate_Location(validate, bookingDataControl._GetFlightNumber(IdentifyController.getCurrent_User_BookingNumber()))) {
                    FileInputStream inputstream = null;
                    try {
                        inputstream = new FileInputStream("Picture/Chosen.png");
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    Image image = new Image(inputstream);
                    ImageView OtherSeat = new ImageView(image);
                    OtherSeat.setFitHeight(30);
                    OtherSeat.setFitWidth(30);
                    gridPane2.add(OtherSeat, j, i - FC_X_MAX);
                } else {
                    FileInputStream inputstream = null;
                    if (j == 1 || j == 6) {
                        try {
                            inputstream = new FileInputStream("Picture/Window.png");
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (j == 2 || j == 5) {
                        try {
                            inputstream = new FileInputStream("Picture/Middle.png");
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        try {
                            inputstream = new FileInputStream("Picture/Asile.png");
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    Image image = new Image(inputstream);
                    ImageView OtherSeat = new ImageView(image);
                    OtherSeat.setFitHeight(30);
                    OtherSeat.setFitWidth(30);
                    gridPane2.add(OtherSeat, j, i - FC_X_MAX);
                }
            }
        }
        counter_2++;
        for (int i = EC_X_MIN; i < EC_X_MAX + 1; i++) {
            for (int j = Seat_Y_MIN; j < EC_Y + 1; j++) {
                String validate = i + Num_To_Alphabet(j);
                BookingDataControl bookingDataControl = new BookingDataControl();
                if ((i == Seat_X) && (j == Seat_Y)) {
                    FileInputStream inputstream = null;
                    try {
                        inputstream = new FileInputStream("Picture/Mine.png");
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    Image image = new Image(inputstream);
                    ImageView thisSeat = new ImageView(image);
                    thisSeat.setFitHeight(30);
                    thisSeat.setFitWidth(30);
                    gridPane3.add(thisSeat, j, i - BS_X_MAX);
                } else if (duplicate_Location(validate, bookingDataControl._GetFlightNumber(IdentifyController.getCurrent_User_BookingNumber()))) {
                    FileInputStream inputstream = null;
                    try {
                        inputstream = new FileInputStream("Picture/Chosen.png");
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    Image image = new Image(inputstream);
                    ImageView OtherSeat = new ImageView(image);
                    OtherSeat.setFitHeight(30);
                    OtherSeat.setFitWidth(30);
                    gridPane3.add(OtherSeat, j, i - BS_X_MAX);
                } else {
                    FileInputStream inputstream = null;
                    if (j == 1 || j == 10) {
                        try {
                            inputstream = new FileInputStream("Picture/Window.png");
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (j == 3 || j == 4 || j == 7 || j == 8) {
                        try {
                            inputstream = new FileInputStream("Picture/Asile.png");
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        try {
                            inputstream = new FileInputStream("Picture/Middle.png");
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    Image image = new Image(inputstream);
                    ImageView OtherSeat = new ImageView(image);
                    OtherSeat.setFitHeight(30);
                    OtherSeat.setFitWidth(30);
                    gridPane3.add(OtherSeat, j, i - BS_X_MAX);
                }
            }
        }
        counter_2++;
        for (int i = 1; i < FC_Y + 1; i++) {
            Label label = new Label(Num_To_Alphabet(i));
            label.setTextFill(Color.rgb(255, 255, 255));
            gridPane1.add(label, i, 0);
        }
        for (int i = FC_X_MIN; i < FC_X_MAX + 1; i++) {
            Label label = new Label(Integer.toString(i));
            label.setTextFill(Color.rgb(255, 255, 255));
            gridPane1.add(label, 0, i - FC_X_MIN + 1);
        }

        for (int i = 1; i < BS_Y + 1; i++) {
            Label label = new Label(Num_To_Alphabet(i));
            label.setTextFill(Color.rgb(255, 255, 255));
            gridPane2.add(label, i, 0);
        }
        for (int i = BS_X_MIN; i < BS_X_MAX + 1; i++) {
            Label label = new Label(Integer.toString(i));
            label.setTextFill(Color.rgb(255, 255, 255));
            gridPane2.add(label, 0, i - BS_X_MIN + 1);
        }

        for (int i = 1; i < EC_Y + 1; i++) {
            Label label = new Label(Num_To_Alphabet(i));
            label.setTextFill(Color.rgb(255, 255, 255));
            gridPane3.add(label, i, 0);
        }
        for (int i = EC_X_MIN; i < EC_X_MAX + 1; i++) {
            Label label = new Label(Integer.toString(i));
            label.setTextFill(Color.rgb(255, 255, 255));
            gridPane3.add(label, 0, i - EC_X_MIN + 1);
        }

        //gridPane1.setGridLinesVisible(true);
        gridPane1.setAlignment(Pos.CENTER);
        gridPane1.setHgap(10);
        gridPane1.setVgap(10);
        gridPane1.setVisible(true);

        //gridPane2.setGridLinesVisible(true);
        gridPane2.setAlignment(Pos.CENTER);
        gridPane2.setHgap(10);
        gridPane2.setVgap(10);
        gridPane2.setVisible(true);

        //gridPane3.setGridLinesVisible(true);
        gridPane3.setAlignment(Pos.CENTER);
        gridPane3.setHgap(10);
        gridPane3.setVgap(10);
        gridPane3.setVisible(true);

        Label label1 = new Label("Airplane Inner Seats View");
        Label label2 = new Label("<First-class Cabin>");
        Label label3 = new Label("<Business Cabin>");
        Label label4 = new Label("<Economy Cabin>");

        FileInputStream inputstream = null;
        try {
            inputstream = new FileInputStream("Picture/Window.png");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Image image = new Image(inputstream);
        ImageView Window = new ImageView(image);
        Window.setFitHeight(20);
        Window.setFitWidth(20);
        Label label5 = new Label("Blue for Window", Window);

        try {
            inputstream = new FileInputStream("Picture/Middle.png");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        image = new Image(inputstream);
        ImageView Middle = new ImageView(image);
        Middle.setFitHeight(20);
        Middle.setFitWidth(20);
        Label label6 = new Label("White for MIddle", Middle);

        try {
            inputstream = new FileInputStream("Picture/Asile.png");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        image = new Image(inputstream);
        ImageView Asile = new ImageView(image);
        Asile.setFitHeight(20);
        Asile.setFitWidth(20);
        Label label7 = new Label("Yellow for Asile", Asile);

        try {
            inputstream = new FileInputStream("Picture/Mine.png");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        image = new Image(inputstream);
        ImageView Mine = new ImageView(image);
        Mine.setFitHeight(25);
        Mine.setFitWidth(25);
        Label label8 = new Label("Green & Selected for Your Seat", Mine);

        try {
            inputstream = new FileInputStream("Picture/Chosen.png");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        image = new Image(inputstream);
        ImageView Chosen = new ImageView(image);
        Chosen.setFitHeight(25);
        Chosen.setFitWidth(25);
        Label label9 = new Label("Red for Chosen Ones", Chosen);

        label1.setFont(new Font("Comic", 30));
        label2.setFont(new Font("Cambria", 25));
        label3.setFont(new Font("Cambria", 25));
        label4.setFont(new Font("Cambria", 25));
        label5.setFont(new Font("Cambria", 15));
        label6.setFont(new Font("Cambria", 15));
        label7.setFont(new Font("Cambria", 15));
        label8.setFont(new Font("Cambria", 15));
        label9.setFont(new Font("Cambria", 15));

        label1.setTextFill(Color.rgb(255, 255, 255));
        label2.setTextFill(Color.rgb(255, 255, 255));
        label3.setTextFill(Color.rgb(255, 255, 255));
        label4.setTextFill(Color.rgb(255, 255, 255));

        label5.setTextFill(Color.rgb(18, 150, 219));
        label6.setTextFill(Color.rgb(255, 255, 255));
        label7.setTextFill(Color.rgb(244, 234, 42));
        label8.setTextFill(Color.rgb(14, 147, 46));
        label9.setTextFill(Color.rgb(216, 30, 6));

        HBox hBox1 = new HBox();
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().add(label1);

        HBox hBox5 = new HBox();
        HBox hBox6 = new HBox();
        HBox hBox7 = new HBox();
        HBox hBox8 = new HBox();
        HBox hBox9 = new HBox();
        hBox5.setAlignment(Pos.CENTER_LEFT);
        hBox6.setAlignment(Pos.CENTER_LEFT);
        hBox7.setAlignment(Pos.CENTER_LEFT);
        hBox8.setAlignment(Pos.CENTER_LEFT);
        hBox9.setAlignment(Pos.CENTER_LEFT);
        hBox5.getChildren().add(label5);
        hBox6.getChildren().add(label6);
        hBox7.getChildren().add(label7);
        hBox8.getChildren().add(label8);
        hBox9.getChildren().add(label9);

        VBox vBox1 = new VBox();
        vBox1.getChildren().add(hBox1);
        vBox1.getChildren().add(hBox5);
        vBox1.getChildren().add(hBox6);
        vBox1.getChildren().add(hBox7);
        vBox1.getChildren().add(hBox8);
        vBox1.getChildren().add(hBox9);
        vBox1.setSpacing(15);

        HBox hBox2 = new HBox();
        hBox2.setAlignment(Pos.CENTER);
        hBox2.getChildren().add(label2);
        HBox hBox3 = new HBox();
        hBox3.setAlignment(Pos.CENTER);
        hBox3.getChildren().add(label3);
        HBox hBox4 = new HBox();
        hBox4.setAlignment(Pos.CENTER);
        hBox4.getChildren().add(label4);

        GridPane gridPane_inner = new GridPane();
        gridPane_inner.add(vBox1, 0, 0);
        gridPane_inner.add(hBox2, 0, 1);
        gridPane_inner.add(gridPane1, 0, 2);
        gridPane_inner.add(hBox3, 0, 3);
        gridPane_inner.add(gridPane2, 0, 4);
        gridPane_inner.add(hBox4, 0, 5);
        gridPane_inner.add(gridPane3, 0, 6);
        gridPane_inner.setAlignment(Pos.CENTER);
        gridPane_inner.setVgap(40);

        counter_2++;

        Hidden_Display.setCenter(gridPane_inner);
    }

    /**
     * Judging if the location duplication occurs for this Locate and FlightNumber
     * @param Locate The location on plane
     * @param FlightNumber The target flight number
     * @return boolean
     */
    public boolean duplicate_Location(String Locate, String FlightNumber) {
        this.counter_1 = 0;
        boolean status = false;
        BookingIO bookingIO = new BookingIO();
        ArrayList<Object> Data = bookingIO.ReadAll();
        for (int i = 0; i < Data.size(); i++) {
            Booking booking = (Booking) Data.get(i);
            if (booking.getFlightNumber().equals(FlightNumber)) {
                if (booking.getLocate().equals(Locate)) {
                    status = true;
                }
            }
            counter_1++;
        }
        return status;
    }

    /**
     * Num to Alphabet convertor to display column on plane in Alphabet format
     * @param Num The original Param of column num
     * @return String
     */
    public String Num_To_Alphabet(int Num) {
        switch (Num) {
            case 1:
                return "A";
            case 2:
                return "B";
            case 3:
                return "C";
            case 4:
                return "D";
            case 5:
                return "E";
            case 6:
                return "F";
            case 7:
                return "G";
            case 8:
                return "H";
            case 9:
                return "I";
            case 10:
                return "J";
            default:
                return "K";
        }
    }

    /**
     * Control and Display of HIdden_ScrollPane
     */
    @FXML
    private void Display() {
        if (Location()) {
            if (Display_Status) {
                HIdden_ScrollPane.setVisible(false);
                Display_Status = false;
            } else {
                HIdden_ScrollPane.setVisible(true);
                Constructor();
                Display_Status = true;
            }
            exit_status = true;
        } else {
            exit_status = false;
        }
    }

    /**
     * Generate Random Seats based on user's cabin and seat selection combination
     * @return boolean
     */
    private boolean Location() {
        long startTime = System.currentTimeMillis();
        while (true) {
            Random rd = new Random();
            switch (Cabin) {
                case "First-Class":
                    Seat_X = FC_X_MIN + rd.nextInt(FC_X_MAX - FC_X_MIN + 1);
                    Seat_X_MIN = FC_X_MIN;
                    Seat_X_MAX = FC_X_MAX;
                    Seat_Y_MAX = FC_Y;
                    break;
                case "Business":
                    Seat_X = BS_X_MIN + rd.nextInt(BS_X_MAX - BS_X_MIN + 1);
                    Seat_X_MIN = BS_X_MIN;
                    Seat_X_MAX = BS_X_MAX;
                    Seat_Y_MAX = BS_Y;
                    break;
                case "Economy":
                    Seat_X = EC_X_MIN + rd.nextInt(EC_X_MAX - EC_X_MIN + 1);
                    Seat_X_MIN = EC_X_MIN;
                    Seat_X_MAX = EC_X_MAX;
                    Seat_Y_MAX = EC_Y;
                    break;
                default:
                    Seat_X = 0;
                    Seat_Y_MAX = 0;
            }
            switch (Seat) {
                case "Windows-Seat":
                    int location = rd.nextInt(2);
                    switch (location) {
                        case 0:
                            Seat_Y = Seat_Y_MIN;
                            break;
                        case 1:
                            Seat_Y = Seat_Y_MAX;
                            break;
                        default:
                            Seat_Y = 0;
                    }
                    break;
                case "Middle-Seat":
                    if (Seat_Y_MAX == 4) {
                        Seat_Y = 0;
                        break;
                    } else if (Seat_Y_MAX == 6) {
                        location = rd.nextInt(2);
                        switch (location) {
                            case 0:
                                Seat_Y = 2;
                                break;
                            case 1:
                                Seat_Y = 5;
                                break;
                            default:
                                Seat_Y = 0;
                        }
                        break;
                    } else if (Seat_Y_MAX == 10) {
                        location = rd.nextInt(4);
                        switch (location) {
                            case 0:
                                Seat_Y = 2;
                                break;
                            case 1:
                                Seat_Y = 5;
                                break;
                            case 2:
                                Seat_Y = 6;
                                break;
                            case 3:
                                Seat_Y = 9;
                                break;
                            default:
                                Seat_Y = 0;
                        }
                        break;
                    } else {
                        break;
                    }
                case "Asile-Seat":
                    if (Seat_Y_MAX == 4 || Seat_Y_MAX == 6) {
                        location = rd.nextInt(2);
                        switch (location) {
                            case 0:
                                Seat_Y = Seat_Y_MAX / 2;
                                break;
                            case 1:
                                Seat_Y = Seat_Y_MAX / 2 + 1;
                                break;
                            default:
                                Seat_Y = 0;
                        }
                        break;
                    } else {
                        location = rd.nextInt(4);
                        switch (location) {
                            case 0:
                                Seat_Y = 3;
                                break;
                            case 1:
                                Seat_Y = 4;
                                break;
                            case 2:
                                Seat_Y = 7;
                                break;
                            case 3:
                                Seat_Y = 8;
                                break;
                            default:
                                Seat_Y = 0;
                        }
                        break;
                    }
                default:
                    Seat_Y = 0;
            }
            BookingDataControl bookingDataControl = new BookingDataControl();
            if (!duplicate_Location((Seat_X + Num_To_Alphabet(Seat_Y)),
                    bookingDataControl._GetFlightNumber(IdentifyController.getCurrent_User_BookingNumber()))) {
                return true;
            }
            long endTime = System.currentTimeMillis();
            long usedTime = (endTime - startTime) / 1000;
            if (usedTime > 20) {
                Alert();
                return false;
            }
        }
    }

    /**
     * Alert Box Display and Requires further confirmation to proceed
     */
    private void Alert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Warning");
        alert.setContentText("Invalid Action: Cannot generate seat selection");
        alert.setHeaderText("All the seats under your selection have been chosen already. Please consider another combination.");
        alert.showAndWait();
    }

    /**
     * Alert Box Display and Requires further confirmation to proceed of specific exit triggering
     */
    private void Alert_exit() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Warning");
        alert.setContentText("Invalid Action: Cannot proceed without confirm your seat");
        alert.setHeaderText("Please click on the ticket icon to generate your seat so as to confirm it.");
        alert.showAndWait();
    }


    /**
     * Store the obtaining information from JavaFx Pane radiobox at once
     */
    private void StoreSelection() {
        if (Radio_FC.isSelected())
            Cabin = "First-Class";
        if (Radio_BS.isSelected())
            Cabin = "Business";
        if (Radio_EC.isSelected())
            Cabin = "Economy";
        if (Radio_WS.isSelected())
            Seat = "Windows-Seat";
        if (Radio_MS.isSelected())
            Seat = "Middle-Seat";
        if (Radio_AS.isSelected())
            Seat = "Asile-Seat";
        Label_Cabin.setText(Cabin);
        Label_Seat.setText(Seat);
    }

    /**
     * Effects of Entering Button Next
     * @param event MouseEvent of Button Next
     */
    @FXML
    private void Enter_Next(MouseEvent event) {
        Button_Next.setText(">>>");
    }

    /**
     * Effects of Exiting Button Next
     * @param event MouseEvent of Button Next
     */
    @FXML
    private void Exit_Next(MouseEvent event) {
        Button_Next.setText("Next");
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

}