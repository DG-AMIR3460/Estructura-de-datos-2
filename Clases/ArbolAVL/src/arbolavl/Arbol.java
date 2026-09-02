/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arbolavl;

/**
 *
 * @author amird
 */
public class Arbol {

    private Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }
    // metodos

    public void imprimir(Nodo n1, int nivel) {
        if (n1 != null) {
            imprimir(n1.getDer(), nivel + 1);
            for (int i = 0; i < nivel; i++) {
                System.out.print("      ");
            }
            System.out.println(n1.getValor());
            imprimir(n1.getIzq(), nivel + 1);

        }
    }

    public static void printTree(int[][] M, Nodo root, int col, int row, int height) {
        if (root == null) {
            return;
        }
        M[row][col] = root.getValor();
        printTree(M, root.getIzq(), col - (int) Math.pow(2, height - 2), row + 1, height - 1);
        printTree(M, root.getDer(), col + (int) Math.pow(2, height - 2), row + 1, height - 1);
    }

    public void TreePrinter() {
        int h = alturaArbol(this.raiz);
        int col = getcol(h);
        int[][] M = new int[h][col];
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

    public static int getcol(int h) {
        if (h == 1) {
            return 1;
        }
        return getcol(h - 1) + getcol(h - 1) + 1;
    }

    public static int alturaArbol(Nodo n1) {
        if (n1 == null) {
            return 0;
        }
        return Math.max(alturaArbol(n1.getIzq()), alturaArbol(n1.getDer())) + 1;
    }

    public static int alturanodo(Nodo n1) {
        if (n1 == null) {
            return 0;
        }
        return n1.getHeight();
    }

    public int factorEq(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return alturanodo(nodo.getIzq()) - alturanodo(nodo.getDer());
    }

    public Nodo rotacion_der(Nodo Y) {
        Nodo X = Y.getIzq();
        Nodo temp = X.getDer();
        X.setDer(Y);
        Y.setIzq(temp);
        Y.setHeight(Math.max(alturanodo(Y.getIzq()), alturanodo(Y.getDer())) + 1);
        X.setHeight(Math.max(alturanodo(X.getIzq()), alturanodo(X.getDer())) + 1);
        return X;
    }

    public Nodo rotacion_izq(Nodo X) {
        Nodo Y = X.getDer();
        Nodo temp = Y.getIzq();
        Y.setIzq(X);
        X.setDer(temp);
        X.setHeight(Math.max(alturanodo(X.getIzq()), alturanodo(X.getDer())) + 1);
        Y.setHeight(Math.max(alturanodo(Y.getIzq()), alturanodo(Y.getDer())) + 1);
        return Y;
    }
    
    public void insertar(int valor){
        this.raiz = insertar(raiz, valor);
    }
    public Nodo insertar(Nodo nodo, int valor){
        if(nodo == null){
            return new Nodo(valor);
        } else if (valor<nodo.getValor()){
            nodo.setIzq(insertar(nodo.getIzq(),valor));
        } else if (valor>nodo.getValor()) {
            nodo.setDer(insertar(nodo.getDer(),valor));
        } else {
            return nodo;  
        } 
        nodo.setHeight(1+Math.max(alturanodo(nodo.getIzq()), alturanodo(nodo.getDer())));
       int fe = factorEq(nodo);
       if(fe>1 & factorEq(nodo.getIzq())>=0){
           System.out.println("rotacion derecha");
           return rotacion_der(nodo);
       }
       if(fe>1 & factorEq(nodo.getIzq())<0){
           System.out.println("rotacion izquierda-derecha");
           nodo.setIzq(rotacion_izq(nodo.getIzq()));
           return rotacion_der(nodo);
       }
       if(fe<-1 & factorEq(nodo.getDer())<=0){
           System.out.println("rotacion izquierda");
           return rotacion_izq(nodo);
       }
       if(fe<-1 & factorEq(nodo.getDer())>0){
           System.out.println("rotacion derecha-izquierda");
           nodo.setDer(rotacion_der(nodo.getDer()));
           return rotacion_izq(nodo);
       }
        return nodo;
    }

    public void delete(int valor) {
        this.raiz = delete(raiz, valor);
    }

    public Nodo delete(Nodo nodo, int valor) {
        if (nodo == null) {
            return null;
        }

        if (valor < nodo.getValor()) {
            nodo.setIzq(delete(nodo.getIzq(), valor));
        } else if (valor > nodo.getValor()) {
            nodo.setDer(delete(nodo.getDer(), valor));
        } else {
            if (nodo.getIzq() == null || nodo.getDer() == null) {
                Nodo temp = (nodo.getIzq() != null) ? nodo.getIzq() : nodo.getDer();
                nodo = temp;
            } else {
                int sucesor = minValue(nodo.getDer());
                nodo.setValor(sucesor);
                nodo.setDer(delete(nodo.getDer(), sucesor));
            }
        }

        if (nodo == null) {
            return null;
        }        
        nodo.setHeight(1 + Math.max(alturanodo(nodo.getIzq()), alturanodo(nodo.getDer())));
        int fe = factorEq(nodo);
        if (fe > 1 && factorEq(nodo.getIzq()) >= 0) {
            return rotacion_der(nodo);
        }
        if (fe > 1 && factorEq(nodo.getIzq()) < 0) {
            nodo.setIzq(rotacion_izq(nodo.getIzq()));
            return rotacion_der(nodo);
        }
        if (fe < -1 && factorEq(nodo.getDer()) <= 0) {
            return rotacion_izq(nodo);
        }
        if (fe < -1 && factorEq(nodo.getDer()) > 0) {
            nodo.setDer(rotacion_der(nodo.getDer()));
            return rotacion_izq(nodo);
        }
        nodo.setHeight(1+Math.max(alturanodo(nodo.getIzq()), alturanodo(nodo.getDer())));
        return nodo;
    }

    public int minValue(Nodo node) {
        int minValue = node.getValor();
        while (node.getIzq() != null) {
            minValue = node.getIzq().getValor();
            node = node.getIzq();
        }
        return minValue;
    }
}
