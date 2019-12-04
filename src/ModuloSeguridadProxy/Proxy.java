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

/*
        pruebas:
        1- usuario con mas de 100 sitios visitados
        2- menos de 100 sitios visitados que solicita una apgina accesible
        3- menos de 100 visitados con una pagina bloqueada
*/

public class Proxy implements InterfazServicioProxy{
    
    private ArrayList<PaginaWeb> sitiosWeb = new ArrayList<PaginaWeb>();
    private ArrayList<UsuarioWeb> listaVisitantes = new ArrayList<UsuarioWeb>();
    private ArrayList<Integer> consumoPorVisitante = new ArrayList<Integer>();
    private ArrayList<String> visitantesBloqueados = new ArrayList<String>();
    private ServicioProxy servicio;
    
    public Proxy (ArrayList<PaginaWeb> sitiosWeb, ArrayList<UsuarioWeb> listaVisitantes){
        this.sitiosWeb = sitiosWeb;
        this.listaVisitantes = listaVisitantes;
    }
    
    @Override
    public PaginaWeb darAccesoInternet(UsuarioWeb usuario, String paginaSolicitada) {
        PaginaWeb pagina = new PaginaWeb(paginaSolicitada);
        boolean acceso;
       
        acceso = revisarSitioWebBloqueado(paginaSolicitada) && revisarUsuario(usuario, paginaSolicitada);
        
        if (acceso)
        {
            System.out.println("Acceso a la página web permitido"); 
            servicio = new ServicioProxy(sitiosWeb, listaVisitantes); 
            servicio.darAccesoInternet(usuario, paginaSolicitada); 
            return pagina;             
        }else
        {
            pagina = null; 
            System.out.println("Acceso a la página web denegado. Usted a intentado acceder a un sitio web bloqueado o ha ingresado a mas de 100 paginas web"); 
            return pagina; 
        }
    }

    public boolean revisarSitioWebBloqueado(String nombrePagina){
        boolean bloqueado = false;
        for (int i = 0; i < sitiosWeb.size(); i++) {
            if (sitiosWeb.get(i).nombrePaginaWeb == nombrePagina) {
                PaginaWeb pagina = sitiosWeb.get(i);
                if (pagina.bloqueada == true) {
                    bloqueado = true;
                }else{
                    bloqueado = false;
                }

            }
        }
        return bloqueado;
    }
    
    public boolean revisarUsuario(UsuarioWeb usuario, String paginaSolicitada)
    {
        ArrayList<String> sitiosWebVisitados = usuario.getSitiosWebVisitados();
        if(usuario.getPaginasVisitadas()< 100)
        {
            if (sitiosWebVisitados.contains(paginaSolicitada))
            {
                    return true;
            }else
            {
                usuario.addSitiosWebVisitados(paginaSolicitada);
                usuario.AumentarPaginasVisitadas();
                return true;
            }    
        }else
        {
            return false;
        }
    }
    
    
    

    public ArrayList<Integer> obtenerListaConsumoPorVisitante() {
        return consumoPorVisitante;
    }



    public void agregarNuevoSitioWeb(PaginaWeb sitioWeb) {
        sitiosWeb.add(sitioWeb);
    }    
    

    public ArrayList<String> obtenerListaVisitantesBloqueados() {
        return visitantesBloqueados;
    }


    public void agregarNuevoVisitanteBloqueado(String visitanteBloqueados) {
        visitantesBloqueados.add(visitanteBloqueados);
    }
    

    public void agregarConsumoVisitante(String visitante, int consumo) {
        int indice = 0;
        indice = listaVisitantes.indexOf(visitante);
        consumoPorVisitante.set(indice, consumo);
    }
    
}
