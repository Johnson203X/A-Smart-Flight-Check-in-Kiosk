package ebu.groupone.iteration.Controller;

import ebu.groupone.iteration.Control.BookingDataControl;
import ebu.groupone.iteration.Main;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
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
 * Class of Controller to JavaFx FXML Meal and Drink Page
 * @author  ebu6304.groupone 
 * @version 5.0 2022/5/29 14:34
 */ 
public class MealDrinkController implements Initializable {
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
     * JavaFx Parameter STEPTWO
     */
    @FXML
    private AnchorPane STEPTWO;
    /**
     * JavaFx Parameter STEPTHREE
     */
    @FXML
    private AnchorPane STEPTHREE;
    /**
     * JavaFx Parameter RICE
     */
    @FXML
    private RadioButton RICE;
    /**
     * JavaFx Parameter NOODLE
     */
    @FXML
    private RadioButton NOODLE;
    /**
     * JavaFx Parameter HAMBURGER
     */
    @FXML
    private RadioButton HAMBURGER;
    /**
     * JavaFx Parameter ROLL
     */
    @FXML
    private RadioButton ROLL;
    /**
     * JavaFx Parameter SUSHI
     */
    @FXML
    private RadioButton SUSHI;
    /**
     * JavaFx Parameter RESERVED
     */
    @FXML
    private RadioButton RESERVED;
    /**
     * JavaFx Parameter StapleGroup
     */
    @FXML
    private ToggleGroup StapleGroup = new ToggleGroup();
    /**
     * JavaFx Parameter PORK
     */
    @FXML
    private RadioButton PORK;
    /**
     * JavaFx Parameter BEEF
     */
    @FXML
    private RadioButton BEEF;
    /**
     * JavaFx Parameter FISH
     */
    @FXML
    private RadioButton FISH;
    /**
     * JavaFx Parameter CHICKEN
     */
    @FXML
    private RadioButton CHICKEN;
    /**
     * JavaFx Parameter RESERVED_DISHES
     */
    @FXML
    private RadioButton RESERVED_DISHES;
    /**
     * JavaFx Parameter DishesGroup
     */
    @FXML
    private ToggleGroup DishesGroup = new ToggleGroup();
    /**
     * JavaFx Parameter WATER
     */
    @FXML
    private RadioButton WATER;
    /**
     * JavaFx Parameter JUICE
     */
    @FXML
    private RadioButton JUICE;
    /**
     * JavaFx Parameter TEA
     */
    @FXML
    private RadioButton TEA;
    /**
     * JavaFx Parameter COFFEE
     */
    @FXML
    private RadioButton COFFEE;
    /**
     * JavaFx Parameter COKE
     */
    @FXML
    private RadioButton COKE;
    /**
     * JavaFx Parameter RESERVED_DRINKS
     */
    @FXML
    private RadioButton RESERVED_DRINKS;
    /**
     * JavaFx Parameter DRINKSGroup
     */
    @FXML
    private ToggleGroup DRINKSGroup = new ToggleGroup();
    /**
     * JavaFx Parameter STAPLE_PIC
     */
    @FXML
    private BorderPane STAPLE_PIC;
    /**
     * JavaFx Parameter DISH_PIC
     */
    @FXML
    private BorderPane DISH_PIC;
    /**
     * JavaFx Parameter DRINKS_PIC
     */
    @FXML
    private BorderPane DRINKS_PIC;
    /**
     * Parameter Staple
     */
    private String Staple = "";
    /**
     * Parameter Dish
     */
    private String Dish = "";
    /**
     * Parameter Drink
     */
    private String Drink = "";


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
        application.gotoseat();
    }

    /**
     * Go to Next Page
     * @param event JavaFx ActionEvent of Button Next
     */
    @FXML
    private void Next(ActionEvent event) {

        BookingDataControl bookingDataControl = new BookingDataControl();
        bookingDataControl._SetMeal(IdentifyController.getCurrent_User_BookingNumber(), Staple + "-" + Dish + "-" + Drink);
        application.gotoconfirm();
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
        RICE.setToggleGroup(StapleGroup);
        NOODLE.setToggleGroup(StapleGroup);
        SUSHI.setToggleGroup(StapleGroup);
        HAMBURGER.setToggleGroup(StapleGroup);
        RESERVED.setToggleGroup(StapleGroup);
        ROLL.setToggleGroup(StapleGroup);
        RESERVED.setSelected(true);

        BEEF.setToggleGroup(DishesGroup);
        PORK.setToggleGroup(DishesGroup);
        FISH.setToggleGroup(DishesGroup);
        CHICKEN.setToggleGroup(DishesGroup);
        RESERVED_DISHES.setToggleGroup(DishesGroup);
        RESERVED_DISHES.setSelected(true);

        WATER.setToggleGroup(DRINKSGroup);
        COKE.setToggleGroup(DRINKSGroup);
        JUICE.setToggleGroup(DRINKSGroup);
        COFFEE.setToggleGroup(DRINKSGroup);
        TEA.setToggleGroup(DRINKSGroup);
        RESERVED_DRINKS.setToggleGroup(DRINKSGroup);
        RESERVED_DRINKS.setSelected(true);

        showTime_Steps();
    }

    /**
     * Time control and display of Timer Button with Steps control
     */
    private void showTime_Steps() {
        EventHandler<ActionEvent> eventHandler = event -> {
            Date date = new Date();
            SimpleDateFormat Current_format = new SimpleDateFormat("HH:mm:ss");
            Button_Time.setText("UTC/GMT " + Current_format.format(new Date()));
            StoreSelection();
            if (RESERVED.isSelected()) {
                STEPTWO.setVisible(false);
                STEPTHREE.setVisible(false);
            } else {
                STEPTWO.setVisible(true);
            }
            if (RESERVED_DISHES.isSelected())
                STEPTHREE.setVisible(false);
            else
                STEPTHREE.setVisible(true);
            ShowStaplePic();
            ShowDishesPic();
            ShowDrinksPic();
        };
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), eventHandler));   //永久动画
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    /**
     * Button Text Content Automatic Display of Entering Next
     * @param event MouseEvent of Next
     */
    @FXML
    private void Enter_Next(MouseEvent event) {
        Button_Next.setText(">>>");
    }

    /**
     * Button Text Content Automatic Display of Exiting Next
     * @param event MouseEvent of Next
     */
    @FXML
    private void Exit_Next(MouseEvent event) {
        Button_Next.setText("Next");
    }

    /**
     * Button Text Content Automatic Display of Entering Return
     * @param event MouseEvent of Return
     */
    @FXML
    private void Enter_Return(MouseEvent event) {
        Button_Return.setText("<<<");
    }

    /**
     * Button Text Content Automatic Display of Exiting Return
     * @param event MouseEvent of Return
     */
    @FXML
    private void Exit_Return(MouseEvent event) {
        Button_Return.setText("Return");
    }

    /**
     * Store the obtaining information from JavaFx Pane radiobox at once
     */
    private void StoreSelection() {
        if (RICE.isSelected())
            Staple = "Rice";
        if (NOODLE.isSelected())
            Staple = "Noodle";
        if (SUSHI.isSelected())
            Staple = "Sushi";
        if (ROLL.isSelected())
            Staple = "Roll";
        if (RESERVED.isSelected())
            Staple = "Reserved";
        if (HAMBURGER.isSelected())
            Staple = "Hamburger";

        if (PORK.isSelected())
            Dish = "Pork";
        if (BEEF.isSelected())
            Dish = "Beef";
        if (CHICKEN.isSelected())
            Dish = "Chicken";
        if (FISH.isSelected())
            Dish = "Fish";
        if (RESERVED_DISHES.isSelected())
            Dish = "Reserved_Dishes";

        if (WATER.isSelected())
            Drink = "Water";
        if (JUICE.isSelected())
            Drink = "Juice";
        if (COFFEE.isSelected())
            Drink = "Coffee";
        if (TEA.isSelected())
            Drink = "Tea";
        if (COKE.isSelected())
            Drink = "Coke";
        if (RESERVED_DRINKS.isSelected())
            Drink = "Reserved_Drinks";
    }

    /**
     * Control and Automatic Display of Staple Picture Accoring to the Button Selected
     */
    private void ShowStaplePic() {
        FileInputStream inputstream = null;
        try {
            String path = "Picture/" + Staple + ".png";
            inputstream = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Image image = new Image(inputstream);
        ImageView Pic = new ImageView(image);
        Pic.setFitHeight(100);
        Pic.setFitWidth(100);
        STAPLE_PIC.setCenter(Pic);
    }

    /**
     * Control and Automatic Display of Dishes Picture Accoring to the Button Selected
     */
    private void ShowDishesPic() {
        FileInputStream inputstream = null;
        try {
            String path = "Picture/" + Dish + ".png";
            inputstream = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Image image = new Image(inputstream);
        ImageView Pic = new ImageView(image);
        Pic.setFitHeight(100);
        Pic.setFitWidth(100);
        DISH_PIC.setCenter(Pic);
    }

    /**
     * Control and Automatic Display of Drink Picture Accoring to the Button Selected
     */
    private void ShowDrinksPic() {
        FileInputStream inputstream = null;
        try {
            String path = "Picture/" + Drink + ".png";
            inputstream = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Image image = new Image(inputstream);
        ImageView Pic = new ImageView(image);
        Pic.setFitHeight(100);
        Pic.setFitWidth(100);
        DRINKS_PIC.setCenter(Pic);
    }

}
