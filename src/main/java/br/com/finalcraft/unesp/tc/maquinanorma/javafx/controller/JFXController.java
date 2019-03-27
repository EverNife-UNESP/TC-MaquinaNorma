package br.com.finalcraft.unesp.tc.maquinanorma.javafx.controller;

import br.com.finalcraft.unesp.tc.maquinanorma.application.NormaOperator;
import br.com.finalcraft.unesp.tc.maquinanorma.application.registrador.Recorder;
import br.com.finalcraft.unesp.tc.maquinanorma.application.smartlogger.SmartLogger;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class JFXController {

    public static Integer valueOf(String string){
        try {
            return Integer.valueOf(string);
        }catch (Exception e){
            return null;
        }
    }

    public static JFXController aThis;

    public void logOut(String message){
        smartLogConsole.appendText( "\n" + message);
    }

    private Recorder recorderA = new Recorder("A",0,0);
    private Recorder recorderB = new Recorder("B",0,0);

    @FXML
    private JFXTextField regATextField;

    @FXML
    private JFXTextField regBTextField;

    @FXML
    void initialize() {
        aThis = this;
    }

    @FXML
    JFXTextArea smartLogConsole;

    @FXML
    JFXButton regAIdentifier;

    @FXML
    JFXButton regBIdentifier;


    public void updateRegA(){
        regAIdentifier.setText("REG A == " + recorderA.toString());
    }

    public void updateRegB(){
        regBIdentifier.setText("REG B == " + recorderB.toString());
    }

    public void updateAllRegs(){
        updateRegA();
        updateRegB();
    }

    @FXML
    void onResetAll(ActionEvent event) {
        recorderA = new Recorder("A",0,0);
        recorderB = new Recorder("B",0,0);
        updateAllRegs();
        onConsoleReset(event);
        regATextField.setText("");
        regBTextField.setText("");
    }

    @FXML
    void onConsoleReset(ActionEvent event) {
        smartLogConsole.setText("");
    }


    @FXML
    void onSetRegA(ActionEvent event) {
        Integer value = valueOf(regATextField.getText());
        if (value != null){
            if (value >= 0){
                recorderA = new Recorder("A",0,value);
            }else {
                recorderA = new Recorder("A",1,Math.abs(value));
            }
            updateRegA();
        }
    }

    @FXML
    void onSetRegB(ActionEvent event) {
        Integer value = valueOf(regBTextField.getText());
        if (value != null){
            if (value >= 0){
                recorderB = new Recorder("B",0,value);
            }else {
                recorderB = new Recorder("B",1,Math.abs(value));
            }
            updateRegB();
        }
    }

    @FXML
    void onAdd(ActionEvent event) {
        NormaOperator.addRecorder(recorderA,recorderB,false);
        updateAllRegs();
    }

    @FXML
    void onAddKeeping(ActionEvent event) {
        NormaOperator.addRecorder(recorderA,recorderB,true);
        updateAllRegs();
    }

    @FXML
    void onFactorial(ActionEvent event) {
        NormaOperator.factorialOf(recorderA);
        updateAllRegs();
    }

    @FXML
    void onMajor(ActionEvent event) {
        SmartLogger.logOut("Resultado == " + (NormaOperator.majorOf(recorderA,recorderB) == 1 ? "Não" : "Sim"));        //Testes A>B        0 == true ; 1 == false
        updateAllRegs();
    }

    @FXML
    void onMajorOrEqual(ActionEvent event) {
        SmartLogger.logOut("Result == " + (NormaOperator.majorOrEqualOf(recorderA,recorderB) == 1 ? "Não" : "Sim"));        //Testes A>B || A=B 0 == true ; 1 == false
        updateAllRegs();
    }

    @FXML
    void onMultiply(ActionEvent event) {
        NormaOperator.multiplyRecorder(recorderA,recorderB);                          //Multiplicação entre dois registradores.
        updateAllRegs();
    }

    @FXML
    void onPower(ActionEvent event) {
        NormaOperator.powerOf(recorderA,recorderB);                                 //Calcula A elevado a B
        updateAllRegs();
    }

    @FXML
    void onPrimal(ActionEvent event) {
        SmartLogger.logOut("Resultado == " + (NormaOperator.isPrime(recorderA) == 1 ? "Não" : "Sim"));        //Verificar Primalidade   0 == true ; 1 == false
        updateAllRegs();
    }

    @FXML
    void onRestOfDivision(ActionEvent event) {
        NormaOperator.restOfDivisionOf(recorderA,recorderB);                      //Calcula o Resto da Divisão de um Registrador (armazena resultado em A)
        updateAllRegs();
    }

}
