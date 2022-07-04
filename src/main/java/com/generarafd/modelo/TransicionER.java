package com.generarafd.modelo;

public class TransicionER {
    private int estadoOrigen;
    private int estadoFinal;
    private final String simboloIngresado;

    public TransicionER(int estadoOrigen, int estadoFinal, String simboloIngresado) {
        this.estadoOrigen = estadoOrigen;
        this.estadoFinal = estadoFinal;
        this.simboloIngresado = simboloIngresado;
    }

    public int getEstadoOrigen() {
        return estadoOrigen;
    }

    public void setEstadoOrigen(int estadoOrigen) {
        this.estadoOrigen = estadoOrigen;
    }

    public int getEstadoFinal() {
        return estadoFinal;
    }

    public void setEstadoFinal(int estadoFinal) {
        this.estadoFinal = estadoFinal;
    }

    public String getSimboloIngresado() {
        return simboloIngresado;
    }

    public String mostrar() {
        return getEstadoOrigen() + "  --  " + getSimboloIngresado() + "  -->  " + getEstadoFinal();
    }
}
