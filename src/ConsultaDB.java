import java.sql.*;

public class ConsultaDB {
    private static final String BD = "prueba";
    private static final String URL = "jdbc:mysql://localhost/";
    private static final String USUARIO = "root";
    private static final String CONTRASENNA = "KahbaZebi#25";

    static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(URL + BD, USUARIO, CONTRASENNA);

            // SELECT - leer datos
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM personas");

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                System.out.println(id + " | " + nombre + " | " + edad);
            }

            rs.close();
            st.close();

            // INSERT - insertar una persona nueva
            //PreparedStatement insert = conn.prepareStatement("INSERT INTO personas (nombre, edad) VALUES (?, ?)");
            //insert.setString(1, "Hugo");
            //insert.setInt(2, 23);
            //insert.executeUpdate();
            //System.out.println("Persona insertada.");
            //insert.close();
//
            // DELETE - borrar por id
            //PreparedStatement delete = conn.prepareStatement("DELETE FROM personas WHERE id = ?");
            //delete.setInt(1, 6 ); // Borra por ID
            //delete.executeUpdate();
            //System.out.println("Persona borrada.");
            //delete.close();

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}