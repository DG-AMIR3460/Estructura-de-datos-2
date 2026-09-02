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
        arbolito.agregar(8);
        arbolito.agregar(3);
        arbolito.agregar(1);
        arbolito.agregar(20);
        arbolito.agregar(10);
        arbolito.agregar(5);
        arbolito.agregar(4);
        System.out.println("Imprimir árbol (rotado)");
        arbolito.imprimir(arbolito.getRaiz(), 0);

        System.out.println("Recorrido Preorden");
        arbolito.preorden(arbolito.getRaiz());

        System.out.println("Recorrido Inorden ");
        arbolito.inorden(arbolito.getRaiz());

        System.out.println("Recorrido Posorden ");
        arbolito.posorden(arbolito.getRaiz());

        System.out.println(" Preorden Iterativo ");
        arbolito.preordenIter(arbolito.getRaiz());

        System.out.println(" Posorden Iterativo ");
        arbolito.posordenIter(arbolito.getRaiz());

        System.out.println("Inorden Iterativo ");
        arbolito.inordenIter(arbolito.getRaiz());

        System.out.println("Peso del arbol ");
        System.out.println("Peso: " + arbolito.pesoArbol(arbolito.getRaiz()));

        System.out.println("Altura del arbol");
        System.out.println("Altura: " + Arbol.alturaArbol(arbolito.getRaiz()));

        System.out.println("Cantidad de hojas");
        System.out.println("Hojas: " + arbolito.contarHojas(arbolito.getRaiz()));

        System.out.println("TreePrinter (formato matricial)");
        arbolito.TreePrinter();

        System.out.println("Eliminar el 3 (nodo con dos hijos)");
        arbolito.eliminar(3);
        System.out.println("Recorrido Inorden tras eliminar");
        arbolito.inorden(arbolito.getRaiz());
        System.out.println();
        System.out.println("Peso tras eliminar: " + arbolito.pesoArbol(arbolito.getRaiz()));
        System.out.println("Hojas tras eliminar: " + arbolito.contarHojas(arbolito.getRaiz()));
        System.out.println("TreePrinter tras eliminar");
        arbolito.TreePrinter();
    }

}
