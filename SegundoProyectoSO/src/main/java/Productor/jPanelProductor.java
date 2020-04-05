/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productor;

import javax.swing.ImageIcon;
import kurokami.monitor.Monitor;

/**
 *
 * @author sharon
 */
public class jPanelProductor extends javax.swing.JPanel {

    int contador =1;
    productor p;
    /**
     * Creates new form jPanelProductor
     * @param monitor
     */
    public jPanelProductor(Monitor monitor) {
        initComponents();
        this.inicializar();
        this.setProductor(monitor);
    }
    public jPanelProductor(Monitor monitor, productor p) {
        initComponents();
        this.inicializar();
        this.p = p;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        f = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(500, 700));
        setPreferredSize(new java.awt.Dimension(500, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText(" 𝑪𝑶𝑭𝑭𝑬𝑬 𝑺𝑯𝑶𝑷");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 410, 52));

        jButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton1.setText("Ordenar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, 137, 49));

        jComboBox1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 244, -1));
        add(f, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 830));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       int num= jComboBox1.getSelectedIndex();
       if(num!=0){
       p.nuevaOrden(num, contador);
       contador++;
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel f;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables


    public void inicializar(){
        
       this.jComboBox1.setModel(
               new javax.swing.DefaultComboBoxModel<>(
                       new String[] { "Seleccione su bebida", "Chemex", "V60", "Expresso", "French Press", "Moka", "Latte" })); 
       ImageIcon fondo = new ImageIcon("fondos/f1.jpg");
        f.setIcon(fondo);
       
    }
    public void setProductor(Monitor monitor)
    {
        p= new productor(monitor);
        p.start();
    }
    
}
