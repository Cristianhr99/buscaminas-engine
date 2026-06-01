public class SistemaPuntuacion {

    private int puntos;
    private boolean logroExplorador;

    private static final int PUNTOS_POR_CASILLA = 10;
    private static final int PUNTOS_LOGRO = 30;

    public SistemaPuntuacion() {
        puntos = 0;
        logroExplorador = false;
    }

    public void sumarPuntos() {

        puntos += PUNTOS_POR_CASILLA;

        verificarLogro();
    }

    private void verificarLogro() {

        if (puntos >= PUNTOS_LOGRO && !logroExplorador) {

            logroExplorador = true;

            System.out.println("🏆 Logro desbloqueado: Explorador");
        }
    }

    public int getPuntos() {
        return puntos;
    }

    public boolean tieneLogroExplorador() {
        return logroExplorador;
    }
}