/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heladeria5t;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Diego
 */
public class FondoInicio extends javax.swing.JPanel {

    /**
     * Creates new form FondoInicio
     */
    public FondoInicio() {
        initComponents();
        this.setSize(700,466);
    }

    public void paintComponent(Graphics g){
        Dimension tam = getSize();
        ImageIcon ImagenFondo = new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/fondoInicio.jpg")).getImage());
        g.drawImage(ImagenFondo.getImage(), 0, 0, tam.width,tam.height,null) ;
        setOpaque(false);
        super.paintComponent(g);
        
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
