package b800varios.E827CadenaAlReves;

public class Principal {
    private static void imprimeCadenaAlReves(String s) {
        if (s.isEmpty()) return;

        System.out.print(s.charAt(s.length() - 1));
        imprimeCadenaAlReves(s.substring(0, s.length() - 1));
    }

    public static void main(String[] args) {
        imprimeCadenaAlReves("abcdefg");
    }
}