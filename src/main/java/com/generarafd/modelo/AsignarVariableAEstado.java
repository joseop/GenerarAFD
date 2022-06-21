package com.generarafd.modelo;


public class AsignarVariableAEstado {
    private static final ConstruirAFDSinLambda estados = new ConstruirAFDSinLambda();
    private static final Elemento elemento = new Elemento();

    public AsignarVariableAEstado() {
        convertirAFD();
    }

    public void convertirAFD() {
        for (int i = 0; i < elemento.getSizeAFD(); i++) {
            TransicionAFD transicionAFD = new TransicionAFD(elemento.getTransicionAFD(i).isAceptacion(),
                    estadoPosicion(elemento.getTransicionAFD(i).getEstadoOrigen()),
                    estadoPosicion(elemento.getTransicionAFD(i).getEstadoFinal()),
                    elemento.getTransicionAFD(i).getSimboloIngresado());
            elemento.addAFDN(transicionAFD);
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
