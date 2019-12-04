/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloSeguridadLogAcceso;

/**
 *
 * @author b66236
 */
public class TarjetaDeIdentificacion 
{
    private String id;
    private String nombre; 
    private String numeroApartamento; 

    public TarjetaDeIdentificacion(String id, String nombre, String numeroApartamento) 
    {
        this.id = id;
        this.nombre = nombre;
        this.numeroApartamento = numeroApartamento;
    }
    
    
    public String getId() 
    {
        return id;
    }

    public String getNombre()
    {
        return nombre;
    }

    public String getNumeroApartamento() 
    {
        return numeroApartamento;
    }
    
}
