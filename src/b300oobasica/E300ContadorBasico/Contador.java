package b300oobasica.E300ContadorBasico;

public class Contador {
    private static final int MIN = 0;
    private static final int MAX = 100;

    private int valor = 0;
    private String etiqueta;

    public Contador () {
        setValor(MIN);
    }

    public Contador (int valor){
        setValor(valor);
    }

    public String toString (){
        return "valgo " + valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        if      (valor > MAX) this.valor =   100;
        else if (valor < MIN) this.valor =     0;
        else                  this.valor = valor;
        //valor = Math.min(Math.max(valor,0),100);
    }

    public void incrementar(int veces) {
        for (int i = 0; i < veces; i++){
            if (valor < MAX) valor++;
        }
    }

    public void decrementar(int veces) {
        for (int i = 0; i < veces; i++){
            if (valor > MIN) valor--;
        }
    }
}