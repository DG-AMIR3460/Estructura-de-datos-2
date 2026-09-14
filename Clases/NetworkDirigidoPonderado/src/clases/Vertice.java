/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Vertice de un grafo dirigido y ponderado. "adyacentes" son los
 * sucesores de este vertice: las aristas que SALEN de el, cada una con
 * su propio peso.
 *
 * @author dg_amir
 */
public class Vertice {

    private String nombre;
    private ArrayList<Arista> adyacentes;
    private int id;
    private static int cid;

    public Vertice(String nombre) {
        this.nombre = nombre;
        this.adyacentes = new ArrayList<>();
        this.id = cid++;
    }

    /**
     * Agrega una arista dirigida y ponderada de este vertice hacia
     * "destino". No agrega la arista inversa: en un grafo dirigido
     * cada sentido se agrega por separado si hace falta.
     */
    public void agregarAdyacente(Vertice destino, double peso) {
        this.adyacentes.add(new Arista(destino, peso));
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve una vista de solo lectura de las aristas salientes, para
     * evitar que se modifiquen por fuera del grafo y se rompa la
     * sincronia con la matriz de adyacencia.
     */
    public ArrayList<Arista> getAdyacentes() {
        return new ArrayList<>(Collections.unmodifiableList(adyacentes));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getCid() {
        return cid;
    }

    public static void setCid(int cid) {
        Vertice.cid = cid;
    }

    @Override
    public String toString() {
        return "Vertice{"
                + "nombre='" + nombre + '\''
                + ", adyacentes="
                + adyacentes.stream()
                        .map(a -> a.getDestino().getNombre() + "(" + a.getPeso() + ")")
                        .collect(Collectors.joining(", "))
                + '}';
    }
}
