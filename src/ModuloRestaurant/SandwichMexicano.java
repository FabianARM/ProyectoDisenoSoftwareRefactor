/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloRestaurant;

/**
 *
 * @author b66236
 */
public class SandwichMexicano implements Sandwich
{
    private final double precio = 5.0; 
    @Override
    public double getPrecio() 
    {
        return this.precio;
    }

    @Override
    public String descripcion() 
    {
        return "Hecho con pan de torta y carnitas"; 
    }
    
}
