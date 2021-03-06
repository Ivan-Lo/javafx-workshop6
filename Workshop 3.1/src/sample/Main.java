package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Travel Experts Add/Edit");
        primaryStage.setScene(new Scene(root, 700, 740));
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
