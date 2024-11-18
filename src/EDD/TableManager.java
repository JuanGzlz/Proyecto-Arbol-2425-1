/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import Arbol.Arbol;
import Funciones.JsonDecoder;
import java.io.IOException;

/**
 *
 * @author valen
 */
public class TableManager {
    
    private HashTable TablaNombre;
    private HashTable TablaMote;
    private Arbol Tree;
    
    public TableManager(){
        TablaNombre = null;
        TablaMote = null;
        Tree = null;
    }
    
    public void CrearEstructuras(JsonDecoder Archivo) throws IOException{
        TablaNombre = Archivo.crearHashTable();
        TablaMote = Archivo.HashTableMotes(TablaNombre);
        Tree = Archivo.crearArbol(TablaNombre, TablaMote);
    }
    
    public String[] ConseguirNombres(){
        Nodo[] Array = TablaNombre.getHash();
        int size = TablaNombre.getSize();
        String[] Nombres = new String[size];
        int j = 0;
        for(int i = 0; i < Array.length; i++){
            Nodo aux = Array[i];
                while(aux!=null){
                    Nombres[j] = aux.getNombre();
                    j++;
                    aux = aux.getpNext();
            }
        }
        
        return Nombres;
    }
    
    public String[] ConseguirTitulos(){
        Nodo[] Array = TablaNombre.getHash();
        String Titulos = "";
        for(int i = 0; i < Array.length; i++){
            Nodo aux = Array[i];
            while(aux!=null){
                String TituloNuevo =  aux.getPersona().getTitulo();
                if(Titulos.equals("")){
                    Titulos = TituloNuevo;
                }else{
                    if(!Titulos.contains(TituloNuevo)){
                        Titulos = Titulos + ", " + TituloNuevo;
                    } 
                }
                aux = aux.getpNext();
            }
        }
        return Titulos.split(", ");
    }
    
    public String[] BuscarPorTitulo(String Titulo){
        Nodo[] Array = TablaNombre.getHash();
        String Nombres = "";
        for(int i = 0; i < Array.length; i++){
            Nodo aux = Array[i];
            while(aux!=null){
                String NombreCompleto =  aux.getNombre();
                if(Titulo.equals(aux.getPersona().getTitulo())){
                    if(Nombres.equals("")){
                        Nombres = NombreCompleto;
                    }else{
                            Nombres = Nombres + "123" + NombreCompleto;
                    }
                }
                aux = aux.getpNext();
            }
        }
        return Nombres.split("123");
        
    }
    
    /**
     * @return the TablaNombre
     */
    public HashTable getTablaNombre() {
        return TablaNombre;
    }

    /**
     * @return the TablaMote
     */
    public HashTable getTablaMote() {
        return TablaMote;
    }

    /**
     * @return the Tree
     */
    public Arbol getTree() {
        return Tree;
    }
    
    
    
    
}
