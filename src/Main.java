public class Main {

    public static void main(String[] args) {

        System.out.println("=== BUSCAMINAS ENGINE ===\n");

        MotorJuego motorJuego = new MotorJuego();

        GestorEntradas gestorEntradas =
                new GestorEntradas(motorJuego);

        motorJuego.iniciarPartida();

        motorJuego.actualizar();

        System.out.println("\n--- Descubriendo casillas seguras ---");

        gestorEntradas.descubrirCasilla(0, 0);

        gestorEntradas.descubrirCasilla(1, 0);

        gestorEntradas.descubrirCasilla(0, 1);

        System.out.println("\n--- Probando pausa ---");

        gestorEntradas.pausarJuego();

        gestorEntradas.reanudarJuego();

        System.out.println(
        "\n--- Eliminando una casilla ---"
);

gestorEntradas.eliminarCasilla(1, 1);

motorJuego.actualizar();

        System.out.println("\n--- Guardado rápido ---");

        System.out.println(
                motorJuego.quickSave()
        );

        System.out.println("\n--- Descubriendo una mina ---");

        gestorEntradas.descubrirCasilla(2, 0);

        System.out.println(
                "\nEstado final: "
                        + motorJuego.getEstadoJuego()
        );
    }
}