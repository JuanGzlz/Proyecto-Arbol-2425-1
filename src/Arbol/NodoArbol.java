/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arbol;

/**
 *
 * @author Admin
 */
public class NodoArbol {
    /**
     * @param pNext variable privada de tipo Nodo que apunta a otro nodo próximo
     * @param data variable privada de tipo Vertice que guarda la información del nodo
     */

    private String Nombre;
    private String Numeral;
    private String Pelo;
    private String Ojos;
    private String Madre;
    private NodoArbol fSon;
    private NodoArbol nBrother;

    public NodoArbol(String Nombre, String Numeral, String Pelo, String Ojos, String Madre) {
        this.Nombre = Nombre;
        this.Numeral = Numeral;
        this.Pelo = Pelo;
        this.Ojos = Ojos;
        this.Madre = Madre;
        this.fSon = null;
        this.nBrother = null;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @return the Numeral
     */
    public String getNumeral() {
        return Numeral;
    }
    
    /**
     * @return the fSon
     */
    public NodoArbol getfSon() {
        return fSon;
    }

    /**
     * @param fSon the fSon to set
     */
    public void setfSon(NodoArbol fSon) {
        this.fSon = fSon;
    }

    /**
     * @return the nBrother
     */
    public NodoArbol getnBrother() {
        return nBrother;
    }

    /**
     * @param nBrother the nBrother to set
     */
    public void setnBrother(NodoArbol nBrother) {
        this.nBrother = nBrother;
    }
    
    
    public void AgregarHijo(NodoArbol hijo){
        if (fSon != null){
            NodoArbol current = fSon;
            while (current.nBrother != null){
                current = current.nBrother;
            }
            current.nBrother = hijo;
        } else{
            fSon = hijo;
        }            
    }
    
}
