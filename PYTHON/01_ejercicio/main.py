def numeroValido(num):
    """
    Verifica si el número introducido es un entero o un flotante.

    Args:
        num: El valor a verificar.

    Returns:
        bool: True si el valor es un entero o flotante, False en caso contrario.
    """
    try:
        float(num)
        return True
    except ValueError:
        print("El número introducido no es válido")
        return False


# Solicita al usuario que ingrese el primer número y verifica su validez
while True:
    num1 = input("Digite el primer número: ")
    if numeroValido(num1):
        num1 = float(num1)
        break

# Solicita al usuario que ingrese el segundo número y verifica su validez
while True:
    num2 = input("Digite el segundo número: ")
    if numeroValido(num2):
        num2 = float(num2)
        break

# Realiza y muestra las operaciones aritméticas
print("OPERACIONES")
print(f"La suma de {num1} + {num2} = {num1 + num2}")
print(f"La resta de {num1} - {num2} = {num1 - num2}")
print(f"La multiplicación de {num1} * {num2} = {num1 * num2}")
print(f"La división de {num1} / {num2} = {num1 / num2}")
print(f"El resto de {num1} % {num2} = {num1 % num2}")
