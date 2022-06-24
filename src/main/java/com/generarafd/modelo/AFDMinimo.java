package com.generarafd.modelo;

import java.util.ArrayList;

public class AFDMinimo {
    Elemento elementos = new Elemento();
    private static ArrayList<GrupoEstado> grupoEstados = new ArrayList<>();
    private static ArrayList<Integer> grupos = new ArrayList<>();

    public AFDMinimo(ArrayList<GrupoEstado> grupoEstados, ArrayList<Integer> grupos) {
        this.grupoEstados = grupoEstados;
        this.grupos = grupos;
        convertirGruposAAFDMinimo();
    }

    private void convertirGruposAAFDMinimo() {
        String estadoOrigen = "", estadoFinal = "", simbolo = "";
        boolean aceptacion;
        for (int i = 0; i < grupos.size(); i++) {
            aceptacion = false;
            for (int j = 0; j < grupoEstados.size(); j++) {
                if (grupos.get(i).equals(grupoEstados.get(j).getGrupo())) {
                    estadoOrigen=estadoOrigen+grupoEstados.get(j).getEstado();
                }
            }
            for (int k = 0; k < elementos.getSizeSimbolos(); k++) {
                estadoFinal=buscarEstadoFinal(estadoOrigen,elementos.getSimbolo(k));
                aceptacion=esAceptacion(estadoOrigen);
                elementos.addTransicionAFDMinimo(new TransicionAFD(aceptacion, estadoOrigen, estadoFinal, elementos.getSimbolo(k)));
            }

        }
    }

    private boolean esAceptacion(String estadoOrigen) {
        boolean aceptacion=false;

        return false;
    }

    private String buscarEstadoFinal(String estadoOrigen, String simbolo) {
        String estadoFinal ="";
        
        return estadoFinal;
    }

    public GrupoEstado getGrupoEstado(int i) {
        return grupoEstados.get(i);
    }
}
