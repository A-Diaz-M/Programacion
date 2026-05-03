package b800varios.E883CrudAgendaCompletoConConexionBD;

import java.sql.*;
import java.util.Scanner;

public class Principal {

    static ConexionBD bd = new ConexionBD();
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        bd.conectar();

        int opcion;
        do {
            System.out.println("\n╔══════════════════════════════╗");
            System.out.println("║         MENÚ PRINCIPAL       ║");
            System.out.println("║  1. Gestión de categorías    ║");
            System.out.println("║  2. Gestión de personas      ║");
            System.out.println("║  0. Salir                    ║");
            System.out.println("╚══════════════════════════════╝");
            System.out.print("Elige: ");
            opcion = Integer.parseInt(teclado.nextLine().trim());

            switch (opcion) {
                case 1 -> menuCategorias();
                case 2 -> menuPersonas();
                case 0 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        bd.desconectar();
    }

    // ════════════════════════════════════════════════════════════════════════
    //  MENÚ CATEGORÍAS
    // ════════════════════════════════════════════════════════════════════════
    private static void menuCategorias() {
        int opcion;
        do {
            System.out.println("\n┌──────────────────────────────┐");
            System.out.println("│      GESTIÓN CATEGORÍAS      │");
            System.out.println("│  1. Listar                   │");
            System.out.println("│  2. Obtener por id           │");
            System.out.println("│  3. Insertar                 │");
            System.out.println("│  4. Eliminar                 │");
            System.out.println("│  5. Modificar                │");
            System.out.println("│  0. Volver                   │");
            System.out.println("└──────────────────────────────┘");
            System.out.print("Elige: ");
            opcion = Integer.parseInt(teclado.nextLine().trim());

            switch (opcion) {
                case 1 -> catListar();
                case 2 -> catObtener();
                case 3 -> catInsertar();
                case 4 -> catEliminar();
                case 5 -> catModificar();
                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    // ── Listar categorías ordenadas por nombre ────────────────────────────
    private static void catListar() {
        PreparedStatement ps = bd.prepareStatement(
                "SELECT id, nombre FROM categoria ORDER BY nombre");
        ResultSet rs = bd.ejecutarConsulta(ps);

        System.out.println("\n── Categorías ──────────────────");
        try {
            boolean hay = false;
            while (rs != null && rs.next()) {
                hay = true;
                System.out.printf("  [%2d] %s%n", rs.getInt("id"), rs.getString("nombre"));
            }
            if (!hay) System.out.println("  (No hay categorías.)");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("────────────────────────────────");
    }

    // ── Obtener categoría por id ──────────────────────────────────────────
    private static void catObtener() {
        System.out.print("\nId de la categoría (vacío para cancelar): ");
        String linea = teclado.nextLine().trim();
        if (linea.isEmpty()) {
            System.out.println("Cancelado.");
            return;
        }

        PreparedStatement ps = bd.prepareStatement(
                "SELECT id, nombre FROM categoria WHERE id = ?");
        try {
            ps.setInt(1, Integer.parseInt(linea));
            ResultSet rs = bd.ejecutarConsulta(ps);
            if (rs != null && rs.next())
                System.out.printf("  [%2d] %s%n", rs.getInt("id"), rs.getString("nombre"));
            else
                System.out.println("No existe ninguna categoría con ese id.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // ── Insertar categoría ────────────────────────────────────────────────
    private static void catInsertar() {
        System.out.print("\nNombre de la nueva categoría (vacío para cancelar): ");
        String nombre = teclado.nextLine().trim();
        if (nombre.isEmpty()) {
            System.out.println("Cancelado.");
            return;
        }

        PreparedStatement ps = bd.prepareStatement(
                "INSERT INTO categoria (nombre) VALUES (?)");
        try {
            ps.setString(1, nombre);
            int filas = bd.ejecutarActualizacion(ps);
            if (filas > 0) System.out.println("Categoría '" + nombre + "' insertada.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // ── Eliminar categoría (por id o por nombre) ──────────────────────────
    private static void catEliminar() {
        catListar();
        System.out.println("\n¿Eliminar por:  1. Id   2. Nombre   0. Cancelar");
        System.out.print("Elige: ");
        String modo = teclado.nextLine().trim();

        if (modo.equals("0")) {
            System.out.println("Cancelado.");
            return;
        }

        try {
            PreparedStatement ps;
            if (modo.equals("1")) {
                System.out.print("Id a eliminar (vacío para cancelar): ");
                String l = teclado.nextLine().trim();
                if (l.isEmpty()) {
                    System.out.println("Cancelado.");
                    return;
                }
                ps = bd.prepareStatement("DELETE FROM categoria WHERE id = ?");
                ps.setInt(1, Integer.parseInt(l));
            } else {
                System.out.print("Nombre a eliminar (vacío para cancelar): ");
                String l = teclado.nextLine().trim();
                if (l.isEmpty()) {
                    System.out.println("Cancelado.");
                    return;
                }
                ps = bd.prepareStatement("DELETE FROM categoria WHERE nombre = ?");
                ps.setString(1, l);
            }
            int filas = bd.ejecutarActualizacion(ps);
            System.out.println(filas > 0 ? "Categoría eliminada." : "No se encontró la categoría.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // ── Modificar categoría ───────────────────────────────────────────────
    private static void catModificar() {
        catListar();
        System.out.print("\nId de la categoría a modificar (vacío para cancelar): ");
        String lineaId = teclado.nextLine().trim();
        if (lineaId.isEmpty()) {
            System.out.println("Cancelado.");
            return;
        }

        int id = Integer.parseInt(lineaId);

        try {
            // Leer nombre actual
            PreparedStatement psLeer = bd.prepareStatement(
                    "SELECT nombre FROM categoria WHERE id = ?");
            psLeer.setInt(1, id);
            ResultSet rs = bd.ejecutarConsulta(psLeer);
            if (rs == null || !rs.next()) {
                System.out.println("No existe esa categoría.");
                return;
            }
            String nombreActual = rs.getString("nombre");
            System.out.println("Nombre actual: " + nombreActual);

            // Pedir nuevo nombre en bucle hasta que sea distinto o se cancele
            String nombreNuevo;
            while (true) {
                System.out.print("Nuevo nombre (vacío para cancelar): ");
                nombreNuevo = teclado.nextLine().trim();
                if (nombreNuevo.isEmpty()) {
                    System.out.println("Cancelado.");
                    return;
                }
                if (nombreNuevo.equalsIgnoreCase(nombreActual))
                    System.out.println("Es el mismo nombre. Introduce uno diferente.");
                else break;
            }

            PreparedStatement psUpd = bd.prepareStatement(
                    "UPDATE categoria SET nombre = ? WHERE id = ?");
            psUpd.setString(1, nombreNuevo);
            psUpd.setInt(2, id);
            int filas = bd.ejecutarActualizacion(psUpd);
            if (filas > 0)
                System.out.println("Actualizado: '" + nombreActual + "' → '" + nombreNuevo + "'");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    // ════════════════════════════════════════════════════════════════════════
    //  MENÚ PERSONAS
    // ════════════════════════════════════════════════════════════════════════
    private static void menuPersonas() {
        int opcion;
        do {
            System.out.println("\n┌──────────────────────────────┐");
            System.out.println("│       GESTIÓN PERSONAS       │");
            System.out.println("│  1. Listar                   │");
            System.out.println("│  2. Obtener por id           │");
            System.out.println("│  3. Insertar                 │");
            System.out.println("│  4. Eliminar                 │");
            System.out.println("│  5. Modificar                │");
            System.out.println("│  0. Volver                   │");
            System.out.println("└──────────────────────────────┘");
            System.out.print("Elige: ");
            opcion = Integer.parseInt(teclado.nextLine().trim());

            switch (opcion) {
                case 1 -> perListar();
                case 2 -> perObtener();
                case 3 -> perInsertar();
                case 4 -> perEliminar();
                case 5 -> perModificar();
                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    // ── Listar personas ───────────────────────────────────────────────────
    private static void perListar() {
        PreparedStatement ps = bd.prepareStatement(
                "SELECT id, nombre, apellidos, telefono, edad, estrella, categoriaId " +
                        "FROM persona ORDER BY apellidos, nombre");
        ResultSet rs = bd.ejecutarConsulta(ps);

        System.out.println("\n── Personas ────────────────────────────────────────────");
        try {
            boolean hay = false;
            while (rs != null && rs.next()) {
                hay = true;
                System.out.printf("  [%2d] %-10s %-20s | Tel: %-10s | Edad: %2d | ⭐:%d | CatID:%d%n",
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("telefono"),
                        rs.getInt("edad"),
                        rs.getInt("estrella"),
                        rs.getInt("categoriaId"));
            }
            if (!hay) System.out.println("  (No hay personas.)");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("────────────────────────────────────────────────────────");
    }

    // ── Obtener persona por id ────────────────────────────────────────────
    private static void perObtener() {
        System.out.print("\nId de la persona (vacío para cancelar): ");
        String linea = teclado.nextLine().trim();
        if (linea.isEmpty()) {
            System.out.println("Cancelado.");
            return;
        }

        PreparedStatement ps = bd.prepareStatement(
                "SELECT id, nombre, apellidos, telefono, edad, estrella, categoriaId " +
                        "FROM persona WHERE id = ?");
        try {
            ps.setInt(1, Integer.parseInt(linea));
            ResultSet rs = bd.ejecutarConsulta(ps);
            if (rs != null && rs.next())
                System.out.printf("  [%2d] %s %s | Tel: %s | Edad: %d | ⭐:%d | CatID:%d%n",
                        rs.getInt("id"), rs.getString("nombre"), rs.getString("apellidos"),
                        rs.getString("telefono"), rs.getInt("edad"),
                        rs.getInt("estrella"), rs.getInt("categoriaId"));
            else
                System.out.println("No existe ninguna persona con ese id.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // ── Insertar persona ──────────────────────────────────────────────────
    private static void perInsertar() {
        System.out.println("\nIntroduce los datos (vacío en nombre para cancelar):");

        System.out.print("  Nombre: ");
        String nombre = teclado.nextLine().trim();
        if (nombre.isEmpty()) {
            System.out.println("Cancelado.");
            return;
        }

        System.out.print("  Apellidos: ");
        String apellidos = teclado.nextLine().trim();

        System.out.print("  Teléfono: ");
        String telefono = teclado.nextLine().trim();

        System.out.print("  Edad: ");
        int edad = Integer.parseInt(teclado.nextLine().trim());

        System.out.print("  Estrella (0/1): ");
        int estrella = Integer.parseInt(teclado.nextLine().trim());

        catListar();
        System.out.print("  CategoriaId: ");
        int categoriaId = Integer.parseInt(teclado.nextLine().trim());

        try {
            PreparedStatement ps = bd.prepareStatement(
                    "INSERT INTO persona (nombre, apellidos, telefono, edad, estrella, categoriaId) " +
                            "VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, nombre);
            ps.setString(2, apellidos);
            ps.setString(3, telefono);
            ps.setInt(4, edad);
            ps.setInt(5, estrella);
            ps.setInt(6, categoriaId);
            int filas = bd.ejecutarActualizacion(ps);
            if (filas > 0) System.out.println("Persona '" + nombre + " " + apellidos + "' insertada.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // ── Eliminar persona ──────────────────────────────────────────────────
    private static void perEliminar() {
        perListar();
        System.out.print("\nId de la persona a eliminar (vacío para cancelar): ");
        String linea = teclado.nextLine().trim();
        if (linea.isEmpty()) {
            System.out.println("Cancelado.");
            return;
        }

        try {
            PreparedStatement ps = bd.prepareStatement("DELETE FROM persona WHERE id = ?");
            ps.setInt(1, Integer.parseInt(linea));
            int filas = bd.ejecutarActualizacion(ps);
            System.out.println(filas > 0 ? "Persona eliminada." : "No se encontró la persona.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // ── Modificar persona ─────────────────────────────────────────────────
    private static void perModificar() {
        perListar();
        System.out.print("\nId de la persona a modificar (vacío para cancelar): ");
        String lineaId = teclado.nextLine().trim();
        if (lineaId.isEmpty()) {
            System.out.println("Cancelado.");
            return;
        }

        int id = Integer.parseInt(lineaId);

        try {
            // Leer datos actuales
            PreparedStatement psLeer = bd.prepareStatement(
                    "SELECT nombre, apellidos, telefono, edad, estrella, categoriaId " +
                            "FROM persona WHERE id = ?");
            psLeer.setInt(1, id);
            ResultSet rs = bd.ejecutarConsulta(psLeer);
            if (rs == null || !rs.next()) {
                System.out.println("No existe esa persona.");
                return;
            }

            String nombreAct = rs.getString("nombre");
            String apellidosAct = rs.getString("apellidos");
            String telefonoAct = rs.getString("telefono");
            int edadAct = rs.getInt("edad");
            int estrellaAct = rs.getInt("estrella");
            int catIdAct = rs.getInt("categoriaId");

            System.out.println("\nDeja vacío para conservar el valor actual.");

            System.out.print("  Nombre [" + nombreAct + "]: ");
            String nombre = teclado.nextLine().trim();
            if (nombre.isEmpty()) nombre = nombreAct;

            System.out.print("  Apellidos [" + apellidosAct + "]: ");
            String apellidos = teclado.nextLine().trim();
            if (apellidos.isEmpty()) apellidos = apellidosAct;

            System.out.print("  Teléfono [" + telefonoAct + "]: ");
            String telefono = teclado.nextLine().trim();
            if (telefono.isEmpty()) telefono = telefonoAct;

            System.out.print("  Edad [" + edadAct + "]: ");
            String edadStr = teclado.nextLine().trim();
            int edad = edadStr.isEmpty() ? edadAct : Integer.parseInt(edadStr);

            System.out.print("  Estrella [" + estrellaAct + "]: ");
            String estrellaStr = teclado.nextLine().trim();
            int estrella = estrellaStr.isEmpty() ? estrellaAct : Integer.parseInt(estrellaStr);

            catListar();
            System.out.print("  CategoriaId [" + catIdAct + "]: ");
            String catStr = teclado.nextLine().trim();
            int categoriaId = catStr.isEmpty() ? catIdAct : Integer.parseInt(catStr);

            PreparedStatement psUpd = bd.prepareStatement(
                    "UPDATE persona SET nombre=?, apellidos=?, telefono=?, edad=?, estrella=?, categoriaId=? " +
                            "WHERE id=?");
            psUpd.setString(1, nombre);
            psUpd.setString(2, apellidos);
            psUpd.setString(3, telefono);
            psUpd.setInt(4, edad);
            psUpd.setInt(5, estrella);
            psUpd.setInt(6, categoriaId);
            psUpd.setInt(7, id);
            int filas = bd.ejecutarActualizacion(psUpd);
            if (filas > 0) System.out.println("Persona actualizada correctamente.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
