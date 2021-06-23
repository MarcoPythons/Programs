def tem_converter_f(temperature_c):
    result = (temperature_c + 32) * 1.8
    return result


def tem_converter_c(temperature_f):
    result = (temperature_f - 32) / 1.8
    return result


def numbers_power(number_a, *args, number_b = False):
    result = number_a**2
    if args:
        result = pow(number_a, number_b)
        return result
    return result


def medir_largos(iterable, *args): #cuando le pasamos el *args quiere decir que le podemos dar mas de un parametro. *args quiere decir opcional
    if args:
        largos = [len(iterable)]
        for a in args:
            largos.append(len(a))
        return largos
    return len(iterable)


def main():
    print("Which temperature do you want to convert, fahrenheit or celsius?")

    which_one = input("F or C?")

    if which_one != "F" and which_one != "C":

        print("Can be only F or C, one try left")
        which_one = input("F or C?")
        if which_one != "F" and which_one != "C":
            exit(-1)

    while which_one != "F" or which_one != "C":

        while True:
            try:
                if which_one == "C":
                    temperatureF = float(input("What is the temperature in degrees fahrenheit? "))
                    print("The temperature in degrees fahrenheit is " + str(
                        temperatureF) + " and in degrees celsius is " + str(tem_converter_c(temperatureF)))
                elif which_one == "F":
                    temperatureC = float(input("What is the temperature in degrees Celsius? "))
                    print("The temperature in degrees celsius is " + str(
                        temperatureC) + " and in degrees fahrenheit is " + str(tem_converter_f(temperatureC)))
                break
            except ValueError:
                print("Invalid character, try again")
        break

    print("Thanks for using")

    for i in range(100):
        print("-", end="")

    print(' ')
    print(numbers_power(2))
    print(numbers_power(2, 3, number_b = True))


if __name__ == "__main__":
    main()
