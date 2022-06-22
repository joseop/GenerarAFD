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
        int aux[] = new int[matrizCierreLambda.length];
        for (int i = 0; i < matrizCierreLambda.length; i++) {
            if (matrizCierreLambda[0][i] != 0) {
                aux[i] = matrizCierreLambda[0][i];
            }
        }
        nuevosEstadosEnVectores.add(aux);
        evaluarCierreLambdaInicial();
        mostrar();
    }

    public void mostrar() {
        System.out.println("\nNuevos Estados");
        for (int i = 0; i < nuevosEstadosEnVectores.size(); i++) {
            for (int j = 0; j < nuevosEstadosEnVectores.get(i).length; j++) {
                if (nuevosEstadosEnVectores.get(i)[j] == 0) {
                    continue;
                }
                System.out.print(nuevosEstadosEnVectores.get(i)[j] + "  ");
            }
            System.out.println("");
        }
    }

    private void evaluarCierreLambdaInicial() {
        int n = 0;
        while (n < nuevosEstadosEnVectores.size()) {//Recorre los estados en vectores
            for (int j = 0; j < elementos.getSizeSimbolos(); j++) {//Recorre los simbolos ingresados en la ER
                int[] vector = new int[matrizCierreLambda.length]; //se crea un vector
                for (int k = 0; k < nuevosEstadosEnVectores.get(n).length; k++) {//Recorre cada elemento del vector de nuevo estado
                    if (nuevosEstadosEnVectores.get(n)[k] != 0) {//no se opera el cero
                        for (int l = 0; l < elementos.getSizeER(); l++) {//Recorre las transiciones de ER
                            if (elementos.getTransicionER(l).getEstadoOrigen() == nuevosEstadosEnVectores.get(n)[k]) {
                                if (elementos.getSimbolo(j).equals(elementos.getTransicionER(l).getSimboloIngresado())) {
                                    agregarEstadoAVector(elementos.getTransicionER(l).getEstadoFinal() - 1, vector);
                                }
                            }
                        }
                    }
                }
                elementos.addTransicionAFD(captarTran(nuevosEstadosEnVectores.get(n), elementos.getSimbolo(j), vector));
                if (!existeEnNuevosEstados(vector)) {
                    agregarNuevoEstadoEnVector(vector);
                }
            }
            n++;
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
        if (!existeCadenaEnEstadosEnString(ei.toString())) {
            estadosEnString.add(ei.toString());
        }
        if (!existeCadenaEnEstadosEnString(ef.toString())) {
            estadosEnString.add(ef.toString());
        }
        return new TransicionAFD(a, ei.toString(), ef.toString(), simbolo);

    }


    private boolean existeEnNuevosEstados(int[] vector) {
        for (int[] estado : nuevosEstadosEnVectores) {
            if (Arrays.equals(vector, estado)) {
                return true;
            }
        }
        return false;
    }

    private boolean existeCadenaEnEstadosEnString(String nuevoEstadoEnString) {
        for (int i = 0; i < estadosEnString.size(); i++) {
            if (estadosEnString.get(i).equals(nuevoEstadoEnString)) {
                return true;
            }
        }
        return false;
    }

    private void agregarNuevoEstadoEnVector(int[] vector) {
        nuevosEstadosEnVectores.add(vector);
    }

    private void agregarEstadoAVector(int estadoFinal, int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] == 0) {
                for (int j = 0; j < matrizCierreLambda[estadoFinal].length; j++) {
                    if (matrizCierreLambda[estadoFinal][j] != 0 && !estaEnVector(vector, matrizCierreLambda[estadoFinal][j])) {
                        vector[i] = matrizCierreLambda[estadoFinal][j];
                        i++;
                    }
                }
                break;
            }
        }
    }

    private boolean estaEnVector(int[] vector, int elemento) {
        for (int i : vector) {
            if (i == elemento) {
                return true;
            }
        }
        return false;
    }

}