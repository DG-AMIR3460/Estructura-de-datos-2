# @amird

from Nodo import Nodo

class Arbol:

    def __init__(self):
        self.raiz = None

    @staticmethod
    def altura_arbol(n1):
        if n1 is None:
            return 0
        return max(Arbol.altura_arbol(n1.izq),
                   Arbol.altura_arbol(n1.der)) + 1

    @staticmethod
    def altura_nodo(n1):
        if n1 is None:
            return 0
        return n1.height

    def factor_eq(self, nodo):
        if nodo is None:
            return 0
        return Arbol.altura_nodo(nodo.izq) - Arbol.altura_nodo(nodo.der)

    def rotacion_der(self, Y):
        X = Y.izq
        temp = X.der
        X.der = Y
        Y.izq = temp
        Y.height = max(Arbol.altura_nodo(Y.izq),
                       Arbol.altura_nodo(Y.der)) + 1
        X.height = max(Arbol.altura_nodo(X.izq),
                       Arbol.altura_nodo(X.der)) + 1
        return X

    def rotacion_izq(self, X):
        Y = X.der
        temp = Y.izq
        Y.izq = X
        X.der = temp
        X.height = max(Arbol.altura_nodo(X.izq),
                       Arbol.altura_nodo(X.der)) + 1
        Y.height = max(Arbol.altura_nodo(Y.izq),
                       Arbol.altura_nodo(Y.der)) + 1
        return Y

    def insertar(self, valor):
        self.raiz = self._insertar(self.raiz, valor)

    def _insertar(self, nodo, valor):
        if nodo is None:
            return Nodo(valor)
        if valor < nodo.valor:
            nodo.izq = self._insertar(nodo.izq, valor)
        elif valor > nodo.valor:
            nodo.der = self._insertar(nodo.der, valor)
        else:
            return nodo
        nodo.height = 1 + max(Arbol.altura_nodo(nodo.izq),
                               Arbol.altura_nodo(nodo.der))
        fe = self.factor_eq(nodo)

        if fe > 1 and self.factor_eq(nodo.izq) >= 0:
            print("Rotación derecha")
            return self.rotacion_der(nodo)
        if fe > 1 and self.factor_eq(nodo.izq) < 0:
            print("Rotación izquierda-derecha")
            nodo.izq = self.rotacion_izq(nodo.izq)
            return self.rotacion_der(nodo)
        if fe < -1 and self.factor_eq(nodo.der) <= 0:
            print("Rotación izquierda")
            return self.rotacion_izq(nodo)
        if fe < -1 and self.factor_eq(nodo.der) > 0:
            print("Rotación derecha-izquierda")
            nodo.der = self.rotacion_der(nodo.der)
            return self.rotacion_izq(nodo)
        return nodo

    def delete(self, valor):
        self.raiz = self._delete(self.raiz, valor)

    def _delete(self, nodo, valor):
        if nodo is None:
            return None
        if valor < nodo.valor:
            nodo.izq = self._delete(nodo.izq, valor)
        elif valor > nodo.valor:
            nodo.der = self._delete(nodo.der, valor)
        else:
            if nodo.izq is None or nodo.der is None:
                temp = nodo.izq if nodo.izq is not None else nodo.der
                nodo = temp
            else:
                sucesor = self.min_value(nodo.der)
                nodo.valor = sucesor
                nodo.der = self._delete(nodo.der, sucesor)

        if nodo is None:
            return None

        nodo.height = 1 + max(Arbol.altura_nodo(nodo.izq),
                               Arbol.altura_nodo(nodo.der))
        fe = self.factor_eq(nodo)

        if fe > 1 and self.factor_eq(nodo.izq) >= 0:
            return self.rotacion_der(nodo)
        if fe > 1 and self.factor_eq(nodo.izq) < 0:
            nodo.izq = self.rotacion_izq(nodo.izq)
            return self.rotacion_der(nodo)
        if fe < -1 and self.factor_eq(nodo.der) <= 0:
            return self.rotacion_izq(nodo)
        if fe < -1 and self.factor_eq(nodo.der) > 0:
            nodo.der = self.rotacion_der(nodo.der)
            return self.rotacion_izq(nodo)

        nodo.height = 1 + max(Arbol.altura_nodo(nodo.izq),
                               Arbol.altura_nodo(nodo.der))
        return nodo

    def min_value(self, nodo):
        min_val = nodo.valor
        while nodo.izq is not None:
            min_val = nodo.izq.valor
            nodo = nodo.izq
        return min_val

    @staticmethod
    def getcol(h):
        if h == 1:
            return 1
        return Arbol.getcol(h - 1) + Arbol.getcol(h - 1) + 1

    @staticmethod
    def _print_tree_matrix(M, root, col, row, height):
        if root is None:
            return
        M[row][col] = root.valor
        Arbol._print_tree_matrix(M, root.izq,
                                  col - int(2 ** (height - 2)),
                                  row + 1, height - 1)
        Arbol._print_tree_matrix(M, root.der,
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
                    print("  ", end="")
                else:
                    print(str(M[i][j]) + " ", end="")
            print()