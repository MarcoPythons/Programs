print("evaluacion alumunos")

Promedio_Alumnos=input("Introdusca nota: ")


def Evaluacion(Promedio):
    Situacion="Aprobado"
    if Promedio<3.95:
    	Situacion="Reprobado"
    return Situacion
#para hacer print se usa "print(Evaluacion(x))", "x" es la nota(cifra que va en la nota)    	


print(Evaluacion(float(Promedio_Alumnos)))
