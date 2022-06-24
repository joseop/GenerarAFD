package com.generarafd.modelo;

import java.util.ArrayList;

public class ConexionAFDR {
    private final Elemento elementos = new Elemento();
    private static final ArrayList<GrupoEstado> grupoEstados = new ArrayList<>();
    private static final ArrayList<Integer> grupos = new ArrayList<>();
    private static final ArrayList<Integer> apuntadorAGrupo = new ArrayList<>();
    private static final ArrayList<Integer> posicion = new ArrayList<>();
    private static final ArrayList<Integer> gruporeferencia = new ArrayList<>();
    GrupoEstado grupoEstado;

    public ConexionAFDR() {
        gruposIniciales();
        elementos.getTransicionAFDN(9).setEstadoFinal("5");
    }

    public void gruposIniciales() {
        grupos.add(0);
        grupos.add(1);
        for (int i = 0; i < elementos.getsizeAFDN(); i++) {
            if (!yaExiste(elementos.getTransicionAFDN(i).getEstadoOrigen())) {


                if (elementos.getTransicionAFDN(i).isAceptacion()) {
                    grupoEstados.add(new GrupoEstado(elementos.getTransicionAFDN(i).getEstadoOrigen(), 1));
                } else {
                    grupoEstados.add(new GrupoEstado(elementos.getTransicionAFDN(i).getEstadoOrigen(), 0));
                }
            }
        }
        mostrarGE();
        evaluarGrupos();
    }

    private boolean yaExiste(String estadoOrigen) {
        for (int i = 0; i < grupoEstados.size(); i++) {
            if (grupoEstados.get(i).getEstado().equals(estadoOrigen)) {
                return true;
            }
        }
        return false;
    }

    public void evaluarGrupos() {
        boolean cambio = false;
        for (int k = 0; k < elementos.getSizeSimbolos(); k++) {// Recorre los simbolos
            for (int j = 0; j < grupos.size(); j++) {
                apuntadorAGrupo.clear();
                posicion.clear();
                for (int i = 0; i < grupoEstados.size(); i++) {//Recorre los grupos de los estados

                    if (grupoEstados.get(i).getGrupo() == grupos.get(j)) {
                        apuntadorAGrupo.add(obtenerApuntadorDeEstado(obtenerTransicionAFDN(grupoEstados.get(i).getEstado(), elementos.getSimbolo(k))));
                        posicion.add(i);
                    }
                }
                cambio = procesar();
                if (cambio) {
                    k = 0;
                    cambio = false;
                }
            }
        }
        mostrarGE();
    }

    private boolean procesar() {
        boolean cambio = false;
        gruporeferencia.clear();
        gruporeferencia.add(apuntadorAGrupo.get(0));
        for (int i = 1; i < apuntadorAGrupo.size(); i++) {
            for (int j = 0; j < gruporeferencia.size(); j++) {
                if (apuntadorAGrupo.get(i) == apuntadorAGrupo.get(j)) {
                    break;
                } else {
                    gruporeferencia.add(grupoMax() + 1);
                    grupoEstados.get(posicion.get(i)).setGrupo(grupoMax() + 1);
                    grupos.add(grupoMax() + 1);
                    cambio = true;
                }
            }
        }
        return cambio;
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

    public void mostrarGE() {
        System.out.println("--");
        for (int i = 0; i < grupoEstados.size(); i++) {
            System.out.println(grupoEstados.get(i).getGrupo() + " - " + grupoEstados.get(i).getEstado());
        }
    }

    public int obtenerApuntadorDeEstado(String estado) {
        for (int i = 0; i < grupoEstados.size(); i++) {
            if (grupoEstados.get(i).equals(estado)) {
                return grupoEstados.get(i).getGrupo();
            }
        }
        return 0;
    }

    public int grupoMax() {
        int max = 0;
        for (int i = 0; i < grupoEstados.size(); i++) {
            if (grupoEstados.get(i).getGrupo() >= max) {
                max = grupoEstados.get(i).getGrupo();
                System.out.println("Maximo es "+max);
            }
        }
        return max;

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
