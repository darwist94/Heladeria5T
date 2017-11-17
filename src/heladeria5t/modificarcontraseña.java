/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heladeria5t;

import clases.CargarDatos;
import clases.ConexionMySQL;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Gledymar
 */
public class modificarcontraseña extends javax.swing.JFrame {
        ConexionMySQL  mysql=new ConexionMySQL();
        Connection cn= mysql.conectar();
        private ImageIcon imageicon;
    /**
     * Creates new form modificarcontraseña
     */
    public modificarcontraseña() {
        initComponents();
        inabilitado();
        imageicon= new ImageIcon(getClass().getResource("/imagenes/boton1.png"));
    
        this.setIconImage(imageicon.getImage());
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Cambiar contraseña");
        this.pack();
    }
    
   void selectopcion(){
   if (radio1.isSelected()){
      txtbuscar.setEnabled(true);
      btnbuscar.setEnabled(true);
   }
   else if(radio2.isSelected()){ 
    cerrar();
    confirmarsalida();
   }
   }
   
   public void cerrar(){
    try{
    this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    addWindowListener(new WindowAdapter(){
     public void windowClosing(WindowEvent e){
     
     }
    }); this.setVisible(true);
            }
    catch( Exception e){e.printStackTrace(); }
    

    }
   public void confirmarsalida(){
   int valor= JOptionPane.showConfirmDialog(this,"¿Desea cambiar contraseña?", "AVISO",JOptionPane.YES_NO_OPTION);
  if(valor==JOptionPane.YES_OPTION) {
      txtbuscar.setEnabled(true);
      btnbuscar.setEnabled(true);
  }
  else{
    new inicio().setVisible(true);
    this.dispose();
  }
   
   
   }
   void acceder(String resp1, String resp2){
   String sSQL,sSQL1;
       String cap="",cap1="",user="";
       
        sSQL="SELECT tb_user.usuario,tb_user.contraseña FROM tb_preguntas,tb_respuestas,tb_user "
                + "WHERE tb_preguntas.id_preg=tb_respuestas.id_preg "
                + "AND tb_respuestas.id_user=tb_user.id_user AND tb_preguntas.id_preg='"+CargarDatos.getNumpregunta1()+ "'"
                + "AND tb_respuestas.respuestas='"+resp1+"' ;";
        
        sSQL1="SELECT tb_user.usuario,tb_user.contraseña FROM tb_preguntas,tb_respuestas,tb_user "
                + "WHERE tb_preguntas.id_preg=tb_respuestas.id_preg "
                + "AND tb_respuestas.id_user=tb_user.id_user AND tb_preguntas.id_preg='"+CargarDatos.getNumpregunta2()+ "'"
                + "AND tb_respuestas.respuestas='"+resp2+"' ;";
        try{
         
        Statement st = cn.createStatement();
        Statement st1 = cn.createStatement();
        ResultSet rs= st.executeQuery(sSQL);
        ResultSet rs1= st1.executeQuery(sSQL1);
         while(rs.next() && rs1.next()){
            user=rs.getString("usuario");
            cap=rs.getString("contraseña");
            cap1=rs1.getString("contraseña");
            
        }
        
        if(cap.equals("") || cap1.equals("") || !(cap.equals(cap1))){
             JOptionPane.showMessageDialog(null, "Respuestas incorrectas");
        }else{
            txtpass1.setEnabled(true);
            txtpass2.setEnabled(true); 
            btnaceptar.setEnabled(true);
        }
        
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, ex);
        }
            
   }
   
String accederPreguntas(int x){
        String sSQL;
        String cap="";
        sSQL="SELECT * FROM tb_preguntas"
                + " WHERE id_preg='"+x+"' ";
        try{
         
        Statement st = cn.createStatement();
        ResultSet rs= st.executeQuery(sSQL);
        while(rs.next()){
            cap=rs.getString("pregunta");
        }
        
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, ex);
        }
        
        
    
        return cap;
    }
void inabilitado(){
    txtbuscar.setEnabled(false);
    txtusuario.setEnabled(false);
    txtrespuesta1.setEnabled(false);
    txtrespuesta2.setEnabled(false);
    txtpass1.setEnabled(false);
    txtpass2.setEnabled(false);
    btnbuscar.setEnabled(false);
    btncfpreg.setEnabled(false);
    btnaceptar.setEnabled(false);
    
    
    
    
    }
void limpiar()
{
this.txtbuscar.setText("");
this.txtrespuesta1.setText("");
this.txtrespuesta2.setText("");
this.txtusuario.setText("");
this.txtpass1.setText("");
this.txtpass2.setText("");
this.txtpregunta1.setText("");
this.txtpregunta2.setText("");


}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cambiar = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        radio1 = new javax.swing.JRadioButton();
        radio2 = new javax.swing.JRadioButton();
        txtpregunta2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtpregunta1 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        btncfpreg = new javax.swing.JButton();
        btnbuscar = new javax.swing.JButton();
        txtrespuesta1 = new javax.swing.JTextField();
        txtrespuesta2 = new javax.swing.JTextField();
        txtusuario = new javax.swing.JTextField();
        jmf = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtpass1 = new javax.swing.JPasswordField();
        txtpass2 = new javax.swing.JPasswordField();
        btnaceptar = new javax.swing.JButton();
        jlabb = new javax.swing.JLabel();
        btncancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel1.setText("Desea cambiar contraseña? ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 200, 28));

        cambiar.add(radio1);
        radio1.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        radio1.setText("Si");
        radio1.setBorder(null);
        radio1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radio1MouseClicked(evt);
            }
        });
        radio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio1ActionPerformed(evt);
            }
        });
        getContentPane().add(radio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, -1, -1));

        cambiar.add(radio2);
        radio2.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        radio2.setText("No");
        radio2.setBorder(null);
        radio2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        radio2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio2ActionPerformed(evt);
            }
        });
        getContentPane().add(radio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, -1, -1));

        txtpregunta2.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        getContentPane().add(txtpregunta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 250, 20));

        jLabel3.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel3.setText("Usuario:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 70, -1));

        txtpregunta1.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        getContentPane().add(txtpregunta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 250, 20));

        txtbuscar.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        getContentPane().add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 121, -1));

        btncfpreg.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        btncfpreg.setText("Siguiente");
        btncfpreg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncfpregActionPerformed(evt);
            }
        });
        getContentPane().add(btncfpreg, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, -1, -1));

        btnbuscar.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, -1, -1));

        txtrespuesta1.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        txtrespuesta1.setForeground(new java.awt.Color(153, 0, 153));
        getContentPane().add(txtrespuesta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 250, -1));

        txtrespuesta2.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        txtrespuesta2.setForeground(new java.awt.Color(153, 0, 153));
        getContentPane().add(txtrespuesta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 250, -1));

        txtusuario.setEditable(false);
        txtusuario.setBackground(new java.awt.Color(255, 204, 255));
        txtusuario.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        getContentPane().add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 104, -1));

        jmf.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jmf.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 0, 153), new java.awt.Color(153, 0, 153)));
        getContentPane().add(jmf, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 290, 232));

        jLabel5.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel5.setText("Usuario:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 60, 20));

        jLabel6.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel6.setText("Nueva contraeña:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, -1, -1));

        jLabel7.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel7.setText("repetir contraseña:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, -1, -1));

        txtpass1.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        txtpass1.setForeground(new java.awt.Color(153, 0, 153));
        getContentPane().add(txtpass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 120, -1));

        txtpass2.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        txtpass2.setForeground(new java.awt.Color(153, 0, 153));
        getContentPane().add(txtpass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, 120, -1));

        btnaceptar.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        btnaceptar.setText("Aceptar");
        btnaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnaceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, -1, -1));

        jlabb.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 0, 153), new java.awt.Color(153, 0, 153)));
        getContentPane().add(jlabb, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 280, 200));

        btncancelar.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 390, -1, -1));

        jLabel2.setFont(new java.awt.Font("Stencil", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 255));
        jLabel2.setText("CAMBIAR CONTRASEÑA");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 280, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/klk.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
      String sSQL;
      
      if(txtbuscar.getText().equals("")){
      javax.swing.JOptionPane.showMessageDialog(this,
                "Debe llenar la casilla\n","AVISO",javax.swing.JOptionPane.INFORMATION_MESSAGE);
        txtbuscar.requestFocus();
      }
      else{
       sSQL="SELECT * FROM tb_user WHERE tb_user.usuario='"+txtbuscar.getText()+"'";
       Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs= st.executeQuery(sSQL);
            while(rs.next()){
                txtusuario.setText(rs.getString("usuario"));
                
                txtrespuesta1.setEnabled(true);
                txtrespuesta2.setEnabled(true);
                txtusuario.setEnabled(false);
                txtpass1.setEnabled(false);
                txtpass2.setEnabled(false);
                btnbuscar.setEnabled(false);
                btncfpreg.setEnabled(true);
                btnaceptar.setEnabled(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(modificarcontraseña.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
        int x=0,y=0;
        
        do{
        for(int i=0;i<2;i++){
            Random r=new Random();
            int na=r.nextInt(4)+1;
            if(i==0)
               x=na;
            
            y=na;
            
            
           }
        }while(x==y);
        CargarDatos.setNumpregunta1(x);
        CargarDatos.setNumpregunta2(y);
        
       txtpregunta1.setText(accederPreguntas(CargarDatos.getNumpregunta1()));
       txtpregunta2.setText(accederPreguntas(CargarDatos.getNumpregunta2()));        // TODO add your handling code here:
    }//GEN-LAST:event_btnbuscarActionPerformed
    }
    private void btncfpregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncfpregActionPerformed
        String resp1=txtrespuesta1.getText();
        String resp2=txtrespuesta2.getText();
        acceder(resp1,resp2);
                txtrespuesta1.setEnabled(false);
                txtrespuesta2.setEnabled(false);
                txtpregunta1.setEnabled(false);
                txtpregunta2.setEnabled(false);
                
        // TODO add your handling code here:
    }//GEN-LAST:event_btncfpregActionPerformed

    private void radio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio1ActionPerformed
      selectopcion();  // TODO add your handling code here:
    }//GEN-LAST:event_radio1ActionPerformed

    private void radio1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radio1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_radio1MouseClicked

    private void radio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio2ActionPerformed
           selectopcion(); // TODO add your handling code here:
    }//GEN-LAST:event_radio2ActionPerformed

    private void btnaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaceptarActionPerformed
String pass=txtpass1.getText().toString();
String pass1=txtpass2.getText().toString();
String sql;


if(pass.equals(pass1)){ 
    
    try{
  PreparedStatement pst= cn.prepareStatement("UPDATE tb_user SET tb_user.contraseña ='"+pass+"' WHERE tb_user.usuario ='"+txtusuario.getText()+"'");
  pst.executeUpdate();
  JOptionPane.showMessageDialog(null,"Se guarda la nueva contraseña");
    
  } catch(Exception e){
  JOptionPane.showMessageDialog(null,"No se pudo");
  } }  else{
              javax.swing.JOptionPane.showMessageDialog(this,
                "Contraseña no coincide\n","AVISO",javax.swing.JOptionPane.INFORMATION_MESSAGE);
              txtpass1.requestFocus();
             }   // TODO add your handling code here:
   limpiar();     // TODO add your handling code here:
    }//GEN-LAST:event_btnaceptarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
     new inicio().setVisible(true);
        this.dispose();   // TODO add your handling code here:
    }//GEN-LAST:event_btncancelarActionPerformed

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
            java.util.logging.Logger.getLogger(modificarcontraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(modificarcontraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(modificarcontraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modificarcontraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new modificarcontraseña().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaceptar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btncfpreg;
    private javax.swing.ButtonGroup cambiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jlabb;
    private javax.swing.JLabel jmf;
    private javax.swing.JRadioButton radio1;
    private javax.swing.JRadioButton radio2;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JPasswordField txtpass1;
    private javax.swing.JPasswordField txtpass2;
    private javax.swing.JLabel txtpregunta1;
    private javax.swing.JLabel txtpregunta2;
    private javax.swing.JTextField txtrespuesta1;
    private javax.swing.JTextField txtrespuesta2;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
