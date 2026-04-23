package BBDDMySQL.E880PruebaDeConceptoBBDD;

import java.net.URL;
import java.sql.*;

public class E880PruebaDeConceptoBBDD {

    private static final String BD          = "agenda";
    private static final String URL         = "jdbc:mysql://localhost/";
    private static final String USUARIO     = "root";
    private static final String CONTRASENNA = "";

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver encontrado correctamente.");
        } catch (ClassNotFoundException e) {
            System.out.println("No se ha podido encontrar el driver.");
            return;
        }

        try {
            Connection conn = DriverManager.getConnection(URL + BD, USUARIO, CONTRASENNA);
            if (conn != null) {
                System.out.println("Conectado a la base de datos [" + BD + "]\n");
            }

            // ── 3. MOSTRAR TODAS LAS CATEGORÍAS ─────────────────────────────
            System.out.println("=== CATEGORÍAS ===");
            String sqlSelectCategorias = "SELECT id, nombre FROM categoria";
            PreparedStatement psSelectCategorias = conn.prepareStatement(sqlSelectCategorias);
            ResultSet rsSelectCategorias = psSelectCategorias.executeQuery();
            while (rsSelectCategorias.next()) {
                int    idCat     = rsSelectCategorias.getInt("id");
                String nombreCat = rsSelectCategorias.getString("nombre");
                System.out.println("  [" + idCat + "] " + nombreCat);
            }
            rsSelectCategorias.close();
            psSelectCategorias.close();

            // ── 4. MOSTRAR TODAS LAS PERSONAS ────────────────────────────────
            System.out.println("\n=== PERSONAS ===");
            String sqlSelectPersonas = "SELECT id, nombre, apellidos, telefono, edad, estrella, categoriaId FROM persona";
            PreparedStatement psSelectPersonas = conn.prepareStatement(sqlSelectPersonas);
            ResultSet rsSelectPersonas = psSelectPersonas.executeQuery();
            while (rsSelectPersonas.next()) {
                System.out.println(
                        "  [" + rsSelectPersonas.getInt("id") + "] "
                                + rsSelectPersonas.getString("nombre") + " "
                                + rsSelectPersonas.getString("apellidos")
                                + " | Tel: "      + rsSelectPersonas.getString("telefono")
                                + " | Edad: "     + rsSelectPersonas.getInt("edad")
                                + " | Estrella: " + rsSelectPersonas.getInt("estrella")
                                + " | CatID: "    + rsSelectPersonas.getInt("categoriaId")
                );
            }
            rsSelectPersonas.close();
            psSelectPersonas.close();

            // ── 5. INSERTAR CATEGORÍA NUEVA ──────────────────────────────────
            System.out.println("\n=== INSERTAR CATEGORÍA ===");
            String sqlInsertCategoria = "INSERT INTO categoria (nombre) VALUES (?)";
            PreparedStatement psInsertCategoria = conn.prepareStatement(sqlInsertCategoria);
            psInsertCategoria.setString(1, "Vecinos");
            psInsertCategoria.executeUpdate();
            System.out.println("Categoría 'Vecinos' insertada.");
            psInsertCategoria.close();

            // ── 6. INSERTAR PERSONA NUEVA ─────────────────────────────────────
            System.out.println("\n=== INSERTAR PERSONA ===");
            String sqlInsertPersona = "INSERT INTO persona (nombre, apellidos, telefono, edad, estrella, categoriaId) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement psInsertPersona = conn.prepareStatement(sqlInsertPersona);
            psInsertPersona.setString(1, "Ana");
            psInsertPersona.setString(2, "Ruiz López");
            psInsertPersona.setString(3, "612345678");
            psInsertPersona.setInt   (4, 28);
            psInsertPersona.setInt   (5, 1);
            psInsertPersona.setInt   (6, 2);
            psInsertPersona.executeUpdate();
            System.out.println("Persona 'Ana Ruiz López' insertada.");
            psInsertPersona.close();

            // ── 7. ELIMINAR UNA CATEGORÍA ────────────────────────────────────
            System.out.println("\n=== ELIMINAR CATEGORÍA ===");
            String sqlDeleteCategoria = "DELETE FROM categoria WHERE nombre = ?";
            PreparedStatement psDeleteCategoria = conn.prepareStatement(sqlDeleteCategoria);
            psDeleteCategoria.setString(1, "Vecinos");
            int filasDeleteCategoria = psDeleteCategoria.executeUpdate();
            System.out.println("Categorías eliminadas: " + filasDeleteCategoria);
            psDeleteCategoria.close();

            // ── 8. ELIMINAR UNA PERSONA ──────────────────────────────────────
            System.out.println("\n=== ELIMINAR PERSONA ===");
            String sqlDeletePersona = "DELETE FROM persona WHERE nombre = ? AND apellidos = ?";
            PreparedStatement psDeletePersona = conn.prepareStatement(sqlDeletePersona);
            psDeletePersona.setString(1, "Ana");
            psDeletePersona.setString(2, "Ruiz López");
            int filasDeletePersona = psDeletePersona.executeUpdate();
            System.out.println("Personas eliminadas: " + filasDeletePersona);
            psDeletePersona.close();

            // ── 9. MODIFICAR CATEGORÍA (cambiar nombre) ───────────────────────
            System.out.println("\n=== MODIFICAR CATEGORÍA (cambiar nombre) ===");
            String sqlUpdateCategoria = "UPDATE categoria SET nombre = ? WHERE id = ?";
            PreparedStatement psUpdateCategoria = conn.prepareStatement(sqlUpdateCategoria);
            psUpdateCategoria.setString(1, "Compañeros de clase");
            psUpdateCategoria.setInt   (2, 8);
            int filasUpdateCategoria = psUpdateCategoria.executeUpdate();
            System.out.println("Categorías actualizadas: " + filasUpdateCategoria);
            psUpdateCategoria.close();

            // ── 10. MODIFICAR PERSONA (cambiar edad a valor fijo) ─────────────
            System.out.println("\n=== MODIFICAR PERSONA (edad fija) ===");
            String sqlUpdateEdadFija = "UPDATE persona SET edad = ? WHERE id = ?";
            PreparedStatement psUpdateEdadFija = conn.prepareStatement(sqlUpdateEdadFija);
            psUpdateEdadFija.setInt(1, 35);
            psUpdateEdadFija.setInt(2, 1);
            int filasUpdateEdadFija = psUpdateEdadFija.executeUpdate();
            System.out.println("Personas actualizadas: " + filasUpdateEdadFija);
            psUpdateEdadFija.close();

            // ── 11. MODIFICAR PERSONA (sumar un año a la edad actual) ─────────
            System.out.println("\n=== MODIFICAR PERSONA (sumar un año) ===");

            // Paso A: leer la edad actual
            String sqlSelectEdad = "SELECT edad FROM persona WHERE id = ?";
            PreparedStatement psSelectEdad = conn.prepareStatement(sqlSelectEdad);
            psSelectEdad.setInt(1, 3);
            ResultSet rsSelectEdad = psSelectEdad.executeQuery();
            rsSelectEdad.next();
            int edadActual = rsSelectEdad.getInt("edad");
            rsSelectEdad.close();
            psSelectEdad.close();

            // Paso B: escribir edad + 1
            String sqlUpdateEdadMasUno = "UPDATE persona SET edad = ? WHERE id = ?";
            PreparedStatement psUpdateEdadMasUno = conn.prepareStatement(sqlUpdateEdadMasUno);
            psUpdateEdadMasUno.setInt(1, edadActual + 1);
            psUpdateEdadMasUno.setInt(2, 3);
            int filasUpdateEdadMasUno = psUpdateEdadMasUno.executeUpdate();
            System.out.println("Edad actualizada de " + edadActual + " a " + (edadActual + 1)
                    + "  (filas: " + filasUpdateEdadMasUno + ")");
            psUpdateEdadMasUno.close();

            // ── CERRAR CONEXIÓN ───────────────────────────────────────────────
            conn.close();
            System.out.println("\nConexión cerrada. Fin del programa.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
