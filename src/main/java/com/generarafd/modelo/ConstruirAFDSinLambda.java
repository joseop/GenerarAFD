package com.generarafd.modelo;

import java.util.ArrayList;
import java.util.Arrays;

public class ConstruirAFDSinLambda {

    private final Elemento elementos = new Elemento();
    static final ArrayList<int[]> nuevosEstadosEnVectores = new ArrayList<>();
    static final ArrayList<String> estadosEnString = new ArrayList<>();
    private int[][] matrizCierreLambda;

    public ConstruirAFDSinLambda() {
    }

    public ConstruirAFDSinLambda(int[][] matriz) {
        this.matrizCierreLambda = matriz;
        inicial();
        new AsignarVariableAEstado();
    }

    public int getEstadosSize() {
        return nuevosEstadosEnVectores.size();
    }

    public int[] getEstado(int i) {
        return nuevosEstadosEnVectores.get(i);
    }

    public int getEstadosssSize() {
        return estadosEnString.size();
    }

    public String getEstadoss(int i) {
        return estadosEnString.get(i);
    }
    
    private void inicial() {
        for (int i = 0; i < matrizCierreLambda.length; i++) {
           nuevosEstadosEnVectores.add(matrizCierreLambda[i]);
        }
        evaluarI();
    }

    private void evaluarI() {
        int ir = 0;
        while (ir < nuevosEstadosEnVectores.size()) {//Recorre los estados en vectores
            for (int j = 0; j < elementos.getSizeSimbolos(); j++) {//Recorre los simbolos ingresados en la ER
                int[] simb = new int[matrizCierreLambda.length]; //se crea un vector
                for (int k = 0; k < nuevosEstadosEnVectores.get(ir).length; k++) {//Recorre cada elemento del vector de nuevo estado
                    if (nuevosEstadosEnVectores.get(ir)[k] != 0) {//no se opera el cero
                        for (int l = 0; l < elementos.getSizeER(); l++) {//Recorre las transiciones
                            if (elementos.getTransicionER(l).getEstadoOrigen() == nuevosEstadosEnVectores.get(ir)[k]) {
                                if (elementos.getSimbolo(j).equals(elementos.getTransicionER(l).getSimboloIngresado())) {
                                    agregarE(elementos.getTransicionER(l).getEstadoFinal() - 1, simb);
                                }
                            }
                        }
                    }
                }
                elementos.addTransicionAFD(captarTran(nuevosEstadosEnVectores.get(ir), elementos.getSimbolo(j), simb));
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
                if (elementos.getAceptacion() == anInt) {
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
        for (int[] estado : nuevosEstadosEnVectores) {
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
        nuevosEstadosEnVectores.add(simb);
    }

    private void agregarE(int estadoFinal, int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] == 0) {
                for (int j = 0; j < matrizCierreLambda[estadoFinal].length; j++) {
                    if (matrizCierreLambda[estadoFinal][j] != 0 && !repetido(vector, matrizCierreLambda[estadoFinal][j])) {
                        vector[i] = matrizCierreLambda[estadoFinal][j];
                        i++;
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
