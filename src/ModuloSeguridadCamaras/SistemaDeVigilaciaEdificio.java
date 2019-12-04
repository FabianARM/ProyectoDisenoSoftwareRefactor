/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloSeguridadCamaras;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Fabián
 */
public class SistemaDeVigilaciaEdificio 
{
    List<Camara> listaDeCamarasEdifio; 
    HashMap<String, CamaraComposite> listaDeConjuntosDeCamaras; 
    
    public SistemaDeVigilaciaEdificio()
    {
        listaDeCamarasEdifio = new ArrayList<>(); 
        listaDeConjuntosDeCamaras = new HashMap<>(); 
    }
    public SistemaDeVigilaciaEdificio(List<Camara> listaDeCamaras)
    {
        listaDeCamarasEdifio = listaDeCamaras; 
        listaDeConjuntosDeCamaras = new HashMap<>(); 
    }
    /**
     * 
     * @return 
     */
    public String getEstadoDeCamaras()
    {
       String estados = "";  
        for(Camara iter : this.listaDeCamarasEdifio)
        {
            estados += iter.obtenerEstadoDeCamara() + "\n"; 
        }
        return estados; 
    }
    /**
     * 
     * @param cedula
     * @return 
     */
    public String ubicarInquilino(String cedula)
    {
        String informacionDeLaCamara = ""; 
        String inquilinoNoEncontrado = "El inquilino que se desea encontrar no esta dentro de las instalaciones."; 
        for(Camara iter : listaDeCamarasEdifio)
        {
            if(iter.reconocer(cedula))
            {
                informacionDeLaCamara = "La camara " + iter.getID() + " en la ubicación " + iter.getLocacion() + " reconocio al inquilino con numero de cedula " + cedula + "\n";
                return informacionDeLaCamara; 
            }
        }
        return inquilinoNoEncontrado; 
    }

    /**
     * 
     * @param nombreDeConjunto 
     */
    public void añadirConjuntoDeCamaras(String nombreDeConjunto) 
    {
        listaDeConjuntosDeCamaras.put(nombreDeConjunto, new CamaraComposite());

    }

    /**
     * 
     * @param nombreDelConjunto
     * @return 
     */
    public boolean borrarConjuntoDeCamaras(String nombreDelConjunto) 
    {
        return listaDeConjuntosDeCamaras.remove(nombreDelConjunto) != null; 
    }
    /**
     * 
     * @param camara 
     */
    public void añadirCamaras(Camara camara) 
    {
        listaDeCamarasEdifio.add(camara); 
    }
    /**
     * 
     * @param id
     * @return 
     */
    private Camara encontrarCamara(int id)
    {
        for(Camara iter : listaDeCamarasEdifio)
        {
            if(iter.getID() == id)
            {
                return iter; 
            }
        }
        return null; 
    }
    /**
     * 
     * @param nombreDelConjunto
     * @param idCamara 
     */
    public void añadirCamarasAUnConjunto(String nombreDelConjunto, int idCamara) 
    {
        if(listaDeConjuntosDeCamaras.get(nombreDelConjunto) == null)
        {
            listaDeConjuntosDeCamaras.put(nombreDelConjunto, new CamaraComposite());
        }
        else
        {
            listaDeConjuntosDeCamaras.get(nombreDelConjunto).addCamara(this.encontrarCamara(idCamara)); 
        }
    }
    
    public void cambiarOrientacionCamara(Orientacion orientacion, int idCamara)
    {
        this.encontrarCamara(idCamara).setOrientacion(orientacion);
    }
    
    public void cambiarOrientacionConjunto(String nombreConjunto, Orientacion orientacion)
    {
        this.listaDeConjuntosDeCamaras.get(nombreConjunto).setOrientacion(orientacion);
    }
}
