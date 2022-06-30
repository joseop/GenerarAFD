package com.generarafd.modelo;

import java.util.ArrayList;

public class Elemento {
    private static final ArrayList<TransicionAFD> transicionesAFD = new ArrayList<>();
    private static final ArrayList<TransicionER> transicionesER = new ArrayList<>();
    private static final ArrayList<String> simbolos = new ArrayList<>();
    private static final ArrayList<TransicionAFD> AFDVariables = new ArrayList<>();
    private static final ArrayList<TransicionAFD> AFDMinimo = new ArrayList<>();

    public Elemento() {
    }


    //Metodos del AFD
    public void addTransicionAFD(TransicionAFD transicionAFD) {
        transicionesAFD.add(transicionAFD);
    }

    public String stringAFD() {
        String cadena="";
        for (int i = 0; i < getSizeAFD(); i++) {
            cadena=cadena+transicionesAFD.get(i).mostrar()+"\n";
        }
        return cadena;
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
    public String stringER() {
        String cadena="";
        for (int i = 0; i < getSizeER(); i++) {
            cadena=cadena+transicionesER.get(i).mostrar()+"\n";
        }
        return cadena;
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

    public String stringAFDN() {
        String cadena="";
        for (TransicionAFD afdVariable : AFDVariables) {
            cadena=cadena+afdVariable.mostrar()+"\n";
        }
        return cadena;
    }

    public void addAFDN(TransicionAFD transicionAFD) {
        AFDVariables.add(transicionAFD);
    }

    //Metodos del AFDMinimo
    public void addTransicionAFDMinimo(TransicionAFD transicionAFD) {
        AFDMinimo.add(transicionAFD);
    }

    public String stringAFDMinimo() {
        String cadena ="";
        for (int i = 0; i < getSizeAFDMinimo(); i++) {
            cadena=cadena+AFDMinimo.get(i).mostrar()+"\n";
        }
        return cadena;
    }

    public int getSizeAFDMinimo() {
        return AFDMinimo.size();
    }

}
