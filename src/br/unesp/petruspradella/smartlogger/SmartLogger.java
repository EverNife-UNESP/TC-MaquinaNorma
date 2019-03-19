package br.unesp.petruspradella.smartlogger;

import br.unesp.petruspradella.registrador.Recorder;

public class SmartLogger {

    public static void logOut(String message){
        System.out.println(message);
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
