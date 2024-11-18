/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;
import Arbol.NodoArbol;
import static java.lang.Math.abs;

/**
 *
 * @author Admin
 */
public class HashTable {
    private String NombreTabla;
    private Nodo[] Hash;
    private int size;

    public HashTable(String nombre) {
        this.NombreTabla = nombre;
        this.Hash = new Nodo[1009];
    }
    
    /**
     * @return the NombreTabla
     */
    public String getNombreTabla() {
        return NombreTabla;
    }
    
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
        
    }
    
    private int buscarIndex (String nombre){
        int indice = nombre.hashCode() % getHash().length;
        return abs(indice);
    }
    
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
