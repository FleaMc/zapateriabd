/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import static Base.Zapateria.txtMod;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mich
 */
public class Ventas extends javax.swing.JFrame {

    /**
     * Creates new form Ventas
     */
    public Ventas() {
        initComponents();
        
      Helper hp = new Helper();
       combo2.setVisible(false);
       
        txtT.setVisible(false); 
       combo.setModel(hp.getvalues());
       Ventas(); 
    }

    Conectar connectionn = new Conectar();  
    PreparedStatement pst;  
        public void Ventas()
    {
       
        try {

            pst = connectionn.Conexion().prepareStatement("SELECT * FROM ventas");
             ResultSet rs = pst.executeQuery();
             ResultSetMetaData RSM = rs.getMetaData();
             int c;
             c = RSM.getColumnCount();
             DefaultTableModel DF = (DefaultTableModel)jTable1.getModel();
             DF.setRowCount(0);                
             
             
             while(rs.next())
             {
             Vector v2 = new Vector();
             for(int i = 1; i<=c; i++)
             {
                 v2.add(rs.getString("Id_Venta"));
                 v2.add(rs.getString("Id_Dependiente"));
                 v2.add(rs.getString("Id_Zapato"));  
                 v2.add(rs.getString("Importe"));    
                 v2.add(rs.getString("FechaVenta"));    
                 v2.add(rs.getString("Modelo"));     
                   
                   
                 
                 
             }
             DF.addRow(v2);
             }
             
        } catch (SQLException ex) {
            Logger.getLogger(Zapateria.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        bttnPay = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtVend = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox<>();
        txtT = new javax.swing.JLabel();
        combo2 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtDispo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id_Venta", "Id_Dependiente", "Id_Zapato", "Importe", "FechaVenta", "Modelo"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton6.setText("Reporte ventas por dependiente");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Reporte venta por modelo");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        bttnPay.setText("Pagar");
        bttnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnPayActionPerformed(evt);
            }
        });

        jLabel2.setText("Id_Vendedor");

        jLabel3.setText("Modelo");

        txtT.setText("Talla");

        jLabel5.setText("Disponibles");

        jButton1.setText("Tallas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Disponibles");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(txtVend, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtT)
                            .addComponent(jLabel5))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combo2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDispo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bttnPay)
                    .addComponent(jButton1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtVend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bttnPay)
                        .addGap(28, 28, 28)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtT))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDispo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                .addComponent(jButton7)
                                .addGap(34, 34, 34)
                                .addComponent(jButton6)
                                .addGap(60, 60, 60))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Ventana abrir = new Ventana();
        abrir.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed
 class Helper {
   public DefaultComboBoxModel getvalues(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
    
        PreparedStatement ps;
        ResultSet rs;
  
       
      
        try{
         
            ps=connectionn.Conexion().prepareStatement("SELECT Modelo From zapatos");
             rs=ps.executeQuery();
           
           
           
               
            while(rs.next()){
                modelo.addElement(rs.getString(1));
               
            
            }
        }catch(SQLException ex){
         
        }return modelo;    
    }
   }
    private void bttnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnPayActionPerformed
  int id2= 0;
              String ven = txtVend.getText();
               System.out.println(ven);
              
   Tickets tick = new Tickets(); 
        try {
                pst = connectionn.Conexion().prepareStatement("SELECT * FROM Ventas");
               
                ResultSet rs = pst.executeQuery();
             
                while(rs.next())
                {    
                     String id = rs.getString(1);
                    if(rs.isLast()){
                        id2 = Integer.parseInt(id);
                        id2 =id2+1;
                        tick.setId(id2);
                    }
                     
                }
              
       
                } catch(Exception e){
                        
                        }
        
        
        String manejador = "com.mysql.jdbc.Driver";
        LocalDate fechaactual = LocalDate.now();
//        String zapato = txtZap.getText();
        String vendedor= txtVend.getText();
        String item = (String)combo.getSelectedItem();
        String item2 = (String)combo2.getSelectedItem();
        Ticket recibo = new Ticket();
        try{
            Class.forName(manejador);
            Conectar connectionn = new Conectar();           
            PreparedStatement ps = connectionn.Conexion().prepareStatement("insert into ventas(Id_Dependiente,Id_Zapato,Importe,FechaVenta,Modelo) values(?,?,?,?,?)");
            ps.setString(1, vendedor);
            
        
  
              try {
                pst = connectionn.Conexion().prepareStatement("SELECT * FROM zapatos");
               
                ResultSet rs = pst.executeQuery();
                
                while(rs.next())
                {    
                    String id = rs.getString(1);
                    String mod = rs.getString(3);
                    String zap = rs.getString(4);
                
                    if(mod.equals(item)){
                        ps.setString (2, id);
                        ps.setString(3, zap);
                       
                        recibo.txtI.setText(zap);
                        recibo.txtM.setText(mod);
                        int imp = Integer.parseInt(zap);
                        tick.setImporte(imp);
                    }
                     
                }
              
       
                } catch(Exception e){
                     JOptionPane.showMessageDialog(null, "Error ");   
                        }
             
             ps.setString(4, ""+fechaactual);
             ps.setString(5, item);
             ps.executeUpdate();
                try {
                pst = connectionn.Conexion().prepareStatement("SELECT * FROM tallas");
               
                ResultSet rs = pst.executeQuery();
                
                while(rs.next())
                {    
                    String id = rs.getString(1);
                    String mod = rs.getString(2);
                    String tall = rs.getString(3);
                
                    if(mod.equals(item) && tall.equals(item2)){
                        String num = txtDispo.getText();
                        int num2 = Integer.parseInt(num);
                        int menos = num2-1;
                        txtDispo.setText(""+menos);
                         try {
            pst = connectionn.Conexion().prepareStatement("update tallas set Disponible=? where IdTallas = ?");
            pst.setString(1, "" +menos); 
            pst.setString(2, id);  
            
            int k = pst.executeUpdate();
            
            if(k==1)
            {
                JOptionPane.showMessageDialog(this, "Stock" +mod + "=" + menos);
    
                
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Fallo");
            }
   
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(this, "No hay disponibles");
        }
                        
                    }
                     
                }
              
       
                } catch(Exception e){
                     JOptionPane.showMessageDialog(null, "Error ");   
                        }
            JOptionPane.showMessageDialog(null, "Pagado");
               Ventas();
 
                recibo.txtT.setText(item2);
               recibo.txtV.setText(ven);
               recibo.txtF.setText(""+fechaactual);
               recibo.setVisible(true);
              
             
               tick.setDepen("Maic");
               tick.setFecha(""+fechaactual);
               tick.setModelo(item);
               tick.setTalla(item2);
               tick.Datos();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al insertar:" + e.getMessage());
        } catch (ClassNotFoundException ex) {
             JOptionPane.showMessageDialog(null, "Error de datos");
        } catch (IOException ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }//GEN-LAST:event_bttnPayActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        combo2.removeAllItems();
        String item = (String)combo.getSelectedItem();
      
        combo2.setVisible(true);
       txtT.setVisible(true);
      
       
       try {
                pst = connectionn.Conexion().prepareStatement("SELECT * FROM tallas");
               
                ResultSet rs = pst.executeQuery();
                
                while(rs.next())
                {    
                    String us = rs.getString(2);
                    String tall = rs.getString(3);
                    if(us.equals(item)){
                        combo2.addItem(tall);
                   
                    }
                     
                }
              
       
                } catch(Exception e){
                        
                        }
       
       

        
       

       
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      txtDispo.setText("");
       String item = (String)combo.getSelectedItem();
       String item2 = (String)combo2.getSelectedItem();
        try {
                pst = connectionn.Conexion().prepareStatement("SELECT * FROM tallas");
               
                ResultSet rs = pst.executeQuery();
                
                while(rs.next())
                {    
                    String us = rs.getString(2);
                    String tall = rs.getString(3);
                    String disp = rs.getString(4);
                  
                    if(us.equals(item) && item2.equals(tall)){
                     txtDispo.setText(disp);
                     if(disp.equals("0")){
                         JOptionPane.showMessageDialog(null, "Sin stock");  
                     }
                     
                          }    
                     }
                    
               
              
       
                } catch(Exception e){
                        
                        }
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       Modelo abrir = new Modelo();
       abrir.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnPay;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JComboBox<String> combo2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel txtDispo;
    private javax.swing.JLabel txtT;
    private javax.swing.JTextField txtVend;
    // End of variables declaration//GEN-END:variables
}
