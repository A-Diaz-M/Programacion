void main() {
    String s = "Arrivederci".toLowerCase();

    IO.print(String.format("El string tiene %d caracteres y hay una letra %s en su posición 4.\n", s.length(), s.charAt(4)));

    int cont = 0;
    int cons = 0;

    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        IO.print(c+" ");
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
            cont++;
        } else {
            cons++;
        }
    }
    IO.println();
    IO.println(String.format("La cantidad total de vocales es de %d y consonantes de %d", cont, cons));
}