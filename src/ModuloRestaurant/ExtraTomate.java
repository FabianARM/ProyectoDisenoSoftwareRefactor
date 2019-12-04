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
public class ExtraTomate implements Sandwich
{
    private Sandwich sandwich;
    private final double precio = 0.5; 
    
    public ExtraTomate(Sandwich sandwich)
    {
        this.sandwich = sandwich; 
    }
    
    @Override
    public double getPrecio() 
    {
       return this.sandwich.getPrecio() + precio; 
    }

    @Override
    public String descripcion() 
    {
         return this.sandwich.descripcion() + ", tomate"; 
    }
    
}
