import java.util.Random;

void main() {
    Random random = new Random();

    int longitud;
    char especiales;
    String contrasena = "";

    IO.println("Voy a generar tu contraseña.");

    do {
        IO.println("¿Cuántos caracteres quieres que tenga? (Entre 4 y 30): ");
        longitud = Integer.parseInt(IO.readln());
    } while (longitud < 4 || longitud > 30);

    IO.println("¿Te parece bien si aparecen caracteres especiales? (s/n): ");
    especiales = IO.readln().toLowerCase().charAt(0);

    for (int i = 0; i < longitud; i++) {

        int tipo;

        if (especiales == 's') {
            tipo = random.nextInt(4);
        } else {
            tipo = random.nextInt(3);
        }

        char caracter = 0;
        int[] especialesChars = {35, 36, 37, 38};

        switch (tipo) {
            case 0 -> caracter = (char) (random.nextInt(26) + 65);//mayusculas
            case 1 -> caracter = (char) (random.nextInt(26) + 97);//minusculas
            case 2 -> caracter = (char) (random.nextInt(10) + 48);//numeros
            case 3 -> caracter = (char) especialesChars[random.nextInt(especialesChars.length)];//especiales
        }

        contrasena += caracter;
        IO.print("*");
    }

    IO.println("\nContraseña generada.");
    IO.println("Introduce 'ok' para ver la contraseña.");

    String respuesta;
    do {
        respuesta = IO.readln();
    } while (!respuesta.equalsIgnoreCase("ok"));

    IO.println("La contraseña generada es " + contrasena);
}