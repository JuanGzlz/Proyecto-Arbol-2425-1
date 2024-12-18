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
import Funciones.JsonChooser;
import Funciones.JsonDecoder;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Clase Interfaz Menu
 * @author Macorre21
 * @version 1.0
 */
public class Menu extends javax.swing.JFrame {

     /**
     * Constructor de la clase interfaz Menu
     * @param newChose variable interna de tipo JsonDecoder
     * @param Arbolito variable interna de tipo ArbolVisualizer
     * @param TableControlador variable interna de tipo TableManager
     * @param HashNombres variable interna de tipo HashTable
     * @param HashMotes variable interna de tipo HashTable
     */
    private JsonDecoder newChose;
    private ArbolVisualizer Arbolito;
    private TableManager TableControlador;
    private HashTable HashNombres;
    private HashTable HashMotes;
    public Menu() {
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

        jLabel2 = new javax.swing.JLabel();
        mostrararbol = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lista = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cargarjson = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        buscarpersona = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        buscartitulo = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        antepasados = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/png-clipart-computer-icons-tree-icon-design-tree-black-silhouette-removebg-preview.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 110, -1));

        mostrararbol.setBackground(new java.awt.Color(255, 204, 153));
        mostrararbol.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        mostrararbol.setText("Ver Árbol");
        mostrararbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrararbolActionPerformed(evt);
            }
        });
        getContentPane().add(mostrararbol, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pngtree-check-list-icon-isolated-on-abstract-background-png-image_1776830-removebg-preview.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, 120, 120));

        lista.setBackground(new java.awt.Color(255, 204, 153));
        lista.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        lista.setText("Generaciones");
        lista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaActionPerformed(evt);
            }
        });
        getContentPane().add(lista, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/subir-removebg-preview.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, 80));

        cargarjson.setBackground(new java.awt.Color(255, 204, 153));
        cargarjson.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        cargarjson.setText("Cargar Json");
        cargarjson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarjsonActionPerformed(evt);
            }
        });
        getContentPane().add(cargarjson, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pngtree-magnifying-glass-icon-image_2292648-removebg-preview.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, 100, -1));

        buscarpersona.setBackground(new java.awt.Color(255, 204, 153));
        buscarpersona.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        buscarpersona.setText("Buscar persona");
        buscarpersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarpersonaActionPerformed(evt);
            }
        });
        getContentPane().add(buscarpersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/depositphotos_308515132-stock-illustration-document-search-minimal-line-web-removebg-preview (1) (1).png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 100, 110));

        buscartitulo.setBackground(new java.awt.Color(255, 204, 153));
        buscartitulo.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        buscartitulo.setText("Buscar por título");
        buscartitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscartituloActionPerformed(evt);
            }
        });
        getContentPane().add(buscartitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, -1, -1));

        exit.setBackground(new java.awt.Color(255, 204, 153));
        exit.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        exit.setText("X ");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        getContentPane().add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, -1, -1));

        antepasados.setBackground(new java.awt.Color(255, 204, 153));
        antepasados.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        antepasados.setText("Antepasados");
        antepasados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                antepasadosActionPerformed(evt);
            }
        });
        getContentPane().add(antepasados, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/download__1_-removebg-preview (2) (1).png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 130, 120));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/beige__1_-removebg-preview.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/beige__1_-removebg-preview.png"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/beige__1_-removebg-preview.png"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/beige__1_-removebg-preview.png"))); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 140, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/beige__1_-removebg-preview.png"))); // NOI18N
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/beige__1_-removebg-preview.png"))); // NOI18N
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/thumb-1920-427997 (1).jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

     /**
     * @param evt
     * En principio se genera una lista desplegable con todos las personas que se encuentren dentro del Json para que 
     * el usuario pueda seleccionar la persona en específico de quien quiera saber sus antepasados.
     * Función que te permite buscar a los antepasados de una persona.
     */
    private void antepasadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_antepasadosActionPerformed
        this.Arbolito = InterfazFunciones.getArbol();
        if (this.Arbolito != null){
            this.TableControlador = InterfazFunciones.getControlador();
            String[] A = this.TableControlador.ConseguirNombres();
            String S = (String) JOptionPane.showInputDialog(rootPane, "Seleccione una persona:", "", HEIGHT, null, A, DISPOSE_ON_CLOSE);
            if (S != null){
                NodoArbol N = this.TableControlador.BusquedaNombres(S);
                if(N==null){
                    JOptionPane.showMessageDialog(null,
                    ("No se tiene información sobre esta persona."),
                    "", JOptionPane.INFORMATION_MESSAGE);
                    Lista l = this.TableControlador.getTree().DFS(N);
                    this.Arbolito.mostrarAntepasados(l);
                } else{
                    String Datos = N.DevolverDatos();
                    JOptionPane.showMessageDialog(null,
                    (Datos),
                    "", JOptionPane.INFORMATION_MESSAGE);
                    Lista l = this.TableControlador.getTree().DFS(N);
                    this.Arbolito.mostrarAntepasados(l);
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Seleccione una persona correctamente.");
            }
        }else {
            JOptionPane.showMessageDialog(rootPane, "No ha ingresado ningún árbol.");
        }         
    }//GEN-LAST:event_antepasadosActionPerformed

     /**
     * @param evt
     * En principio se genera una lista desplegable con todos las generaciones que se encuentren dentro del Json para que 
     * el usuario pueda seleccionar la generación en específico de la cual quiera saber su información.
     * Función que te permite buscar a los integrantes de cada generación.
     */
    private void listaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaActionPerformed
        this.Arbolito = InterfazFunciones.getArbol();
        if (this.Arbolito != null){
            this.TableControlador = InterfazFunciones.getControlador();
            String[] A = this.TableControlador.ConseguirGeneraciones();
            String S = (String) JOptionPane.showInputDialog(rootPane, "Se mostrarán los miembros de la generación que seleccione:", "", HEIGHT, null, A, DISPOSE_ON_CLOSE);
            if (S != null){
                String[] B = this.TableControlador.BuscarPorGeneracion(S);
                String T = (String) JOptionPane.showInputDialog(rootPane, "Seleccione una persona:", "", HEIGHT, null, B, DISPOSE_ON_CLOSE);
                if (T != null){
                    NodoArbol N = this.TableControlador.BusquedaNombres(T);
                    if(N==null){
                        JOptionPane.showMessageDialog(null,
                        ("No se tiene información sobre esta persona."),
                        "", JOptionPane.INFORMATION_MESSAGE);
                    } else{
                        String Datos = N.DevolverDatos();
                        JOptionPane.showMessageDialog(null,
                        (Datos),
                        "", JOptionPane.INFORMATION_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Seleccione una persona correctamente.");
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Seleccione una generación correctamente.");
            }
        }else {
            JOptionPane.showMessageDialog(rootPane, "No ha ingresado ningún árbol.");
        }          
    }//GEN-LAST:event_listaActionPerformed

    /**
     * @param evt
     * @param file nueva variable de tipo JsonChooser
     * Función que permite cargar un archivo Json mediante el uso de una ventana de archivos del computador
     * Se guarda este arbol "Arbolito" en la clase InterfazFunciones para poder llamarlo en las distintas funciones de la clase
     * Se guarda este hashtable "HashNombres" en la clase InterfazFunciones para poder llamarlo en las distintas funciones de la clase
     * Se guarda este hashtable "HashMotes" en la clase InterfazFunciones para poder llamarlo en las distintas funciones de la clase
     */
    private void cargarjsonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarjsonActionPerformed
        JsonChooser file = new JsonChooser();
        file.chooseFile();
        if (file.getJson() != null){
            JOptionPane.showMessageDialog(null, "Su archivo fue cargado exitosamente.");
            try {

                newChose = new JsonDecoder(file.getJson());
                TableControlador = new TableManager();
                TableControlador.CrearEstructuras(newChose);
                InterfazFunciones.setControlador(TableControlador);
                Arbolito = new ArbolVisualizer(TableControlador.getTree(), TableControlador.getTablaNombre());
                InterfazFunciones.setArbol(Arbolito);
                HashNombres = newChose.crearHashTable();
                InterfazFunciones.setHashTablaNombres(HashNombres);
                HashMotes = newChose.HashTableMotes(HashNombres);
                InterfazFunciones.setHashTablaMotes(HashMotes);


            } catch (FileNotFoundException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione un archivo correctamente.");
        }                                           
    }//GEN-LAST:event_cargarjsonActionPerformed

     /**
     * @param evt
     * En principio se genera una lista desplegable con todos los títulos que se encuentren dentro del Json para que 
     * el usuario pueda seleccionar el título específico de quien quiera saber su información.
     * Función que te permite buscar a una persona por su título.
     */
    private void buscartituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscartituloActionPerformed
        this.Arbolito = InterfazFunciones.getArbol();
        if (this.Arbolito != null){
            this.TableControlador = InterfazFunciones.getControlador();
            String[] A = this.TableControlador.ConseguirTitulos();
            String S = (String) JOptionPane.showInputDialog(rootPane, "Se mostrarán las personas con el título que seleccione:", "", HEIGHT, null, A, DISPOSE_ON_CLOSE);
            if (S != null){
                String[] B = this.TableControlador.BuscarPorTitulo(S);
                String T = (String) JOptionPane.showInputDialog(rootPane, "Seleccione una persona:", "", HEIGHT, null, B, DISPOSE_ON_CLOSE);
                if (T != null){
                    NodoArbol N = this.TableControlador.BusquedaNombres(T);
                    if(N==null){
                        JOptionPane.showMessageDialog(null,
                        ("No se tiene información sobre esta persona."),
                        "", JOptionPane.INFORMATION_MESSAGE);
                    } else{
                        String Datos = N.DevolverDatos();
                        JOptionPane.showMessageDialog(null,
                        (Datos),
                        "", JOptionPane.INFORMATION_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Seleccione una persona correctamente.");
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Seleccione un título correctamente.");
            }
        }else {
            JOptionPane.showMessageDialog(rootPane, "No ha ingresado ningún árbol.");
        }
    }//GEN-LAST:event_buscartituloActionPerformed

    
    /**
     * @param evt
     * Función para que la clase interfaz BuscarPersona sea visible al llamar el método
     */
    private void buscarpersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarpersonaActionPerformed
        InterfazFunciones.openBuscarPersona();
    }//GEN-LAST:event_buscarpersonaActionPerformed

     /**
     * @param evt
     * Al presionar el botón se llama a la función de la Clase InterfazFunciones "getArbol" y si ésta 
     * no es igual a null se muestra el árbol
     */
    private void mostrararbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrararbolActionPerformed
        this.Arbolito = InterfazFunciones.getArbol();
        if (this.Arbolito != null) {
            this.Arbolito.mostrarArbol();
            
        }else {
            JOptionPane.showMessageDialog(rootPane, "No ha ingresado ningún archivo Json para leer.");
        }   

    }//GEN-LAST:event_mostrararbolActionPerformed

     /**
     * @param evt
     * Función para que termine la corrida del programa
     */
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton antepasados;
    private javax.swing.JButton buscarpersona;
    private javax.swing.JButton buscartitulo;
    private javax.swing.JButton cargarjson;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton lista;
    private javax.swing.JButton mostrararbol;
    // End of variables declaration//GEN-END:variables
}
