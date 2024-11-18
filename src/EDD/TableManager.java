/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import Arbol.Arbol;
import Arbol.NodoArbol;
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
    
    public String[] ConseguirMotes(){
        Nodo[] Array = TablaMote.getHash();
        int size = TablaMote.getSize();
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
    
    public String[] ConseguirGeneraciones(){
    int nodos_por_capa = 1;
    int nodos_por_ver = 0;
    int profundidad_max = 1;
    NodoArbol aux = Tree.getRaiz();
    NodoArbol hijo = null;
    Cola C = new Cola();
    C.encolar(aux);
    
    while(!C.isEmpty()){
        if(nodos_por_capa==0){ //Paso a la siguiente generacion
            nodos_por_capa = nodos_por_ver;
            nodos_por_ver = 0;
            profundidad_max++;
        }
        
        aux = C.desencolar().getPersona();
        hijo = aux.getfSon();
        while(hijo!=null){
            C.encolar(hijo);
            nodos_por_ver++;
            hijo = hijo.getnBrother();
        }
        nodos_por_capa--;
    }
    
    
    String Generaciones = "";
    for(int i = 1; i <= profundidad_max; i++){
        if(Generaciones.equals("")){
            Generaciones = "Generacion " + i;
        }else{
            Generaciones = Generaciones + "qwerty" + "Generacion " + i;
        }
    }
        return Generaciones.split("qwerty");
    }
    
    public String[] BuscarPorGeneracion(String Generacion){
        String Numero = Generacion.replace("Generacion ", "");
        int Profundidad_Deseada = Integer.parseInt(Numero);
        int nodos_por_capa = 1;
        int nodos_por_ver = 0;
        int Profundidad_Actual = 1;
        NodoArbol aux = Tree.getRaiz();
        NodoArbol hijo = null;
        Cola C = new Cola();
        C.encolar(aux);

        while(!C.isEmpty()){
            if(nodos_por_capa==0){ //Paso a la siguiente generacion
                nodos_por_capa = nodos_por_ver;
                nodos_por_ver = 0;
                Profundidad_Actual++;
                if(Profundidad_Actual == Profundidad_Deseada){ //Se llega a la profundidad deseada
                    break;
                }
            }

            aux = C.desencolar().getPersona();
            hijo = aux.getfSon();
            while(hijo!=null){
                C.encolar(hijo);
                nodos_por_ver++;
                hijo = hijo.getnBrother();
            }
            nodos_por_capa--;
        }
        int ColaSize = C.getSize();
        String[] Nombres = new String[ColaSize];
        for(int i = 0; i < ColaSize; i++){
            aux = C.desencolar().getPersona();
            Nombres[i] = aux.NombreCompleto();
            
        }
        
        
        return Nombres;
    }
    
}
