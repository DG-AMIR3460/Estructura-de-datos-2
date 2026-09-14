/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import clases.Grafo;
import clases.Vertice;

/**
 * Mismo escenario de red que el proyecto Network, pero modelado como
 * grafo dirigido y ponderado: cada conexion tiene un sentido y un peso
 * (por ejemplo, latencia/costo del enlace en ms).
 *
 * @author dg_amir
 */
public class Main {

    public static void main(String[] args) {
        Grafo red = new Grafo();
        Vertice PC1 = new Vertice("PC1");
        Vertice PC2 = new Vertice("PC2");
        Vertice PC3 = new Vertice("PC3");
        Vertice PC4 = new Vertice("PC4");
        Vertice PC5 = new Vertice("PC5");

        red.agregarVertice(PC1);
        red.agregarVertice(PC2);
        red.agregarVertice(PC3);
        red.agregarVertice(PC4);
        red.agregarVertice(PC5);

        // origen -> destino, peso = latencia del enlace en ms
        red.conectarVertices(PC1, PC2, 4.0);
        red.conectarVertices(PC1, PC5, 1.0);
        red.conectarVertices(PC3, PC4, 2.5);
        red.conectarVertices(PC5, PC4, 3.0);
        red.conectarVertices(PC5, PC2, 1.5);

        red.imprimir();
    }
}
