import math

print("Programa de calculo de raiz cuadrada")

numero=int(input("Introduce un numero: "))

intentos=0

while numero <0:
  print("error, numero negativo")

  if intentos==2:
     print("ya no te quedan intentos")
     break;
  
  numero=int(input("Introduce un numero: "))

  if numero<0:
  	 intentos=intetos+1

if intentos<2:
	solucion=math.sqrt(numero)
	print("la raiz cuadrada de " + str(numero) + " es " + str(solucion))






