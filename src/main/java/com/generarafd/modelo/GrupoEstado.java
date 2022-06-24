package com.generarafd.modelo;

public class GrupoEstado {
    private String estado;
    private int grupo;

    public GrupoEstado(String estado, int grupo) {
        this.estado = estado;
        this.grupo = grupo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

}
