package br.unesp.petruspradella.operator;

import br.unesp.petruspradella.registrador.Recorder;
import br.unesp.petruspradella.smartlogger.SmartLogger;

public class NormaOperator {

    public static void addRecorder(Recorder recorderA, Recorder recorderB, boolean keepRecorderBValue){

        SmartLogger.logOut("Soma dos registradores [" + recorderA.name + "] e [" + recorderB.name +"]" + (keepRecorderBValue ? " usando um Registrador Temporario!" : ""));

        if (!keepRecorderBValue){
            SmartLogger.verboseLogStates(recorderA,recorderB);

            while (recorderB.value != 0){
                recorderB.value--;

                if (recorderB.signal == 0){
                    recorderA.addOne();
                }else {
                    recorderA.removeOne();
                }

                recorderB.fixSignal();
                SmartLogger.verboseLogStates(recorderA,recorderB);
            }
        }else {
            Recorder recorderT = new Recorder("T",0,0);

            SmartLogger.verboseLogStates(recorderA,recorderB,recorderT);

            while (recorderB.value > 0){
                recorderB.value--;

                if (recorderB.signal == 0){
                    recorderA.addOne();
                    recorderT.addOne();
                }else {
                    recorderA.removeOne();
                    recorderT.removeOne();
                }

                SmartLogger.verboseLogStates(recorderA,recorderB,recorderT);
            }

            SmartLogger.logOut("\n\n");

            while (recorderT.value > 0){
                recorderT.value--;

                if (recorderT.signal == 0){
                    recorderB.addOne();
                }else {
                    recorderB.removeOne();
                }

                recorderT.fixSignal();
                SmartLogger.verboseLogStates(recorderA,recorderB,recorderT);
            }
        }


    }


}
