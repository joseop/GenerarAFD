package com.generarafd;

import com.generarafd.modelo.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class VentanaController {
    ReconocimientoDescendente reconocer;
    @FXML
    private TextArea tAAFDM;
    @FXML
    private TextArea tAAFResultante;
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
    private TextField tFER;

    Elemento elementos = new Elemento();

    public void vaciar() {
        elementos.vaciar();
        ParticionesDeEstado.vaciar();
        ConstruirAFDSinLambda.vaciar();
        CierreLambda.vaciar();
        AFDMinimo.vaciar();
    }

    @FXML
    void cerrar() {
        System.exit(0);
    }

    @FXML
    void convertir() {

        vaciar();
        reconocer = new ReconocimientoDescendente(tFER.getText());
        new LeerER(tFER.getText());
        tATransiciones.setText(elementos.stringER());
        tACierreLambda.setText(CierreLambda.stringMatriz());
        tAEvaluarCierreLambda.setText(elementos.stringAFD());
        tAEstadosResultantes.setText(ConstruirAFDSinLambda.stringNuevosEstados());
        tAAFResultante.setText(elementos.representacionAFD());
        tAGrupos.setText(ParticionesDeEstado.stringGE());
        tAAFDM.setText(elementos.representacionAFDM());
    }

}