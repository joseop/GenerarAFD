package com.generarafd.modelo;

import javax.swing.JOptionPane;

import java.awt.*;
import java.util.Stack;

public class ReconocimientoDescendente {
    private String eR;
    private Stack<String> pila = new Stack<>();
    private String simbolo;
    private int x = 0;
    private boolean salir = false, correcto=false;

    //Constructor
    public ReconocimientoDescendente(String er) {
        this.eR = er + "-";
        leerEr();
    }

    public void leerEr() {
        pila.push("λ");//Indicador de pila vacia
        pila.push("A");//no Terminar inicial de la G
        simbolo = String.valueOf(eR.charAt(x));
        while (!salir) {
            switch (pila.lastElement()) {
                case "A":
                    switch (simbolo) {
                        case "|":salir=true;
                            break;
                        case ".":salir=true;
                            break;
                        case "(":
                        case "1":
                        case "0":
                            remplazar("BC");
                            break;
                        case ")":salir=true;
                            break;
                        case "*":salir=true;
                            break;
                        case "+":salir=true;
                            break;
                        case "-":salir=true;
                            break;
                    }
                    break;
                case "B":
                    switch (simbolo) {
                        case "|":
                            remplazar("BC");
                            avance();
                            break;
                        case ".":salir=true;
                            break;
                        case "(":salir=true;
                            break;
                        case ")":
                        case "-":
                            desapilar();
                            break;
                        case "0":salir=true;
                            break;
                        case "1":salir=true;
                            break;
                        case "*":salir=true;
                            break;
                        case "+":salir=true;
                            break;
                    }
                    break;
                case "C":
                    switch (simbolo) {
                        case "|":salir=true;
                            break;
                        case ".":salir=true;
                            break;
                        case "(":
                        case "0":
                        case "1":
                            remplazar("ED");
                            break;
                        case ")":salir=true;
                            break;
                        case "*":salir=true;
                            break;
                        case "+":salir=true;
                            break;
                        case "-":salir=true;
                            break;
                    }
                    break;
                case "D":
                    switch (simbolo) {
                        case "|":salir=true;
                            break;
                        case ".":salir=true;
                            break;
                        case "(":
                        case "1":
                        case "0":
                            remplazar("GF");
                            break;
                        case ")":salir=true;
                            break;
                        case "*":salir=true;
                            break;
                        case "+":salir=true;
                            break;
                        case "-":salir=true;
                            break;
                    }
                    break;
                case "E":
                    switch (simbolo) {
                        case "|":
                        case "-":
                        case ")":
                            desapilar();
                            break;
                        case ".":
                            remplazar("ED");
                            avance();
                            break;
                        case "(":salir=true;
                            break;
                        case "0":salir=true;
                            break;
                        case "1":salir=true;
                            break;
                        case "*":salir=true;
                            break;
                        case "+":salir=true;
                            break;
                    }
                    break;
                case "F":
                    switch (simbolo) {
                        case "|":salir=true;
                            break;
                        case ".":salir=true;
                            break;
                        case "(":
                            remplazar(")A");
                            avance();
                            break;
                        case ")":salir=true;
                            break;
                        case "0":
                        case "1":
                            desapilar();
                            avance();
                            break;
                        case "*":salir=true;
                            break;
                        case "+":salir=true;
                            break;
                        case "-":salir=true;
                            break;
                    }
                    break;
                case "G":
                    switch (simbolo) {
                        case "|":
                        case ".":
                        case ")":
                        case "-":
                            desapilar();
                            break;
                        case "(":salir=true;
                            break;
                        case "0":salir=true;
                            break;
                        case "1":salir=true;
                            break;
                        case "*":
                        case "+":
                            desapilar();
                            avance();
                            break;
                    }
                    break;
                case ")":
                    switch (simbolo) {
                        case "|":salir=true;
                            break;
                        case ".":salir=true;
                            break;
                        case "(":salir=true;
                            break;
                        case ")":
                            desapilar();
                            avance();
                            break;
                        case "0":salir=true;
                            break;
                        case "1":salir=true;
                            break;
                        case "*":salir=true;
                            break;
                        case "+":salir=true;
                            break;
                        case "-":salir=true;
                            break;
                    }
                    break;
                case "λ":
                    switch (simbolo) {
                        case "|":salir=true;
                            break;
                        case ".":salir=true;
                            break;
                        case "(":salir=true;
                            break;
                        case ")":salir=true;
                            break;
                        case "0":salir=true;
                            break;
                        case "1":salir=true;
                            break;
                        case "*":salir=true;
                            break;
                        case "+":salir=true;
                            break;
                        case "-":
                            correcto=true;
                            salir = true;
                            break;
                    }
                    break;
            }
        }
    }

    //Este metodo nos permitira avanzar en la ER
    private void avance() {
        x++;
        simbolo = String.valueOf(eR.charAt(x));
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

    //Este metodo se usara para retornar un boolean en la que indicara si la expresion es correc
    public boolean isCorrecto() {
        return correcto;
    }
}
