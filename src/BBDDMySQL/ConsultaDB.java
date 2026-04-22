package BBDDMySQL;

import java.sql.*;

public class ConsultaDB {
    private static final String BD          = "agenda";
    private static final String URL         = "jdbc:mysql://localhost/";
    private static final String USUARIO     = "root";
    private static final String CONTRASENNA = "";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(URL + BD, USUARIO, CONTRASENNA);

            // SELECT - leer todos los datos
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM persona");

            while (rs.next()) {
                int    id          = rs.getInt("id");
                String nombre      = rs.getString("nombre");
                String apellidos   = rs.getString("apellidos");
                String telefono    = rs.getString("telefono");
                int    edad        = rs.getInt("edad");
                int    estrella    = rs.getInt("estrella");
                int    categoriaId = rs.getInt("categoriaId");

                System.out.println(id + " | " + nombre + " | " + apellidos + " | " + telefono + " | " + edad + " | " + estrella + " | " + categoriaId);
            }

            rs.close();
            st.close();

            // INSERT - insertar una persona nueva
            PreparedStatement insert = conn.prepareStatement(
                    "INSERT INTO persona (nombre, apellidos, telefono, edad, estrella, categoriaId) VALUES (?, ?, ?, ?, ?, ?)");
            insert.setString(1, "Hugo");
            insert.setString(2, "García");
            insert.setString(3, "600000000");
            insert.setInt(4, 23);
            insert.setInt(5, 0);
            insert.setInt(6, 1);
            insert.executeUpdate();
            System.out.println("Persona insertada.");
            insert.close();

            // DELETE - borrar por id
            PreparedStatement delete = conn.prepareStatement("DELETE FROM persona WHERE id = ?");
            delete.setInt(1, 1); // borra a Joseph (id=1)
            delete.executeUpdate();
            System.out.println("Persona borrada.");
            delete.close();

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}