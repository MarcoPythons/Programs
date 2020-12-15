email=False

Mi_email=input("Email: ")

for correo in Mi_email:
    if correo=="@" or correo=="." or correo=="., ." or correo=="., ., .":
      email=True
      

if email==True:
    print("correcto") 

else:
    print("Intente nuevamente")




