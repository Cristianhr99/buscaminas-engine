public abstract class EntidadVideojuego {

    private int x;
    private int y;
    private int w;
    private int h;

    private String nombre;
    private int estado;
    private String imagen;

    public EntidadVideojuego(int x, int y, String nombre) {
        this.x = x;
        this.y = y;
        this.w = 1;
        this.h = 1;
        this.nombre = nombre;
        this.estado = 1;
        this.imagen = "default.png";
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEstado() {
        return estado;
    }

    public String getImagen() {
        return imagen;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public abstract void actualizar();
}