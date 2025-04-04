package bdd;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotasService {
    private final int idAlumno;
    private static final String URL = "jdbc:mariadb://localhost:3306/prueba";
    private static final String USER = "root";
    private static final String PASS = "alumno";

    public NotasService(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public List<Object[]> obtenerDatosCombinados() {
        List<Object[]> resultados = new ArrayList<>();
        String query = "SELECT n.Evaluacion1, n.Evaluacion2, n.Evaluacion3, n.NotaFinal, "
                     + "m.ID_Profesor, n.ID_Modulo, a.Nombre, a.Ciclo, a.Curso "
                     + "FROM Nota n "
                     + "JOIN Modulo m ON n.ID_Modulo = m.ID_Modulo "
                     + "JOIN Alumnos a ON n.ID_Alumno = a.ID_Alumno "
                     + "WHERE n.ID_Alumno = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, this.idAlumno);
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
        }
        return resultados;
    }
    
}