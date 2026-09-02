/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolavl;

/**
 *
 * @author amird
 */
public class ArbolAVL {
    public static void main(String[] args) {
        Arbol arbolito = new Arbol();
        int []V = {20, 30, 40, 35, 15, 50, 55, 56, 57, 58};

        for (int valor : V) {
            arbolito.insertar(valor);
        }

        System.out.println("Árbol despues de insertar:");
        arbolito.TreePrinter();

        arbolito.delete(40);
        System.out.println("\nÁrbol despues de eliminar 40:");
        arbolito.TreePrinter();
    }
}
