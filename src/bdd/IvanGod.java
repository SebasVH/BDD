package bdd;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import static org.mariadb.jdbc.plugin.authentication.standard.ed25519.Utils.bytesToHex;

/**
 *
 * @author Vespertino
 */
public class IvanGod {

    public static void comprobarNotas(JLabel lblCiclo, JLabel lblCurso, JLabel lblNombre, 
                                  JLabel lbl1, JLabel lbl2, JLabel lbl3, JLabel lbl4, 
                                  String usuario1, String password){
        String url = "jdbc:mariadb://10.227.189.184:3306/prog";
        String usuario = "root";
        String contraseña = "alumno";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            

            
            String passwordHash = password;// Implementa bytesToHex

            String query = "SELECT a.Ciclo, a.Curso, a.Nombre, " 
                     + "n.Evaluacion1, n.Evaluacion2, n.Evaluacion3, n.NotaFinal "
                     + "FROM Usuarios u "
                     + "JOIN alumnos a ON u.ID_Alumno = a.ID_Alumno " // ¡Aquí el JOIN con alumno!
                     + "JOIN Nota n ON u.ID_Alumno = n.ID_Alumno "
                     + "WHERE u.Nombre_Usuario = ? AND u.Contraseña_Hash = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setString(1, usuario1);
                stmt.setString(2, passwordHash);

                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        // Campos de la tabla alumno
                    lblCiclo.setText(rs.getString("Ciclo"));
                    lblCurso.setText(rs.getString("Curso"));
                    lblNombre.setText(rs.getString("Nombre"));
                        // Manejo seguro de posibles NULLs
                        lbl1.setText(rs.getString("Evaluacion1"));
                        lbl2.setText(rs.getString("Evaluacion2"));
                        lbl3.setText(rs.getString("Evaluacion3"));
                        lbl4.setText(rs.getString("NotaFinal"));

                        
                    
                        
                        // Repite para las demás columnas...
                    }
                    
                }
            }
        } catch (SQLException ex) {
            // Manejo de excepciones
        }
    }
    
    public static void main(String[] args) {
        
    }

}
