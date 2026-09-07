# @amird

class Nodo:
    def __init__(self, valor):
        self.izq = None
        self.der = None
        self.valor = valor
        self.height = 1