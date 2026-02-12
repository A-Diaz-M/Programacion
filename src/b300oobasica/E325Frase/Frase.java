package b300oobasica.E325Frase;

public class Frase implements Cloneable {

    private StringBuilder texto;

    public Frase() {
        texto = new StringBuilder();
    }

    public Frase(String cadena) {
        texto = new StringBuilder(cadena);
    }

    public Frase(int repeticiones, String cadena) {
        texto = new StringBuilder();
        for (int i = 0; i < repeticiones; i++) {
            texto.append(cadena);
            if (i < repeticiones - 1) {
                texto.append(" ");
            }
        }
    }

    public char caracterEn(int posicion) {
        return texto.charAt(posicion);
    }

    public int longitud() {
        return texto.length();
    }

    public void anexar(String cadena) {
        if (texto.length() > 0) {
            texto.append(" ");
        }
        texto.append(cadena);
    }

    public void recortar(int numCaracteres) {
        int nuevaLongitud = texto.length() - numCaracteres;
        if (nuevaLongitud < 0) {
            texto.setLength(0);
        } else {
            texto.setLength(nuevaLongitud);
            if (texto.length() > 0 && texto.charAt(texto.length() - 1) == ' ') {
                texto.setLength(texto.length() - 1);
            }
        }
    }

    @Override
    public String toString() {
        return texto.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Frase)) return false;
        Frase otra = (Frase) obj;
        return this.texto.toString().equals(otra.texto.toString());
    }

    @Override
    public Frase clone() {
        return new Frase(this.texto.toString());
    }
}
