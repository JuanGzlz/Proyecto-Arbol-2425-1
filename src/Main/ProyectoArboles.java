/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Arbol.Arbol;
import Arbol.NodoArbol;
import EDD.HashTable;
import EDD.Lista;
import EDD.Nodo;
import EDD.TableManager;
import Funciones.JsonChooser;
import Funciones.JsonDecoder;
import java.io.IOException;


/**
 *
 * @author Admin
 */
public class ProyectoArboles {

    /**
     * @param args the command line arguments
     */


    public static void main(String[] args) throws IOException {
        JsonChooser newFile = new JsonChooser();
        newFile.chooseFile();
        JsonDecoder newChose = new JsonDecoder(newFile.getJson());
        HashTable tabla = newChose.crearHashTable();
        NodoArbol newNodo = tabla.busquedaHasheo("Viserys Targaryen, First of his name, son of Aegon the Conqueror");
        HashTable tabla2 = newChose.HashTableMotes(tabla);
        NodoArbol newNodo2 = tabla2.busquedaHasheo("Daeron the Good");
        NodoArbol newNodo3 = tabla2.busquedaHasheo("Baelor Breakspear");
        
        TableManager creador = new TableManager();
        creador.CrearEstructuras(newChose);
        String[] a = creador.BuscarPorTitulo("Prince of Dragonstone");
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
        System.out.println(newNodo3.DevolverDatos());
//        System.out.println(hijo.getNombre());
//        System.out.println(newNodo.getNombre());
//        System.out.println(root.getHijos());
//        System.out.println(newNodo2.getNombre());
//        System.out.println(newNodo.getNumeral());
//        System.out.println(newNodo.getPapa());
//        System.out.println(newNodo.getMama());
//        System.out.println(newNodo.getApodo());
//        System.out.println(newNodo.getCasado());
//        System.out.println(newNodo.getOjos());
//        System.out.println(newNodo.getPelo());
//        System.out.println(newNodo.getHijos());
//        System.out.println(newNodo.getNotas());
//        System.out.println(newNodo.getDestino());
//        System.out.println(newNodo.getTitulo());
    }

}
