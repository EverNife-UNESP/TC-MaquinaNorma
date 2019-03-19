package br.unesp.petruspradella.maquinanorma;

import br.unesp.petruspradella.maquinanorma.operator.NormaOperator;
import br.unesp.petruspradella.maquinanorma.registrador.Recorder;

public class TrueMain {

    public static void main(String[] args) {

        Recorder recorderA = new Recorder("A",5,0);
        Recorder recorderB = new Recorder("B",5,0);


        NormaOperator.addRecorder(recorderA,recorderB,true);

    }
}