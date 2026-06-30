package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args){
         System.out.println("ESTOY EJECUTANDO ESTE MAIN");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Principal.fxml"));

        Scene scene = new Scene(loader.load());

        primaryStage.setTitle("Conversor de monedas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
