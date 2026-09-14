/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author dg_amir
 */
public class Grafo {

    private ArrayList<Vertice> vertice;
    private int[][] matrizadyacencia;

    public Grafo() {
        this.vertice = new ArrayList<>();
    }

    public void ConectarVertices(Vertice vertice1, Vertice vertice2) {
        if (matrizadyacencia == null) {
            this.matrizadyacencia = new int[vertice.size()][vertice.size()];
        }

        vertice1.AgregarAdyacentes(vertice2);
        vertice2.AgregarAdyacentes(vertice1);

        matrizadyacencia[vertice1.getId()][vertice2.getId()] = 1;
        matrizadyacencia[vertice2.getId()][vertice1.getId()] = 1;
    }

    public void AgregarVertice(Vertice vertice) {
        this.vertice.add(vertice);
    }

    public void Imprimir() {
        for (Vertice vertice1 : vertice) {
            System.out.println(vertice1.toString());
        }
        for (int i = 0; i < matrizadyacencia.length; i++) {
            for (int j = 0; j < matrizadyacencia.length; j++) {
                System.out.print(matrizadyacencia[i][j]);
                
            }
            System.out.println("");
        }
    }

}
