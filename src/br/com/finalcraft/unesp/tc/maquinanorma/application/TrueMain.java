package br.com.finalcraft.unesp.tc.maquinanorma.application;

import br.com.finalcraft.unesp.tc.maquinanorma.application.registrador.Recorder;

public class TrueMain {



    public static void main(String[] args) {

        //Esses recorders são o iniciais, eles são feito por atribuição de usuário!
        Recorder recorderA = new Recorder("A",0,9);
        Recorder recorderB = new Recorder("B",0,10);
        Recorder recorderC = new Recorder("C",0,0);


        //NormaOperator.addRecorder(recorderA,recorderB,false);                     //Adição entre dois registradores   Sem preservar conteúdo – obs: utilize números positivos/negativos
        //NormaOperator.addRecorder(recorderA,recorderB,true);                      //Adição entre dois registradores   Preservando o conteúdo

        //NormaOperator.multiplyRecorder(recorderA,recorderB);                      //Multiplicação entre dois registradores.

        //NormaOperator.resetRecorder(recorderA);                                   //Reseta um registrador (seta (0,0);

        //NormaOperator.atributeTo(recorderA,recorderB,true);                       //Testes A<B e A<=B
        //NormaOperator.atributeTo(recorderA,recorderB,false);

        //logOut("Result == " + NormaOperator.majorOf(recorderA,recorderB));        //Testes A<B

        //logOut("Result == " + NormaOperator.equalOf(recorderA,recorderB));        //Testes A=B

        //logOut("Result == " + NormaOperator.majorOrEqualOf(recorderA,recorderB)); //Testes A<B || A=B

        //NormaOperator.modOf(recorderA);                                           //Calcula o módulo de um Registrador

        //NormaOperator.restOfDivisionOf(recorderA,recorderB);                      //Calcula o Resto da Divisão de um Registrador (armazena resultado em A)

        //NormaOperator.restOfDivisionOf(recorderA,recorderB,recorderC);            //Calcula o Resto da Divisão de um Registrador (armazena resultado em C)

        //logOut("Result == " + NormaOperator.isPrime(recorderA));                  //Verificar Primalidade

        //NormaOperator.powerOf(recorderA,recorderB);                               //Calcula A elevado a B

        //NormaOperator.factorialOf(recorderA);                                     //Calcula o Fatorial de A

    }
}