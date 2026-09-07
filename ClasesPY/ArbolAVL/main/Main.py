# @amird

import sys

sys.path.insert(0, '/Users/dg_amir/Documents/GitHub/Estructura-de-datos-2/ClasesPY/ArbolAVL/Clases')

from Arbol import Arbol   # ← Arbol con A mayúscula, igual que tu archivo Arbol.py

if __name__ == "__main__":
    arbolito = Arbol()

    V = [20, 30, 40, 35, 15, 50, 55, 56, 57, 58]

    for valor in V:
        arbolito.insertar(valor)

    print("\nÁrbol después de insertar:")
    arbolito.tree_printer()

    arbolito.delete(40)
    print("\nÁrbol después de eliminar 40:")
    arbolito.tree_printer()