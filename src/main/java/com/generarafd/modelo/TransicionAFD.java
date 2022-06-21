package com.generarafd.modelo;

public class TransicionAFD {
    private boolean aceptacion;
    private String estadoOrigen;
    private String estadoFinal;
    private String simboloIngresado;

    public TransicionAFD(boolean aceptacion, String estadoOrigen, String estadoFinal, String simboloIngresado) {
        this.aceptacion = aceptacion;
        this.estadoOrigen = estadoOrigen;
        this.estadoFinal = estadoFinal;
        this.simboloIngresado = simboloIngresado;
    }

    public boolean isAceptacion() {
        return aceptacion;
    }

    public void setAceptacion(boolean aceptacion) {
        this.aceptacion = aceptacion;
    }

    public String getEstadoOrigen() {
        return estadoOrigen;
    }

    public void setEstadoOrigen(String estadoOrigen) {
        this.estadoOrigen = estadoOrigen;
    }

    public String getEstadoFinal() {
        return estadoFinal;
    }

    public void setEstadoFinal(String estadoFinal) {
        this.estadoFinal = estadoFinal;
    }

    public String getSimboloIngresado() {
        return simboloIngresado;
    }

    public void setSimboloIngresado(String simboloIngresado) {
        this.simboloIngresado = simboloIngresado;
    }

    public String mostrar() {
        return getEstadoOrigen() + "  ---  " + getSimboloIngresado() + "  --->  " + getEstadoFinal() + "  =  " + isAceptacion();
    }
}
