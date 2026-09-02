/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolavl;

/**
 *
 * @author amird
 */
public class Nodo {
    private Nodo izq;
    private Nodo der;
    private int valor;
    private int height;

    public Nodo(int valor) {
        this.izq = null;
        this.der = null;
        this.valor = valor;
        this.height = 1;
    }

    public Nodo getIzq() {
        return izq;
    }
    
    public int getHeight() {
        return height;
    }
    
    public void setHeight(int h) {
        this.height = h;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public Nodo getDer() {
        return der;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    
    
}
