package b300oobasica.E303ContadorConPasoYRedondeo;

public class Contador {

    private static final int MIN = 0;
    private static final int MAX = 100;
    private static final int RESET = 50;

    private int valor = 0;
    private int paso = 1;
    private boolean redondeo = false;
    private String etiqueta = "Unidades";

    public Contador() {
        setValor(MIN);
    }
    public Contador(int valor) {
        setValor(valor);
    }
    public Contador(int valor, int paso) {
        this.paso = paso;
        setValor(valor);
    }
    public Contador(int valor, int paso, boolean redondeo) {
        this.paso = paso;
        this.redondeo = redondeo;
        setValor(valor);
    }
    public Contador(String etiqueta) {
        this.etiqueta = etiqueta;
    }
    public Contador(int valor, String etiqueta) {
        setValor(valor);
        this.etiqueta = etiqueta;
    }

    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        valor = aplicarRedondeo(valor);

        if (valor > MAX) this.valor = MAX;
        else if (valor < MIN) this.valor = MIN;
        else this.valor = valor;
    }
    public int getPaso() {
        return paso;
    }
    public void setPaso(int paso) {
        this.paso = paso;
        setValor(this.valor);
    }
    public boolean getRedondeo() {
        return redondeo;
    }
    public void setRedondeo(boolean redondeo) {
        this.redondeo = redondeo;
        setValor(this.valor);
    }
    public String getEtiqueta() {
        return etiqueta;
    }
    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    @Override
    public String toString() {
        return "Valgo: " + valor + " " + etiqueta;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;

        if (!(obj instanceof Contador)) return false;

        Contador otro = (Contador) obj;
        return (this.valor == otro.valor);
    }

    @Override
    public Contador clone() {
        return new Contador(this.valor, this.etiqueta);

    }

    public void resetear() {
        valor = RESET;
    }
    public void incrementar() {
        setValor(valor + paso);
    }
    public void incrementar(int veces) {
        setValor(valor + veces);
    }
    public void decrementar() {
        setValor(valor - paso);
    }
    public void decrementar(int veces) {
        setValor(valor - veces);
    }

    private int aplicarRedondeo(int valor) {
        if (redondeo && paso > 1) {
            valor = (valor / paso) * paso;
        }
        return valor;
    }
    public boolean redondeo(int veces) {
        return veces % paso == 0;
    }
}