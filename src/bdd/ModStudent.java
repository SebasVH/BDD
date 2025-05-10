package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModStudent extends javax.swing.JPanel {
    private String IP = PanelPrincipal.IP;
    public ModStudent() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Modificar = new javax.swing.JButton();
        lblCurso = new javax.swing.JTextField();
        lblNombre1 = new javax.swing.JTextField();
        lblApellido1 = new javax.swing.JTextField();
        lblEdad1 = new javax.swing.JTextField();
        lblNia1 = new javax.swing.JTextField();
        lblID = new javax.swing.JTextField();
        lblCiclo2 = new javax.swing.JTextField();
        lblFecha1 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(550, 540));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buscar.setText("Search");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 80, -1));

        txtBuscar.setText("Ingrese el ID del alumno");
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 380, -1));

        jLabel1.setFont(new java.awt.Font("Speedee", 1, 24)); // NOI18N
        jLabel1.setText("Apellido");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));

        jLabel2.setFont(new java.awt.Font("Speedee", 1, 24)); // NOI18N
        jLabel2.setText("Nombre");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Speedee", 1, 24)); // NOI18N
        jLabel3.setText("NIA");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, -1, -1));

        jLabel5.setFont(new java.awt.Font("Speedee", 1, 24)); // NOI18N
        jLabel5.setText("Curso");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, -1, -1));

        jLabel6.setFont(new java.awt.Font("Speedee", 1, 24)); // NOI18N
        jLabel6.setText("Edad");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, -1, -1));

        jLabel7.setFont(new java.awt.Font("Speedee", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 199, 44));
        jLabel7.setText("ID Alumno");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, -1, -1));

        jLabel8.setFont(new java.awt.Font("Speedee", 1, 24)); // NOI18N
        jLabel8.setText("Fecha de Matricula");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 410, -1, -1));

        jLabel9.setFont(new java.awt.Font("Speedee", 1, 24)); // NOI18N
        jLabel9.setText("Ciclo");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, -1, -1));

        Modificar.setBackground(new java.awt.Color(218, 41, 28));
        Modificar.setFont(new java.awt.Font("McDonalds Helvetica", 1, 18)); // NOI18N
        Modificar.setForeground(new java.awt.Color(255, 255, 255));
        Modificar.setText("Modificar Datos");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });
        add(Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 510, 200, 50));

        lblCurso.setText("Ingrese su nombre");
        add(lblCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 380, 130, 30));

        lblNombre1.setText("Ingrese su nombre");
        add(lblNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 360, 30));

        lblApellido1.setText("Ingrese su nombre");
        add(lblApellido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 360, 30));

        lblEdad1.setText("Ingrese su nombre");
        add(lblEdad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 130, 30));

        lblNia1.setText("Ingrese su nombre");
        add(lblNia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 130, 30));

        lblID.setText("Ingrese su nombre");
        add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 130, 30));

        lblCiclo2.setText("Ingrese su nombre");
        add(lblCiclo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, 130, 30));

        lblFecha1.setText("Ingrese su nombre");
        add(lblFecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 450, 130, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed

        try (Connection conn = DriverManager.getConnection(IP, "root", "alumno")) {

            System.out.println("¡Conexión exitosa!");

            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM Alumnos WHERE ID_ALUMNO LIKE " + txtBuscar.getText();
            // String query= "DELETE FROM equipo WHERE nomeq LIKE 'sr1e';";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                
                
                lblID.setText(rs.getString("ID_Alumno"));
                lblNombre1.setText(rs.getString("nombre"));
                lblApellido1.setText(rs.getString("apellidos"));
                lblEdad1.setText(rs.getString("Edad"));
                lblNia1.setText(rs.getString("NIA"));
                lblCiclo2.setText(rs.getString("Ciclo"));
                lblCurso.setText(rs.getString("Curso"));
                lblFecha1.setText(rs.getString("Fecha_Matricula"));
            }
        } catch (SQLException e) {
            System.err.println("Error de conexión SQL");
            e.printStackTrace();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        try (Connection conn = DriverManager.getConnection(IP, "root", "alumno")) {

            System.out.println("¡Conexión exitosa!");

            Statement stmt = conn.createStatement();
            String query = "UPDATE alumnos SET "+ "Nombre = '" + lblNombre1.getText() + "', "
                    + "Apellidos = '" + lblApellido1.getText() + "', "
                    + "Edad = " + lblEdad1.getText() + ", "
                    + "NIA = " + lblNia1.getText() + ", "
                    + "Ciclo = '" + lblCiclo2.getText() + "', "
                    + "Curso = '" + lblCurso.getText() + "', "
                    + "Fecha_Matricula = '" + lblFecha1.getText() + "' "
                    + "WHERE ID_Alumno = " + lblID.getText();


            // String query= "DELETE FROM equipo WHERE nomeq LIKE 'sr1e';";
            int rowsAffected = stmt.executeUpdate(query);
            if (rowsAffected > 0) {
                System.out.println("El registro ha sido modificado exitosamente.");
            } else {
                System.out.println("No se encontró un registro con el ID especificado.");
            }
        } catch (SQLException e) {
            System.err.println("Error de conexión SQL");
            e.printStackTrace();

            // TODO add your handling code here:
        }

    }//GEN-LAST:event_ModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Modificar;
    private javax.swing.JButton buscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField lblApellido1;
    private javax.swing.JTextField lblCiclo2;
    private javax.swing.JTextField lblCurso;
    private javax.swing.JTextField lblEdad1;
    private javax.swing.JTextField lblFecha1;
    private javax.swing.JTextField lblID;
    private javax.swing.JTextField lblNia1;
    private javax.swing.JTextField lblNombre1;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

}