package b300oobasica.E303NumeroInteligenteBasico;

public class NumeroInteligente {

    private int valor = 0;
    private int numeroPerfecto = 0;


    public NumeroInteligente (){
        valor = 1;
    }

    public NumeroInteligente (int valor){
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void incrementar() {
        setValor(valor + 1);
    }

    public void incrementar(int veces) {
        setValor(valor + veces);
    }

    public void decrementar(int veces) {
        setValor(valor - veces);
    }

    public void decrementar() {
        setValor(valor - 1);
    }

    public Boolean esPrimo() {
        if (valor == 1) return false;
        for (int i = 2; i <= valor - 1; i++) {
            if (valor % i == 0) return false;
        }
        return true;
    }

    public Boolean esPrimo(int numero) {
        if (numero == 1) return false;
        for (int i = 2; i <= numero - 1; i++) {
            if (numero % i == 0) return false;
        }
        return true;
    }


    public Boolean esPerfecto() {
        int numMersenne = (int) Math.pow(2, valor) - 1;

        if (esPrimo(numMersenne)) {
            numeroPerfecto = numMersenne * (int) Math.pow(2, valor - 1);
            return true;
        }
        return false;
    }

    public int getNumeroPerfecto() {
        return numeroPerfecto;
    }
}