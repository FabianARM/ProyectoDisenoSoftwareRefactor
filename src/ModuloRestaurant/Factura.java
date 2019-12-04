/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloRestaurant;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Mayquely Salmerón & Fabian Rojas
 */
public class Factura {
    
    private  List <Sandwich> orden ;
    private LocalDateTime fecha;
    private Double precioTotal; 
    private String descripcion ;

    public List<Sandwich> getOrden() {
        return orden;
    }

    public void setOrden(List<Sandwich> orden) {
        this.orden = orden;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
