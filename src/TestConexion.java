import java.sql.Connection;
import java.sql.DriverManager;

public class TestConexion {
    private static final String BD = "prueba";
    private static final String URL = "jdbc:mysql://localhost/";
    private static final String USUARIO = "root";
    private static final String CONTRASENNA = "KahbaZebi#25";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(URL + BD, USUARIO, CONTRASENNA);
            if (conn != null) {
                System.out.println("Conectado a la base de datos [" + BD + "]");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}