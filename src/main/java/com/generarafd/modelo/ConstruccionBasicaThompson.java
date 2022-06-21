package com.generarafd.modelo;

import java.util.ArrayList;

public class ConstruccionBasicaThompson {
    private final String nulo = "λ";

    public ConstruccionBasicaThompson() {
    }

    public ArrayList<TransicionER> expresionOR(String a, String b, int estadoBase) {
        ArrayList<TransicionER> transiciones = new ArrayList<>();
        TransicionER transicionER;

        transicionER = new TransicionER(estadoBase, estadoBase + 1, nulo);
        transiciones.add(transicionER);

        transicionER = new TransicionER(estadoBase + 1, estadoBase + 2, a);
        transiciones.add(transicionER);

        transicionER = new TransicionER(estadoBase, estadoBase + 3, nulo);
        transiciones.add(transicionER);

        transicionER = new TransicionER(estadoBase + 3, estadoBase + 4, b);
        transiciones.add(transicionER);

        transicionER = new TransicionER(estadoBase + 4, estadoBase + 5, nulo);
        transiciones.add(transicionER);

        transicionER = new TransicionER(estadoBase + 2, estadoBase + 5, nulo);
        transiciones.add(transicionER);

        return transiciones;
    }

    public ArrayList<TransicionER> expresionAND(String a, String b, int estadoBase) {
        ArrayList<TransicionER> transiciones = new ArrayList<>();
        TransicionER transicionER;

        transicionER = new TransicionER(estadoBase, estadoBase + 1, a);
        transiciones.add(transicionER);

        transicionER = new TransicionER(estadoBase + 1, estadoBase + 2, b);
        transiciones.add(transicionER);

        return transiciones;
    }

    public ArrayList<TransicionER> superIndiceMas(String a, int estadoBase) {
        ArrayList<TransicionER> transiciones = new ArrayList<>();
        TransicionER transicionER;

        transicionER = new TransicionER(estadoBase, estadoBase + 1, nulo);
        transiciones.add(transicionER);

        transicionER = new TransicionER(estadoBase + 1, estadoBase + 2, a);
        transiciones.add(transicionER);

        transicionER = new TransicionER(estadoBase + 2, estadoBase + 1, nulo);
        transiciones.add(transicionER);

        transicionER = new TransicionER(estadoBase + 2, estadoBase + 3, nulo);
        transiciones.add(transicionER);

        return transiciones;
    }

    public ArrayList<TransicionER> superIndiceAsterisco(String a, int estadoBase) {
        ArrayList<TransicionER> transiciones = new ArrayList<>();
        TransicionER transicionER;

        transicionER = new TransicionER(estadoBase, estadoBase + 1, nulo);
        transiciones.add(transicionER);

        transicionER = new TransicionER(estadoBase, estadoBase + 3, nulo);
        transiciones.add(transicionER);

        transicionER = new TransicionER(estadoBase + 1, estadoBase + 2, a);
        transiciones.add(transicionER);

        transicionER = new TransicionER(estadoBase + 2, estadoBase + 1, nulo);
        transiciones.add(transicionER);

        transicionER = new TransicionER(estadoBase + 2, estadoBase + 3, nulo);
        transiciones.add(transicionER);

        return transiciones;
    }

    public TransicionER reescribirExpresion(String a, int estadoBase) {
        TransicionER transicionER;
        transicionER = new TransicionER(estadoBase, estadoBase + 1, a);
        return transicionER;
    }
}
