package com.generarafd.modelo;

public class TransicionAFD {
    private final boolean aceptacion;
    private final String estadoOrigen;
    private final String estadoFinal;
    private final String simboloIngresado;

    public TransicionAFD(boolean aceptacion, String estadoOrigen, String estadoFinal, String simboloIngresado) {
        this.aceptacion = aceptacion;
        this.estadoOrigen = estadoOrigen;
        this.estadoFinal = estadoFinal;
        this.simboloIngresado = simboloIngresado;
    }

    public boolean isAceptacion() {
        return aceptacion;
    }

    public String getEstadoOrigen() {
        return estadoOrigen;
    }

    public String getEstadoFinal() {
        return estadoFinal;
    }

    public String getSimboloIngresado() {
        return simboloIngresado;
    }

    public String mostrar() {
        return getEstadoOrigen() + "  ---  " + getSimboloIngresado() + "  --->  " + getEstadoFinal() + "  =  " + isAceptacion();
    }

    public String mostrar2() {
        return getEstadoOrigen() + " {" + getSimboloIngresado() + "}  =  " + getEstadoFinal();
    }
}
