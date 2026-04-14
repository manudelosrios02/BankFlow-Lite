# BankFLow Lite

## Descripción
BankFlow Lite es una aplicación desarrollada en Java que simula el funcionamiento básico de un sistema bancario. Permite gestionar clientes, cuentas bancarias y operaciones como ingresos, retiradas y transferencias.

Además, integra una API REST pública de tipos de cambio para consultar el valor de distintas divisas y simular transferencias internacionales con conversión de moneda.

Este proyecto está orientado al aprendizaje de programación orientada a objetos, consumo de APIs REST y diseño de aplicaciones con estructura modular, en un contexto realista del sector bancario.


## Objetivos
•  Aplicar conceptos de Programación Orientada a Objetos (POO) en Java.
•  Diseñar una aplicación estructurada en capas (modelo, servicio, integración).
•  Consumir una API REST externa y procesar respuestas JSON.
•  Simular lógica de negocio bancaria básica.


## Requisitos
1. Gestión de clientes  
El sistema debe permitir crear y almacenar información básica de clientes (nombre, DNI, email) y asociarlos a cuentas bancarias.

2. Gestión de cuentas  
El sistema debe permitir crear cuentas bancarias con IBAN, saldo inicial y moneda, asociadas a un cliente.

3. Consulta de saldo  
El usuario debe poder consultar el saldo actual de una cuenta en cualquier momento.

4. Operaciones básicas  
El sistema debe permitir ingresar y retirar dinero de una cuenta, validando que no haya saldo negativo.

5. Registro de transacciones  
Cada operación (ingreso, retirada o transferencia) debe generar una transacción que se almacene en el historial de la cuenta.

6. Transferencias entre cuentas  
El sistema debe permitir transferencias de dinero entre dos cuentas, actualizando los saldos correctamente.

7. Transferencias internacionales  
El sistema debe permitir transferencias entre cuentas con distintas monedas, aplicando conversión de divisa.

8. Consulta de tipos de cambio (API REST)  
El sistema debe conectarse a una API externa para obtener tipos de cambio actualizados entre divisas.

9. Conversión de moneda  
El sistema debe calcular el importe convertido entre monedas usando los datos de la API.

10. Integración con API  
El sistema debe realizar peticiones HTTP a una API REST y procesar la respuesta en formato JSON.

11. Manejo de errores  
El sistema debe controlar errores como saldo insuficiente, datos inválidos o fallos en la API.
