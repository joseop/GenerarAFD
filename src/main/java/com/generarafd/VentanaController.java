package com.generarafd;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class VentanaController {

    @FXML
    private Button btnConvertir;
    @FXML
    private TextArea tAAFDM;
    @FXML
    private TextArea tAAFResultante;
    @FXML
    private TextArea tAAsignarVariables;
    @FXML
    private TextArea tACierreLambda;
    @FXML
    private TextArea tAEstadosResultantes;
    @FXML
    private TextArea tAEvaluarCierreLambda;
    @FXML
    private TextArea tAGrupos;
    @FXML
    private TextArea tATransiciones;
    @FXML
    private Tab tabAsignarVariables;
    @FXML
    private Tab tabCierreLambda;
    @FXML
    private Tab tabNuevosEstados;
    @FXML
    private Tab tabAFDM;
    @FXML
    private Tab tabTransiciones;
    @FXML
    private Label txtNota;

    private void desactivarTab(){
        tabTransiciones.setDisable(true);
        tabCierreLambda.setDisable(true);
        tabNuevosEstados.setDisable(true);
        tabAsignarVariables.setDisable(true);
        tabAFDM.setDisable(true);
    }
    @FXML
    void asignarVariables(ActionEvent event) {
        tabAFDM.setDisable(false);
        btnConvertir.setDisable(false);
    }

    @FXML
    void cerrar(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void cierreLambda(ActionEvent event) {
        tabNuevosEstados.setDisable(false);
    }

    @FXML
    void convertir(ActionEvent event) {
        desactivarTab();
        btnConvertir.setDisable(true);
        tabTransiciones.setDisable(false);
    }

    @FXML
    void nuevosEstados(ActionEvent event) {
        tabAsignarVariables.setDisable(false);
    }

    @FXML
    void transiciones(ActionEvent event) {
        tabCierreLambda.setDisable(false);

    }
}