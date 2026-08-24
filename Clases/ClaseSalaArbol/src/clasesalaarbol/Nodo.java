/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesalaarbol;

/**
 * @author amird
 */
public class Nodo {
    //Atributo
    private char dato;
    private Nodo izquierdo;
    private Nodo derecho;
    //Metodos

    public Nodo(char dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
        
        
    }

    public void setDato(char dato) {
        this.dato = dato;
    }

    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }

    public char getDato() {
        return dato;
    }

    public Nodo getIzquierdo() {
        return izquierdo;
    }

    public Nodo getDerecho() {
        return derecho;
    }
    
    
}
