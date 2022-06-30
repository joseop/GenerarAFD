package com.generarafd;

import com.generarafd.modelo.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class VentanaController implements Initializable {

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
    Elemento elementos = new Elemento();


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
        tAGrupos.setText(ParticionesDeEstado.stringGE());
        tAAFDM.setText(elementos.stringAFDMinimo());
        btnConvertir.setDisable(false);
    }

    @FXML
    void cerrar(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void cierreLambda(ActionEvent event) {
        tabNuevosEstados.setDisable(false);
        tAEvaluarCierreLambda.setText(elementos.stringAFD());
        tAEstadosResultantes.setText(ConstruirAFDSinLambda.stringNuevosEstados());
    }

    @FXML
    void convertir(ActionEvent event) {
        desactivarTab();
        tATransiciones.setText(elementos.stringER());
        btnConvertir.setDisable(true);
        tabTransiciones.setDisable(false);
    }

    @FXML
    void nuevosEstados(ActionEvent event) {
        tabAsignarVariables.setDisable(false);
        tAAFResultante.setText(elementos.stringAFDN());
        tAAsignarVariables.setText(ConstruirAFDSinLambda.stringNuevosEstadosAsignados());
    }

    @FXML
    void transiciones(ActionEvent event) {
        tabCierreLambda.setDisable(false);
        tACierreLambda.setText(CierreLambda.stringMatriz());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        new LeerER("(0|1.0*.1)*.0*");
    }
}