package br.com.finalcraft.unesp.tc.maquinanorma.javafx;

import br.com.finalcraft.unesp.tc.maquinanorma.javafx.view.MyFXMLs;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class JavaFXMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        MyFXMLs.initialize();   //Load all FXML files

        Parent root = MyFXMLs.main_screen;
        if (root == null){
            System.out.println("root is null...");
            return;
        }
        Scene scene = new Scene(root);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
