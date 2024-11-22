/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Arbol.ArbolVisualizer;
import Arbol.NodoArbol;
import EDD.HashTable;
import EDD.Lista;
import EDD.TableManager;
import static java.awt.image.ImageObserver.HEIGHT;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author User
 */
public class BuscarPersona extends javax.swing.JFrame {

    /**
     * Creates new form BuscarNombre
     */
    public BuscarPersona() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        volver = new javax.swing.JButton();
        buscarpornombre = new javax.swing.JButton();
        buscarpormote = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        volver.setBackground(new java.awt.Color(153, 153, 153));
        volver.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        volver.setForeground(new java.awt.Color(255, 255, 255));
        volver.setText("Atrás");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        getContentPane().add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        buscarpornombre.setBackground(new java.awt.Color(153, 153, 153));
        buscarpornombre.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        buscarpornombre.setForeground(new java.awt.Color(255, 255, 255));
        buscarpornombre.setText("Buscar por nombre");
        buscarpornombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarpornombreActionPerformed(evt);
            }
        });
        getContentPane().add(buscarpornombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, -1, -1));

        buscarpormote.setBackground(new java.awt.Color(153, 153, 153));
        buscarpormote.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        buscarpormote.setForeground(new java.awt.Color(255, 255, 255));
        buscarpormote.setText("Buscar por mote");
        buscarpormote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarpormoteActionPerformed(evt);
            }
        });
        getContentPane().add(buscarpormote, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 300, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/6135265.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/11273270.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/2cdJe2yF6uy5LDRni2hxAvnEkM0-mobile-removebg-preview (1).png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 200, 200));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/2cdJe2yF6uy5LDRni2hxAvnEkM0-mobile-removebg-preview (1).png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 200, 200));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/game-of-thrones-wallpaper-background.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/png-transparent-circle-area-point-angle-white-gray-circle-angle-other-white-thumbnail-removebg-preview (1) (1).png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 200, 200));

        jLabel8.setText("jLabel8");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        InterfazFunciones.VolverMenu();
    }//GEN-LAST:event_volverActionPerformed

    private void buscarpormoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarpormoteActionPerformed
        ArbolVisualizer AV = InterfazFunciones.getArbol();
        if (AV != null){
            TableManager TableControlador = InterfazFunciones.getControlador();
            String[] A = TableControlador.ConseguirMotes();
            String S = (String) JOptionPane.showInputDialog(rootPane, "Seleccione una persona:", "", HEIGHT, null, A, DISPOSE_ON_CLOSE);
            if (S != null){
                NodoArbol N = TableControlador.BusquedaMotes(S);
                if(N==null){
                    JOptionPane.showMessageDialog(null,
                    ("No se tiene información sobre esta persona."),
                    "", JOptionPane.INFORMATION_MESSAGE);
                    AV.mostrarDescendencia(N);
                } else{
                    String Datos = N.DevolverDatos();
                    JOptionPane.showMessageDialog(null,
                    (Datos),
                    "", JOptionPane.INFORMATION_MESSAGE);
                    AV.mostrarDescendencia(N);
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Seleccione una persona correctamente.");
            }
        }else {
            JOptionPane.showMessageDialog(rootPane, "No ha ingresado ningún árbol.");
        }  
    }//GEN-LAST:event_buscarpormoteActionPerformed

    private void buscarpornombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarpornombreActionPerformed
        ArbolVisualizer AV = InterfazFunciones.getArbol();
        if (AV != null){
            TableManager TableControlador = InterfazFunciones.getControlador();
            String[] A = TableControlador.ConseguirNombres();
            String S = (String) JOptionPane.showInputDialog(rootPane, "Seleccione una persona:", "", HEIGHT, null, A, DISPOSE_ON_CLOSE);
            if (S != null){
                NodoArbol N = TableControlador.BusquedaNombres(S);
                if(N==null){
                    JOptionPane.showMessageDialog(null,
                    ("No se tiene información sobre esta persona."),
                    "", JOptionPane.INFORMATION_MESSAGE);
                    AV.mostrarDescendencia(N);
                } else{
                    String Datos = N.DevolverDatos();
                    JOptionPane.showMessageDialog(null,
                    (Datos),
                    "", JOptionPane.INFORMATION_MESSAGE);
                    AV.mostrarDescendencia(N);
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Seleccione una persona correctamente.");
            }
        }else {
            JOptionPane.showMessageDialog(rootPane, "No ha ingresado ningún árbol.");
        }  
    }//GEN-LAST:event_buscarpornombreActionPerformed

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
            java.util.logging.Logger.getLogger(BuscarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarPersona().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarpormote;
    private javax.swing.JButton buscarpornombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}