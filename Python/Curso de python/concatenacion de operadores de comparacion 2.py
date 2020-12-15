Salario_presidente=int(input("Introduzca salario presidente: "))
print("Salario presidente: " + str(Salario_presidente))

Salario_director=int(input("Introduzca salario director: "))
print("Salario director: " + str(Salario_director))

Salario_jefe_area=int(input("Introduzca salario jefe de area: "))
print("Salario jefe area: " + str(Salario_jefe_area))


Salario_administrativo=int(input("Introduzca salario administrativo: "))
print("Salario administrativo: " + str(Salario_administrativo)) 

if Salario_presidente>Salario_director>Salario_jefe_area>Salario_administrativo:
  print("todo bien")
else:
	print("todo mal")




