# Tic Tac Toe Java

Juego de Tres en Raya desarrollado en Java por consola.

## Funcionalidades

- Sistema de turnos
- Detección de victoria y empate
- Validación de posiciones ocupadas
- Contador de victorias
- Posibilidad de volver a jugar
- Tablero dinámico

## Tecnologías utilizadas

- Java
- Arrays bidimensionales
- HashMap
- Scanner
- Bucles y condicionales

## Conceptos trabajados

- Gestión de turnos
- Manipulación de matrices
- Métodos estáticos
- Validación de datos
- Lógica de victoria
- Uso de HashMap para coordenadas

## Funcionamiento

El juego utiliza una matriz `String[][]` para representar el tablero y un `HashMap<Integer, int[]>` para traducir posiciones numéricas a coordenadas.

Después de cada turno se comprueba si existe una combinación ganadora en filas, columnas o diagonales. 
