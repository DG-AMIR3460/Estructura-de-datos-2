/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesalaarbol;

import java.util.Stack;

/**
 * @author amird 
 */
public class Arbol {
    
    private Nodo raiz;

    public Nodo getRaiz() {
        return raiz;
        
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public Arbol() {
        this.raiz = null;
    } 
    
    public void agregar (char valor){
        Nodo newnodo = new Nodo(valor);
        if(this.raiz == null){
            this.raiz = newnodo;
        }
        else{
            agregar_recursivo(this.raiz, newnodo);
        }
        
    } 
    
    public void agregar_recursivo(Nodo nodo, Nodo newnodo){
        if (newnodo.getDato()<nodo.getDato()){
            if (nodo.getIzquierdo()== null){
                nodo.setIzquierdo(newnodo);
            }
            else{
                agregar_recursivo(nodo.getIzquierdo(), newnodo);
            }
        }else{
            if (nodo.getDerecho()== null){
                nodo.setDerecho(newnodo);
            }
            else{
                agregar_recursivo(nodo.getDerecho(), newnodo);
            }
        }
    }
    
    public void imprimir ( Nodo n1 ,int nivel ){
        if ( n1 != null ){
            imprimir ( n1.getDerecho() , nivel+1 );
            for (int i = 0; i < nivel; i++){
                System.out.print ("      ");
            }
            System.out.println(n1.getDato() );
            imprimir (n1.getIzquierdo() , nivel+1 );
           
        }
    }
    
    public void preorden ( Nodo nodo){
        if (nodo == null){
        return;
        }
        System.out.print(nodo.getDato()+"-");
        preorden(nodo.getIzquierdo());
        preorden(nodo.getDerecho());
    }
    
    public void inorden ( Nodo nodo){
        if (nodo == null){
        return;}
        inorden(nodo.getIzquierdo());
        System.out.print(nodo.getDato() + "-");
        
        inorden(nodo.getDerecho());
        }
    
    public void posorden ( Nodo nodo){
        if (nodo == null){return;}
        posorden(nodo.getIzquierdo());
        posorden(nodo.getDerecho());
        System.out.print(nodo.getDato() + "-");
        
}
    
    public int pesar(Nodo nodo) {
            if (nodo == null) {
                return 0;
            }
            return 1 + pesar(nodo.getIzquierdo()) + pesar(nodo.getDerecho());
        }
    
    public void impila(Stack pila, Nodo p){
        pila.push(p);
        }
    
    public Nodo campila(Stack<Nodo> pila){
    if (!pila.isEmpty()){
        return pila.pop();
        
    }
    return null;
    } 
    
    public static int getcol(int h) {
        if (h == 1) {
            return 1;
        }
        return getcol(h - 1) + getcol(h - 1) + 1;
    }
    
    public static void printTree(char[][] M, Nodo root, int col, int row, int height) {
        if (root == null) {
            return;
        }
        M[row][col] = root.getDato();
        printTree(M, root.getIzquierdo(), col - (int) Math.pow(2, height - 2), row + 1, height - 1);
        printTree(M, root.getDerecho(), col + (int) Math.pow(2, height - 2), row + 1, height - 1);
    }

    public void TreePrinter() {
        int h = alturaArbol(this.raiz);
        int col = getcol(h);
        char[][] M = new char[h][col];
        printTree(M, this.raiz, col / 2, 0, h);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < col; j++) {
                if (M[i][j] == 0) {
                    System.out.print("  ");
                } else {
                    System.out.print(M[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    
    public static int alturaArbol(Nodo n1) {
        if (n1 == null) {
            return 0;
        }
        return Math.max(alturaArbol(n1.getIzquierdo()), alturaArbol(n1.getDerecho())) + 1;
    }
       
    public void preordenIT( Nodo raiz){
       Stack <Nodo> pila = new Stack <>();
       Nodo p = raiz;
       
       do {
           if ( p != null){
               System.out.print(p.getDato());
               impila(pila,p);
               p = p.getIzquierdo();
           } else {
               p = campila(pila);
               p = p.getDerecho();}
           
       }while ( !pila.isEmpty()  || p != null);
       System.out.println("");
   }
   
    public void inordenIT( Nodo raiz){
       Stack <Nodo> pila = new Stack <>();
       Nodo p = raiz;
       
       do {
           if ( p != null){
               impila(pila,p);
               p = p.getIzquierdo();
           } else {
               p = campila(pila);
               System.out.print(p.getDato());
               p = p.getDerecho();}
           
       }while ( !pila.isEmpty()  || p != null);
       System.out.println("");
   }
   
    public void posordenIT( Nodo raiz){
       Stack <Nodo> pila = new Stack <>();
       Nodo p = raiz;
       Nodo visitado = null;

       do {
           if ( p != null){
               impila(pila,p);
               p = p.getIzquierdo();

           } else {
               Nodo tope = pila.peek();
               if ( tope.getDerecho() != null && tope.getDerecho() != visitado){
                   p = tope.getDerecho();
               } else {
                   System.out.print(tope.getDato());
                   visitado = campila(pila);
               }
           }


       }while ( !pila.isEmpty()  || p != null);
       System.out.println("");
   }
      
   
 
}

