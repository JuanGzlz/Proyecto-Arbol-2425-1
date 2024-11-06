/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Clase JsonChooser
 * Incluye todo el proceso de selección del archivo Json con el sistema de paradas
 * @author Juan González
 * @version 1.0
 */

public class JsonChooser {
    /**
    * @param archivo variable privada de tipo File que indica el archivo seleccionada en la carpeta de archivos del usuario
    */
    
    private File archivo;
 
    /**
     * Constructor de la clase JsonChooser, no recibe parámetro de entrada
     * Automáticamente asigna el valor de null a archivo
     */
    
    public JsonChooser(){
        this.archivo = null;
    }
    
    /**
     * @return variable interna archivo
     */
    
    public File getJson(){
        return this.archivo;
    }
    
    /**
     * Método que permite seleccionar el archivo json con las paradas pasando a su vez un filtro que solo permita ingresar este tipo de archivos
     */
    
    public void chooseFile(){
        JFileChooser NewFile = new JFileChooser();
        FileNameExtensionFilter NewFilter = new FileNameExtensionFilter("Archivos Json", "json");
        NewFile.setFileFilter(NewFilter);
        NewFile.setAcceptAllFileFilterUsed(false);
        int IsValid = NewFile.showOpenDialog(NewFile);
        if(IsValid == JFileChooser.APPROVE_OPTION){
            this.archivo = NewFile.getSelectedFile();
        }
    }
}
