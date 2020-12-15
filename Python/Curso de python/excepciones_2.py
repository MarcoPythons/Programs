def divide():
    while True:
        try:
            op1=float(input("introduce el primer numero: "))
            op2=float(input("introduce el segundo numero: "))
            print("la divicion es: " + str(op1/op2))
            break
        except ValueError:
            print("el valor es erroneo")

        except ZeroDivisionError:
            print("no se puede dividir por 0")



        
print("el calculo a finalizado")

