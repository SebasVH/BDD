package bdd;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BDD {
    
    
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
     
     
    public static void main(String[] args) {
        /*String url = "jdbc:mariadb://10.227.189.79:3306/prog";
        String usuario = "root";
        String contraseña = "alumno";

        try(Connection conexion = DriverManager.getConnection("jdbc:mariadb://10.227.189.133:3306/prog", "root", "alumno");) {
          
          
            System.out.println("¡Conexión exitosa!");
            String query = "Insert into alumnos(ID_Alumno, Nombre, Apellidos, Edad, NIA,Ciclo,Curso,Fecha_Matricula) values("+"1"+","+"'Ricardo'"+","+"'ysi'"+
                    ","+"12"+","+"'19238'"+","+
                    "19"+","+
                    "'hola'"+","+"'2025-10-10'"+")";
            PreparedStatement preparedStatement = conexion.prepareStatement(query);

           
            int columnas = preparedStatement.executeUpdate();

            if (columnas > 0) {
                System.out.println("Usuario insertado correctamente.");
            } else {
                System.out.println("Error al insertar el usuario.");
            }
            
    }   catch (SQLException ex) {
            Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        System.out.println(cifrarMD5("comida"));
        
    }  
    }

