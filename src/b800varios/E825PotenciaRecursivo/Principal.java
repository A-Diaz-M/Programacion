package b800varios.E825PotenciaRecursivo;

public class Principal {
    public static int potencia(int base, int exp) {
        if (exp == 0) return 1;
        else return base * potencia(base, exp - 1);
    }

    public static void main(String[] args) {
        System.out.println(potencia(2, 4));
    }
}