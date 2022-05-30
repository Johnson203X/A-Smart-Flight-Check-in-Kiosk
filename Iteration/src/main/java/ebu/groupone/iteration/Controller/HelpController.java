package ebu.groupone.iteration.Controller;

import ebu.groupone.iteration.BackEnd.BookingIO;
import ebu.groupone.iteration.Control.BookingDataControl;
import ebu.groupone.iteration.Main;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Class of Controller to JavaFx FXML Help Page
 * @author  ebu6304.groupone 
 * @version 5.0 2022/5/29 14:19
 */ 
public class HelpController implements Initializable {
    /**
     * Parameter application
     */
    private Main application;
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
     * Parameter BL_Retrieve
     */
    private boolean BL_Retrieve = false;
    /**
     * Parameter BL_RetrieveInfo
     */
    private boolean BL_RetrieveInfo = false;
    /**
     * Parameter BL_AS
     */
    private boolean BL_AS = false;
    /**
     * Parameter BL_LS
     */
    private boolean BL_LS = false;
    /**
     * Parameter Services
     */
    private String Services;
    /**
     * Parameter group_info
     */
    private ToggleGroup group_info = new ToggleGroup();
    /**
     * JavaFx Parameter BT_RI
     */
    @FXML
    private Button BT_RI;
    /**
     * JavaFx Parameter BT_AS
     */
    @FXML
    private Button BT_AS;
    /**
     * JavaFx Parameter LS
     */
    @FXML
    private Button LS;
    /**
     * JavaFx Parameter Retrieve
     */
    @FXML
    private Button Retrieve;
    /**
     * JavaFx Parameter Anchor_Retrieve
     */
    @FXML
    private AnchorPane Anchor_Retrieve;
    /**
     * JavaFx Parameter Anchor_Info
     */
    @FXML
    private AnchorPane Anchor_Info;
    /**
     * JavaFx Parameter Anchor_AS
     */
    @FXML
    private AnchorPane Anchor_AS;
    /**
     * JavaFx Parameter Anchor_LS
     */
    @FXML
    private AnchorPane Anchor_LS;
    /**
     * JavaFx Parameter Text_BN
     */
    @FXML
    private TextField Text_BN;
    /**
     * JavaFx Parameter Text_SN
     */
    @FXML
    private TextField Text_SN;
    /**
     * JavaFx Parameter Text_IN
     */
    @FXML
    private TextField Text_IN;
    /**
     * JavaFx Parameter Label_BN
     */
    @FXML
    private Label Label_BN;
    /**
     * JavaFx Parameter Label_SN
     */
    @FXML
    private Label Label_SN;
    /**
     * JavaFx Parameter Label_IN
     */
    @FXML
    private Label Label_IN;
    /**
     * JavaFx Parameter Label_FN
     */
    @FXML
    private Label Label_FN;
    /**
     * JavaFx Parameter Label_GT
     */
    @FXML
    private Label Label_GT;
    /**
     * JavaFx Parameter Label_DT
     */
    @FXML
    private Label Label_DT;
    /**
     * JavaFx Parameter borderPane
     */
    @FXML
    private BorderPane borderPane;
    /**
     * JavaFx Parameter RB_BN
     */
    @FXML
    private RadioButton RB_BN;
    /**
     * JavaFx Parameter RB_SN
     */
    @FXML
    private RadioButton RB_SN;
    /**
     * JavaFx Parameter  RB_IN
     */
    @FXML
    private RadioButton RB_IN;


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
     * The initialization of the current page, which will be run everytime this page is being accessed
     * @param url The location used to resolve relative paths for the root object, or
     *            {@code null} if the location is not known.
     * @param rb  The resources used to localize the root object, or {@code null} if
     *            the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        RB_BN.setToggleGroup(group_info);
        RB_SN.setToggleGroup(group_info);
        RB_IN.setToggleGroup(group_info);

        showTime_Display();
    }

    /**
     * Time control and display of Timer Button
     */
    private void showTime_Display() {
        EventHandler<ActionEvent> eventHandler = event -> {
            Date date = new Date();
            SimpleDateFormat Current_format = new SimpleDateFormat("HH:mm:ss");
            Button_Time.setText("UTC/GMT " + Current_format.format(new Date()));
            display();
            ShowPic();
        };
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), eventHandler));   //永久动画
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    /**
     * Control and Display of the 3 help services
     */
    private void display() {
        if (BL_Retrieve) {
            Anchor_Retrieve.setVisible(true);
            Services = "Retrieve";
        } else {
            Anchor_Retrieve.setVisible(false);
        }
        if (BL_RetrieveInfo) {
            Anchor_Info.setVisible(true);
            Services = "Retrieve";
        } else {
            Anchor_Info.setVisible(false);
        }
        if (BL_AS) {
            Anchor_AS.setVisible(true);
            Services = "ArtificialServices";
        } else {
            Anchor_AS.setVisible(false);
        }
        if (BL_LS) {
            Anchor_LS.setVisible(true);
            Services = "LHRServices";
        } else {
            Anchor_LS.setVisible(false);
        }

        if (!(BL_Retrieve || BL_RetrieveInfo || BL_AS || BL_LS))
            Services = "Reserved";

        if (RB_BN.isSelected()) {
            Text_SN.setVisible(false);
            Text_BN.setVisible(true);
            Text_IN.setVisible(false);
            Text_SN.setText("");
            Text_IN.setText("");
        } else if (RB_SN.isSelected()) {
            Text_SN.setVisible(true);
            Text_BN.setVisible(false);
            Text_IN.setVisible(false);
            Text_BN.setText("");
            Text_IN.setText("");
        } else {
            Text_SN.setVisible(false);
            Text_BN.setVisible(false);
            Text_IN.setVisible(true);
            Text_BN.setText("");
            Text_SN.setText("");
        }
    }

    /**
     * The Automatic picture Display accodring to the Button Triggered
     */
    private void ShowPic() {
        FileInputStream inputstream = null;
        try {
            String path = "Picture/" + Services + ".png";
            inputstream = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        javafx.scene.image.Image image = new Image(inputstream);
        ImageView Pic = new ImageView(image);
        Pic.setFitHeight(150);
        Pic.setFitWidth(150);
        borderPane.setCenter(Pic);
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
     * Control and Display of the Retrieve Services
     * @param event MouseEvent of Retrieve
     */
    @FXML
    private void Clicked_Retrieve(MouseEvent event) {
        BL_RetrieveInfo = true;

        Boolean Find = false;
        BookingIO bookingIO = new BookingIO();
        BookingDataControl bookingDataControl = new BookingDataControl();

        String BookingNumber = "";
        String Surname = "";
        String IDNumber = "";
        String FlightNumber = "";
        String Gate = "";
        String DepartureTime = "";

        if (RB_BN.isSelected()) {
            BookingNumber = Text_BN.getText();
            try {
                Surname = bookingDataControl._GetSurName(BookingNumber);
                IDNumber = bookingDataControl._GetIDNumber(BookingNumber);
                FlightNumber = bookingDataControl._GetFlightNumber(BookingNumber);
                Gate = bookingDataControl._GetGate(BookingNumber);
                DepartureTime = bookingDataControl._GetDepartureTime(BookingNumber);
            } catch (Exception e) {
                Alert();
            }
        } else if (RB_SN.isSelected()) {
            Surname = Text_SN.getText();
            try {
                BookingNumber = bookingDataControl._GetBookingNumber_WithSurname(Surname);
                IDNumber = bookingDataControl._GetIDNumber(BookingNumber);
                FlightNumber = bookingDataControl._GetFlightNumber(BookingNumber);
                Gate = bookingDataControl._GetGate(BookingNumber);
                DepartureTime = bookingDataControl._GetDepartureTime(BookingNumber);
            } catch (Exception e) {
                Alert();
            }
        } else {
            IDNumber = Text_IN.getText();
            try {
                BookingNumber = bookingDataControl._GetBookingNumber_WithIDNumber(IDNumber);
                Surname = bookingDataControl._GetSurName(BookingNumber);
                FlightNumber = bookingDataControl._GetFlightNumber(BookingNumber);
                Gate = bookingDataControl._GetGate(BookingNumber);
                DepartureTime = bookingDataControl._GetDepartureTime(BookingNumber);
            } catch (Exception e) {
                Alert();
            }
        }
        Label_BN.setText(BookingNumber);
        Label_SN.setText(Surname);
        Label_IN.setText(IDNumber);
        Label_FN.setText(FlightNumber);
        Label_GT.setText(Gate);
        Label_DT.setText(DepartureTime);
    }

    /**
     * Alert Box Display and Requires further confirmation to proceed
     */
    private void Alert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Warning");
        alert.setContentText("Invalid Information: No Related Data");
        alert.setHeaderText("Please input valid information for search");
        alert.showAndWait();
    }


    /**
     * AnchorPane Display among 3 services Buttons - Retrieve_Info
     * @param event MouseEvent of Button Retrieve_Info
     */
    @FXML
    private void Retrieve_Info(MouseEvent event) {
        BL_Retrieve = true;
        BL_RetrieveInfo = false;
        BL_LS = false;
        BL_AS = false;
    }

    /**
     * AnchorPane Display among 3 services Buttons - Clicked_AS
     * @param event MouseEvent of Button Clicked_AS
     */
    @FXML
    private void Clicked_AS(MouseEvent event) {
        BL_Retrieve = false;
        BL_RetrieveInfo = false;
        BL_LS = false;
        BL_AS = true;
    }

    /**
     * AnchorPane Display among 3 services Buttons - Clicked_LS
     * @param event MouseEvent of Button Clicked_LS
     */
    @FXML
    private void Clicked_LS(MouseEvent event) {
        BL_Retrieve = false;
        BL_RetrieveInfo = false;
        BL_LS = true;
        BL_AS = false;
    }

}