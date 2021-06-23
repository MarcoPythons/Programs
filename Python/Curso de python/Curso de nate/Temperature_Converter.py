
def Tem_Converter_F(temperatureC):
    Result=(temperatureC+32)*1.8
    return Result

def Tem_Converter_C(temperatureF):
    Result=(temperatureF-32)/1.8
    return Result

print("Which temperature do you want to convert, fahrenheit or celsius?")

which_one=input("F or C?")
while which_one != "F" or which_one != "C":
    

    print("Can be only F or C, one try left")
    which_one=input("F or C? ")
    

    while True:
        try:
            if which_one == "C":
                temperatureF=float(input("What is the temperature in degrees fahrenheit? "))
                print("The temperature in degrees fahrenheit is " + str(temperatureF)+ " and in degrees celsius is "+ str(Tem_Converter_C(temperatureF) ))
            elif which_one== "F":
                temperatureC=float(input("What is the temperature in degrees Celsius? "))
                print("The temperature in degrees celsius is " + str(temperatureC)+ " and in degrees fahrenheit is "+str(Tem_Converter_F(temperatureC)) )
            break
        except ValueError:
            print("Invalid character, try again")
    break 
    
print("Thanks for using")
    




    




