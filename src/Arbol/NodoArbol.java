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
    private String Papa;
    private String Mama;
    private String Apodo;
    private String Titulo;
    private String Casado;
    private String Ojos;
    private String Pelo;
    private String Hijos;
    private String Notas;
    private String Destino;
    private NodoArbol fSon;
    private NodoArbol nBrother;

    public NodoArbol(String Nombre, String Numeral, String Papa, String Mama, String Apodo, String Titulo, String Casado, String Ojos, String Pelo, String Hijos, String Notas, String Destino) {
        this.Nombre = Nombre;
        this.Numeral = Numeral;
        this.Papa = Papa;
        this.Mama = Mama;
        this.Apodo = Apodo;
        this.Titulo = Titulo;
        this.Casado = Casado;
        this.Ojos = Ojos;
        this.Pelo = Pelo;
        this.Hijos = Hijos;
        this.Notas = Notas;
        this.Destino = Destino;
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
        if(fSon==null){
            fSon = hijo;
        } else{
            NodoArbol PrimerHijo = fSon;
            while(PrimerHijo!=null){
                PrimerHijo = PrimerHijo.nBrother;
            }
            PrimerHijo = hijo;
        }
    }

    /**
     * @return the Mama
     */
    public String getMama() {
        return Mama;
    }

    /**
     * @return the Apodo
     */
    public String getApodo() {
        return Apodo;
    }

    /**
     * @return the Titulo
     */
    public String getTitulo() {
        return Titulo;
    }

    /**
     * @return the Casado
     */
    public String getCasado() {
        return Casado;
    }

    /**
     * @return the Ojos
     */
    public String getOjos() {
        return Ojos;
    }

    /**
     * @return the Pelo
     */
    public String getPelo() {
        return Pelo;
    }

    /**
     * @return the Hijos
     */
    public String getHijos() {
        return Hijos;
    }

    /**
     * @return the Notas
     */
    public String getNotas() {
        return Notas;
    }

    /**
     * @return the Destino
     */
    public String getDestino() {
        return Destino;
    }

    /**
     * @return the Papa
     */
    public String getPapa() {
        return Papa;
    }
    
    
    
}
