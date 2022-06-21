package com.generarafd.modelo;

import java.util.Objects;
import java.util.Stack;

public class LeerER {

    private final String expresionRegular;
    private final Elemento elemento = new Elemento();
    private final ConstruccionBasicaThompson operacion = new ConstruccionBasicaThompson();

    public LeerER(String expresionRegular) {
        this.expresionRegular = expresionRegular;
        iniciarConexion();
    }

    private void iniciarConexion() {
        elemento.addTransicionER(operacion.reescribirExpresion(expresionRegular, 1));
        conectarTransiciones();
        capturarSimbolosDeLaER();
        new CierreLambda();
    }

    private void conectarTransiciones() {
        int i = 0;
        while (i < elemento.getSizeER()) {
            if (elemento.getTransicionER(i).getSimboloIngresado().length() > 1) {
                nuevaTransicion(elemento.getTransicionER(i).getEstadoOrigen(), elemento.getTransicionER(i).getSimboloIngresado());
                elemento.borrarER(i);
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
                elemento.incrementarER(estadoBase, 4);
                elemento.addTransicionesER(operacion.expresionOR(expresionReg.substring(0, s), substring, estadoBase));
            }
            if ((expresionReg.charAt(s) == '.')) {
                elemento.incrementarER(estadoBase, 1);
                elemento.addTransicionesER(operacion.expresionAND(expresionReg.substring(0, s), substring, estadoBase));
            }
        } else {
            if (expresionReg.charAt(0) == '(') {
                String substring = expresionReg.substring(1, expresionReg.length() - 2);
                if ((expresionReg.charAt(expresionReg.length() - 1) == '*')) {
                    elemento.incrementarER(estadoBase, 2);
                    elemento.addTransicionesER(operacion.superIndiceAsterisco(substring, estadoBase));

                } else if ((expresionReg.charAt(expresionReg.length() - 1) == '+')) {
                    elemento.incrementarER(estadoBase, 2);
                    elemento.addTransicionesER(operacion.superIndiceMas(substring, estadoBase));

                } else if ((expresionReg.charAt(expresionReg.length() - 1) == ')')) {
                    elemento.addTransicionER(operacion.reescribirExpresion(expresionReg.substring(1, expresionReg.length() - 1), estadoBase));
                }
            } else {
                if ((expresionReg.charAt(expresionReg.length() - 1) == '*')) {
                    elemento.incrementarER(estadoBase, 2);
                    elemento.addTransicionesER(operacion.superIndiceAsterisco(expresionReg.substring(0, expresionReg.length() - 1), estadoBase));

                } else if ((expresionReg.charAt(expresionReg.length() - 1) == '+')) {
                    elemento.incrementarER(estadoBase, 2);
                    elemento.addTransicionesER(operacion.superIndiceMas(expresionReg.substring(0, expresionReg.length() - 1), estadoBase));
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
        for (int i = 0; i < elemento.getSizeER(); i++) {
            String nulo = "λ";
            if (!Objects.equals(elemento.getTransicionER(i).getSimboloIngresado(), nulo) && !existeEnSimbolos(elemento.getTransicionER(i).getSimboloIngresado())) {
                elemento.addSimbolo(elemento.getTransicionER(i).getSimboloIngresado());
            }
        }
    }

    private boolean existeEnSimbolos(String simbolo) {
        for (int i = 0; i < elemento.getSizeSimbolos(); i++) {
            if (elemento.getSimbolo(i).equals(simbolo)) {
                return true;
            }
        }
        return false;
    }
}
