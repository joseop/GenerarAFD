package com.generarafd.modelo;

import java.util.ArrayList;

public class AFDMinimo {
    Elemento elementos = new Elemento();
    private static ArrayList<GrupoEstado> grupoEstados = new ArrayList<>();
    private static ArrayList<Integer> grupos = new ArrayList<>();
    private static ArrayList<String> nuevosEstados = new ArrayList<>();

    public AFDMinimo(ArrayList<GrupoEstado> grupoEstados, ArrayList<Integer> grupos) {
        this.grupoEstados = grupoEstados;
        this.grupos = grupos;
        nuevosEstadosAFDM();
        elementos.mostrarAFDMinimo();
    }

    private void convertirGruposAAFDMinimoO() {
        String estadoOrigen, estadoFinal;
        boolean aceptacion;
        for (int i = 0; i < grupos.size(); i++) {
            aceptacion = false;
            estadoOrigen = "";
            estadoFinal = "";
            for (int j = 0; j < grupoEstados.size(); j++) {
                if (grupos.get(i).equals(grupoEstados.get(j).getGrupo())) {
                    estadoOrigen = estadoOrigen + grupoEstados.get(j).getEstado();
                }
            }
            for (int k = 0; k < elementos.getSizeSimbolos(); k++) {
                estadoFinal = buscarEstadoFinal(estadoOrigen, elementos.getSimbolo(k));
                aceptacion = esAceptacion(estadoOrigen);
                elementos.addTransicionAFDMinimo(new TransicionAFD(aceptacion, estadoOrigen, estadoFinal, elementos.getSimbolo(k)));
            }
        }
    }

    private void convertirGruposAAFDMinimo() {
        String estadoFinal;
        boolean aceptacion;
        for (int i = 0; i < nuevosEstados.size(); i++) {
            for (int k = 0; k < elementos.getSizeSimbolos(); k++) {
                estadoFinal = buscarEstadoFinal(nuevosEstados.get(i), elementos.getSimbolo(k));
                aceptacion = esAceptacion(nuevosEstados.get(i));
                elementos.addTransicionAFDMinimo(new TransicionAFD(aceptacion, nuevosEstados.get(i), estadoFinal, elementos.getSimbolo(k)));
            }
        }
    }

    private void nuevosEstadosAFDM() {
        String nuevoEstado;
        for (int i = 0; i < grupos.size(); i++) {
            nuevoEstado = "";
            for (int j = 0; j < grupoEstados.size(); j++) {
                if (grupos.get(i).equals(grupoEstados.get(j).getGrupo())) {
                    nuevoEstado = nuevoEstado + grupoEstados.get(j).getEstado();
                }
            }
            nuevosEstados.add(nuevoEstado);
        }
        convertirGruposAAFDMinimo();
    }

    private boolean esAceptacion(String estadoOrigen) {
        for (int j = 0; j < estadoOrigen.length(); j++) {
            for (int i = 0; i < elementos.getsizeAFDN(); i++) {
                if (estadoOrigen.substring(j, j + 1).equals(elementos.getTransicionAFDN(i).getEstadoOrigen())) {
                    if (elementos.getTransicionAFDN(i).isAceptacion()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private String buscarEstadoFinal(String estadoOrigen, String simbolo) {
        String estadoFinal = "";
        for (int j = 0; j < estadoOrigen.length(); j++) {
            for (int i = 0; i < elementos.getsizeAFDN(); i++) {
                if (estadoOrigen.substring(j, j + 1).equals(elementos.getTransicionAFDN(i).getEstadoOrigen())
                        && simbolo.equals(elementos.getTransicionAFDN(i).getSimboloIngresado())) {
                    estadoFinal = estadoFinal + elementos.getTransicionAFDN(i).getEstadoFinal();
                }
            }
        }
        for (int i = 0; i < estadoFinal.length(); i++) {
            for (int j = 0; j < nuevosEstados.size(); j++) {
                for (int k = 0; k < nuevosEstados.get(j).length(); k++) {
                    if (estadoFinal.substring(i,i+1).equals(nuevosEstados.get(j).substring(k,k+1))) {
                        estadoFinal=nuevosEstados.get(j);
                        return nuevosEstados.get(j);
                    }
                }
            }
        }
        return estadoFinal;
    }

    public GrupoEstado getGrupoEstado(int i) {
        return grupoEstados.get(i);
    }
}
