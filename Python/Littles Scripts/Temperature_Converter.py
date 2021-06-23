def tem_converter_f(temperature_c):
    result = (temperature_c + 32) * 1.8
    return result


def tem_converter_c(temperature_f):
    result = (temperature_f - 32) / 1.8
    return result


print("Which temperature do you want to convert, fahrenheit or celsius?")

which_one = input("F or C?")
while which_one != "F" or which_one != "C":

    print("Can be only F or C, one try left")
    which_one = input("F or C? ")

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
