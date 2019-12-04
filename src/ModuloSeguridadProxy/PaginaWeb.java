/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloSeguridadProxy;

/**
 *
 * @author Paola & Polina
 */
public class PaginaWeb {
    
    String nombrePaginaWeb;
    boolean bloqueada;
    
    public PaginaWeb(String nombre){
        this.nombrePaginaWeb = nombre;
        this.bloqueada = false;
    }
    
    public String getNombrePagina(){
        return this.nombrePaginaWeb;
    }
       
}
