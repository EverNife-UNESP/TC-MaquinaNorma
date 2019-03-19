package br.unesp.petruspradella;

import br.unesp.petruspradella.operator.NormaOperator;
import br.unesp.petruspradella.registrador.Recorder;

public class TrueMain {

    public static void main(String[] args) {

        Recorder recorderA = new Recorder("A",5,0);
        Recorder recorderB = new Recorder("B",5,0);


        NormaOperator.addRecorder(recorderA,recorderB,true);

    }
}