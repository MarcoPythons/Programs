avion = ["0"], ["0"], ["0"], ["0"], ["0"], ["0"] # este es el avion, los fors de abajo es para expandir esta lista de multidimenciones.
for pos0 in range(6):                      
    for pos1 in range(32):
        avion[pos0].append("0")
rut_avion = [0] # En esta lista se guardaran los ruts de los pasajeros que vallan comprando asientos en el avion.
venta_rut = 0 # esta variable sirve para la opcion 3 y 5, basicamente esta variable cambia de valor, exactamente a "1" lo cual para la opcion 3 ,que sirve para ver la lista de pasajeros, si no se han vendido ningun asiento aun(por lo cual la variable sera de valor "0") imprima un mensaje que diga que aun no se han vendido pasajes. para la opcion 5 funciona practicamente igual.
Tipoasiento=[" "," ","E","E","E","E","E","N","N","N","N"," R"," R"," E"," N"," N"," N"," N"," N"," N"," N"," N"," N"," N"," N"," N"," N"," N"," N"," N"," N"," N"," N"," N"," N","N"]
posicion = int(0) # sirve para practicamente iniciar ciclos, esa es su unica funcion
asientoE = int(80000) #AsientoE == Asiento con espacio para piernas.
asientoR = int(50000) #AsientoR == Asiento No Reclinable.
asientoN = int(60000) #AsientoN == Asiento Comuno o Normal.
AsientoE_vendidos = int(0) #Numero de asientos vendidos
AsientoR_vendidos = int(0)  #Numero de asientos vendidos
AsientoN_vendidos = int(0)  #Numero de asientos vendidos
Total_asientosE = int(0) #es la suma de los asientos E vendidos
Total_asientosR = int(0)    #es la suma de los asientos R vendidos
Total_asientosN = int(0)    #es la suma de los asientos N vendidos
asientos_disponibles= int(198) #El total de asientos disponibles en el avion
asientos_restantes= int(198)    #el total de asientos que quedan despues de una venta
venta_avion2= int(0)    #Es la el numero del asiento que el cliente comprara (1-33)
venta_avion1= int(0) #Es la el numero del asiento que el cliente comprara (1-33)
print("")

opcion = int(0) # sirve para practicamente iniciar ciclos, esa es su unica funcion
def disponibilidad_avion():   #esta funcion sirve para imprimir el avion, esta funcion la trabajamos y le hicimos algunos cambios ENTRE MARCO PEÑA
    print("  " , end= "")
    for pos1 in range(1,34):
        print(str(pos1) + " " ,end= "")
    print("")


    for pos0 in range(6):
        print(chr(70 - pos0) + " " ,end= "")
        for pos1 in range(33):
            if pos1<8:
                print(str(avion[pos0] [pos1]) + " " ,end = "")
            else:
                print(str(avion[pos0] [pos1]) + "  " ,end = "")
        print("")
    for pos1 in range(1,35):
        print(Tipoasiento[pos1]+" ", end="")
def lista_avion():#esta funcion sirve para imprimir la lista de pasajeros de menor a mayor
  rut_avion.sort()
  print("                                ")         
  print(rut_avion[1:])
  print("                                ")
def OpcionFila(ValorNumerico): #esta funcion es para cambiar "LETRAS" a "NUMEROS".
    Letra = venta_avion.upper()
    ValorNumerico = int(ord(Letra))
    return ValorNumerico
def buscaRut(rut): #esta funcion sirve para buscar ruts en la lista de avion 
    if rut in rut_avion:
        print("                                ")
        print("Este pasajero esta registrado en el avion")
        print("                                ")
    else:
        print("                                ")
        print("este pasajero no esta registrado en el avion")
        print("                                ")
def Numero(venta_avion_numero1):#esta funcion sirve para restar el numero que da la letra de la fila, por ejemplo, cuando el usuario digita "F" este sera 70 y apartir de ahi se restara.
    if venta_avion_numero == 70:                      
        venta_avion_numero1 = venta_avion_numero - 70
    elif venta_avion_numero == 69:
        venta_avion_numero1 = venta_avion_numero - 68
    elif venta_avion_numero == 68:
        venta_avion_numero1 = venta_avion_numero - 66
    elif venta_avion_numero == 67:
        venta_avion_numero1 = venta_avion_numero - 64
    elif venta_avion_numero == 66:
        venta_avion_numero1 = venta_avion_numero - 62
    elif venta_avion_numero == 65:
        venta_avion_numero1 = venta_avion_numero - 60
    return venta_avion_numero1
def muestraVenta(): # esta funcion sirve para imprimir las ganancias actuales del avion. DESARROLLADO POR NICOLAS GARCEZ
    print("")
    print("Tipo de Asiento                                Cantidad                          Total")
    print("Asiento común         " + str(asientoN)+"                    " + str(AsientoN_vendidos)+"                          "+ "       "+str(Total_asientosN))
    print("Espacio para piernas  " + str(asientoE)+"                    " + str(AsientoE_vendidos)+"                          "+ "       "+str(Total_asientosE))
    print("No reclina            " + str(asientoR)+"                    " + str(AsientoR_vendidos)+"                          "+ "       "+str(Total_asientosR))
    print("Total" + "                                          " + str(AsientoN_vendidos + AsientoE_vendidos + AsientoR_vendidos)+"                                 " + str(Total_asientosE + Total_asientosR + Total_asientosN))
    print("                                ")
def CambioRut(rut_a_cambiar): # esta funcion sirve para cambiar el rut de la lista de avion, primero busca si el rut esta en la lista y si no esta, este lo cambiara. DESARROLLADO POR NICOLAS GARCEZ
    if rut_a_cambiar in rut_avion:
            nuevo_rut=int(input("Ingrese el nuevo rut: "))
            if nuevo_rut in rut_avion:
              print("                                ")
              print("Este rut ya esta en la lista de pasajeros")
              print("                                ")
            else:
              rut_avion.remove(rut_a_cambiar)
              rut_avion.append(nuevo_rut)
              print("                                ")
              print("El asiento ha sido reasignado correctamente") 
              print("                                ")

print("")


while opcion != 7:
    while True: # aqui empezamos un bucle infinito por la sencilla razon de que la opcion que dice "opcion" sea un "int", si el usuario pone otra cosa este le preguntara hasta que ponga un int


      try: #justo aqui le decimos al programa que intente ejecutar eso, de lo contrario saltara al la linea 121 donde esta el "except" que en este caso es una excepcion de ValueError que esta ocurre cuando pedimos un entero pero el usuario digita un texto o otra clase de caracter no int.

        print("----------------------------------------------")
        print("Bienvenidos a Aerolineas Flash")
        print("                                ")
        print("Compra de pasajes: opcion 1")  
        print("Ver disponibilidad del avion: opcion 2")
        print("Listado de pasajeros: opcion 3")
        print("Busca de pasajeros: opcion 4")
        print("Reasignacion de pasajeros: opcion 5")
        print("Ver ganacias totales: opcion 6")
        print("Salir: opcion 7")
        print("----------------------------------------------")

        opcion = int(input("Que operacion desea realizar? "))
        
        
        break
      except ValueError:
        print("                                ")
        print("Opcion no valida")


    if opcion == 1:   
        while True:
            try:
                entradas=int(input("Cuantos pasajes quiere comprar? "))
                break
            except ValueError:
                print("Se debe ingresar la cantidad de pasajes")
        if entradas > asientos_restantes:
            print("La cantidad ingresada de asientos no estan disponible")
        else:
            disponibilidad_avion()
            print("")
            for pos in range(entradas):
                while posicion == 0:   #basicamente este while  pide la fila, el usuario pone un caracter de tipo "letra" y la funcion "ord" la transforma en numero, y este la resto con una serie de numeros y esto da 0, 1 ,2 ,3, 4 ó 5 lo que hace alusión a la fila correspondiente.
                    while True:
                        try:

                            venta_avion = (input("Que fila desea(A-F)? "))
                            venta_avion_numero=OpcionFila(venta_avion)        
                            break
                        except TypeError:
                            print("Esa fila no existe")
                    if venta_avion_numero >= 65 and venta_avion_numero <= 70:  #por ejemplo, si el usuario pone "f", esta sera cambiada po un f mayuscula y la f mayuscula es igual a 70
                        break                                                       
                    
                    else:
                        print("Esa fila no existe")
                venta_avion_numero1=Numero(venta_avion_numero)

                if venta_avion_numero1 == 0 or venta_avion_numero1 == 1 or venta_avion_numero1 == 2 or venta_avion_numero1 == 3 or venta_avion_numero1 == 4 or venta_avion_numero1 == 5:
                    while posicion == 0:
                        while True:
                            try:
                                venta_avion1 = int(input("Que numero de asiento(1-33), pulse cero(0) para cancelar la venta? "))
                                break
                            
                            except ValueError:
                                print("Se debe ingresar el numero del asiento")

                    
                        venta_avion2 = venta_avion1 - 1
                        

                        if venta_avion2 >= 0 and venta_avion2 <= 32 and avion[venta_avion_numero1][venta_avion2] != "x":
                            avion[venta_avion_numero1][venta_avion2] = "x"
                            break
                        elif venta_avion2 == -1: # esto hace que se cancele la venta, ya que siempre a la variable "venta_avion1" le resto 1, si le ponemos 0 quedara en -1
                            break                #entonces saldra del ciclo y cancelara la venta
                        else:
                            print("Dicho asiento no existe o ya esta ocupado, intente nuevamente.")
                
                    while venta_avion2 != -1:
                        while True:     # esta parte es cuando se pide el rut
                            try:
                                rut = int(input("Introduce tu rut SIN digito verificador: ")) #se pido el rut
                                break

                            except ValueError:
                                print("No se admiten caracteres de tipo LETRA o tipo DECIMAL")

                        
                        
                        if rut in rut_avion:      #si este esta en el avion, imprime el mensaje                      
                            print("este rut ya esta registrado")
                    
                    
                    
                        else:   # si no esta en el avion, este le sumara 1 a la variable "venta_rut" explicada anteriormente, y guardara el rut en el la lista del avion.
                            venta_rut+=1
                            rut_avion.append(rut)
                            break
                    
                    if venta_avion1 >= 1 and venta_avion1 <= 5 or venta_avion1 == 12: # si se venden asientos con espacio para piernas se le sumara 1 a la varible que guarda la cantidad de asientos vendidos
                        AsientoE_vendidos+=1 #se le sumara 1 a la varible que guarda la cantidad de asientos vendidos
                        Total_asientosE = AsientoE_vendidos*asientoE # y se multiplicara esta cantidad por el precio.
                    elif venta_avion1 >= 6 and venta_avion1 <=9 or venta_avion1 >= 13 and venta_avion1 <=33:
                        AsientoN_vendidos+=1
                        Total_asientosN = AsientoN_vendidos*asientoN
                    elif venta_avion1 == 10 or venta_avion1 == 11:
                        AsientoR_vendidos+=1
                        Total_asientosR = AsientoR_vendidos*asientoR
            asientos_restantes= asientos_disponibles-entradas
            print("                                ")
            if venta_avion2 == -1: # las opciones de aca son para cancelar la venta
                print("La operación ha sido cancelada correctamente")
            elif venta_avion1 == 0:
                print("La operación ha sido cancelada correctamente")
            else: # nada interviene con la compra, el programa imprimira el siguiente mensaje que dice que la compra ha sido realizada.
                print("La operacion a sido realizada correctamente.")
            print("                                ")
          
    elif opcion == 2:
        print("                                ")
        disponibilidad_avion()
        print("")
        print("                                ")
    elif opcion == 3: #esto opcion hace que muestra los rut de los pasajeros que este registrado el el avion.
      if venta_rut == 0:
        print("                                ")
        print("Aun no se han registrado pasajeros.")  #el caso que no haya nigun rut registrado se mostrara este mensaje
        print("                                ")
      else:
        print("la lista de pasajeros por rut es:")
        lista_avion()
    elif opcion == 4: #opcion desarrollada por NICOLAS GARCEZ
        while True: # iniciamos un bucle infinito para poder ejecutar el try, que este caso necesitamos que se repita hasta que el valor que pedimos este correcto.
            try:
                busca_rut= int(input("Ingrese rut a buscar: "))
                break
            except ValueError:
                print("Caracter no permitido")
        buscaRut(busca_rut)
        
    elif opcion == 5:  # esta opcion fue desarrollada por MASTER PROMMUNGKAO
        if venta_rut == 0:
            print("                                ")
            print("Aun no se han registrado pasajeros")
            print("                                ")
        else:
            while True:
                try:   # le decimos al programa que intente ejecutar esto
                    rut_a_cambiar=int(input("ingrese el rut a cambiar: ")) # aca se pide el rut que se decea cambiar(el rut debe estar registrado en el avion)
                    if rut_a_cambiar not in rut_avion:  # si el rut que se digita en la variable "rut_a_cambiar" no esta en la lista entonces se imprimira por pantalla que el rut no esta registrado.
                        print("                                ")
                        print("Este rut no esta registrado en el avion")
                        print("                                ")
                    else:
                    
                        CambioRut(rut_a_cambiar)
                    break
                except ValueError:
                    print("                                ")
                    print("Los ruts no tienen digito verificador, puntos ni guion o cualquier letra")
                    print("                                ")    
    elif opcion== 6:
      muestraVenta()
        
    elif opcion == 7:
        break
    elif opcion > 7 or opcion <= 0 :
        print("                                ")  
        print("opcion no valida, porfavor ingrese una opcion valida")
        print("                                ")
