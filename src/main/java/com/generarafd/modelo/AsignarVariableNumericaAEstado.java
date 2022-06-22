package com.generarafd.modelo;


public class AsignarVariableNumericaAEstado {
    private static final ConstruirAFDSinLambda estados = new ConstruirAFDSinLambda();
    private final Elemento elementos = new Elemento();

    public AsignarVariableNumericaAEstado() {
        elementos.mostrarAFD();
        convertirEstadosEnVariablesNumericas();
        elementos.mostrarAFDN();
    }

    public void convertirEstadosEnVariablesNumericas() {
        for (int i = 0; i < elementos.getSizeAFD(); i++) {
            TransicionAFD transicionAFD = new TransicionAFD(elementos.getTransicionAFD(i).isAceptacion(),
                    posicionDelEstado(elementos.getTransicionAFD(i).getEstadoOrigen()),
                    posicionDelEstado(elementos.getTransicionAFD(i).getEstadoFinal()),
                    elementos.getTransicionAFD(i).getSimboloIngresado());
            elementos.addAFDN(transicionAFD);
        }
    }

    private String posicionDelEstado(String estado) {
        for (int i = 0; i < estados.getEstadosssSize(); i++) {
            if (estado.equals(estados.getEstadoss(i))) {
                i++;
                return String.valueOf(i);
            }
        }
        return estado;
    }
}
