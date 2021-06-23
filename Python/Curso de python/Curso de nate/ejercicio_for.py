"""

Calcular cuantas comas, cantos puntos y espacios hay en una cadena de texto de

ej:
        espacio = 2
        puntos = 40
        comas = 1

"""

texto = "Hola, me, llamo Nate. ¿Tu como te llamas?"
comas = 0
espacios = 0
puntos = 0
for i in (texto):
    if i == ",":
        comas += 1

    elif i == ".":
        puntos += 1
    elif i == " ":
        espacios += 1

print("Estacios {}".format(espacios))
print("Puntos {}".format(puntos))
print("Comas {}".format(comas))

# Ahora calcularemos cuantas mayuscuals tiene el texto


import string as Letras

mayusculas = 0
for i in texto:
    if i in Letras.ascii_uppercase:
        mayusculas += 1

print("Mayusculas {}".format(mayusculas))

"""
Numero elegido por el usuario ej. 2 y dar como resultado la tabla de multiplicar
de ese numero en contreto

2x1 = 2
2x2 = 4
etc
"""

numero = int(input("Ver la tabla de multiplicar del numero: "))

for i in range(1, 11):
    resultado = i * numero 
    print("{0} x {1} = {2}".format(numero, i, resultado))
