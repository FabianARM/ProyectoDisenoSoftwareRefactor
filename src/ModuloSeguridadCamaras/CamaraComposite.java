/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloSeguridadCamaras;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Fabián
 */
public class CamaraComposite implements Camara
{
    //private static int Id = 0; 
    List<Camara> listaDeCamaras; 
    public CamaraComposite()
    {
        listaDeCamaras = new ArrayList<>(); 
        //this.Id = ++Id; 
    }
    
    @Override
    public int getID() 
    {
        return 0; //ESTE METODO NO SE IMPLEMENTA.
    }

    @Override
    public boolean reconocer(String numeroDeCedula) 
    {
        return false; //ESTE METODO NO SE IMPLEMENTA.
    }

    @Override
    public Locacion getLocacion()
    {
        return null;  //ESTE METODO NO SE IMPLEMENTA.
    }

    @Override
    public Orientacion getOrientacion()
    {
        return null; //ESTE METODO NO SE IMPLEMENTA.
    }

    @Override
    public void setOrientacion(Orientacion orientacion) 
    {
        for(Camara iter : listaDeCamaras)
        {
            iter.setOrientacion(orientacion); 
        }
    }

    @Override
    public void addCamara(Camara camara) 
    {
        listaDeCamaras.add(camara); 
    }

    @Override
    public void removeCamara(int indice) 
    {
        Iterator<Camara> iter = listaDeCamaras.iterator(); 
        while(iter.hasNext())
        {
            Camara camara = iter.next(); 
            if(camara.getID() == indice)
            {
                listaDeCamaras.remove(iter);
                break; 
            }
        }
    }

    @Override
    public Camara getCamara(int id) 
    {
        for(Camara iter : listaDeCamaras)
        {
            if(iter.getID() == id)
            {
                return iter;
            }
        }
        return null;
    }

    @Override
    public List<Persona> getListaPersonas()
    {
        return null; //ESTE METODO NO SE IMPLEMENTA.
    }

    @Override
    public String obtenerEstadoDeCamara() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void añadirPersonaEnCuadro(Persona persona) 
    {
        //Este metodo no se debe implementar. 
    }
    
}
