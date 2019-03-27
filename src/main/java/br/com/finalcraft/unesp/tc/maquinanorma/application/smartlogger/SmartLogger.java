package br.com.finalcraft.unesp.tc.maquinanorma.application.smartlogger;

import br.com.finalcraft.unesp.tc.maquinanorma.application.registrador.Recorder;
import br.com.finalcraft.unesp.tc.maquinanorma.javafx.controller.JFXController;

public class SmartLogger {

    public static void logOut(String message){
        System.out.println(message);
        JFXController.aThis.logOut(message);
    }

    public static void verboseLogStates(Recorder... recorders){

        StringBuilder stringBuilder = new StringBuilder();

        for (Recorder recorder : recorders){
            stringBuilder.append("[" + recorder.name + " : (" + recorder.signal + "," + recorder.value +")] -- ");
        }

        String message = stringBuilder.substring(0,stringBuilder.length() - 4);

        logOut(message);
    }



}
