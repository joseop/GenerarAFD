package com.generarafd.modelo;

import java.util.ArrayList;
import java.util.Objects;

public class CierreLambda {
    private static final Elemento elementos = new Elemento();
    private static final ArrayList<Boolean> yaProcesado = new ArrayList<>();
    private static final int[][] matrizCierreLambda = new int[elementos.getAceptacion()][elementos.getAceptacion()];

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


    public static String stringMatriz() {
        StringBuilder cadena = new StringBuilder();
        int i = 1;
        for (int[] ints : matrizCierreLambda) {
            cadena.append(i).append("λ: ");
            i++;
            for (int j = 0; j < matrizCierreLambda.length; j++) {
                if (ints[j] != 0) {
                    cadena.append(ints[j]).append(" ");
                }
            }
            cadena.append("\n");
        }
        return cadena.toString();
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
