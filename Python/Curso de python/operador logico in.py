print("Asignaturas:")
print("matematicas")
print("lenguaje")
print("ingles")

Opciones=input("Escoje tu asignatura: ")

Asignaturas_alumnos=Opciones.lower()

if Asignaturas_alumnos in("matematicas", "lenguaje" , "ingles"):
   print("Asignatura elegida: " + str(Asignaturas_alumnos))

else:
    print("es incorrecto, intenta nuevamente")

print("Gracias por escoger")

print("fin del programa")



