import sys
sys.path.insert(0, '/Users/dg_amir/Documents/GitHub/Estructura-de-datos-2/ClasesPY/ArbolABB/Clases')

from Arbol import Arbol

if __name__ == "__main__":
    arbolito = Arbol()
    arbolito.agregar(8)
    arbolito.agregar(3)
    arbolito.agregar(1)
    arbolito.agregar(20)
    arbolito.agregar(10)
    arbolito.agregar(5)
    arbolito.agregar(4)

    print("Imprimir árbol (rotado)")
    arbolito.imprimir(arbolito.raiz, 0)

    print("\nRecorrido Preorden")
    arbolito.preorden(arbolito.raiz)

    print("\nRecorrido Inorden")
    arbolito.inorden(arbolito.raiz)

    print("\nRecorrido Posorden")
    arbolito.posorden(arbolito.raiz)

    print("\nPreorden Iterativo")
    arbolito.preorden_iter(arbolito.raiz)

    print("Posorden Iterativo")
    arbolito.posorden_iter(arbolito.raiz)

    print("Inorden Iterativo")
    arbolito.inorden_iter(arbolito.raiz)

    print("Peso del arbol")
    print("Peso:", arbolito.peso_arbol(arbolito.raiz))

    print("Altura del arbol")
    print("Altura:", Arbol.altura_arbol(arbolito.raiz))

    print("Cantidad de hojas")
    print("Hojas:", arbolito.contar_hojas(arbolito.raiz))

    print("TreePrinter (formato matricial)")
    arbolito.tree_printer()

    print("Eliminar el 3 (nodo con dos hijos)")
    arbolito.eliminar(3)
    print("Recorrido Inorden tras eliminar")
    arbolito.inorden(arbolito.raiz)
    print()
    print("Peso tras eliminar:", arbolito.peso_arbol(arbolito.raiz))
    print("Hojas tras eliminar:", arbolito.contar_hojas(arbolito.raiz))
    print("TreePrinter tras eliminar")
    arbolito.tree_printer()