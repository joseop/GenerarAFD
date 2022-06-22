package com.generarafd.modelo;

import java.util.ArrayList;
import java.util.Objects;

public class CierreLambda {
    private final Elemento elementos = new Elemento();
    private static final ArrayList<Boolean> yaProcesado = new ArrayList<>();
    private final int[][] matrizCierreLambda = new int[elementos.getAceptacion()][elementos.getAceptacion()];

    public CierreLambda() {
        elementos.mostrarER();
        buscarCierreLambda();
        mostrarMatriz();
        new ConstruirAFDSinLambda(matrizCierreLambda);
    }

    private void buscarCierreLambda() {
        crearArrayListBoolean();
        for (int i = 0; i < matrizCierreLambda.length; i++) {
            convertirArrayListAFalso();
            int k = 0;
            matrizCierreLambda[i][k] = i + 1;
            k++;
            for (int j = 0; j < elementos.getSizeER(); j++) {
                if (existeEnFila(elementos.getTransicionER(j).getEstadoOrigen(), i) && !yaProcesado.get(j)) {
                    if (Objects.equals(elementos.getTransicionER(j).getSimboloIngresado(), "λ")) {
                        matrizCierreLambda[i][k] = elementos.getTransicionER(j).getEstadoFinal();
                        yaProcesado.set(j, true);
                        k++;
                        j = 0;
                    }
                }
            }
        }
    }

    private void crearArrayListBoolean() {
        for (int m = 0; m < elementos.getAceptacion(); m++) {
            yaProcesado.add(false);
        }
    }

    private void convertirArrayListAFalso() {
        for (int m = 0; m < elementos.getAceptacion(); m++) {
            yaProcesado.add(m, false);
        }
    }


    public void mostrarMatriz() {
        for (int[] ints : matrizCierreLambda) {
            for (int j = 0; j < matrizCierreLambda.length; j++) {
                if (ints[j] != 0) {
                    System.out.print(ints[j] + " ");
                }
            }
            System.out.println();
        }
    }

    private boolean existeEnFila(int dato, int fila) {
        for (int j = 0; j < matrizCierreLambda.length; j++) {
            if (dato == matrizCierreLambda[fila][j]) {
                return true;
            }
        }
        return false;
    }
}