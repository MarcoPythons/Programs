def fibonachi(number):
    if number <= 1:
        return 1
    return fibonachi(number - 1) + fibonachi(number - 2)


def potencia(numero, base=2):
    resultado = numero
    for i in range(1, base):
        resultado *= numero

    return resultado


"""

Ejercicio 1: La string más larga

Crea una funcion que reciba una lista de strings como entrada y te diga cual es la más larga de todas Ejemplo: string_mas_larga("hola", "como", "estas") > "estas"
pista:
 def poner_prefijo_cadena(prefijo, *cadenas):

...     return [ prefijo + cadena for cadena in cadenas ]

...

 poner_prefijo_cadena('bi', 'cicleta', 'centenario', 'polar', 'direccional', 'scocho')

['bicicleta', 'bicentenario', 'bipolar', 'bidireccional', 'biscocho']


lista = ["hola", "como", "estas"]
print(str(len(lista[0]))+ " " + str(len(lista[1]))+ " " + str(len(lista[2])))


"""


def string_mas_larga(string1, *args):
    if args:

        args = list(args)
        for i in range(len(args) -1, 0, -1):
            posMax = 0
            for a in range(1, i + 1):
                if args[a] < args[posMax]:
                    posMax = a
                temp = args[i]
                args[i] = args[posMax]
                args[posMax] = temp

        if string1 > args[0]:
            return string1
        else:
            return args[0]
    return string1


def main():
    """
    for i in range(19):
        print(fibonachi(i))

    print(potencia(4)) print(potencia(4, 5)) """

    print(string_mas_larga("como", "hoasdfasdfdasfla", "como", "estas", "moco", "parcas"))
    print(string_mas_larga("comoasdfsdafads"))


if __name__ == '__main__': main()
