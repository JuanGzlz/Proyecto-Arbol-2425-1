/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;
import Arbol.NodoArbol;
import static java.lang.Math.abs;

/**
 * Clase que implementa una hash table con manejo de colisiones mediante listas enlazadas.
 * Permite insertar, buscar y listar elementos almacenados en la hash table.
 * Cada posición de la tabla es un nodo que puede contener una lista enlazada de nodos en caso de colisiones.
 * @author Admin
 */
public class HashTable {
    private String NombreTabla;
    private Nodo[] Hash;
    private int size;
    
    /**
     * Constructor de la clase HashTable.
     *
     * @param nombre el nombre que identifica a la hash table.
     */
    public HashTable(String nombre) {
        this.NombreTabla = nombre;
        this.Hash = new Nodo[1009];
        this.size = 0;
    }
    
    /**
     * @return the NombreTabla
     */
    public String getNombreTabla() {
        return NombreTabla;
    }
    
    /**
     * Inserta un nodo en la hash table basado en un nombre.
     * 
     * @param persona el nodo del árbol que contiene la información del elemento.
     * @param Nombre el nombre del elemento a insertar, usado como clave.
     */
    public void insertNodo (NodoArbol persona, String Nombre){
        Nodo newNodo = new Nodo(Nombre, persona);
        int indice = buscarIndex(Nombre);
        if (getHash()[indice] == null){
            Hash[indice] = newNodo;
        }else{
            Nodo current = getHash()[indice];
            while (current.getpNext() != null){
                current = current.getpNext();
            }
            current.setpNext(newNodo);
        }
        this.setSize(this.getSize()+1);
        
    }
    
    /**
     * Calcula el índice hash para un nombre.
     * 
     * @param nombre el nombre a procesar.
     * @return el índice calculado en el rango de la hash table.
     */
    private int buscarIndex (String nombre){
        int indice = nombre.hashCode() % getHash().length;
        return abs(indice);
    }
    
    /**
     * Busca un elemento en la hash table utilizando su nombre como clave.
     * 
     * @param nombre el nombre del elemento a buscar.
     * @return el nodo del árbol asociado al nombre, o null si no se encuentra.
     */
    public NodoArbol busquedaHasheo (String nombre){
        int ind = buscarIndex(nombre);
        NodoArbol newArbol = null;
        Nodo newNodo = getHash()[ind];
        while (newNodo != null){
            if (newNodo.getNombre().equals(nombre)){
                newArbol = newNodo.getPersona();
                break;
            }
            newNodo = newNodo.getpNext();
        }
        return newArbol;
    }
    
    /**
     * Devuelve una lista de nodos cuyo nombre contiene una subcadena específica.
     * 
     * @param Nombre el nombre a buscar.
     * @return una lista con los nodos que coincidan parcialmente.
     */
    public Lista DevolverPosible(String Nombre){
        Lista posibles = new Lista();
        Nodo current = null;
        for(int i = 0; i < this.getHash().length; i++){
            if(getHash()[i]!=null){
                current = getHash()[i];
                while(current!=null){
                    if(Nombre.contains(current.getPersona().getNombre())){
                        posibles.addLast(current.getPersona());
                    }
                current = current.getpNext();
                }
            }
        }
        return posibles;
    }

    /**
     * @return the Hash
     */
    public Nodo[] getHash() {
        return Hash;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

}
