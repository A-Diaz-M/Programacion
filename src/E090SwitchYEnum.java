void main() {
    IO.println("EJERCICIO 1");
    IO.println("DIA DE LA SEMANA");
    IO.println("Introduzca un numero y se dira que dia de la semana es\n");
    String nombre = IO.readln("Dime como te llamas:\n").toUpperCase();

    int num = Integer.parseInt(IO.readln(nombre + ", introduzca un numero:"));

    String dia = switch (num) {
        case 1 -> "lunes";
        case 2 -> "martes";
        case 3 -> "miercoles";
        case 4 -> "jueves";
        case 5 -> "viernes";
        case 6 -> "sabado";
        case 7 -> "domingo";
        default -> throw new IllegalArgumentException("Numero no valido");
    };
    IO.println(String.format("%s, el numero %d es el dia de la semana '%s'\n\n", nombre, num, dia));


    IO.println("EJERCICIO 2");
    IO.println("ESTACIONES DEL AÑO");
    IO.println("Introduzca un mes del año y se dira en que estación esta.\n");

    String texto = IO.readln(nombre + ", introduzca un mes:\n").toLowerCase();

    enum MesAnno {
        enero,
        febrero,
        marzo,
        abril,
        mayo,
        junio,
        julio,
        agosto,
        septiembre,
        octubre,
        noviembre,
        diciembre
    }

    MesAnno mes = MesAnno.valueOf(texto);

    String estacion = switch (mes) {
        case diciembre, enero, febrero -> "Invierno";
        case marzo, abril, mayo -> "Primavera";
        case junio, julio, agosto -> "Verano";
        case septiembre, octubre, noviembre -> "Otoño";
    };
    IO.println(String.format("%s, el mes %s esta en %s.\n\n", nombre, texto, estacion));


    IO.println("EJERCICIO 3");
    IO.println("CALIFICACION NÚMERICA");
    IO.println("Introduzca un numero y se dira que calificacion es.\n");

    int nota = Integer.parseInt(IO.readln(nombre + ", introduzca un numero:"));

    String calificacion = switch (nota) {
        case 0, 1, 2, 3, 4 -> "Suspenso";
        case 5, 6 -> "Aprobado";
        case 7, 8 -> "Notable";
        case 9, 10 -> "Sobresaliente";
        default -> throw new IllegalStateException("Nota introducida invalida.");
    };
    IO.println(String.format("%s, la nota de %d tiene una calificación de %s.\n\n", nombre, nota, calificacion));


    IO.println("EJERCICIO 4");
    IO.println("DIRECCIONES");
    IO.println("Introduzca una direccion y se dira hacia donde avanza.\n");

    String rumbo = IO.readln(nombre + ", introduzca una direccion:\n").toLowerCase();

    enum Direccion {
        norte,
        sur,
        este,
        oeste
    }

    Direccion sentido = Direccion.valueOf(rumbo);

    String orientacion = switch (sentido) {
        case norte -> ", avanzas hacia el norte";
        case sur -> ", retrocedes hacia el sur";
        case este -> ", te desplazas hacia la derecha";
        case oeste -> ", te desplazas hacia la izquierda";
    };
    IO.println(String.format("%s%s", nombre, orientacion));
}