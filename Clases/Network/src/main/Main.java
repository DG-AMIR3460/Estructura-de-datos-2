/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import clases.Grafo;
import clases.Vertice;

/**
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
        
        red.AgregarVertice(PC1);
        red.AgregarVertice(PC2);
        red.AgregarVertice(PC3);
        red.AgregarVertice(PC4);
        red.AgregarVertice(PC5);
        
        red.ConectarVertices(PC1, PC2);
        red.ConectarVertices(PC1, PC5);
        red.ConectarVertices(PC3, PC4);
        red.ConectarVertices(PC5, PC4);
        red.ConectarVertices(PC5, PC2);
        
        red.Imprimir();
    }
}
