/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

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
        NodoArbol newNodo = tabla.busquedaHasheo("Baelon  Targaryen, First of his name");
        HashTable tabla2 = newChose.HashTableMotes(tabla);
        NodoArbol newNodo2 = tabla2.busquedaHasheo("Baelon Targaryen, First of his name");
        System.out.println(newNodo.getNombre());
        System.out.println(newNodo2.getNombre());
    }
}
