package br.unesp.petruspradella.maquinanorma;

import br.unesp.petruspradella.maquinanorma.operator.NormaOperator;
import br.unesp.petruspradella.maquinanorma.registrador.Recorder;

public class TrueMain {

    public static void main(String[] args) {

        Recorder recorderA = new Recorder("A",10,1);
        Recorder recorderB = new Recorder("B",4,0);


        //NormaOperator.addRecorder(recorderA,recorderB,true);
        //NormaOperator.multiplyRecorder(recorderA,recorderB);
        //NormaOperator.resetRecorder(recorderA);
        //NormaOperator.atributeTo(recorderA,recorderB,true);
        //System.out.printf("Result == " + NormaOperator.majorOf(recorderA,recorderB));
        //System.out.printf("Result == " + NormaOperator.equalOf(recorderA,recorderB));
        //System.out.printf("Result == " + NormaOperator.majorOrEqualOf(recorderA,recorderB));
        //NormaOperator.modOf(recorderA);
        //NormaOperator.restOfDivisionOf(recorderA,recorderB);

    }
}