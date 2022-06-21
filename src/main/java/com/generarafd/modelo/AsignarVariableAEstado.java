package com.generarafd.modelo;


public class AsignarVariableAEstado {
    private static final ConstruirAFDSinLambda estados = new ConstruirAFDSinLambda();
    private final Elemento elementos = new Elemento();

    public AsignarVariableAEstado() {
        convertirAFD();
    }

    public void convertirAFD() {
        for (int i = 0; i < elementos.getSizeAFD(); i++) {
            TransicionAFD transicionAFD = new TransicionAFD(elementos.getTransicionAFD(i).isAceptacion(),
                    estadoPosicion(elementos.getTransicionAFD(i).getEstadoOrigen()),
                    estadoPosicion(elementos.getTransicionAFD(i).getEstadoFinal()),
                    elementos.getTransicionAFD(i).getSimboloIngresado());
            elementos.addAFDN(transicionAFD);
        }
    }

    private String estadoPosicion(String estado) {
        for (int i = 0; i < estados.getEstadosssSize(); i++) {
            if (estado.equals(estados.getEstadoss(i))) {
                i++;
                return String.valueOf(i);
            }
        }
        return estado;
    }
}
