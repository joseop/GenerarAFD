package com.generarafd.modelo;

import java.util.ArrayList;

public class AFDMinimo {
    Elemento elementos = new Elemento();
    private static ArrayList<GrupoEstado> grupoEstados = new ArrayList<>();
    private static ArrayList<Integer> grupos = new ArrayList<>();
    private static final ArrayList<String> nuevosEstados = new ArrayList<>();

    public AFDMinimo(ArrayList<GrupoEstado> grupoEstados, ArrayList<Integer> grupos) {
        AFDMinimo.grupoEstados = grupoEstados;
        AFDMinimo.grupos = grupos;
        nuevosEstadosAFDM();
    }

    private void convertirGruposAAFDMinimo() {
        String estadoFinal;
        boolean aceptacion;
        for (int i = 0; i <nuevosEstados.size() ; i++) {
            for (int k = 0; k < elementos.getSizeSimbolos(); k++) {
                estadoFinal = buscarEstadoFinal(nuevosEstados.get(i), elementos.getSimbolo(k));
                aceptacion = esAceptacion(nuevosEstados.get(i));
                elementos.addTransicionAFDMinimo(new TransicionAFD(aceptacion, nuevosEstados.get(i), estadoFinal, elementos.getSimbolo(k)));
            }
        }
    }

    private void nuevosEstadosAFDM() {
        StringBuilder nuevoEstado;
        for (Integer grupo : grupos) {
            nuevoEstado = new StringBuilder();
            for (GrupoEstado grupoEstado : grupoEstados) {
                if (grupo.equals(grupoEstado.getGrupo())) {
                    nuevoEstado.append(grupoEstado.getEstado());
                }
            }
            nuevosEstados.add(nuevoEstado.toString());
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
        StringBuilder estadoFinal = new StringBuilder();
        for (int j = 0; j < estadoOrigen.length(); j++) {
            for (int i = 0; i < elementos.getsizeAFDN(); i++) {
                if (estadoOrigen.substring(j, j + 1).equals(elementos.getTransicionAFDN(i).getEstadoOrigen())
                        && simbolo.equals(elementos.getTransicionAFDN(i).getSimboloIngresado())) {
                    estadoFinal.append(elementos.getTransicionAFDN(i).getEstadoFinal());
                }
            }
        }
        for (int i = 0; i < estadoFinal.length(); i++) {
            for (String nuevosEstado : nuevosEstados) {
                for (int k = 0; k < nuevosEstado.length(); k++) {
                    if (estadoFinal.substring(i, i + 1).equals(nuevosEstado.substring(k, k + 1))) {
                        return nuevosEstado;
                    }
                }
            }
        }
        return estadoFinal.toString();
    }
}
