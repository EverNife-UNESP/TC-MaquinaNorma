package br.com.finalcraft.unesp.tc.maquinanorma.application;

import br.com.finalcraft.unesp.tc.maquinanorma.application.registrador.Recorder;
import br.com.finalcraft.unesp.tc.maquinanorma.application.smartlogger.SmartLogger;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class ConsoleMain {


    public static void consoleMenu(){


        Scanner input = new Scanner(System.in);

        Recorder recorderA;
        Recorder recorderB;

        int value;
        int signal;

        System.out.printf("Insira o SINAL do REG A:   ");
        signal = input.nextInt();
        System.out.printf("Insira o VALOR do REG A:   ");
        value = input.nextInt();
        recorderA = new Recorder("A",signal,value);

        System.out.printf("Insira o SINAL do REG B:   ");
        signal = input.nextInt();
        System.out.printf("Insira o VALOR do REG B:   ");
        value = input.nextInt();
        recorderB = new Recorder("B",signal,value);

        int method = -1;

        while (true){
            switch (method){

                case 1:
                    NormaOperator.addRecorder(recorderA,recorderB,false);       //Adição entre dois registradores   Sem preservar conteúdo – obs: utilize números positivos/negativos
                    break;
                case 2:
                    NormaOperator.addRecorder(recorderA,recorderB,true);        //Adição entre dois registradores   Sem preservar conteúdo – obs: utilize números positivos/negativos
                    break;
                case 3:
                    NormaOperator.multiplyRecorder(recorderA,recorderB);                          //Multiplicação entre dois registradores.
                    break;
                case 4:
                    NormaOperator.factorialOf(recorderA);                                       //Calcula o Fatorial de A
                    break;
                case 5:
                    NormaOperator.powerOf(recorderA,recorderB);                                 //Calcula A elevado a B
                    break;
                case 6:
                    SmartLogger.logOut("Resultado == " + (NormaOperator.isPrime(recorderA) == 1 ? "Não" : "Sim"));        //Verificar Primalidade   0 == true ; 1 == false
                    break;
                case 7:
                    SmartLogger.logOut("Resultado == " + (NormaOperator.majorOf(recorderA,recorderB) == 1 ? "Não" : "Sim"));        //Testes A>B        0 == true ; 1 == false
                    break;
                case 8:
                    SmartLogger.logOut("Result == " + NormaOperator.majorOrEqualOf(recorderA,recorderB));        //Testes A>B || A=B 0 == true ; 1 == false
                    break;
                case 9:
                    NormaOperator.restOfDivisionOf(recorderA,recorderB);                      //Calcula o Resto da Divisão de um Registrador (armazena resultado em A)
                    break;
                case 10:
                    System.out.printf("Insira o SINAL do REG A:   ");
                    signal = input.nextInt();
                    System.out.printf("Insira o VALOR do REG A:   ");
                    value = input.nextInt();
                    recorderA = new Recorder("A",signal,value);
                    break;
                case 11:
                    System.out.printf("Insira o SINAL do REG B:   ");
                    signal = input.nextInt();
                    System.out.printf("Insira o VALOR do REG B:   ");
                    value = input.nextInt();
                    recorderB = new Recorder("B",signal,value);
                    break;
                case 20:
                    return;

            }

            System.out.println("\n Insira qualquer coisa para continuar!");
            try {
                input.nextInt();
            }catch (Exception ignored){

            }
            input = new Scanner(System.in);


            SmartLogger.verboseLogStates(recorderA,recorderB);
            System.out.println("Escolha qual função deseja realizar:");
            System.out.println("[1] Somar A + B");
            System.out.println("[2] Somar A + B (com T)");
            System.out.println("[3] Multiplicar A por B");
            System.out.println("[4] A Fotorial");
            System.out.println("[5] A Elevado a B");
            System.out.println("[6] A é Primo ?");
            System.out.println("[7] A > B ?");
            System.out.println("[8] A >= B ?");
            System.out.println("[9] A % B");
            System.out.println("[10] Atributir N em A");
            System.out.println("[11] Atributir N em B");
            System.out.println("[20] SAIR");
            System.out.print("---->    ");
            method = input.nextInt();
        }

    }

    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {

        consoleMenu();

        //Daqui para baixo foi usado como testes...

        //Esses recorders são o iniciais, eles são feito por atribuição de usuário!
        //Recorder recorderA = new Recorder("A",0,9);
        //Recorder recorderB = new Recorder("B",0,10);
        //Recorder recorderC = new Recorder("C",0,0);


        //NormaOperator.addRecorder(recorderA,recorderB,false);                     //Adição entre dois registradores   Sem preservar conteúdo – obs: utilize números positivos/negativos
        //NormaOperator.addRecorder(recorderA,recorderB,true);                      //Adição entre dois registradores   Preservando o conteúdo

        //NormaOperator.multiplyRecorder(recorderA,recorderB);                      //Multiplicação entre dois registradores.

        //NormaOperator.resetRecorder(recorderA);                                   //Reseta um registrador (seta (0,0);

        //NormaOperator.atributeTo(recorderA,recorderB,true);                       //Testes A<B e A<=B
        //NormaOperator.atributeTo(recorderA,recorderB,false);

        //SmartLogger.logOut("Result == " + NormaOperator.majorOf(recorderA,recorderB));        //Testes A<B        0 == true ; 1 == false

        //SmartLogger.logOut("Result == " + NormaOperator.equalOf(recorderA,recorderB));        //Testes A=B        0 == true ; 1 == false

        //SmartLogger.logOut("Result == " + NormaOperator.majorOrEqualOf(recorderA,recorderB)); //Testes A<B || A=B 0 == true ; 1 == false

        //NormaOperator.modOf(recorderA);                                           //Calcula o módulo de um Registrador

        //NormaOperator.restOfDivisionOf(recorderA,recorderB);                      //Calcula o Resto da Divisão de um Registrador (armazena resultado em A)

        //NormaOperator.restOfDivisionOf(recorderA,recorderB,recorderC);            //Calcula o Resto da Divisão de um Registrador (armazena resultado em C)

        //SmartLogger.logOut("Result == " + NormaOperator.isPrime(recorderA));        //Verificar Primalidade   0 == true ; 1 == false

        //NormaOperator.powerOf(recorderA,recorderB);                               //Calcula A elevado a B

        //NormaOperator.factorialOf(recorderA);                                     //Calcula o Fatorial de A
    }
}