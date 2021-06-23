#aca vamos a ordenar una lista de mayor a menor sin usar la funcion sort


#lista_ordenada  = sorted(lista) asi se usa la funcion de sort

#print(lista_ordenada )  #asi no la usaremos

lista=[1,5,24,2]

len_list = len(lista)


for pos1 in range(len_list -1, 0, -1):
    posMax = 0
    for pos2 in range(1 ,pos1 + 1):
        if lista[pos2] < lista[posMax]:
            posMax = pos2

        temp = lista[pos1] 
        lista[pos1] = lista[posMax]
        lista[posMax] = temp

            
        print(str(lista[pos1]) + " " +str(lista[pos2]) + " " + str(lista))
        
print("---------------------------------------------------------------")
print(lista)



