package bdd;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import static org.mariadb.jdbc.plugin.authentication.standard.ed25519.Utils.bytesToHex;

/**
 *
 * @author Vespertino
 */
public class Metodos {
    /*
    public static void comprobarNotas() {
    String url = "jdbc:mariadb://localhost:3306/prueba";
    String usuario = "root";
    String contraseña = "alumno";
    String usuario1 = "juanperez";
    String password = "comida"; // Contraseña en texto plano
    String passwordHash = cifrarMD5(password);
        System.out.println(passwordHash);// Convertimos a hash

    try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {

        String query = "SELECT a.Ciclo, a.Curso, a.Nombre, "
                + "COALESCE(n.Evaluacion1, 0) AS Evaluacion1, "
                + "COALESCE(n.Evaluacion2, 0) AS Evaluacion2, "
                + "COALESCE(n.Evaluacion3, 0) AS Evaluacion3, "
                + "COALESCE(n.NotaFinal, 0) AS NotaFinal "
                + "FROM Usuarios u "
                + "JOIN Alumnos a ON u.ID_Alumno = a.ID_Alumno "
                + "LEFT JOIN Nota n ON u.ID_Alumno = n.ID_Alumno "
                + "WHERE u.Nombre_Usuario = ? AND u.Contraseña_Hash = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, usuario1);
            stmt.setString(2, passwordHash);

            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.isBeforeFirst()) {  // No hay resultados
                    System.out.println("⚠️ No se encontraron notas para este usuario.");
                    return;
                }

                while (rs.next()) {
                    System.out.println("Ciclo: " + rs.getString("Ciclo"));
                    System.out.println("Curso: " + rs.getString("Curso"));
                    System.out.println("Nombre: " + rs.getString("Nombre"));
                    System.out.println("Evaluación 1: " + rs.getFloat("Evaluacion1"));
                    System.out.println("Evaluación 2: " + rs.getFloat("Evaluacion2"));
                    System.out.println("Evaluación 3: " + rs.getFloat("Evaluacion3"));
                    System.out.println("Nota Final: " + rs.getFloat("NotaFinal"));
                }
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace(); // Para ver el error exacto en la consola
    }
}*/

     public static String cifrarMD5(String input) {
        String[] cont;
        try {
            // Crear un objeto MessageDigest para MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            
            // Pasar la entrada a bytes y obtener el hash
            byte[] bytes = md.digest(input.getBytes());
            
            // Convertir el byte[] resultante a una cadena hexadecimal
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%2x", b)); // Formato hexadecimal
            }
            
            cont=sb.toString().split(" "); // Devolver el hash en formato hexadecimal
            return cont[0];
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null; // Si ocurre un error, devolver null
        }}
     
      public static Connection getPatata() throws Exception {
        return DriverManager.getConnection(
            "jdbc:mariadb://localhost:3306/prueba",
            "root", 
            "alumno");
    }
     public static List<Object[]> obtenerDatosCombinados(int id) {
        List<Object[]> resultados = new ArrayList<>();
        String query = "SELECT n.Evaluacion1, n.Evaluacion2, n.Evaluacion3, n.NotaFinal, "
                     + "m.ID_Profesor, n.ID_Modulo, a.Nombre, a.Ciclo, a.Curso "
                     + "FROM Nota n "
                     + "JOIN Modulo m ON n.ID_Modulo = m.ID_Modulo "
                     + "JOIN Alumnos a ON n.ID_Alumno = a.ID_Alumno "
                     + "WHERE n.ID_Alumno = ?";

        try (Connection conn = getPatata();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Object[] fila = {
                    rs.getFloat("Evaluacion1"),
                    rs.getFloat("Evaluacion2"),
                    rs.getFloat("Evaluacion3"),
                    rs.getFloat("NotaFinal"),
                    rs.getInt("ID_Profesor"),
                    rs.getInt("ID_Modulo"),
                    rs.getString("Nombre"),
                    rs.getString("Ciclo"),
                    rs.getString("Curso")
                };
                resultados.add(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultados;
    }
    public static String getNombreProfesor(int idProfesor) {
    try (Connection conn = getPatata();
         PreparedStatement pstmt = conn.prepareStatement(
             "SELECT CONCAT(Nombre, ' ', Apellidos) FROM Profesores WHERE ID_Profesor = ?")) {
        pstmt.setInt(1, idProfesor);
        ResultSet rs = pstmt.executeQuery();
        return rs.next() ? rs.getString(1) : "Profesor no encontrado";
    }   catch (Exception ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
            return "aña";
        }
    
}
    public static String getNombreModulo(int idModulo) {
    try (Connection conn = getPatata();
         PreparedStatement pstmt = conn.prepareStatement(
             "SELECT Nombre_Modulo FROM Modulo WHERE ID_Modulo = ?")) {
        pstmt.setInt(1, idModulo);
        ResultSet rs = pstmt.executeQuery();
        return rs.next() ? rs.getString(1) : "Módulo no encontrado";
    }   catch (Exception ex) {
            return "jijija";
        }
}
    public static int obtenerIdAlPC(String usuario, String contraseña) {
        String query = "SELECT u.ID_Alumno FROM Usuarios u "
                     + "WHERE u.Nombre_Usuario = ? AND u.Contraseña_Hash = ? "
                     + "AND u.Rol = 'Alumno'";  // Aseguramos que sea un alumno

        try (Connection conn = getPatata();
             PreparedStatement pstmt = conn.prepareStatement(query);) {
            
            pstmt.setString(1, usuario);
            pstmt.setString(2, contraseña);
            
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return rs.getInt("ID_Alumno");
            } else {
                System.out.println("no se encontro");
                return -1; // Retorna -1 si no encuentra coincidencias
            }
        } catch (Exception ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Pendejo");
        return 0;
        }
    public static int obtenerIdProfPC(String usuario, String contraseña) {
        String query = "SELECT u.ID_Profesor FROM Usuarios u "
                     + "WHERE u.Nombre_Usuario = ? AND u.Contraseña_Hash = ? "
                     + "AND u.Rol = 'Profesor'";  // Aseguramos que sea un Profesor

        try (Connection conn = getPatata();
             PreparedStatement pstmt = conn.prepareStatement(query);) {
            
            pstmt.setString(1, usuario);
            pstmt.setString(2, contraseña);
            
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return rs.getInt("ID_Profesor");
            } else {
                System.out.println("no se encontro");
                return -1; // Retorna -1 si no encuentra coincidencias
            }
        } catch (Exception ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Pendejo");
        return 0;
        }
    public static String getNombreAl(int id_alumno){
    try (Connection conn = getPatata();
         PreparedStatement pstmt = conn.prepareStatement(
             "SELECT Nombre,Apellidos FROM Alumnos WHERE ID_Alumno = ?")) {
        pstmt.setInt(1, id_alumno);
        ResultSet rs = pstmt.executeQuery();
        
        return rs.next() ? rs.getString(1)+" "+rs.getString(2) : "Módulo no encontrado";
    }   catch (Exception ex) {
            return "jijija";
        }
    }
    public static void cargarWombo(JComboBox<String> combo, int idProfesor) {
    combo.removeAllItems(); // Limpiar combo existente
    
    String query = "SELECT Nombre_Modulo, Ciclo, Curso FROM Modulo WHERE ID_Profesor = ?";
    
    try (Connection conn = getPatata();
         PreparedStatement pstmt = conn.prepareStatement(query)) {
        
        pstmt.setInt(1, idProfesor);
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()) {
            String textoCombo = String.format("%s | %s | %s", 
                rs.getString("Nombre_Modulo"),
                rs.getString("Ciclo"),
                rs.getString("Curso"));
            
            combo.addItem(textoCombo);
        }
        
        if (combo.getItemCount() == 0) {
            combo.addItem("No se encontraron módulos");
        }
        
    } catch (SQLException e) {
        combo.addItem("Error al cargar módulos");
        e.printStackTrace();
    }    catch (Exception ex) {
             Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
         }
}        
         

     
    public static void main(String[] args) {
        System.out.println(cifrarMD5("comida"));
        try {
            System.out.println("El ID es "+obtenerIdAlPC("martadiaz","c5"));
        } catch (Exception ex) {
            System.out.println("hola");
        }
    }

}
