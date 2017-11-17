/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heladeria5t;

import clases.ConexionMySQL;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gledymar
 */
public class modificiarusuario extends javax.swing.JFrame {
 ConexionMySQL  mysql=new ConexionMySQL();
        Connection cn= mysql.conectar();
        
    /**
     * Creates new form modificiarusuario
     */
    public modificiarusuario() {
       initComponents();
       inabilitar();
        mostrardatos("");
    }
    
    void inabilitar(){
        txtcod.setEnabled(false);
        txtusuario.setEnabled(false);
        txtapellido.setEnabled(false);
        txtnombre.setEnabled(false);
        txtcedula.setEnabled(false);
       
    }
    void habilitar(){
       
        txtusuario.setEnabled(true);
        txtapellido.setEnabled(true);
        txtnombre.setEnabled(true);
        txtcedula.setEnabled(true);
       
    }
    void limpiar(){
        this.txtcod.setText("");
        this.txtusuario.setText("");
        this.txtnombre.setText("");
        this.txtapellido.setText("");
        this.txtcedula.setText("");
    }
    
void mostrardatos(String valor){
DefaultTableModel modelo= new DefaultTableModel();
modelo.addColumn("Codigo");
modelo.addColumn("Usuario");
modelo.addColumn("Nombre");
modelo.addColumn("Apellido");
modelo.addColumn("Cedula");
tbusuarios.setModel(modelo);
String sql="";
if(valor.equals("")){
sql="SELECT tb_user.id_user,usuario,nombre,apellido,cedula FROM tb_user JOIN tb_usuarior  WHERE tb_user.id_user=tb_usuarior.id_user ";
}
else{ sql="SELECT tb_user.id_user,usuario,nombre,apellido,cedula FROM tb_user JOIN tb_usuarior  WHERE tb_user.id_user=tb_usuarior.id_user  AND  tb_user.id_user='"+valor+"'";}
String []datos = new String [5];

    try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
     while(rs.next()){
         datos[0]=rs.getString(1);
         datos[1]=rs.getString(2);
         datos[2]=rs.getString(3);
         datos[3]=rs.getString(4);
         datos[4]=rs.getString(5);
         
         modelo.addRow(datos);
     
     } tbusuarios.setModel(modelo);
    
    } catch (SQLException ex) {
        java.util.logging.Logger.getLogger(EliminarUsuario.class.getName()).log(Level.SEVERE, null, ex);
    }

}

    /**}
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtcod = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        txtcedula = new javax.swing.JTextField();
        btnactualizar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        txtbuscar = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbusuarios = new javax.swing.JTable();
        btnsalir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(470, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 0, 153), null, new java.awt.Color(153, 0, 153)));
        jPanel1.setPreferredSize(new java.awt.Dimension(350, 240));

        jLabel2.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jLabel2.setText("Cod:");

        jLabel3.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jLabel3.setText("Nombre:");

        jLabel4.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jLabel4.setText("Apellido:");

        jLabel5.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jLabel5.setText("Cedula:");

        txtcod.setEditable(false);
        txtcod.setBackground(new java.awt.Color(204, 153, 255));
        txtcod.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        txtcod.setForeground(new java.awt.Color(153, 0, 153));

        txtnombre.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N

        txtapellido.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N

        txtcedula.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N

        btnactualizar.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        btnactualizar.setText("Actualizar");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jLabel6.setText("Usuario:");

        txtusuario.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnactualizar))
                            .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 22, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnactualizar)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 350, 220));

        txtbuscar.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        getContentPane().add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 136, -1));

        btnbuscar.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, -1));

        tbusuarios.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        tbusuarios.setForeground(new java.awt.Color(153, 0, 204));
        tbusuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbusuarios.setGridColor(new java.awt.Color(102, 0, 102));
        tbusuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbusuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbusuarios);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 400, 135));

        btnsalir.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 500, -1, -1));

        jLabel7.setFont(new java.awt.Font("Stencil", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 255));
        jLabel7.setText("MODIFICAR  DATOS");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 230, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imagen1.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
       mostrardatos(txtbuscar.getText()); // TODO add your handling code here:
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void tbusuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbusuariosMouseClicked
int fila = tbusuarios.getSelectedRow();

        if(fila >=0){
        txtcod.setText(tbusuarios.getValueAt(fila,0).toString());
        txtusuario.setText(tbusuarios.getValueAt(fila,1).toString());
        txtnombre.setText(tbusuarios.getValueAt(fila, 2).toString());
        txtapellido.setText(tbusuarios.getValueAt(fila, 3).toString());
        txtcedula.setText(tbusuarios.getValueAt(fila, 4).toString());
        habilitar();
        
        }
        else {
        JOptionPane.showMessageDialog(null,"No a seleccionado usuario");
        }          // TODO add your handling code here:
    }//GEN-LAST:event_tbusuariosMouseClicked

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
  try{
  PreparedStatement pst= cn.prepareStatement("UPDATE tb_user INNER JOIN tb_usuarior ON tb_usuarior.id_user=tb_user.id_user SET tb_user.usuario='"+txtusuario.getText()+"', tb_usuarior.nombre='"+txtnombre.getText()+"',tb_usuarior.apellido='"+txtapellido.getText()+"',tb_usuarior.cedula='"+txtcedula.getText()+"' WHERE tb_user.id_user='"+txtcod.getText()+"'" );
  pst.executeUpdate();
  mostrardatos("");
  JOptionPane.showMessageDialog(null,"Actualizacion exitosa");
  limpiar();
  
  } catch(Exception e){
  JOptionPane.showMessageDialog(null,"No se pudo");
  }    // TODO add your handling code here:
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
new inicio().setVisible(true);
this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_btnsalirActionPerformed

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
            java.util.logging.Logger.getLogger(modificiarusuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(modificiarusuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(modificiarusuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modificiarusuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new modificiarusuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbusuarios;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtcod;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
