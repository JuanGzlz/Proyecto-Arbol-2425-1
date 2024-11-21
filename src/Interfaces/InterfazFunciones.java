/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Arbol.ArbolVisualizer;
import EDD.HashTable;
import EDD.TableManager;

/**
 *
 * @author User
 */
public class InterfazFunciones {
    
    private static ArbolVisualizer VisualArbol = null;
    private static TableManager controlador = null;
    private static HashTable hashTablaNombres = null;
    private static HashTable hashTablaMotes = null;
    
    private static final Bienvenida paginaprincipal= new Bienvenida(); 
    private static final Menu menu =new Menu();
    private static final BuscarPersona buscarpersona = new BuscarPersona();
    
    /**
     * Función para que la clase de interfaz Bienvenida sea visible al llamar el método
     */
    public static void openBienvenida(){
        getBienvenida().setVisible(true);
        
    }
    
    /**
     * @return variable interna paginaprincipal
     */      
    
    public static Bienvenida getBienvenida() {
        return paginaprincipal;
    }
    
    /**
     * Función para que la clase de interfaz Menú sea visible al llamar el método
     */
    public static void openMenu() {
        getMenuPrincipal().setVisible(true);
    }
     /**
     * @return variable interna menu
     */  
      public static Menu getMenuPrincipal() {
        return menu;
    }
   
    /**
     * @return variable interna buscarnombre
     */      
    public static BuscarPersona getBuscarPersona() {
        return buscarpersona;
    }
   
    /**
     * Función para que la clase de interfaz BuscarNombre sea visible al llamar el método
     */    
    public static void openBuscarPersona() {
        getBuscarPersona().setVisible(true);
        getMenuPrincipal().setVisible(false);
    }
    
    /**
     * Función para que la clase de interfaz Menú sea visible la única visible cuado el usuario salga
     de las otras interfaces y vuelva al origen
     */
    
    public static void VolverMenu(){
        getMenuPrincipal().setVisible(true);

        getBuscarPersona().setVisible(false);
        
   }

    /**
     * @return the arbol
     */
    public static ArbolVisualizer getArbol() {
        return VisualArbol;
    }

    /**
     * @param Arbol the arbol to set
     */
    public static void setArbol(ArbolVisualizer Arbol) {
        InterfazFunciones.VisualArbol = Arbol;
    }

    /**
     * @return the controlador
     */
    public static TableManager getControlador() {
        return controlador;
    }

    /**
     * @param aControlador the controlador to set
     */
    public static void setControlador(TableManager aControlador) {
        InterfazFunciones.controlador = aControlador;
    }

    /**
     * @return the hashTabla
     */
    public static HashTable getHashTablaNombres() {
        return hashTablaNombres;
    }

    /**
     * @param aHashTabla the hashTabla to set
     */
    public static void setHashTablaNombres(HashTable aHashTabla) {
        InterfazFunciones.hashTablaNombres = aHashTabla;
    }

    /**
     * @return the hashTablaMotes
     */
    public static HashTable getHashTablaMotes() {
        return hashTablaMotes;
    }

    /**
     * @param aHashTablaMotes the hashTablaMotes to set
     */
    public static void setHashTablaMotes(HashTable aHashTablaMotes) {
        hashTablaMotes = aHashTablaMotes;
    }

}
