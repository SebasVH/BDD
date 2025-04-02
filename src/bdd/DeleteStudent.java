package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteStudent extends javax.swing.JPanel {
        private String IP = PanelPrincipal.IP;

    public DeleteStudent() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        delButton = new javax.swing.JButton();
        lblNia = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        lblCiclo = new javax.swing.JLabel();
        lblCurso = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(550, 540));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 80, -1));

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

        delButton.setBackground(new java.awt.Color(218, 41, 28));
        delButton.setFont(new java.awt.Font("McDonalds Helvetica", 1, 18)); // NOI18N
        delButton.setForeground(new java.awt.Color(255, 255, 255));
        delButton.setText("Borrar de BDD");
        delButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delButtonActionPerformed(evt);
            }
        });
        add(delButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 510, 200, 50));

        lblNia.setBackground(new java.awt.Color(204, 204, 204));
        lblNia.setFont(new java.awt.Font("Monotype Corsiva", 2, 24)); // NOI18N
        lblNia.setForeground(new java.awt.Color(255, 102, 102));
        lblNia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNia.setText("qwe");
        add(lblNia, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 190, 40));

        lblNombre.setBackground(new java.awt.Color(204, 204, 204));
        lblNombre.setFont(new java.awt.Font("Monotype Corsiva", 2, 24)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 102, 102));
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNombre.setText("qwe");
        add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 360, 40));

        lblApellido.setBackground(new java.awt.Color(204, 204, 204));
        lblApellido.setFont(new java.awt.Font("Monotype Corsiva", 2, 24)); // NOI18N
        lblApellido.setForeground(new java.awt.Color(255, 102, 102));
        lblApellido.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblApellido.setText("qwe");
        add(lblApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 360, 40));

        lblFecha.setBackground(new java.awt.Color(204, 204, 204));
        lblFecha.setFont(new java.awt.Font("Monotype Corsiva", 2, 24)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(255, 102, 102));
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFecha.setText("qwe");
        add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 440, 220, 40));

        lblEdad.setBackground(new java.awt.Color(204, 204, 204));
        lblEdad.setFont(new java.awt.Font("Monotype Corsiva", 2, 24)); // NOI18N
        lblEdad.setForeground(new java.awt.Color(255, 102, 102));
        lblEdad.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblEdad.setText("qwe");
        add(lblEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 100, 40));

        lblID.setBackground(new java.awt.Color(204, 204, 204));
        lblID.setFont(new java.awt.Font("Monotype Corsiva", 2, 24)); // NOI18N
        lblID.setForeground(new java.awt.Color(255, 102, 102));
        lblID.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblID.setText("qwe");
        add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 200, 40));

        lblCiclo.setBackground(new java.awt.Color(204, 204, 204));
        lblCiclo.setFont(new java.awt.Font("Monotype Corsiva", 2, 24)); // NOI18N
        lblCiclo.setForeground(new java.awt.Color(255, 102, 102));
        lblCiclo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCiclo.setText("qwe");
        add(lblCiclo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 200, 40));

        lblCurso.setBackground(new java.awt.Color(204, 204, 204));
        lblCurso.setFont(new java.awt.Font("Monotype Corsiva", 2, 24)); // NOI18N
        lblCurso.setForeground(new java.awt.Color(255, 102, 102));
        lblCurso.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCurso.setText("qwe");
        add(lblCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, 200, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try (Connection conn = DriverManager.getConnection(IP, "root", "alumno")) {

            System.out.println("¡Conexión exitosa!");

            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM Alumnos WHERE ID_ALUMNO LIKE " + txtBuscar.getText();
            // String query= "DELETE FROM equipo WHERE nomeq LIKE 'sr1e';";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                lblID.setText(rs.getString("ID_Alumno"));
                lblNombre.setText(rs.getString("nombre"));
                lblApellido.setText(rs.getString("apellidos"));
                lblEdad.setText(rs.getString("Edad"));
                lblNia.setText(rs.getString("NIA"));
                lblCurso.setText(rs.getString("Ciclo"));
                lblCiclo.setText(rs.getString("Curso"));
                lblFecha.setText(rs.getString("Fecha_Matricula"));
            }
        } catch (SQLException e) {
            System.err.println("Error de conexión SQL");
            e.printStackTrace();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void delButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delButtonActionPerformed
        try (Connection conn = DriverManager.getConnection(IP, "root", "alumno")) {

            System.out.println("¡Conexión exitosa!");

            Statement stmt = conn.createStatement();
            String query = "DELETE FROM Alumnos WHERE ID_Alumno ="+lblID.getText();
            // String query= "DELETE FROM equipo WHERE nomeq LIKE 'sr1e';";
            int rowsAffected = stmt.executeUpdate(query);
            if (rowsAffected > 0) {
                System.out.println("El registro ha sido eliminado exitosamente.");
            } else {
                System.out.println("No se encontró un registro con el ID especificado.");
            }
        } catch (SQLException e) {
            System.err.println("Error de conexión SQL");
            e.printStackTrace();

            // TODO add your handling code here:
        }

    }//GEN-LAST:event_delButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton delButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCiclo;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNia;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

}