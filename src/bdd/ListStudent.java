package bdd;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;



public class ListStudent extends javax.swing.JPanel {

    public ListStudent() {
        initComponents();
         
        // Datos de ejemplo para la tabla
        Object[][] data = {
            {"John", 28, "Engineer"},
            {"Anna", 22, "Designer"},
            {"Mike", 35, "Manager"}
        };
        
         // Nombres de las columnas
        String[] columns = {"Name", "Age", "Occupation"};
        
        // Crear el modelo de tabla original
        DefaultTableModel originalModel = new DefaultTableModel(data, columns);
        
        // Crear el modelo de tabla transpuesto
        TableModel transposedModel = new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return originalModel.getColumnCount(); // Las columnas se convierten en filas
            }

            @Override
            public int getColumnCount() {
                return originalModel.getRowCount(); // Las filas se convierten en columnas
            }

            @Override
            public Object getValueAt(int row, int column) {
                return originalModel.getValueAt(column, row); // Intercambia filas por columnas
            }

            @Override
            public String getColumnName(int column) {
                return originalModel.getColumnName(column); // Los nombres de las columnas no cambian
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return originalModel.getColumnClass(columnIndex);
            }
        };
        
        // Establecer el modelo transpuesto en el JTable
        jTable1.setModel(transposedModel); // jTable1 es el nombre generado por NetBeans
    }

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(670, 670));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setText("jLabel6");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 770, 60));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 820, 130));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    
}