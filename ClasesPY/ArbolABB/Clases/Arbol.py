from Nodo import Nodo

class Arbol:

    def __init__(self):
        self.raiz = None

    def agregar(self, valor):
        nuevo_nodo = Nodo(valor)
        if self.raiz is None:
            self.raiz = nuevo_nodo
        else:
            self.agregar_recursivo(self.raiz, nuevo_nodo)

    def agregar_recursivo(self, nodo, nuevo_nodo):
        if nuevo_nodo.dato < nodo.dato:
            if nodo.izquierdo is None:
                nodo.izquierdo = nuevo_nodo
            else:
                self.agregar_recursivo(nodo.izquierdo, nuevo_nodo)
        else:
            if nodo.derecho is None:
                nodo.derecho = nuevo_nodo
            else:
                self.agregar_recursivo(nodo.derecho, nuevo_nodo)

    def imprimir(self, n1, nivel):
        if n1 is not None:
            self.imprimir(n1.derecho, nivel + 1)
            print("      " * nivel + str(n1.dato))
            self.imprimir(n1.izquierdo, nivel + 1)

    def preorden(self, nodo):
        if nodo is None:
            return
        print(str(nodo.dato) + "-", end="")
        self.preorden(nodo.izquierdo)
        self.preorden(nodo.derecho)

    def inorden(self, nodo):
        if nodo is None:
            return
        self.inorden(nodo.izquierdo)
        print(str(nodo.dato) + "-", end="")
        self.inorden(nodo.derecho)

    def posorden(self, nodo):
        if nodo is None:
            return
        self.posorden(nodo.izquierdo)
        self.posorden(nodo.derecho)
        print(str(nodo.dato) + "-", end="")

    def peso_arbol(self, nodo):
        if nodo is None:
            return 0
        return 1 + self.peso_arbol(nodo.izquierdo) + self.peso_arbol(nodo.derecho)

    def contar_hojas(self, nodo):
        if nodo is None:
            return 0
        if nodo.izquierdo is None and nodo.derecho is None:
            return 1
        return self.contar_hojas(nodo.izquierdo) + self.contar_hojas(nodo.derecho)

    def eliminar(self, valor):
        self.raiz = self._eliminar_recursivo(self.raiz, valor)

    def _encontrar_minimo(self, nodo):
        while nodo.izquierdo is not None:
            nodo = nodo.izquierdo
        return nodo

    def _eliminar_recursivo(self, nodo, valor):
        if nodo is None:
            return None
        if valor < nodo.dato:
            nodo.izquierdo = self._eliminar_recursivo(nodo.izquierdo, valor)
        elif valor > nodo.dato:
            nodo.derecho = self._eliminar_recursivo(nodo.derecho, valor)
        else:
            if nodo.izquierdo is None:
                return nodo.derecho
            elif nodo.derecho is None:
                return nodo.izquierdo
            sucesor = self._encontrar_minimo(nodo.derecho)
            nodo.dato = sucesor.dato
            nodo.derecho = self._eliminar_recursivo(nodo.derecho, sucesor.dato)
        return nodo

    def impila(self, pila, p):
        pila.append(p)

    def campila(self, pila):
        if pila:
            return pila.pop()
        return None

    def preorden_iter(self, raiz):
        pila = []
        p = raiz
        while True:
            if p is not None:
                print(p.dato, end="")
                self.impila(pila, p)
                p = p.izquierdo
            else:
                p = self.campila(pila)
                p = p.derecho
            if not pila and p is None:
                break
        print()

    def inorden_iter(self, raiz):
        pila = []
        p = raiz
        while True:
            if p is not None:
                self.impila(pila, p)
                p = p.izquierdo
            else:
                p = self.campila(pila)
                print(p.dato, end="")
                p = p.derecho
            if not pila and p is None:
                break
        print()

    def posorden_iter(self, raiz):
        pila = []
        p = raiz
        visitado = None
        while True:
            if p is not None:
                self.impila(pila, p)
                p = p.izquierdo
            else:
                tope = pila[-1]
                if tope.derecho is not None and tope.derecho != visitado:
                    p = tope.derecho
                else:
                    print(tope.dato, end="")
                    visitado = self.campila(pila)
            if not pila and p is None:
                break
        print()

    @staticmethod
    def getcol(h):
        if h == 1:
            return 1
        return Arbol.getcol(h - 1) + Arbol.getcol(h - 1) + 1

    @staticmethod
    def altura_arbol(n1):
        if n1 is None:
            return 0
        return max(Arbol.altura_arbol(n1.izquierdo),
                   Arbol.altura_arbol(n1.derecho)) + 1

    @staticmethod
    def _print_tree_matrix(M, root, col, row, height):
        if root is None:
            return
        M[row][col] = root.dato + 1
        Arbol._print_tree_matrix(M, root.izquierdo,
                                  col - int(2 ** (height - 2)),
                                  row + 1, height - 1)
        Arbol._print_tree_matrix(M, root.derecho,
                                  col + int(2 ** (height - 2)),
                                  row + 1, height - 1)

    def tree_printer(self):
        h = Arbol.altura_arbol(self.raiz)
        col = Arbol.getcol(h)
        M = [[0] * col for _ in range(h)]
        Arbol._print_tree_matrix(M, self.raiz, col // 2, 0, h)
        for i in range(h):
            for j in range(col):
                if M[i][j] == 0:
                    print("   ", end="")
                else:
                    print(str(M[i][j] - 1) + " ", end="")
            print()