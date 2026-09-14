/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 * Representa una arista dirigida y ponderada: un enlace de un vertice
 * origen hacia un vertice destino, con un peso (costo/latencia/distancia).
 *
 * @author dg_amir
 */
public class Arista {

    private Vertice destino;
    private double peso;

    public Arista(Vertice destino, double peso) {
        this.destino = destino;
        this.peso = peso;
    }

    public Vertice getDestino() {
        return destino;
    }

    public void setDestino(Vertice destino) {
        this.destino = destino;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return destino.getNombre() + "(" + peso + ")";
    }
}
