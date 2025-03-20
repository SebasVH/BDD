package bdd;

import java.sql.*;

public class BDD {

    public static void main(String[] args) {
        String url = "jdbc:mariadb://localhost:3307/vuelta";
        String usuario = "root";
        String contraseña = "alumno";

        try (Connection conn = DriverManager.getConnection(url, usuario, contraseña)) {

            System.out.println("¡Conexión exitosa!");
            
            Statement stmt = conn.createStatement();
            String query = "SELECT dorsal,nombre,edad,nomeq FROM ciclista";
            // String query= "DELETE FROM equipo WHERE nomeq LIKE 'sr1e';";
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("hi "+rsmd.getColumnCount());

            rs.afterLast();
            
            while (rs.previous()) {
                System.out.print(rs.getInt("dorsal") + " ");
                System.out.print(rs.getString("nombre") + " ");
                System.out.print(rs.getInt("edad") + " ");
                System.out.print(rs.getString("nomeq") + " ");
                System.out.println();
                rs.previous();
            }

        } catch (SQLException e) {
            System.err.println("Error de conexión SQL");
            e.printStackTrace();
        }
    }
}
