/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloRestaurant;

import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Mayquely Salmerón & Fabian Rojas
 */
public class CajaRestaurante {
    
    private  List <Sandwich> orden ;
    private LocalDateTime fecha;
    private Double precioTotal; 
    private List <Sandwich> ordenMemento ;
    private Factura factura; 
    
    
    public CajaRestaurante()
    {
        this.orden = new ArrayList<Sandwich>(); 
        this.precioTotal = 0.0; 
        this.factura = new Factura(); 
    }
    public List<Sandwich> getOrden ()
    {
        return this.orden;
    }

    public void setFecha ()
    {
        this.fecha = LocalDateTime.now();
    }
    
    public Double calcularPrecioTotal ()
    {
        this.precioTotal= 0.0;
        for (Sandwich temp : orden) {
            precioTotal += temp.getPrecio();
        }
        return this.precioTotal;
    }    
    
    
    public void addSandwich (Sandwich newSandwich)
    {
        this.ordenMemento= this.orden;
        orden.add(newSandwich);
    }
    
    public List<Sandwich> removeSandwich ()
    {
        this.orden= this.ordenMemento;
        return this.orden;
    }
    
    public Factura facturar ()
    {
        this.setFecha();
        this.calcularPrecioTotal();
        String descripcion =" ";
        for (Sandwich temp : orden) {
            descripcion += temp.descripcion()+ "\n";
        }
        
        this.factura = new Factura();
        
        factura.setFecha(fecha);
        factura.setOrden(orden);
        factura.setPrecioTotal(precioTotal);
        factura.setDescripcion(descripcion);
        orden.clear();
        return this.factura;
   
    }
    
}
