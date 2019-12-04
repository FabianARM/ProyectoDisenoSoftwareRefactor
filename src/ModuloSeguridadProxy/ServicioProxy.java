/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloSeguridadProxy;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Paola & Polina
 */
public class ServicioProxy implements InterfazServicioProxy{
    
    private ArrayList<PaginaWeb> sitiosWeb = new ArrayList<PaginaWeb>();
    private ArrayList<UsuarioWeb> listaVisitantes = new ArrayList<UsuarioWeb>();
    private ArrayList<Integer> consumoPorVisitante = new ArrayList<Integer>();
    private ArrayList<String> visitantesBloqueados = new ArrayList<String>();
    
    public ServicioProxy (ArrayList<PaginaWeb> sitiosWeb, ArrayList<UsuarioWeb> listaVisitantes){
        this.sitiosWeb = sitiosWeb;
        this.listaVisitantes = listaVisitantes;
    }
    
    @Override
    public PaginaWeb darAccesoInternet(UsuarioWeb usuario, String paginaSolicitada) {
        System.out.println("Acceso a la página web permitido");
        PaginaWeb pagina = new PaginaWeb(paginaSolicitada);
        return pagina; 
    }


}
