package br.com.finalcraft.unesp.tc.maquinanorma.javafx.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.net.URL;

public class MyFXMLs {

    public static Parent main_screen;

    public static void initialize() throws IOException {
        main_screen = FXMLLoader.load(MyFXMLs.class.getResource("/assets/tc_maquina_norma.fxml"));
    }

}
