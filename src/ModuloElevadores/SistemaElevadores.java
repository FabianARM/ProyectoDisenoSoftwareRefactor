/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloElevadores;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static proyectodiseno.ModuloElevadores.Direccion.ABAJO;
import static proyectodiseno.ModuloElevadores.Direccion.ARRIBA;

/**
 *
 * @author Mayquely & Fabian
 */
public class SistemaElevadores {
    
    private List<Elevador> elevadoresEdificio;
    private int numPisos;
    private int duracionPromedioPisos;
    private int duracionPromedioSalida;

    public SistemaElevadores(int numElevadores, int numPisos, int duracionPromedioPisos, int duracionPromedioSalida) {
        this.elevadoresEdificio = new ArrayList(numElevadores);
        for(int i=0; i < numElevadores; ++i)
        {
            this.elevadoresEdificio.add(new Elevador(i));
        }
        this.numPisos = numPisos;
        this.duracionPromedioPisos = duracionPromedioPisos;
        this.duracionPromedioSalida = duracionPromedioSalida;
    }

    public List<Elevador> getElevadoresEdificio() 
    {
        return elevadoresEdificio;
    }

    public int getNumPisos() 
    {
        return numPisos;
    }

    public int ProcesarPeticion(int pisoDestino, int pisoOrigen) throws ExcepcionesElevadores
    {
        Direccion direccionPeticion;
        int elevadorAsignado = 0;
        int tiempoLlegada; //Tiempo estimado de llegada
        int tiempoTardia; //Tiempo estimado de tardia (salida de personas del elevador)
        int costoTotal;
        int costoMinimo = -1;
        
         if (pisoDestino == pisoOrigen)
         {
            throw new ExcepcionesElevadores("No puede pedir un elevador al mismo piso");
         }
         
         if (pisoDestino > this.numPisos)
         {
             throw new ExcepcionesElevadores("No Existe ese piso");
         }
         
         if (pisoDestino < 0)
         {
             throw new ExcepcionesElevadores("No Existe ese piso");
         }
         
        if (pisoOrigen < pisoDestino)
        {
            direccionPeticion = ARRIBA;
        }
        else
        {
            direccionPeticion= ABAJO;
        }
        //Usamos un iterator ya hecho de Java 
         Iterator<Elevador> iterator = this.elevadoresEdificio.iterator(); 
         Elevador elevadorActual; 
        //Recorrer lista de ascensores y para cada ascensor hacer:
        while (iterator.hasNext()) 
        {
            elevadorActual = iterator.next();
            if (elevadorActual.hayCampo())
            {
                tiempoLlegada = calcularTiempoLlegada(elevadorActual, pisoDestino, direccionPeticion);
                tiempoTardia = calcularTiemposSalidas(elevadorActual,pisoDestino, direccionPeticion);
                costoTotal = tiempoLlegada + tiempoTardia;
                if (costoMinimo < 0)
                {
                    elevadorAsignado = elevadorActual.getElevadorID();
                    costoMinimo = costoTotal;
                }else
                {
                    if (costoTotal< costoMinimo)
                    {
                        elevadorAsignado = elevadorActual.getElevadorID();
                        costoMinimo = costoTotal;
                    }
                }
            }
       } // fin while iterator has next
        
        //Preguntar si tiene campo
       //ETD =  llamar a calcular tiempo llegada (Parametro Elevador)
        //TET = llamar calcular Tiempo Salidas
        //costo total = edt+ TET;
        //reviso el costo total y si es menor al costominimo actual(o cma =- 1) lo cambio 
        // y asigno el id del elevador en el que estoy en la lista como elevador asignado
        //Sigo recorriendo la lista (sino he terminado)
        //Return elevadorAsignado;
        //Y retirarle esa persona a los cupos disponibles 
        return elevadorAsignado; //CAMBIAR ESTO 
    }
    
    private int calcularTiempoLlegada(Elevador elevador, int pisoDestino, Direccion dirPeticion)
    {
       
        int pisoElevador = elevador.getPisoActual();
        int tiempoLlegada = 0;
        while(pisoElevador != pisoDestino)
        {
            tiempoLlegada += this.duracionPromedioPisos;
            if (dirPeticion == ABAJO)
            {
                pisoElevador -= 1;
            }else
            {
                pisoElevador += 1;
            }
        }
        //RECORDAR IR IMPRIMINEDO CADA UNO DE LOS PASOS DE ESTA LOGICA 
         //while no haya llegado al piso destino
        // if subiendo +1 al piso actual (ETD más cantidad de tiempo promedio)
        // if bajando -1 al piso actual  (ETD más cantidad de tiempo promedio)
        // validar los limites de los pisos y si llega a un limite cambiar de dirección para los if de arriba 
        //NOTA: validar los limites en los if de arriba 
        //Si sale del while (llego al piso destino)
        // return el costo ETD
        return tiempoLlegada;
    }
    
    private int calcularTiemposSalidas(Elevador elevador, int pisoDestino,Direccion dirPeticion)
    {
        int tiempoTardia = 0;
        Iterator<Integer> iterator = elevador.getPisosEnCola().iterator(); 
        while(iterator.hasNext())
        {
            if(dirPeticion == ABAJO)
            {
                if(iterator.next() > pisoDestino)
                {
                    tiempoTardia += this.duracionPromedioSalida;
                }
            }else
            {
                if(iterator.next() < pisoDestino)
                {
                    tiempoTardia += this.duracionPromedioSalida;
                }      
            }
        }
        //RECORDAR IR IMPRIMINEDO CADA UNO DE LOS PASOS DE ESTA LOGICA 
        //Recorrer el array de pisos en los que tengo que dejar gente
        //Tomar en cuenta la direccion:
        //Si es para abajo tomar en cuenta todos los pisos de arriba
        //Si es para arriba todos los pisos antes del destino
        //Por cada uno le sumo el tiempo de bajada de personas
        //Return el total :D 
        return tiempoTardia;
    }
    
    
}
