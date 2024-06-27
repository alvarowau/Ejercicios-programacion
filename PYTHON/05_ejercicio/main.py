lista_notas = list()


for num in range(3):
    nota = float(input(f"Digite la nota numero {num+1}: "))
    lista_notas.append(nota)

suma = 0

for num in lista_notas:
    suma += num

resultado = suma / len(lista_notas)
print(f"El resultado es: {resultado}" )
if resultado >= 5:
    print("El alumno esta aprobado")
else:
    print("El alumno esta suspenso")
