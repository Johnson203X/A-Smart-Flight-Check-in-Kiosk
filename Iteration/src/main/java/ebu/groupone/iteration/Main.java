package ebu.groupone.iteration;

import ebu.groupone.iteration.Controller.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class of the Main Application of JavaFx Program
 * @author  ebu6304.groupone
 * @version 5.0 2022/5/29 15:01
 */ 
public class Main extends Application {
    /**
     * Parameter MINIMUM_WINDOW_WIDTH
     */
    private final double MINIMUM_WINDOW_WIDTH = 1200;
    /**
     * Parameter MINIMUM_WINDOW_HEIGHT
     */
    private final double MINIMUM_WINDOW_HEIGHT = 800;
    /**
     * Parameter stage
     */
    private Stage stage;

    /**
     * The Main Function within JavaFx Project Main Class
     * @param args Input Param of initializing the Main Function
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages.
     * @throws Exception Unexpected JavaFx Exceptions
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setTitle("London Heathrow Airport Self-Check-In Kiosk Service");
        stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
        stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
        stage.setResizable(false);
        gotomain();
        stage.show();
    }

    /**
     * Go to Main Page
     */
    public void gotomain() {
        try {
            MainController main = (MainController) replaceSceneContent("FXML/Main.fxml");
            main.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Go to Identify Page
     */
    public void gotoidentify() {
        try {
            IdentifyController identify = (IdentifyController) replaceSceneContent("FXML/Identify.fxml");
            identify.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Go to Seat Page
     */
    public void gotoseat() {
        try {
            SeatController seat = (SeatController) replaceSceneContent("FXML/Seat.fxml");
            seat.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Go to Meal and Drink Page
     */
    public void gotomealdrink() {
        try {
            MealDrinkController mealdrink = (MealDrinkController) replaceSceneContent("FXML/MealDrink.fxml");
            mealdrink.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Go to Confirm Page
     */
    public void gotoconfirm() {
        try {
            ConfirmController confirm = (ConfirmController) replaceSceneContent("FXML/Confirm.fxml");
            confirm.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Go to Print Page
     */
    public void gotoprint() {
        try {
            PrintController print = (PrintController) replaceSceneContent("FXML/Print.fxml");
            print.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Go to Admin Page
     */
    public void gotoadmin() {
        try {
            AdminController admin = (AdminController) replaceSceneContent("FXML/Admin.fxml");
            admin.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Go to help Page
     */
    public void gotohelp() {
        try {
            HelpController help = (HelpController) replaceSceneContent("FXML/Help.fxml");
            help.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    /**
     * The restricting intializing methods for all JavaFx Pages within this Project
     * @param fxml The FXML to be loaded
     * @return Initializable
     * @throws Exception Unexpected JavaFx Exception
     */
    private Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = Main.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(Main.class.getResource(fxml));
        AnchorPane page;
        try {
            page = (AnchorPane) loader.load(in);
        } finally {
            in.close();
        }
        Scene scene = new Scene(page, 1200, 800);
        stage.setScene(scene);
        stage.sizeToScene();
        return (Initializable) loader.getController();
    }


}

