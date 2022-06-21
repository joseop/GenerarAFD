package com.generarafd.modelo;

import java.util.ArrayList;
import java.util.Arrays;

public class ConstruirAFDSinLambda {

    private final Elemento elemento = new Elemento();
    static final ArrayList<int[]> estadosEnVectorDeInt = new ArrayList<>();
    static final ArrayList<String> estadosEnString = new ArrayList<>();
    private int[][] matrizCierreLambda;
    private int[] estadoEnVector;


    public ConstruirAFDSinLambda(int[][] matriz) {
        this.matrizCierreLambda = matriz;
        estadoEnVector = new int[matriz.length];
        inicial();
        new AsignarVariableAEstado();
    }
    public ConstruirAFDSinLambda() {
    }

    public int getEstadosSize() {
        return estadosEnVectorDeInt.size();
    }

    public int[] getEstado(int i) {
        return estadosEnVectorDeInt.get(i);
    }

    public int getEstadosssSize() {
        return estadosEnString.size();
    }

    public String getEstadoss(int i) {
        return estadosEnString.get(i);
    }
    
    private void inicial() {
        for (int i = 0; i < matrizCierreLambda.length; i++) {
            if (matrizCierreLambda[0][i] != 0) {
                estadoEnVector[i] = matrizCierreLambda[0][i];
            }
        }
        estadosEnVectorDeInt.add(estadoEnVector);
        evaluarI();
    }

    private void evaluarI() {
        int ir = 0;
        while (ir < estadosEnVectorDeInt.size()) {//Recorre los nuevos estados
            for (int j = 0; j < elemento.getSizeSimbolos(); j++) {//Recorre los simbolos ingresados en la ER
                int[] simb = new int[matrizCierreLambda.length];
                for (int k = 0; k < estadosEnVectorDeInt.get(ir).length; k++) {//Recorre cada Caracter del estado
                    if (estadosEnVectorDeInt.get(ir)[k] != 0) {
                        for (int l = 0; l < elemento.getSizeER(); l++) {//Recorre las transiciones
                            if (elemento.getTransicionER(l).getEstadoOrigen() == estadosEnVectorDeInt.get(ir)[k]) {
                                if (elemento.getSimbolo(j).equals(elemento.getTransicionER(l).getSimboloIngresado())) {
                                    agregarE(elemento.getTransicionER(l).getEstadoFinal() - 1, simb);
                                }
                            }
                        }
                    }
                }
                elemento.addTransicionAFD(captarTran(estadosEnVectorDeInt.get(ir), elemento.getSimbolo(j), simb));
                if (!exis(simb)) {
                    agrE(simb);
                }
            }
            ir++;
        }
    }

    private TransicionAFD captarTran(int[] ints, String simbolo, int[] simb) {
        StringBuilder ei = new StringBuilder();
        StringBuilder ef = new StringBuilder();
        boolean a = false;
        for (int anInt : ints) {
            if (anInt != 0) {
                ei.append("  ").append(anInt);
                if (elemento.getAceptacion() == anInt) {
                    a = true;
                }
            }
        }
        for (int j : simb) {
            if (j != 0) {
                ef.append("  ").append(j);
            }
        }
        if (!exis2(ei.toString())) {
            estadosEnString.add(ei.toString());
        }
        if (!exis2(ef.toString())) {
            estadosEnString.add(ef.toString());
        }
        return new TransicionAFD(a, ei.toString(), ef.toString(), simbolo);
    }


    private boolean exis(int[] ints) {
        for (int[] estado : estadosEnVectorDeInt) {
            if (Arrays.equals(ints, estado)) {
                return true;
            }
        }
        return false;
    }

    private boolean exis2(String ints) {
        for (int i = 0; i < estadosEnString.size(); i++) {
            if (estadosEnString.get(i).equals(ints)) {
                return true;
            }
        }
        return false;
    }

    private void agrE(int[] simb) {
        estadosEnVectorDeInt.add(simb);
    }

    private void agregarE(int j, int[] x) {
        for (int h = 0; h < x.length; h++) {
            if (x[h] == 0) {
                for (int i = 0; i < matrizCierreLambda[j].length; i++) {
                    if (matrizCierreLambda[j][i] != 0 && !repetido(x, matrizCierreLambda[j][i])) {
                        x[h] = matrizCierreLambda[j][i];
                        h++;
                    }
                }
                break;
            }
        }
    }

    private boolean repetido(int[] vector, int elemento) {
        for (int i : vector) {
            if (i == elemento) {
                return true;
            }
        }
        return false;
    }

}
