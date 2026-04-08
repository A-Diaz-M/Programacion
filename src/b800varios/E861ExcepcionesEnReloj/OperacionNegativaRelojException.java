package b800varios.E861ExcepcionesEnReloj;

// Se lanza cuando se intenta sumar o restar un número negativo de minutos.
public class OperacionNegativaRelojException extends Exception {
    private static final long serialVersionUID = 1L;

    public OperacionNegativaRelojException(String mensaje) {
        super(mensaje);
    }
}
