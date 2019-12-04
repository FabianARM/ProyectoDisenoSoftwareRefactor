/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloSeguridadLogAcceso;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * Puerta del edificio...
 */
public class ControlDeAcceso 
{
    Log log;
    Calendar calendario;

    public ControlDeAcceso() throws IOException
    {
        this.calendario = new GregorianCalendar();
        this.log= new Log();
    }
    
    
    public void entrarEdificio(TarjetaDeIdentificacion tarjeta) throws IOException
    {
        int hora, minutos;
        hora =calendario.get(Calendar.HOUR_OF_DAY);
        minutos = this.calendario.get(Calendar.MINUTE);
        //segundos = this.calendario.get(Calendar.SECOND);
        String mensaje = "Entro el inquilino "+tarjeta.getId() +" "+ tarjeta.getNombre() +" del apartamento " + tarjeta.getNumeroApartamento()+ ", hora: "+ hora + ":" + minutos;
        this.log.escribirLog(mensaje);
        
    }
    
     public void salioEdificio(TarjetaDeIdentificacion tarjeta) throws IOException
    {
        int hora, minutos, segundos;
        hora =calendario.get(Calendar.HOUR_OF_DAY);
        minutos = this.calendario.get(Calendar.MINUTE);
        //segundos = this.calendario.get(Calendar.SECOND);
        String mensaje = "Salio el inquilino "+tarjeta.getId() +" "+ tarjeta.getNombre() +" del apartamento " + tarjeta.getNumeroApartamento()+ ", hora: "+ hora + ":" + minutos;
        this.log.escribirLog(mensaje);
        
    }
    
     public String getLog() throws IOException
    {
        String mylog = this.log.getLog();
        return mylog;
    }
}


