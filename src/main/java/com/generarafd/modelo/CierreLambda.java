package com.generarafd.modelo;

import java.util.ArrayList;
import java.util.Objects;

public class CierreLambda {
    private final Elemento elemento = new Elemento();
    private static final ArrayList<Boolean> yaProcesado = new ArrayList<>();
    private final int[][] matrizCierreLambda = new int[elemento.getAceptacion()][elemento.getAceptacion()];

    public CierreLambda() {
        buscarCierreLambda();
        new ConstruirAFDSinLambda(matrizCierreLambda);
    }

    private void buscarCierreLambda() {
        crearArrayListBoolean();
        for (int i = 0; i < matrizCierreLambda.length; i++) {
            convertirArrayListAFalso();
            int k = 0;
            matrizCierreLambda[i][k] = i + 1;
            k++;
            for (int j = 0; j < elemento.getSizeER(); j++) {
                if (existeEnFila(elemento.getTransicionER(j).getEstadoOrigen(), i) && !yaProcesado.get(j)) {
                    if (Objects.equals(elemento.getTransicionER(j).getSimboloIngresado(), "λ")) {
                        matrizCierreLambda[i][k] = elemento.getTransicionER(j).getEstadoFinal();
                        yaProcesado.set(j, true);
                        k++;
                        j = 0;
                    }
                }
            }
        }
    }

    private void crearArrayListBoolean() {
        for (int m = 0; m < elemento.getAceptacion(); m++) {
            yaProcesado.add(false);
        }
    }

    private void convertirArrayListAFalso() {
        for (int m = 0; m < elemento.getAceptacion(); m++) {
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
