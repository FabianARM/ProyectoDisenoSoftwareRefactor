/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloSeguridadCamaras;

import java.util.List;

/**
 *
 * @author Fabián
 */
public interface Camara {
 
    public int getID(); 
    public boolean reconocer(String numeroDeCedula); 
    public Locacion getLocacion();
    public Orientacion getOrientacion(); 
    public void setOrientacion(Orientacion orientacion);
    public void addCamara(Camara camara); 
    public void removeCamara(int indice);
    public Camara getCamara(int id); 
    public List<Persona> getListaPersonas(); 
    public String obtenerEstadoDeCamara(); 
    public void añadirPersonaEnCuadro(Persona persona);//Con algun softwre de reconocimiento facial que se añadan las personas que esten en uadroe 

}
