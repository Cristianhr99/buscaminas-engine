public class GestorEntradas {

    private MotorJuego motorJuego;

    public GestorEntradas(MotorJuego motorJuego) {
        this.motorJuego = motorJuego;
    }

    public void descubrirCasilla(int x, int y) {

        System.out.println(
                "Jugador selecciona la posición (" +
                x + "," + y + ")"
        );

        motorJuego.descubrirCelda(x, y);
    }

    public void eliminarCasilla(int x, int y) {

    System.out.println(
            "Eliminando casilla (" +
            x + "," + y + ")"
    );

    motorJuego.eliminarCelda(x, y);
}

    public void pausarJuego() {
        motorJuego.pausar();
    }

    public void reanudarJuego() {
        motorJuego.reanudar();
    }
}