/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloSeguridadCamaras;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fabián
 */
public class CamaraLeaf implements Camara
{
    private static int cantidadDeCamaras;
    private int id; 
    private Locacion locacion; 
    private Orientacion orientacion;
    List<Persona> personasEnCuadro;
    
    public CamaraLeaf(Locacion locacion)
    {
        this.id = cantidadDeCamaras;
        cantidadDeCamaras++;
        personasEnCuadro = new ArrayList<>(); 
        this.locacion = locacion;
        this.orientacion = Orientacion.CENTRO; 
    }
    
    @Override
    public int getID() 
    {
        return this.id; 
    }

    @Override
    public boolean reconocer(String numeroDeCedula) 
    { 
        for(Persona iter : this.getListaPersonas())
        {
           if(iter.getCedula().equalsIgnoreCase(numeroDeCedula))
           {
               return true;
           }
        }    
        return false; 
    }

    @Override
    public Locacion getLocacion()
    {
        return locacion; 
    }

    @Override
    public Orientacion getOrientacion()
    {
        return orientacion; 
    }

    @Override
    public void setOrientacion(Orientacion orientacion) 
    {
        this.orientacion = orientacion; 
    }

    @Override
    public void addCamara(Camara camara) 
    {
        //No se implementa. 
    }

    @Override
    public void removeCamara(int indice) 
    {
        //No se implementa.+
    }

    @Override
    public Camara getCamara(int id) 
    {
        return null;
    }

    @Override
    public List<Persona> getListaPersonas() 
    {
        return this.personasEnCuadro; 
    }

    @Override
    public String obtenerEstadoDeCamara() 
    {
        return "La camara: "+ this.getID() + 
                "\nOrientacion: " + this.getOrientacion() + 
                "\nLocacion: " + this.getLocacion();
    }

    @Override
    public void añadirPersonaEnCuadro(Persona persona) 
    {
        this.getListaPersonas().add(persona);
    }
    
}
