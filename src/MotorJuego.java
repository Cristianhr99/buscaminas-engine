import java.util.ArrayList;
import java.util.List;

public class MotorJuego {

    private static final String MENU = "MENU";
    private static final String JUGANDO = "JUGANDO";
    private static final String PAUSA = "PAUSA";
    private static final String GAME_OVER = "GAME_OVER";

    private String estadoJuego;

    private List<Celda> tablero;

    private SistemaPuntuacion sistemaPuntuacion;

    public MotorJuego() {

        estadoJuego = MENU;

        tablero = new ArrayList<>();

        sistemaPuntuacion = new SistemaPuntuacion();
    }

    public void iniciarPartida() {

        estadoJuego = JUGANDO;

        tablero.clear();

        tablero.add(new Celda(0, 0, false));
        tablero.add(new Celda(1, 0, false));
        tablero.add(new Celda(2, 0, true));

        tablero.add(new Celda(0, 1, false));
        tablero.add(new Celda(1, 1, false));
        tablero.add(new Celda(2, 1, false));

        System.out.println("Partida iniciada");
    }

    public void pausar() {

        if (estadoJuego.equals(JUGANDO)) {

            estadoJuego = PAUSA;

            System.out.println("Juego pausado");
        }
    }

    public void reanudar() {

        if (estadoJuego.equals(PAUSA)) {

            estadoJuego = JUGANDO;

            System.out.println("Juego reanudado");
        }
    }

    public void gameOver() {

        estadoJuego = GAME_OVER;

        System.out.println("💀 GAME OVER");
    }

    public void actualizar() {

        System.out.println("\n=== GAME LOOP ===");

        for (Celda celda : tablero) {
            celda.actualizar();
        }
    }

    public void descubrirCelda(int x, int y) {

        for (Celda celda : tablero) {

            if (celda.getX() == x && celda.getY() == y) {

                if (celda.isDescubierta()) {

                    System.out.println(
                            "La casilla ya estaba descubierta"
                    );

                    return;
                }

                celda.descubrir();

                System.out.println(
                        "Casilla descubierta en (" +
                        x + "," + y + ")"
                );

                if (celda.tieneMina()) {

                    System.out.println(
                            "💣 Has encontrado una mina"
                    );

                    gameOver();

                } else {

                    sistemaPuntuacion.sumarPuntos();

                    System.out.println(
                            "Puntos actuales: " +
                            sistemaPuntuacion.getPuntos()
                    );
                }

                return;
            }
        }

        System.out.println("No existe una casilla en esa posición");
    }

    public void eliminarCelda(int x, int y) {

    for (int i = 0; i < tablero.size(); i++) {

        Celda celda = tablero.get(i);

        if (celda.getX() == x && celda.getY() == y) {

            tablero.remove(i);

            System.out.println(
                    "Celda eliminada en (" +
                    x + "," + y + ")"
            );

            return;
        }
    }

    System.out.println(
            "No existe una celda en esa posición"
    );
}

    public String quickSave() {

    StringBuilder save = new StringBuilder();

    save.append("{\n");
    save.append("  estado:'")
            .append(estadoJuego)
            .append("',\n");

    save.append("  puntos:")
            .append(sistemaPuntuacion.getPuntos())
            .append(",\n");

    save.append("  tablero:[\n");

    for (Celda celda : tablero) {

        save.append("    {")
                .append("x:")
                .append(celda.getX())
                .append(", y:")
                .append(celda.getY())
                .append(", mina:")
                .append(celda.tieneMina())
                .append(", descubierta:")
                .append(celda.isDescubierta())
                .append("},\n");
    }

    save.append("  ]\n");
    save.append("}");

    return save.toString();
}

    public String getEstadoJuego() {
        return estadoJuego;
    }
}