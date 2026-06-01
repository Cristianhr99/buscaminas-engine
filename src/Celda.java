public class Celda extends EntidadVideojuego {

    private boolean mina;
    private boolean descubierta;

    public Celda(int x, int y, boolean mina) {
        super(x, y, "Celda");
        this.mina = mina;
        this.descubierta = false;
    }

    public boolean tieneMina() {
        return mina;
    }

    public boolean isDescubierta() {
        return descubierta;
    }

    public void descubrir() {
        descubierta = true;
    }

    @Override
    public void actualizar() {
        System.out.println("Celda (" + getX() + "," + getY() + ")");
    }
}