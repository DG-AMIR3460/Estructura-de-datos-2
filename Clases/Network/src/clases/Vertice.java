/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *
 * @author dg_amir
 */
public class Vertice {

    private String nombre;
    private ArrayList<Vertice> adyacentes;
    private int id;
    private static int cid;

    public Vertice(String nombre) {
        this.nombre = nombre;
        this.adyacentes = new ArrayList<>();
        this.id = cid++;
    }

    public void AgregarAdyacentes(Vertice vertice) {
        this.adyacentes.add(vertice);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Vertice> getAdyacentes() {
        return adyacentes;
    }

    public void setAdyacentes(ArrayList<Vertice> adyacentes) {
        this.adyacentes = adyacentes;
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

    public String toString() {
        return "Vertice{"
                + "nombre='" + nombre + '\''
                + ",adyacentes="
                + adyacentes.stream().map(Vertice::getNombre).collect(Collectors.joining(", "))
                + '}';
    }

}
