package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * This is a calculator application where one can perform simple calculations.
 * Built 5-11. October 2020
 * @author Kasanderh
 *
 * Application icon made by Freepik from www.flaticon.com
 */

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/Views/MainWindow.fxml"));
        primaryStage.setTitle("Calculadora");
        primaryStage.setScene(new Scene(root, 320, 600));
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.getIcons().add(new Image("/style/calculator.png"));
    }


    public static void main(String[] args) {
        launch(args);
    }
}
