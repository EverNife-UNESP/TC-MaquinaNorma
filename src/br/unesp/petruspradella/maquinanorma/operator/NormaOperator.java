package br.unesp.petruspradella.maquinanorma.operator;

import br.unesp.petruspradella.maquinanorma.registrador.Recorder;
import br.unesp.petruspradella.maquinanorma.smartlogger.SmartLogger;

public class NormaOperator {

    public static void addRecorder(Recorder recorderA, Recorder recorderB, boolean keepRecorderBValue){

        SmartLogger.logOut("Soma dos registradores [" + recorderA.name + "] e [" + recorderB.name +"]" + (keepRecorderBValue ? " usando um Registrador Temporario!" : ""));

        if (!keepRecorderBValue){
            SmartLogger.verboseLogStates(recorderA,recorderB);

            while (true){
                if (recorderB.value == 0){
                    break;
                }

                if (recorderB.signal == 0){
                    recorderB.removeOne();
                    recorderA.addOne();
                }else {
                    recorderB.addOne();
                    recorderA.removeOne();
                }

                SmartLogger.verboseLogStates(recorderA,recorderB);
            }
        }else {
            Recorder recorderT = new Recorder("T",0,0);

            SmartLogger.verboseLogStates(recorderA,recorderB,recorderT);

            while (true){
                if (recorderB.value == 0){
                    break;
                }
                if (recorderB.signal == 0){
                    recorderB.removeOne();
                    recorderA.addOne();
                    recorderT.addOne();
                }else {
                    recorderB.addOne();
                    recorderA.removeOne();
                    recorderT.addOne();
                }
                SmartLogger.verboseLogStates(recorderA,recorderB,recorderT);
            }
            SmartLogger.logOut("<-- Retornando valor do registrador B");

            while (true){
                if (recorderT.value == 0){
                    break;
                }
                if (recorderT.signal == 0){
                    recorderT.removeOne();
                    recorderB.addOne();
                }else {
                    recorderT.addOne();
                    recorderB.removeOne();
                }
                SmartLogger.verboseLogStates(recorderA,recorderB,recorderT);
            }
        }
    }

    public static void multiplierRecorder(Recorder recorderA, Recorder recorderB){
        SmartLogger.logOut("Multiplicação dos registradores [" + recorderA.name + "] e [" + recorderB.name +"] usando um Registrador Temporario!");

        Recorder recorderC = new Recorder("C",0,0);
        Recorder recorderD = new Recorder("D",0,0);
        SmartLogger.verboseLogStates(recorderA,recorderB,recorderC);

        while (true){
            if (recorderA.value == 0){
                break;
            }
            if (recorderA.signal == 0){
                recorderA.removeOne();
                recorderC.addOne();
                recorderD.addOne();
            }else {
                recorderA.addOne();
                recorderC.removeOne();
                recorderD.removeOne();
            }
            SmartLogger.verboseLogStates(recorderA,recorderB,recorderC);
        }
        SmartLogger.logOut("");

        while (true){
            if (recorderC.value == 0){
                break;
            }
            if (recorderC.signal == 0){
                recorderC.removeOne();
            }else {
                recorderC.addOne();
            }
            SmartLogger.logOut("");

            addRecorder(recorderA,recorderB,true);
            SmartLogger.verboseLogStates(recorderA,recorderB,recorderC);
        }

        if ( (recorderB.signal == 0 && recorderD.signal == 0) || (recorderB.signal == 1 && recorderD.signal == 1)) {
            if (recorderA.signal == 1){
                recorderA.signal--;
            }
        }else{
            if (recorderA.signal == 0){
                recorderA.signal++;
            }
        }

        SmartLogger.logOut("\n ----> Resultado Final: ");
        SmartLogger.verboseLogStates(recorderA,recorderB,recorderC);

        //TODO
    }


}
