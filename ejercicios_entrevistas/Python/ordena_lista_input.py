#aca se ordena una lista pidiendo al usuario el largo de la lista
#luego se le pide al usuario que ingrese los numeros de la lista

lista_2=[]
while True:
    try:

        contador=int(input("ingrese el largo de la lista: "))
        break
    except:
        print("opcion no valida")
for i in range(contador):
    try:
        numeros=int(input("ingresa los numeros en a ordenar en la lista: "))
        lista_2.append(numeros)
        for pos1 in range(len(lista_2) - 1, 0, -1):
            posMax = 0
            for pos2 in range(1, pos1 + 1):
                if lista_2[pos2] > lista_2[posMax]:
                    posMax = pos2
            temp = lista_2[pos1]
            lista_2[pos1] = lista_2[posMax]
            lista_2[posMax] = temp
    except :
        print("opcion no valida")

print(lista_2)
