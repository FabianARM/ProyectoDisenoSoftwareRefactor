/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloSeguridadCamaras;

/**
 *
 * @author Fabián
 */
public class Persona 
{
    private String cedula; 

    public Persona(String cedula)
    {
         this.cedula = cedula; 
    }
    
    public String getCedula()
    {
        return cedula;
    }

    public void setCedula(String cedula) 
    {
        this.cedula = cedula;
    }
    
}
