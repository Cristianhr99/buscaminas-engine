# Buscaminas Engine

Motor básico de un videojuego tipo Buscaminas desarrollado en Java mediante programación orientada a objetos.

## Temática Elegida

El proyecto simula la lógica interna de un videojuego tipo Buscaminas. El jugador descubre casillas de un tablero intentando evitar minas ocultas. El sistema gestiona estados de juego, puntuación, logros y guardado rápido.

## Arquitectura del Software

El sistema está compuesto por seis clases principales:

- Main: Simula el bucle de ejecución.
- MotorJuego: Controla el estado general de la partida.
- EntidadVideojuego: Clase abstracta base para las entidades.
- Celda: Representa una casilla del tablero.
- GestorEntradas: Simula las acciones del jugador.
- SistemaPuntuacion: Gestiona puntos y logros.

## Diagrama de Clases UML

```mermaid
classDiagram

class Main{
    +main(String[] args)
}

class MotorJuego{
    -String estado
    -List~EntidadVideojuego~ entidades
    +iniciarPartida()
    +pausarPartida()
    +reanudarPartida()
    +gameOver()
    +actualizar()
    +quickSave()
}

class EntidadVideojuego{
    #String nombre
    #int x
    #int y
    #int ancho
    #int alto
    #int estado
    #String imagen
}

class Celda{
    -boolean tieneMina
    -boolean descubierta
    +descubrir()
}

class GestorEntradas{
    +procesarEntrada(String comando)
}

class SistemaPuntuacion{
    -int puntuacion
    -int logros
    +sumarPuntos(int puntos)
    +desbloquearLogro(String nombre)
}

EntidadVideojuego <|-- Celda

MotorJuego --> EntidadVideojuego
MotorJuego --> SistemaPuntuacion
Main --> MotorJuego
Main --> GestorEntradas
```

## Diagrama de Casos de Uso UML

```mermaid
flowchart LR

Jugador((Jugador))

CU1[Iniciar Partida]
CU2[Descubrir Celda]
CU3[Pausar Partida]
CU4[Reanudar Partida]
CU5[Guardar Partida]
CU6[Finalizar Partida]

Jugador --> CU1
Jugador --> CU2
Jugador --> CU3
Jugador --> CU4
Jugador --> CU5
Jugador --> CU6
```

## Casos de Uso

(Pendiente)

## Bitácora de Uso de IA

(Pendiente)