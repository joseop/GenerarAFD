package com.generarafd.modelo;

import java.util.Stack;

public class ReconocimientoDescendente {
    private String eR;
    private Stack<String> pila = new Stack<>();
    private String simbolo;
    private int x = 0;

    //Constructor
    public ReconocimientoDescendente(String er) {
        this.eR = er + "-";
        leerEr();
        pila.push("λ");//Indicador de pila vacia
        pila.push("A");//no Terminar inicial de la G
    }

    public void leerEr() {
        simbolo = String.valueOf(eR.charAt(x));
        while (!finSecuencia(simbolo)) {
            switch (pila.lastElement()) {
                case "A":
                    switch (simbolo) {
                        case "|":
                            break;
                        case ".":
                            break;
                        case "(":
                            break;
                        case ")":
                            break;
                        case "0":
                            break;
                        case "1":
                            break;
                        case "*":
                            break;
                        case "+":
                            break;
                        case "-":
                            break;
                    }
                    break;
                case "B":
                    switch (simbolo) {
                        case "|":
                            break;
                        case ".":
                            break;
                        case "(":
                            break;
                        case ")":
                            break;
                        case "0":
                            break;
                        case "1":
                            break;
                        case "*":
                            break;
                        case "+":
                            break;
                        case "-":
                            break;
                    }
                    break;
                case "C":
                    switch (simbolo) {
                        case "|":
                            break;
                        case ".":
                            break;
                        case "(":
                            break;
                        case ")":
                            break;
                        case "0":
                            break;
                        case "1":
                            break;
                        case "*":
                            break;
                        case "+":
                            break;
                        case "-":
                            break;
                    }
                    break;
                case "D":
                    switch (simbolo) {
                        case "|":
                            break;
                        case ".":
                            break;
                        case "(":
                            break;
                        case ")":
                            break;
                        case "0":
                            break;
                        case "1":
                            break;
                        case "*":
                            break;
                        case "+":
                            break;
                        case "-":
                            break;
                    }
                    break;
                case "E":
                    switch (simbolo) {
                        case "|":
                            break;
                        case ".":
                            break;
                        case "(":
                            break;
                        case ")":
                            break;
                        case "0":
                            break;
                        case "1":
                            break;
                        case "*":
                            break;
                        case "+":
                            break;
                        case "-":
                            break;
                    }
                    break;
                case "F":
                    switch (simbolo) {
                        case "|":
                            break;
                        case ".":
                            break;
                        case "(":
                            break;
                        case ")":
                            break;
                        case "0":
                            break;
                        case "1":
                            break;
                        case "*":
                            break;
                        case "+":
                            break;
                        case "-":
                            break;
                    }
                    break;
                case "G":
                    switch (simbolo) {
                        case "|":
                            break;
                        case ".":
                            break;
                        case "(":
                            break;
                        case ")":
                            break;
                        case "0":
                            break;
                        case "1":
                            break;
                        case "*":
                            break;
                        case "+":
                            break;
                        case "-":
                            break;
                    }
                    break;
                case ")":
                    switch (simbolo) {
                        case "|":
                            break;
                        case ".":
                            break;
                        case "(":
                            break;
                        case ")":
                            break;
                        case "0":
                            break;
                        case "1":
                            break;
                        case "*":
                            break;
                        case "+":
                            break;
                        case "-":
                            break;
                    }
                    break;
                case "λ":
                    switch (simbolo) {
                        case "|":
                            break;
                        case ".":
                            break;
                        case "(":
                            break;
                        case ")":
                            break;
                        case "0":
                            break;
                        case "1":
                            break;
                        case "*":
                            break;
                        case "+":
                            break;
                        case "-":
                            break;
                    }
                    break;


            }
            avance();
        }
    }

    //Este metodo nos permitira avanzar en la ER
    private void avance() {
        x++;
        simbolo = String.valueOf(eR.charAt(x));
    }

    //Este metodo nos ayudara a controlar el ciclo y el recorrido
    private boolean finSecuencia(String simb) {
        return simb.equals("-");
    }

    private void desapilar() {
        pila.pop();
    }

    //Este metodo se usa para remplazar el elemento de la pila por los nuevos simbolos
    private void remplazar(String cadena) {
        pila.pop();
        for (int i = 0; i < cadena.length(); i++) {
            pila.push(String.valueOf(cadena.charAt(i)));
        }
    }


}
