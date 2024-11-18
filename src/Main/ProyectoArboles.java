/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Arbol.Arbol;
import Arbol.NodoArbol;
import EDD.HashTable;
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
        Arbol ar = newChose.crearArbol(tabla, tabla2);
        NodoArbol hijo = newNodo2.getfSon().getnBrother();
        NodoArbol root = ar.getRaiz();
        System.out.println(hijo.getNombre());
//        System.out.println(newNodo.getNombre());
        System.out.println(root.getHijos());
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
