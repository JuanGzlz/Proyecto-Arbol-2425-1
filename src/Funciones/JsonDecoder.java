/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;
import Arbol.Arbol;
import Arbol.NodoArbol;
import EDD.HashTable;
import EDD.Lista;
import EDD.Nodo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase encargada de decodificar un archivo JSON para procesar y construir estructuras
 * de datos relacionadas con jerarquías familiares.
 * Permite extraer información y transformarla en hash tables, árboles y otras estructuras.
 * 
 * @author Juan González & Valentina Vegas
 * @version 1.0
 */

public class JsonDecoder {
    /**
    * @param file variable privada de tipo File que indica el archivo seleccionada en la carpeta de archivos del usuario
    * @param NewBufferedReader variable de tipo BufferedReader que permite leer el json por caracteres, matrices y cadenas de manera eficiente
    * @param text variable de tipo String que representa un texto para realizar pruebas de este decodificador (uso no definido)
    */
    private File file;
    private BufferedReader NewBufferedReader;
    private String text;
       
    /**
     * Constructor que inicializa el lector de archivo con el JSON proporcionado.
     * Automáticamente asigna la variable file al valor de la entrada
     * Los Readers son asignados a la lectura del propio file que representa el archivo ingresado
     * 
     * @param file archivo JSON a decodificar.
     * @throws FileNotFoundException si el archivo no existe.
     */
    public JsonDecoder(File file) throws FileNotFoundException{
        this.file = file;
        FileReader NewFileReader = new FileReader(this.file);
        this.NewBufferedReader = new BufferedReader(NewFileReader);
    }
    
    /**
     * Lee una línea del archivo JSON.
     * 
     * @return una línea del archivo en formato String.
     * @throws IOException si ocurre un error durante la lectura.
     */
    public String Read() throws FileNotFoundException, IOException{
        return this.NewBufferedReader.readLine();
    }
    
    /**
     * Reinicia el lector del archivo, posicionándolo nuevamente al inicio del JSON.
     * 
     * @throws FileNotFoundException si el archivo no existe.
     */
    public void Reset() throws FileNotFoundException{
        FileReader NewFileReader = new FileReader(this.file);
        this.NewBufferedReader = new BufferedReader(NewFileReader);
    }
    
     /**
     * Lee y muestra en consola todo el contenido del archivo JSON línea por línea.
     * 
     * @throws IOException si ocurre un error durante la lectura.
     */
    public void ReadAll() throws FileNotFoundException, IOException{
        FileReader NewFileReader = new FileReader(this.file);
        BufferedReader MyBuffer = new BufferedReader(NewFileReader);
        String mystr = MyBuffer.readLine();
        while(mystr != null){
            System.out.println(mystr);
            mystr = MyBuffer.readLine();
        }
    }
    
    /**
     * Obtiene el nombre la casa a partir de la segunda línea del JSON.
     * 
     * @return el nombre de la casa.
     * @throws IOException si ocurre un error durante la lectura.
     */
    public String CasaNombre() throws FileNotFoundException, IOException{
        this.Reset();
        this.Read();
        String Nombre = this.Read();
        Nombre = Nombre.replace("\"", "").replace(":[", "").trim();
        return Nombre;
    }
    
    /**
     * Crea una hash table basada en la información extraída del JSON. Procesa
     * nombres, atributos y relaciones para estructurarlas en nodos.
     * 
     * @return una HashTable que contiene los nodos creados a partir del JSON.
     * @throws IOException si ocurre un error durante la lectura.
     */
    @SuppressWarnings("empty-statement")
    public HashTable crearHashTable() throws IOException{
        String N = this.CasaNombre();
        HashTable tabla = new HashTable(N);
        String Iteracion = this.Read();
        int contador = 0;
        boolean Madre = false;
        String[] Atributos = {"", "", "", "", "", "", "", "", "", "", "", ""};
        while (Iteracion != null){
            if (Iteracion.contains("[") && !Iteracion.contains("]")){
                if(!Iteracion.contains("Father to")){
                    Atributos[0] = Iteracion.replace("\"", "").replace("[", "").replace(":", "").trim();
                }
                contador++;                
            }else if (Iteracion.contains("]") && !Iteracion.contains("[")){
                contador--;                
            }
            
            switch (contador) {
                case 0:
                    if(!Iteracion.contains("{") && !Iteracion.contains("}")){
                    NodoArbol newNodoArbol = new NodoArbol(Atributos[0], Atributos[1], Atributos[2], Atributos[3], Atributos[4], Atributos[5], Atributos[6], Atributos[7], Atributos[8], Atributos[9], Atributos[10], Atributos[11]);
                    String Nombre_completo = Atributos[0] + ", " + Atributos[1] + " of his name, son of " + Atributos[2];
                    tabla.insertNodo(newNodoArbol, Nombre_completo);
                    for(int i = 0; i < Atributos.length; i++){
                        Atributos[i] = "";
                        }
                    Madre = false;
                    }
                    break;
                case 1:
                    if(Iteracion.contains("Born to")){
                        if(Madre==false){
                            Atributos[2] = Iteracion.replace("Born to", "").replace("\"", "").replace("{", "").replace("}", "").replace(",", "").replace(":", "").trim();
                            Madre = true;
                        }else{
                            Atributos[3] = Iteracion.replace("Born to", "").replace("\"", "").replace("{", "").replace("}", "").replace(",", "").replace(":", "").trim();
                        }
                    }else{
                    Atributos = GuardarDatos(Iteracion, Atributos, Madre);
                    }
                    break;
                case 2:
                    Atributos = GuardarHijos(Iteracion, Atributos);
                    break;
                default:
                    break;
            }
            Iteracion = this.Read();
        }
        return tabla;
    }
    
    /**
     * Método auxiliar para procesar y guardar atributos individuales de los nodos.
     * 
     * @param Linea línea actual del JSON.
     * @param Array arreglo que almacena temporalmente los atributos del nodo.
     * @param Madre bandera para identificar si se está procesando la madre del nodo.
     * @return el arreglo actualizado con los nuevos datos.
     * @throws IOException si ocurre un error durante la lectura.
     */   
    private String[] GuardarDatos(String Linea, String[] Array, boolean Madre) throws IOException{
        if (Linea.contains("Of his name")){
            Array[1] = Linea.replace("Of his name", "").replace("\"", "").replace("{", "").replace("}", "").replace(",", "").replace(":", "").trim();
        } else if (Linea.contains("Known throughout as")){
            Array[4] = Linea.replace("Known throughout as", "").replace("\"", "").replace("{", "").replace("}", "").replace(",", "").replace(":", "").trim();
        } else if (Linea.contains("Held title")){
            Array[5] = Linea.replace("Held title", "").replace("\"", "").replace("{", "").replace("}", "").replace(",", "").replace(":", "").trim();
        } else if (Linea.contains("Wed to")){
            Array[6] = Linea.replace("Wed to", "").replace("\"", "").replace("{", "").replace("}", "").replace(",", "").replace(":", "").trim();
        } else if (Linea.contains("Of eyes")){
            Array[7] = Linea.replace("Of eyes", "").replace("\"", "").replace("{", "").replace("}", "").replace(",", "").replace(":", "").trim();
        } else if (Linea.contains("Of hair")){
            Array[8] = Linea.replace("Of hair", "").replace("\"", "").replace("{", "").replace("}", "").replace(",", "").replace(":", "").trim();
        } else if (Linea.contains("Notes")){
            Array[10] = Linea.replace("Notes", "").replace("\"", "").replace("{", "").replace("}", "").replace(",", "").replace(":", "").trim();
        } else if (Linea.contains("Fate")){
            Array[11] = Linea.replace("Fate", "").replace("\"", "").replace("{", "").replace("}", "").replace(",", "").replace(":", "").trim();
        }
              
        return Array;
    }
    
    /**
     * Método auxiliar para procesar y guardar hijos de un nodo.
     * 
     * @param Linea línea actual del JSON.
     * @param Array arreglo que almacena temporalmente los datos del nodo.
     * @return el arreglo actualizado con los hijos procesados.
     */
    private String[] GuardarHijos(String Linea, String[] Array){
        if(Linea.contains("Father to")){
            return Array;
        }
        else if(Array[9].equals("")){
            Array[9] = Linea.replace("\"", "").replace(",", "").trim();
        } else {
            Array[9] = Array[9] + ", " + Linea.replace("\"", "").replace(",", "").trim();
        }
        return Array;
    }
    
    /**
     * Construye una hash table secundaria utilizando motes para los nodos.
     * Se basa en la información procesada previamente en la tabla principal.
     * 
     * @param Tabla hash table principal que contiene los nodos originales.
     * @return una nueva HashTable que utiliza los motes como claves.
     * @throws IOException si ocurre un error durante la lectura.
     */
    public HashTable HashTableMotes(HashTable Tabla) throws IOException{
        this.Reset();
        String N = this.CasaNombre();
        HashTable NuevaTabla = new HashTable(N);
        String Iteracion = this.Read();
        int contador = 0;
        String mote = "";
        String NombreCompleto = "";
        String Nombre = "";
        String Padre = "";
        String Numeral = "";
        boolean SeenPadre = false;
        while (Iteracion != null){
            if (Iteracion.contains("[") && !Iteracion.contains("]")){
                if(!Iteracion.contains("Father to")){
                    Nombre = Iteracion.replace("\"", "").replace("[", "").replace(":", "").trim();
                }
                contador++;                
            }else if (Iteracion.contains("]") && !Iteracion.contains("[")){
                contador--;                
            }
            switch (contador){
                case 0:
                    if (!Iteracion.contains("{") && !Iteracion.contains("}")){
                        NombreCompleto = Nombre + ", " + Numeral + " of his name, son of " + Padre;
                        NodoArbol nodo = Tabla.busquedaHasheo(NombreCompleto);
                        if(!mote.equals("")){
                            NuevaTabla.insertNodo(nodo, mote);
                        }
                        else {
                            NuevaTabla.insertNodo(nodo, NombreCompleto);
                        }
                    }
                    mote = "";
                    NombreCompleto = "";
                    Nombre = "";
                    Padre = "";
                    Numeral = "";
                    SeenPadre = false;
                    break;
                case 1:
                    if (Iteracion.contains("Known throughout as")){
                        mote = Iteracion.replace("Known throughout as", "").replace("\"", "").replace("{", "").replace("}", "").replace(",", "").replace(":", "").trim();
                    } else if(Iteracion.contains("Of his name")){
                        Numeral = Iteracion.replace("Of his name", "").replace("\"", "").replace("{", "").replace("}", "").replace(",", "").replace(":", "").trim();
                    }else if(Iteracion.contains("Born to")){
                        if(SeenPadre==false){
                        Padre = Iteracion.replace("Born to", "").replace("\"", "").replace("{", "").replace("}", "").replace(",", "").replace(":", "").trim();
                        SeenPadre = true;
                        }
                    }
                    break;
            }
        Iteracion = this.Read();
        }
        return NuevaTabla;
    }
    
     /**
     * Construye un árbol basado en la información del JSON. Las relaciones entre nodos
     * padre e hijo se definen según los datos de nacimiento y jerarquías.
     * 
     * @param tablaNombres hash table principal con los nodos originales.
     * @param tablaMotes hash table secundaria con motes como claves.
     * @return un árbol que representa la jerarquía procesada.
     * @throws IOException si ocurre un error durante la lectura.
     */
    public Arbol crearArbol(HashTable tablaNombres, HashTable tablaMotes) throws FileNotFoundException, IOException{
        this.Reset();
        String N = this.CasaNombre();
        String Iteracion = this.Read();
        Arbol newArbol = new Arbol();
        int contador = 0;
        boolean SeenPadre = false;
        String padre = "";
        String NombreCompleto = "";
        String Nombre = "";
        String Numeral = "";
        while (Iteracion != null){
            if (Iteracion.contains("[") && !Iteracion.contains("]")){
                if(!Iteracion.contains("Father to")){
                    Nombre = Iteracion.replace("\"", "").replace("[", "").replace(":", "").trim();
                }
                contador++;                
            }else if (Iteracion.contains("]") && !Iteracion.contains("[")){
                contador--;                
            }
            switch (contador){
                case 0:
                    if (!Iteracion.contains("{") && !Iteracion.contains("}")){
                        NombreCompleto = Nombre + ", " + Numeral + " of his name, son of " + padre;
                        NodoArbol nodo = tablaNombres.busquedaHasheo(NombreCompleto);
                        NodoArbol PadreMote = tablaMotes.busquedaHasheo(padre);
                        if (padre.contains("Unknown")){
                            newArbol.setRaiz(nodo);
                        } else if(PadreMote != null){
                            PadreMote.AgregarHijo(nodo);
                        } else{
                            Lista posibles = tablaNombres.DevolverPosible(padre);
                            Nodo current = posibles.getpFirst();
                            while(current!=null){
                                String[] Hijos = current.getPersona().getHijos().split(", ");
                                for(int i = 0; i < Hijos.length; i++){
                                    if(nodo.getNombre().contains(Hijos[i]) && !Hijos[i].equals("") && padre.contains(current.getPersona().getNumeral())){
                                       current.getPersona().AgregarHijo(nodo);
                                       break;
                                    } else if(!padre.contains("of his name")){
                                       current.getPersona().AgregarHijo(nodo);
                                       break;
                                    }
                                }
                            current = current.getpNext();
                            }
                        }
                                
                    }
                    
                    
                    NombreCompleto = "";
                    Nombre = "";
                    padre = "";
                    SeenPadre = false;
                    break;
                case 1:
                    if(Iteracion.contains("Of his name")){
                        Numeral = Iteracion.replace("Of his name", "").replace("\"", "").replace("{", "").replace("}", "").replace(",", "").replace(":", "").trim();   
                    } else if(Iteracion.contains("Born to")){
                        if(SeenPadre==false){
                        padre = Iteracion.replace("Born to", "").replace("\"", "").replace("{", "").replace("}", "").replace(",", "").replace(":", "").trim();
                        SeenPadre = true;
                        }
                    }
                    break;
            }
        Iteracion = this.Read();
    }  
        return newArbol;
    }
}
