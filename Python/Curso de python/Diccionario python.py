midiccionario={"alemania":"berlin","francia":"paris","chile":"santiago"}

print(midiccionario["alemania"])

print(midiccionario)

print(midiccionario["chile"])

midiccionario["brasil"]="brasilia"

print(midiccionario["brasil"])

print(midiccionario)

midiccionario["brasil"]="rio"

print(midiccionario)

del midiccionario ["alemania"]

print(midiccionario)

tupla=("maku","pena","romero")
diccionario2={tupla[0]:"nombre",tupla[1]:"apellido1",tupla[2]:"apellido2"}

print(diccionario2)

Diccionario5sos={2014:"don't stop",2018:"want you back","youngblood":{2019:["valentine","lie to me"]}}
print(Diccionario5sos)

print(Diccionario5sos.keys())
print(Diccionario5sos.values())
print(len(Diccionario5sos))


