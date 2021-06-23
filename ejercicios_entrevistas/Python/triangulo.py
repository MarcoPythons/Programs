#el objetivo de esta prueba es dibujar un triangulo con numeros hasta el numero 9
"""
1
22
333
4444
55555
666666
7777777
88888888
999999999
"""

filas = int(input("ingrese la cantidad de filas: "))

caracter = ""        

for i in range(filas):
    caracter = str(1 + i)
    print ((i+1) * caracter)

