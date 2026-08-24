/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pilas;

import java.util.Stack;

/**
 *
 * @author Scastanedad
 */
public class Pilas {

    public static void main(String[] args) {
        Stack <Integer> pila = new Stack <>();
        
        int [] Vector = {1,2,3,4,5};
        for (int i: Vector){
            pila.push(i);
        }
        System.out.println(pila.peek());
        // Mientras la pila no este vacia
        while( !pila.isEmpty()){
            //Elimino elemento por elemento de la pila
            int b = pila.pop();
            System.out.println("El elemento eliminado de la pila fue: " + b);
            if ( !pila.isEmpty()){
                System.out.println("El elemento que esta en la cima es "+ pila.peek());
            } else {
                System.out.println("La pila fue vaciada correctamente.");
            }
        }


    }


    
     
    
}
