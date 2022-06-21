package com.generarafd.modelo;

import java.util.ArrayList;

public class ConexionAFDR {
    private static final ArrayList<TransicionAFD> TRANSICIONESAFDR = new ArrayList<>();
    private static final ArrayList<GrupoEstado> GRUPOSAFDR = new ArrayList<>();
    private static final ArrayList<Integer> GRUPOS = new ArrayList<>();
    //private final ConexionAFD conexionAFD = new ConexionAFD();
    GrupoEstado grupoEstado;
  /*  CovertirEstadosANumeros conexionAFD = new CovertirEstadosANumeros();
    Simbolo simbolos = new Simbolo();

    public ConexionAFDR() {
        for (int i = 0; i < conexionAFD.getsize(); i++) {
            TRANSICIONESAFDR.add(conexionAFD.getTransicionAFDN(i));
        }
    }

    public void apartarGrupos() {
        int[] x0 = new int[TRANSICIONESAFDR.size()];
        int[] x1 = new int[TRANSICIONESAFDR.size()];
        for (int i = 0; i < TRANSICIONESAFDR.size(); i++) {
            if (TRANSICIONESAFDR.get(i).isAceptacion()) {
                GRUPOSAFDR.add(new GrupoEstado(TRANSICIONESAFDR.get(i).getEstadoI(), 1));
            } else {
                GRUPOSAFDR.add(new GrupoEstado(TRANSICIONESAFDR.get(i).getEstadoI(), 0));
            }
        }
    }

    public void evaluarGrupos() {
        int grupoR;
        boolean cambio;
        ArrayList<Integer> gruposR = new ArrayList<>();
        ArrayList<Integer> posiciones = new ArrayList<>();
        boolean primero = true;
        for (int i = 0; i < GRUPOS.size(); i++) {//Recorre los i grupos
            for (int k = 0; k < simbolos.getSizeSimbolos(); k++) {// Recorre los simbolos
                gruposR.clear();
                for (int j = 0; j < GRUPOSAFDR.size(); j++) {//Recorre los Estados asociados a un grupo
                    if (GRUPOSAFDR.get(j).getGrupo() == GRUPOS.get(i)) {
                        grupoR = grupoPertenece(obEstadoF(GRUPOSAFDR.get(j).getEstado(), simbolos.getSimbolo(k)));
                        gruposR.add(grupoR);
                        posiciones.add(j);
                        cambio = procesar(gruposR,posiciones);
                        if (cambio) {
                            i = 0;
                            cambio = false;
                        }
                    }
                }
            }
        }
    }

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
