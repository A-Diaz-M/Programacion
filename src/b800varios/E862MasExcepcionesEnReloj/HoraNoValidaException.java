package b800varios.E862MasExcepcionesEnReloj;

public class HoraNoValidaException extends Exception {

    private int horaRecibida;

    public HoraNoValidaException(int horaRecibida) {
        this.horaRecibida = horaRecibida;
    }

    public int getHoraRecibida() { return horaRecibida; }
}