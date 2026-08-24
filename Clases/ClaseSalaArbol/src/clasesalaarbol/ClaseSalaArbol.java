/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clasesalaarbol;

/**
 *
 * @author amird
 */
public class ClaseSalaArbol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Arbol arbolito = new Arbol();
        arbolito.agregar('M');
        arbolito.agregar('E');
        arbolito.agregar('Z');
        arbolito.agregar('A');
        arbolito.agregar('G');
        arbolito.agregar('P');
        arbolito.agregar('Q');
        arbolito.TreePrinter();
        arbolito.preorden(arbolito.getRaiz());
        System.out.println("");
        arbolito.inorden(arbolito.getRaiz());
        System.out.println("");
        arbolito.posorden(arbolito.getRaiz());
        System.out.println(arbolito.pesar(arbolito.getRaiz()));
        arbolito.preordenIT(arbolito.getRaiz());
        arbolito.inordenIT(arbolito.getRaiz());
        arbolito.posordenIT(arbolito.getRaiz());

    }
    
}
