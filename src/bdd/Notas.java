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
import javax.swing.JComboBox;

public class Notas extends javax.swing.JPanel {
    private String IP = PanelPrincipal.IP;
    private int IdAL;
    private int IDProf=PanelPrincipal.getIDprof();
    private int IDModulo;
    public Notas() {
        initComponents();
        Metodos.cargarWombo(comboWombo, IDProf);
        cargarAlumnosMismoCiclo(comboPerfecto,IDProf);
    }
    public void cargarAlumnosMismoCiclo(JComboBox<String> comboAlumnos, int idProfesor) {
    comboAlumnos.removeAllItems();
    
    // Primero obtenemos el ciclo del profesor desde sus módulos
    String cicloProfesor = obtenerCicloDeProfesor(idProfesor);
        
    
    if (cicloProfesor == null) {
        comboAlumnos.addItem("Profesor no tiene módulos asignados");
        return;
    }

    // Consulta que filtra alumnos por ciclo
    String query = "SELECT ID_Alumno, Nombre, Apellidos FROM Alumnos " +
                   "WHERE Ciclo = ? ORDER BY Apellidos";
    
    try (Connection conn = Metodos.getPatata();
         PreparedStatement pstmt = conn.prepareStatement(query)) {
        
        pstmt.setString(1, cicloProfesor);
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()) {
            String nombreCompleto = rs.getInt("ID_Alumno")+" "+rs.getString("Nombre") + " " + rs.getString("Apellidos");
            comboAlumnos.addItem(nombreCompleto);
        }
        
        if (comboAlumnos.getItemCount() == 0) {
            comboAlumnos.addItem("No hay alumnos en el ciclo " + cicloProfesor);
        }
        
    } catch (SQLException e) {
        comboAlumnos.addItem("Error al cargar alumnos");
        e.printStackTrace();
    }   catch (Exception ex) {
            Logger.getLogger(Notas.class.getName()).log(Level.SEVERE, null, ex);
        }
}      
        
    private String obtenerCicloDeProfesor(int idProfesor) {
    String query = "SELECT Ciclo FROM Modulo WHERE ID_Profesor = ? LIMIT 1";
    
    try (Connection conn = Metodos.getPatata();
         PreparedStatement pstmt = conn.prepareStatement(query)) {
        
        pstmt.setInt(1, idProfesor);
        ResultSet rs = pstmt.executeQuery();
        
        return rs.next() ? rs.getString("Ciclo") : null;
    }   catch (Exception ex) {
            Logger.getLogger(Notas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return "aña";
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblJijijija = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblGasp = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Modificar = new javax.swing.JButton();
        lblCurso = new javax.swing.JTextField();
        lblNombre1 = new javax.swing.JTextField();
        lblEdad1 = new javax.swing.JTextField();
        lblNia1 = new javax.swing.JTextField();
        lblID = new javax.swing.JTextField();
        lblCiclo2 = new javax.swing.JTextField();
        lblFecha1 = new javax.swing.JTextField();
        comboWombo = new javax.swing.JComboBox<>();
        comboPerfecto = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(550, 540));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblJijijija.setFont(new java.awt.Font("Speedee", 1, 24)); // NOI18N
        lblJijijija.setText("Modulo");
        add(lblJijijija, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 480, -1));

        jLabel2.setFont(new java.awt.Font("Speedee", 1, 24)); // NOI18N
        jLabel2.setText("Estas agregando notas a:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Speedee", 1, 24)); // NOI18N
        jLabel3.setText("Alumno a Matar");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jLabel5.setFont(new java.awt.Font("Speedee", 1, 24)); // NOI18N
        jLabel5.setText("Curso");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, -1, -1));

        lblGasp.setFont(new java.awt.Font("Speedee", 1, 24)); // NOI18N
        lblGasp.setText("Edad");
        add(lblGasp, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jLabel7.setFont(new java.awt.Font("Speedee", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 199, 44));
        jLabel7.setText("ID Alumno");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, -1, -1));

        jLabel8.setFont(new java.awt.Font("Speedee", 1, 24)); // NOI18N
        jLabel8.setText("Fecha de Matricula");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 280, -1, -1));

        jLabel9.setFont(new java.awt.Font("Speedee", 1, 24)); // NOI18N
        jLabel9.setText("Ciclo");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, -1, 30));

        Modificar.setBackground(new java.awt.Color(218, 41, 28));
        Modificar.setFont(new java.awt.Font("McDonalds Helvetica", 1, 18)); // NOI18N
        Modificar.setForeground(new java.awt.Color(255, 255, 255));
        Modificar.setText("Modificar Datos");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });
        add(Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 540, 200, 50));

        lblCurso.setText("Ingrese su nombre");
        add(lblCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 310, 130, 30));

        lblNombre1.setText("Ingrese su nombre");
        add(lblNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 480, 360, 30));

        lblEdad1.setText("Ingrese su nombre");
        add(lblEdad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 130, 30));

        lblNia1.setText("Ingrese su nombre");
        add(lblNia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 480, 130, 30));

        lblID.setText("Ingrese su nombre");
        add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 130, 30));

        lblCiclo2.setText("Ingrese su nombre");
        add(lblCiclo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 310, 130, 30));

        lblFecha1.setText("Ingrese su nombre");
        add(lblFecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, 130, 30));

        comboWombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboWombo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        comboWombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboWomboActionPerformed(evt);
            }
        });
        add(comboWombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 280, -1));

        comboPerfecto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboPerfecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPerfectoActionPerformed(evt);
            }
        });
        add(comboPerfecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 200, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        // TODO add your handling code here:
        

    }//GEN-LAST:event_ModificarActionPerformed

    private void comboWomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboWomboActionPerformed
         if (comboWombo.getSelectedItem() != null) {
            // Obtener el texto seleccionado
            String seleccion = comboWombo.getSelectedItem().toString();

            String[] partes = seleccion.split("\\|");
            
            
                // Actualizar los JLabels
                lblJijijija.setText(partes[0].trim());
                lblGasp.setText("Ciclo: " + partes[1].trim() + " - Curso: " + partes[2].trim());
            
        }
// TODO add your handling code here:
    }//GEN-LAST:event_comboWomboActionPerformed

    private void comboPerfectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPerfectoActionPerformed
            // TODO add your handling code here:
    }//GEN-LAST:event_comboPerfectoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Modificar;
    private javax.swing.JComboBox<String> comboPerfecto;
    private javax.swing.JComboBox<String> comboWombo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField lblCiclo2;
    private javax.swing.JTextField lblCurso;
    private javax.swing.JTextField lblEdad1;
    private javax.swing.JTextField lblFecha1;
    private javax.swing.JLabel lblGasp;
    private javax.swing.JTextField lblID;
    private javax.swing.JLabel lblJijijija;
    private javax.swing.JTextField lblNia1;
    private javax.swing.JTextField lblNombre1;
    // End of variables declaration//GEN-END:variables

}