package b800varios.E862MasExcepcionesEnReloj;

public class DesbordamientoRelojException extends Exception {

    private boolean superior;
    private int     excesoMinutos;

    public DesbordamientoRelojException(boolean superior, int excesoMinutos) {
        this.superior      = superior;
        this.excesoMinutos = excesoMinutos;
    }

    public boolean isSuperior()     { return superior;      }
    public int     getExcesoMinutos() { return excesoMinutos; }
}