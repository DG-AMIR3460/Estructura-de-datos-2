/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.ArrayList;

/**
 *
 * @author dg_amir
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<String> Equipo = new ArrayList<>();
        Equipo.add("Junior");
        Equipo.add("Millonarios");
        Equipo.add("Real Cartagena");
        Equipo.add("Pereira");
        Equipo.add("Deportivo Pasto");
        
        System.out.println(Equipo);
        System.out.println(Equipo.get(3));
        System.out.println(Equipo.size());
        Equipo.set(3, "Deportivo Tapita");
        System.out.println(Equipo);
    }
}
