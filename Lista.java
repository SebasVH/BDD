/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lista;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Vespertino
 */
public class Lista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         String password = "ivan1";
        
        // Cifrar la contraseña con MD5
        String hashedPassword = Lista.cifrarMD5(password);
        
        // Mostrar el resultado
        System.out.println("Contraseña cifrada:" + hashedPassword);
        
    }
    
    // Método para cifrar una cadena usando MD5
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
        }
    }
}
        
        
        
    
    

