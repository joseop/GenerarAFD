package com.generarafd.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Elemento {
    private static final ArrayList<TransicionAFD> transicionesAFD = new ArrayList<>();
    private static final ArrayList<TransicionER> transicionesER = new ArrayList<>();
    private static final ArrayList<String> simbolos = new ArrayList<>();
    private static final ArrayList<TransicionAFD> AFDVariables = new ArrayList<>();

    public Elemento() {
    }


    //Metodos del AFD
    public void addTransicionAFD(TransicionAFD transicionAFD) {
        transicionesAFD.add(transicionAFD);
    }

    public void mostrarAFD() {
        for (int i = 0; i < getSizeAFD(); i++) {
            System.out.println(transicionesAFD.get(i).mostrar());
        }
    }

    public int getSizeAFD() {
        return transicionesAFD.size();
    }

    public TransicionAFD getTransicionAFD(int i) {
        return transicionesAFD.get(i);
    }


    //Metodos de la ER
    public TransicionER getTransicionER(int i) {
        return transicionesER.get(i);
    }

    public void addTransicionER(TransicionER transicionER) {
        transicionesER.add(transicionER);
    }

    public void ordenarTransicionesER() {
        transicionesER.sort((p1, p2) -> Integer.valueOf(p1.getEstadoOrigen()).compareTo(Integer.valueOf(p2.getEstadoOrigen())));
    }


    public void addTransicionesER(ArrayList<TransicionER> transicionERS) {
        transicionesER.addAll(transicionERS);
    }

    public void incrementarER(int base, int valorAumentar) {
        for (TransicionER transicionER : transicionesER) {
            if (transicionER.getEstadoOrigen() > base) {
                transicionER.setEstadoOrigen(transicionER.getEstadoOrigen() + valorAumentar);
            }
            if (transicionER.getEstadoFinal() > base) {
                transicionER.setEstadoFinal(transicionER.getEstadoFinal() + valorAumentar);
            }
        }
    }

    public void borrarER(int i) {
        transicionesER.remove(i);
    }

    public void mostrarER() {
        for (int i = 0; i < getSizeER(); i++) {
            System.out.println(transicionesER.get(i).mostrar());
        }
    }

    public int getSizeER() {
        return transicionesER.size();
    }

    public int getAceptacion() {
        int aceptacion = 0;
        for (int i = 0; i < transicionesER.size(); i++) {
            if (getTransicionER(i).getEstadoFinal() > aceptacion) {
                aceptacion = getTransicionER(i).getEstadoFinal();
            }
        }
        return aceptacion;
    }


    //Metodos de los simbolos de la ER
    public String getSimbolo(int i) {
        return simbolos.get(i);
    }

    public void addSimbolo(String s) {
        simbolos.add(s);
    }

    public int getSizeSimbolos() {
        return simbolos.size();
    }


    //Metodos del AFD en variables
    public TransicionAFD getTransicionAFDN(int i) {
        return AFDVariables.get(i);
    }

    public int getsizeAFDN() {
        return AFDVariables.size();
    }

    public void mostrarAFDN() {
        for (TransicionAFD afdVariable : AFDVariables) {
            System.out.println(afdVariable.mostrar());
        }
    }

    public void addAFDN(TransicionAFD transicionAFD) {
        AFDVariables.add(transicionAFD);
    }
}
