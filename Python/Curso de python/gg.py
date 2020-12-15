print("Asignaturas:")
print("matematicas")
print("lenguaje")
print("ingles")

asig_lista1="lenguaje"
asig_lista2="matematicas"
asig_lista3="ingles"

Opciones=input("Escoje tu asignatura: ")



while Opciones==asig_lista1 or asig_lista2 or asig_lista3:
    print("es incorrecto, intenta nuevamente")
    Opciones=input("Escoje tu asignatura: ")
    break


	
print("Asignatura elegida: " + str(Opciones))

print("Gracias por escoger")

print("fin del programa")