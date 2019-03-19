package br.unesp.petruspradella.maquinanorma;

import br.unesp.petruspradella.maquinanorma.operator.NormaOperator;
import br.unesp.petruspradella.maquinanorma.registrador.Recorder;

public class TrueMain {

    public static void main(String[] args) {

        Recorder recorderA = new Recorder("A",3,1);
        Recorder recorderB = new Recorder("B",3,0);


        //NormaOperator.addRecorder(recorderA,recorderB,true);
        NormaOperator.multiplierRecorder(recorderA,recorderB);

    }
}