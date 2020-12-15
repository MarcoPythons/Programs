print("Sistema de becas 2019.")

Distancia_escuela=int(input("Distancia de su domicilio a la escuela: "))
print("Su distancia en km es: " + str(Distancia_escuela))

Numero_hermanos=int(input("Cantidad de hermanos: "))
print("Su numero de hermanos es: " + str(Numero_hermanos))

Salario=int(input("Salario mensual: "))
print("Su salario es: " + str(Salario))


if Distancia_escuela>40 or Numero_hermanos>2 or Salario<20000: 
   print("Usted es apto para beca, Felicitaciones.")

else:
	print("Usted no es apto para beca, Lo sentimos.")
	