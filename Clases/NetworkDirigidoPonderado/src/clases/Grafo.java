/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.ArrayList;

/**
 * Grafo DIRIGIDO y PONDERADO representado con lista de adyacencia
 * (dentro de cada Vertice, vía Arista) y matriz de adyacencia de pesos
 * como estructura auxiliar para imprimir/consultar en O(1).
 *
 * Diferencias frente a la version no dirigida y sin peso:
 *  - conectarVertices(origen, destino, peso) solo registra el sentido
 *    origen -> destino (antes se registraban ambos sentidos).
 *  - La matriz guarda "double" (el peso de la arista) en vez de 0/1.
 *  - La matriz ya no es necesariamente simetrica.
 *  - La matriz se redimensiona cada vez que se agrega un vertice, para
 *    evitar el ArrayIndexOutOfBoundsException que se producia si se
 *    conectaba antes de agregar todos los vertices.
 *
 * @author dg_amir
 */
public class Grafo {

    /** Sin arista entre dos vertices (para distinguir de un peso 0 real). */
    public static final double SIN_CONEXION = 0.0;

    private ArrayList<Vertice> vertice;
    private double[][] matrizAdyacencia;

    public Grafo() {
        this.vertice = new ArrayList<>();
        this.matrizAdyacencia = new double[0][0];
    }

    public void agregarVertice(Vertice v) {
        this.vertice.add(v);
        redimensionarMatriz();
    }

    /**
     * Conecta origen -> destino con el peso indicado (grafo dirigido).
     * Si tambien se necesita el sentido inverso, se llama de nuevo con
     * los parametros invertidos.
     */
    public void conectarVertices(Vertice origen, Vertice destino, double peso) {
        origen.agregarAdyacente(destino, peso);
        matrizAdyacencia[origen.getId()][destino.getId()] = peso;
    }

    /** Peso de la arista origen -> destino, o SIN_CONEXION si no existe. */
    public double getPeso(Vertice origen, Vertice destino) {
        return matrizAdyacencia[origen.getId()][destino.getId()];
    }

    public boolean existeConexion(Vertice origen, Vertice destino) {
        return matrizAdyacencia[origen.getId()][destino.getId()] != SIN_CONEXION;
    }

    private void redimensionarMatriz() {
        int n = vertice.size();
        double[][] nueva = new double[n][n];
        for (int i = 0; i < matrizAdyacencia.length; i++) {
            System.arraycopy(matrizAdyacencia[i], 0, nueva[i], 0, matrizAdyacencia[i].length);
        }
        this.matrizAdyacencia = nueva;
    }

    public void imprimir() {
        for (Vertice v : vertice) {
            System.out.println(v.toString());
        }
        System.out.println("Matriz de adyacencia (fila = origen, columna = destino):");
        for (int i = 0; i < matrizAdyacencia.length; i++) {
            for (int j = 0; j < matrizAdyacencia.length; j++) {
                System.out.printf("%6.1f", matrizAdyacencia[i][j]);
            }
            System.out.println();
        }
    }
}
