package b800varios.E862MasExcepcionesEnReloj;

public class MinutoNoValidoException extends Exception {

    private int minutoRecibido;

    public MinutoNoValidoException(int minutoRecibido) {
        this.minutoRecibido = minutoRecibido;
    }

    public int getMinutoRecibido() { return minutoRecibido; }
}
