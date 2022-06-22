package com.generarafd.modelo;

import java.util.ArrayList;

public class ConexionAFDR {
    private final Elemento elementos = new Elemento();
    private static final ArrayList<GrupoEstado> grupoEstados = new ArrayList<>();
    private static final ArrayList<Integer> grupos = new ArrayList<>();
    private static final ArrayList<Integer> apuntador = new ArrayList<>();
    private static final ArrayList<Integer> gruporeferencia = new ArrayList<>();
    GrupoEstado grupoEstado;

    public ConexionAFDR() {
    }

    public void gruposIniciales() {
        grupos.add(0);
        grupos.add(1);
        for (int i = 0; i < elementos.getsizeAFDN(); i++) {
            if (elementos.getTransicionAFDN(i).isAceptacion()) {
                grupoEstados.add(new GrupoEstado(elementos.getTransicionAFDN(i).getEstadoOrigen(), 1));
            } else {
                grupoEstados.add(new GrupoEstado(elementos.getTransicionAFDN(i).getEstadoOrigen(), 0));
            }
        }
        evaluarGrupos();
    }

    public void evaluarGrupos() {
        int grupoR;
        boolean cambio;
        ArrayList<Integer> gruposR = new ArrayList<>();
        ArrayList<Integer> posiciones = new ArrayList<>();
        boolean primero = true;


        for (int k = 0; k < elementos.getSizeSimbolos(); k++) {// Recorre los simbolos
            for (int j = 0; j < grupos.size(); j++) {
                apuntador.clear();
                for (int i = 0; i < grupoEstados.size(); i++) {//Recorre los grupos de los estados
                    if (grupoEstados.get(i).getGrupo() == grupos.get(j)) {
                        apuntador.add(obtenerApuntadorDeEstado(obtenerTransicionAFDN(grupoEstados.get(i).getEstado(), elementos.getSimbolo(k))));
                    }
                }
                procesar(k,j);
            }
        }
    }

    private void procesar(int posicionSimbolo, int posicionGrupo) {
        
    }


    public String obtenerTransicionAFDN(String estadoOrigen, String simboloIngresado) {
        for (int i = 0; i < elementos.getsizeAFDN(); i++) {
            if (elementos.getTransicionAFDN(i).getSimboloIngresado().equals(simboloIngresado) &&
                    elementos.getTransicionAFDN(i).getEstadoOrigen().equals(estadoOrigen)) {
                return elementos.getTransicionAFDN(i).getEstadoFinal();
            }
        }
        return null;
    }

    public int obtenerApuntadorDeEstado(String estado) {
        for (int i = 0; i < grupoEstados.size(); i++) {
            if (grupoEstados.get(i).equals(estado)) {
                return grupoEstados.get(i).getGrupo();
            }
        }
        return 0;
    }
  /*




    private boolean procesar(ArrayList<Integer> gruposR,ArrayList<Integer> posiciones) {
        ArrayList<Integer> gDf = new ArrayList<>();
        gDf.add(gruposR.get(0));
        boolean cambio=false;
        boolean agregado=false;
        for (int i = 1; i < gruposR.size(); i++) {
            if (!existeArr(gruposR.get(i),gDf)) {
                gDf.add(gruposR.get(i));
            }
        }
        if (gDf.size()>1) {
            for (int i = 1; i < gDf.size(); i++) {
                int nuevo = grupoMax()+1;
                for (int j = 0; j < gruposR.size(); j++) {
                    if (gruposR.get(j)==gDf.get(i)) {
                        GRUPOSAFDR.get(posiciones.get(j)).setGrupo(nuevo);
                        cambio=true;
                    }
                }

            }
        }

        return cambio;
    }

    public void nuevoAFDR(){

    }

    public void addTransicion(TransicionAFD transicionAFD) {
        TRANSICIONESAFDR.add(transicionAFD);
    }

    public void mostrarT() {
        for (int i = 0; i < getSize(); i++) {
            System.out.println(TRANSICIONESAFDR.get(i).getEstadoI() + " \t---\t " + TRANSICIONESAFDR.get(i).getEstadoF() + " \t---\t "
                    + TRANSICIONESAFDR.get(i).getSimbolo() + " \t---\t " + TRANSICIONESAFDR.get(i).isAceptacion());
        }
    }

    public int getSize() {
        return TRANSICIONESAFDR.size();
    }

    public TransicionAFD getTransicionAFDR(int i) {
        return TRANSICIONESAFDR.get(i);

    }

    public int grupoMax() {
        int max = 0;
        for (int i = 0; i < GRUPOSAFDR.size(); i++) {
            if (GRUPOSAFDR.get(i).getGrupo() > max) {
                max = GRUPOSAFDR.get(i).getGrupo();
            }
        }
        return max;
    }

    public int grupoPertenece(String est) {
        int gru = -1;
        for (int i = 0; i < GRUPOSAFDR.size(); i++) {
            if (est.equals(GRUPOSAFDR.get(i).getEstado())) {
                gru = GRUPOSAFDR.get(i).getGrupo();
            }
        }
        return gru;
    }

    public String obEstadoF(String est, String simb) {
        String estaF = "";
        for (int i = 0; i < TRANSICIONESAFDR.size(); i++) {
            if (TRANSICIONESAFDR.get(i).getEstadoI().equals(est) && TRANSICIONESAFDR.get(i).getSimbolo().equals(simb)) {
                estaF = TRANSICIONESAFDR.get(i).getEstadoF();
            }
        }
        return estaF;
    }

    public void grupos() {
        for (int i = 0; i < GRUPOSAFDR.size(); i++) {
            if (!existe(GRUPOSAFDR.get(i).getGrupo())) {
                GRUPOS.add(GRUPOSAFDR.get(i).getGrupo());
            }
        }
    }

    private boolean existe(int grupoEstado) {
        for (int i = 0; i < GRUPOS.size(); i++) {
            if (grupoEstado == GRUPOS.get(i)) {
                return true;
            }
        }
        return false;
    }
    private boolean existeArr(int x,ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            if (x == arr.get(i)) {
                return true;
            }
        }
        return false;
    }
    public void mostrar() {
        for (int i = 0; i < getSize(); i++) {
        }
    }*/

}
