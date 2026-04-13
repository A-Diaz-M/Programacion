package b800varios.E862MasExcepcionesEnReloj;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        Reloj reloj = null;

        do {
            try {
                // Paso 1: preguntar al usuario qué modo de creación quiere
                System.out.println("¿Cómo quieres crear el reloj?");
                System.out.println("  1 → Introducir horas y minutos por separado");
                System.out.println("  2 → Introducir el total de minutos del día");
                System.out.print("Elige (1 o 2): ");

                int opcion = teclado.nextInt();

                if (opcion == 1) {
                    // Paso 2a: pedir horas y minutos
                    System.out.print("Horas   (0-23): ");
                    int h = teclado.nextInt();
                    System.out.print("Minutos (0-59): ");
                    int m = teclado.nextInt();

                    reloj = new Reloj(h, m);

                } else if (opcion == 2) {
                    // Paso 2b: pedir total de minutos
                    System.out.print("Total de minutos del día (0-" + (24 * 60 - 1) + "): ");
                    int totalMinutos = teclado.nextInt();

                    reloj = new Reloj(totalMinutos);

                } else {
                    System.out.println("Opción no válida. Elige 1 o 2.\n");
                }

            } catch (HoraNoValidaException e) {
                System.out.println("✗ La hora " + e.getHoraRecibida()
                        + " no es válida. Debe estar entre 0 y 23. Inténtalo de nuevo.\n");

            } catch (MinutoNoValidoException e) {
                System.out.println("✗ El minuto " + e.getMinutoRecibido()
                        + " no es válido. Debe estar entre 0 y 59. Inténtalo de nuevo.\n");

            } catch (DesbordamientoRelojException e) {
                if (e.isSuperior()) {
                    System.out.println("✗ Demasiados minutos: te has pasado " + e.getExcesoMinutos()
                            + " minuto(s) del límite del día (23:59). Inténtalo de nuevo.\n");
                } else {
                    System.out.println("✗ Minutos negativos: te has quedado " + e.getExcesoMinutos()
                            + " minuto(s) por debajo de 00:00. Inténtalo de nuevo.\n");
                }

            } catch (InputMismatchException e) {
                System.out.println("✗ Eso no es un número. Inténtalo de nuevo.\n");
                teclado.nextLine();
            }

        } while (reloj == null);

        System.out.println("\nReloj creado correctamente: " + reloj + "\n");

        boolean salir = false;

        System.out.println("Ahora puedes operar sobre el reloj.");
        System.out.println("  + N  → sumar N minutos");
        System.out.println("  - N  → restar N minutos");
        System.out.println("  q    → salir\n");

        while (!salir) {
            System.out.println("Reloj actual: " + reloj);
            System.out.print("> ");

            String cmd = teclado.next();

            if (cmd.equalsIgnoreCase("q")) {
                salir = true;

            } else if (cmd.equals("+") || cmd.equals("-")) {
                try {
                    int n = teclado.nextInt();

                    if (cmd.equals("+")) {
                        reloj.sumar(n);
                        System.out.println("  ✓ Resultado: " + reloj + "\n");
                    } else {
                        reloj.restar(n);
                        System.out.println("  ✓ Resultado: " + reloj + "\n");
                    }

                } catch (OperacionNegativaRelojException e) {
                    System.out.println("  ✗ No puedes pasar un número negativo. "
                            + "Usa el operador contrario si quieres ir en la otra dirección.\n");

                } catch (DesbordamientoRelojException e) {
                    if (e.isSuperior()) {
                        System.out.println("  ✗ Te habrías salido del día por arriba en "
                                + e.getExcesoMinutos() + " minuto(s). Operación cancelada.\n");
                    } else {
                        System.out.println("  ✗ Te habrías salido del día por abajo en "
                                + e.getExcesoMinutos() + " minuto(s). Operación cancelada.\n");
                    }

                } catch (InputMismatchException e) {
                    System.out.println("  ✗ Eso no es un número.\n");
                    teclado.nextLine();
                }

            } else {
                System.out.println("  Comando no reconocido. Usa +, - o q.\n");
            }
        }

        System.out.println("\nReloj final: " + reloj);
        teclado.close();
    }
}