package b800varios;

public class E827CadenaAlReves {
    public static void cadenaAlReves(String s) {
        if (s.isEmpty()) {
            return;
        }
        System.out.print(s.charAt(s.length() - 1));
        cadenaAlReves(s.substring(0, s.length() - 1));
    }

    static void main(String[] args) {
        cadenaAlReves("0 9 8 7 6 5 4 3 2 1");
    }
}