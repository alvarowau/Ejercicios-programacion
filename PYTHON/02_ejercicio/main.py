import math


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


# Solicita al usuario que ingrese el radio de la circunferencia y verifica su validez
while True:
    radio = input("Digite el radio de la circunferencia: ")
    if numeroValido(radio):
        radio = float(radio)
        break

# Calcula el área de la circunferencia
area = math.pi * radio**2

# Muestra el resultado
print(f"El área de la circunferencia es: {area}")
