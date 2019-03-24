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
                    recorderT.removeOne();
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

    public static int equalOf(Recorder recorderA, Recorder recorderB){
        SmartLogger.logOut("Verificando se registrador [" + recorderA.name + "] é igual a [" + recorderB.name + "]!");

        //Se os sinais forem diferentes
        if ((recorderA.signal == 0 && recorderB.signal == 1) || (recorderA.signal == 1 && recorderB.signal == 0)){
            return 1;
        }

        Recorder recorderTA = new Recorder("TA",0,0);
        Recorder recorderTB = new Recorder("TB",0,0);
        atributeTo(recorderTA,recorderA,true);
        atributeTo(recorderTB,recorderB,true);

        SmartLogger.verboseLogStates(recorderA,recorderB,recorderTA,recorderTB);

        while (true){
            if (recorderTA.value == 0){
                SmartLogger.verboseLogStates(recorderA,recorderB,recorderTA,recorderTB);
                if (recorderTB.value == 0){
                    return 0;
                }else {
                    return 1;
                }
            }
            if (recorderA.signal == 0){
                recorderTA.removeOne();
                recorderTB.removeOne();
            }else {
                recorderTA.addOne();
                recorderTB.addOne();
            }
            SmartLogger.verboseLogStates(recorderA,recorderB,recorderTA,recorderTB);
        }
    }

    //Return 0 == true
    public static int majorOf(Recorder recorderA, Recorder recorderB){
        SmartLogger.logOut("Verificando se registrador [" + recorderA.name + "] é maior que [" + recorderB.name + "]!");

        //Se os sinais forem diferentes
        if (recorderA.signal == 0 && recorderB.signal == 1){
            return 0;
        }else if (recorderA.signal == 1 && recorderB.signal == 0){
            return 1;
        }

        Recorder recorderTA = new Recorder("TA",0,0);
        Recorder recorderTB = new Recorder("TB",0,0);
        atributeTo(recorderTA,recorderA,true);
        atributeTo(recorderTB,recorderB,true);

        SmartLogger.verboseLogStates(recorderA,recorderB,recorderTA,recorderTB);

        while (true){
            if (recorderTA.value == 0){
                if (recorderTB.value == 0){
                    SmartLogger.verboseLogStates(recorderA,recorderB,recorderTA,recorderTB);
                    return 1;
                }else {
                    SmartLogger.verboseLogStates(recorderA,recorderB,recorderTA,recorderTB);
                    if (recorderA.signal == 0){
                        return 1;
                    }else {
                        return 0;
                    }
                }
            }
            if (recorderTB.value == 0){
                SmartLogger.verboseLogStates(recorderA,recorderB,recorderTA,recorderTB);
                if (recorderA.signal == 0){
                    return 0;
                }else {
                    return 1;
                }
            }
            if (recorderA.signal == 0){
                recorderTA.removeOne();
                recorderTB.removeOne();
            }else {
                recorderTA.addOne();
                recorderTB.addOne();
            }
            SmartLogger.verboseLogStates(recorderA,recorderB,recorderTA,recorderTB);
        }
    }

    //Return 0 == true
    public static int majorOrEqualOf(Recorder recorderA, Recorder recorderB){
        SmartLogger.logOut("Verificando se o registrador [" + recorderA.name + "] é maior ou igual a [" + recorderB.name + "]!");
        if (equalOf(recorderA,recorderB) == 0){
            return 0;
        }else {
            return majorOf(recorderA, recorderB);
        }
    }

    public static void multiplyRecorder(Recorder recorderA, Recorder recorderB){
        SmartLogger.logOut("Multiplicação dos registradores [" + recorderA.name + "] e [" + recorderB.name +"]!");

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
    }


    public static void resetRecorder(Recorder recorder){
        SmartLogger.logOut("Resetando registrador [" + recorder.name + "]!");
        while (true){
            if (recorder.value == 0){
                break;
            }
            if (recorder.signal == 0){
                recorder.removeOne();
            }else {
                recorder.addOne();
            }
            SmartLogger.verboseLogStates(recorder);
        }
    }

    public static void modOf(Recorder recorder){
        SmartLogger.logOut("Calculando MODULO do registrador [" + recorder.name + "]!");

        Recorder recorderT = new Recorder("T",0,0);

        SmartLogger.verboseLogStates(recorder, recorderT);

        while (true){
            if (recorder.value == 0){
                break;
            }
            if (recorder.signal == 0){
                recorder.removeOne();
                recorderT.addOne();
            }else {
                recorder.addOne();
                recorderT.addOne();
            }
            SmartLogger.verboseLogStates(recorder, recorderT);
        }
        while (true){
            if (recorderT.value == 0){
                break;
            }
            recorderT.removeOne();
            recorder.addOne();
            SmartLogger.verboseLogStates(recorder, recorderT);
        }
        SmartLogger.verboseLogStates(recorder);
    }

    public static void restOfDivisionOf(Recorder recorderA, Recorder recorderB){
        SmartLogger.logOut("Resto da divisão  dos registradores [" + recorderA.name + "] e [" + recorderB.name +"]!");

        if (recorderB.value == 0){
            throw new ArithmeticException("O registrador B não pode ser ZERO!");
        }

        Recorder recorderTA = new Recorder("TA",0,0);
        Recorder recorderTB = new Recorder("TB",0,0);
        Recorder recorderTBNegative = new Recorder("TBNegative",0,0);
        atributeTo(recorderTA,recorderA,true);
        atributeTo(recorderTB,recorderB,true);
        atributeTo(recorderTBNegative,recorderB,true);
        recorderTBNegative.invertSignal();

        modOf(recorderTA);
        modOf(recorderTB);

        SmartLogger.verboseLogStates(recorderA,recorderB,recorderTA,recorderTB,recorderTBNegative);

        while (true){
            SmartLogger.verboseLogStates(recorderA,recorderB,recorderTA,recorderTB,recorderTBNegative);
            if (majorOrEqualOf(recorderTA,recorderTB) == 0){
                addRecorder(recorderTA,recorderTBNegative,true);
            }else {
                break;
            }
        }

        SmartLogger.verboseLogStates(recorderA,recorderB,recorderTA,recorderTB,recorderTBNegative);

        if ((recorderA.signal == 0 && recorderB.signal == 1) || (recorderA.signal == 1 && recorderB.signal == 0)){
            recorderTA.signal--;
        }

        resetRecorder(recorderA);

        atributeTo(recorderA,recorderTA,false);
        SmartLogger.verboseLogStates(recorderA,recorderB,recorderTA,recorderTB,recorderTBNegative);
    }

    public static void atributeTo(Recorder recorderA, Recorder recorderB, boolean keepValueInB){
        SmartLogger.logOut("Atribuição do registrador [" + recorderB.name + "] em [" + recorderA.name +"]!");

        Recorder recorderT = new Recorder("T",0,0);

        resetRecorder(recorderA);

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
                recorderT.removeOne();
            }
            SmartLogger.verboseLogStates(recorderA,recorderB,recorderT);
        }

        if (keepValueInB){
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
        SmartLogger.verboseLogStates(recorderA,recorderB,recorderT);
    }
}
