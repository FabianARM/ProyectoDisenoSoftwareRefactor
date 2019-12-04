/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloElevadores;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mayquely & Fabian
 */
enum Direccion {ARRIBA, ABAJO}
public class Elevador {
    
   private int elevadorID;
   private int pisoActual;
   private List<Integer> pisosEnCola; 
   private Direccion direccion;
   private int camposDisponibles;
   
    public Elevador(int elevadorID) 
    {
        this.elevadorID = elevadorID;
        this.pisosEnCola = new ArrayList();
        this.camposDisponibles =10;
    }
    
    public int getPisoActual() 
    {
        return pisoActual;
    }

    public void setPisoActual(int pisoActual) 
    {
        this.pisoActual = pisoActual;
    }
    
    public int getElevadorID() {
        return elevadorID;
    }


    public List<Integer> getPisosEnCola() {
        return pisosEnCola;
    }
    
     public boolean hayCampo() {
       return this.camposDisponibles> 0;
    }
     
    public void addPersonaEnElevador()
    {
        this.camposDisponibles-=1; 
    }
    
    public void addPisosEnCola(int newPiso) {
        this.pisosEnCola.add(newPiso);
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}
