package com.generarafd.modelo;

import java.util.Objects;
import java.util.Stack;

public class LeerER {

    private final String expresionRegular;
    private final Elemento elementos = new Elemento();
    private final ConstruccionBasicaThompson operacion = new ConstruccionBasicaThompson();

    public LeerER(String expresionRegular) {
        this.expresionRegular = expresionRegular;
        iniciarConexion();
    }

    private void iniciarConexion() {
        elementos.addTransicionER(operacion.reescribirExpresion(expresionRegular, 1));
        conectarTransiciones();
        capturarSimbolosDeLaER();
        new CierreLambda();
    }

    private void conectarTransiciones() {
        int i = 0;
        while (i < elementos.getSizeER()) {
            if (elementos.getTransicionER(i).getSimboloIngresado().length() > 1) {
                nuevaTransicion(elementos.getTransicionER(i).getEstadoOrigen(), elementos.getTransicionER(i).getSimboloIngresado());
                elementos.borrarER(i);
                i = 0;
            } else {
                i++;
            }
        }
    }

    private void nuevaTransicion(int estadoBase, String expresionReg) {
        int s = buscarDondeDividirLaER(expresionReg);
        if (s != 0) {
            String substring = expresionReg.substring(s + 1);
            if ((expresionReg.charAt(s) == '|')) {
                elementos.incrementarER(estadoBase, 4);
                elementos.addTransicionesER(operacion.expresionOR(expresionReg.substring(0, s), substring, estadoBase));
            }
            if ((expresionReg.charAt(s) == '.')) {
                elementos.incrementarER(estadoBase, 1);
                elementos.addTransicionesER(operacion.expresionAND(expresionReg.substring(0, s), substring, estadoBase));
            }
        } else {
            if (expresionReg.charAt(0) == '(') {
                String substring = expresionReg.substring(1, expresionReg.length() - 2);
                if ((expresionReg.charAt(expresionReg.length() - 1) == '*')) {
                    elementos.incrementarER(estadoBase, 2);
                    elementos.addTransicionesER(operacion.superIndiceAsterisco(substring, estadoBase));

                } else if ((expresionReg.charAt(expresionReg.length() - 1) == '+')) {
                    elementos.incrementarER(estadoBase, 2);
                    elementos.addTransicionesER(operacion.superIndiceMas(substring, estadoBase));

                } else if ((expresionReg.charAt(expresionReg.length() - 1) == ')')) {
                    elementos.addTransicionER(operacion.reescribirExpresion(expresionReg.substring(1, expresionReg.length() - 1), estadoBase));
                }
            } else {
                if ((expresionReg.charAt(expresionReg.length() - 1) == '*')) {
                    elementos.incrementarER(estadoBase, 2);
                    elementos.addTransicionesER(operacion.superIndiceAsterisco(expresionReg.substring(0, expresionReg.length() - 1), estadoBase));

                } else if ((expresionReg.charAt(expresionReg.length() - 1) == '+')) {
                    elementos.incrementarER(estadoBase, 2);
                    elementos.addTransicionesER(operacion.superIndiceMas(expresionReg.substring(0, expresionReg.length() - 1), estadoBase));
                }
            }
        }
    }

    private int buscarDondeDividirLaER(String simbolo) {
        Stack<Boolean> parentesis = new Stack<>();
        int separador = 0;
        for (int i = 0; i < simbolo.length(); i++) {
            if (simbolo.charAt(i) == '(') {
                parentesis.push(true);
            } else if (simbolo.charAt(i) == ')') {
                if (!parentesis.isEmpty()) {
                    parentesis.pop();
                }
            }
            if ((simbolo.charAt(i) == '|') && (parentesis.isEmpty())) {
                if (simbolo.charAt(separador) != '|') {
                    separador = i;
                }
            } else if ((simbolo.charAt(i) == '.') && (parentesis.isEmpty())) {
                if (simbolo.charAt(separador) != '.' && simbolo.charAt(separador) != '|') {
                    separador = i;
                }
            }
        }
        return separador;
    }

    private void capturarSimbolosDeLaER() {
        for (int i = 0; i < elementos.getSizeER(); i++) {
            String nulo = "λ";
            if (!Objects.equals(elementos.getTransicionER(i).getSimboloIngresado(), nulo) && !existeEnSimbolos(elementos.getTransicionER(i).getSimboloIngresado())) {
                elementos.addSimbolo(elementos.getTransicionER(i).getSimboloIngresado());
            }
        }
    }

    private boolean existeEnSimbolos(String simbolo) {
        for (int i = 0; i < elementos.getSizeSimbolos(); i++) {
            if (elementos.getSimbolo(i).equals(simbolo)) {
                return true;
            }
        }
        return false;
    }
}
