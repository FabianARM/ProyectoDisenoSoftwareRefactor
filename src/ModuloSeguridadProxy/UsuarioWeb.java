/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloSeguridadProxy;

import java.util.ArrayList;

/**
 *
 * @author pao__
 */
public class UsuarioWeb {
    int iD;
    int paginasVisitadas;
    private ArrayList<String> sitiosWebVisitados;
    
    public UsuarioWeb(int id){
        this.iD = id;
        this.paginasVisitadas = 0;
        this.sitiosWebVisitados  = new ArrayList<String>();
    }

    public int getPaginasVisitadas() {
        return paginasVisitadas;
    }

    public void AumentarPaginasVisitadas() {
        ++this.paginasVisitadas;
    }

    public ArrayList<String> getSitiosWebVisitados() {
        return sitiosWebVisitados;
    }

    public void addSitiosWebVisitados(String newSitioWebVisitado) {
        this.sitiosWebVisitados.add(newSitioWebVisitado);
    }
    
    
    
}
