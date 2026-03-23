package b400ooavanz.E431GlobosDeDistintosTipos;

public class GloboNormal extends Globo {

    public GloboNormal() {
        super();
    }

    public GloboNormal(int valor) {
        super(valor);
    }

    @Override
    public void inflar(int cantidad) {
        aire += cantidad;
    }

    @Override
    public boolean explotado() {
        return aire > capacidad;
    }
}
