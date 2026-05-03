package b800varios.E883CrudAgendaCompletoConConexionBD;

import java.sql.*;

public class ConexionBD {

    private static final String BD = "agenda";
    private static final String URL = "jdbc:mysql://localhost/";
    private static final String USUARIO = "root";
    private static final String CONTRASENNA = "";

    private Connection conexion;

    // ── Constructor: comprueba el driver al instanciar ────────────────────
    public ConexionBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver no encontrado: " + e.getMessage());
        }
    }

    // ── Conectar ──────────────────────────────────────────────────────────
    public void conectar() {
        try {
            conexion = DriverManager.getConnection(URL + BD, USUARIO, CONTRASENNA);
            System.out.println("Conectado a [" + BD + "].");
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
    }

    // ── Desconectar ───────────────────────────────────────────────────────
    public void desconectar() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.out.println("Error al desconectar: " + e.getMessage());
        }
    }

    // ── Preparar sentencia ────────────────────────────────────────────────
    public PreparedStatement prepareStatement(String sql) {
        try {
            return conexion.prepareStatement(sql);
        } catch (SQLException e) {
            System.out.println("Error al preparar sentencia: " + e.getMessage());
            return null;
        }
    }

    // ── Ejecutar SELECT → devuelve ResultSet ──────────────────────────────
    public ResultSet ejecutarConsulta(PreparedStatement ps) {
        try {
            return ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error al ejecutar consulta: " + e.getMessage());
            return null;
        }
    }

    // ── Ejecutar INSERT / UPDATE / DELETE → devuelve filas afectadas ──────
    public int ejecutarActualizacion(PreparedStatement ps) {
        try {
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al ejecutar actualización: " + e.getMessage());
            return 0;
        }
    }
}
