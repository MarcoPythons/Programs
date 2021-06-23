import hashlib


def get_sha1(password):
    h = hashlib.new("sha1",password.encode())
    upper_case = h.hexdigest().upper()
    return upper_case

password = input("contraseña: ")


pass_1 = get_sha1(password)
print(pass_1)
password_2=input("repite la contraseña: ")

pass_2 = get_sha1(password_2)
print(pass_2)

if pass_1 == pass_2:
    print("las contraseñas coinciden")

else:
    print("Error")
