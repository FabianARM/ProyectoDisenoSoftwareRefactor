
package ModuloAutomotionParkingSystem;

/**
 *
 * @author Fabian y Mayquely. 
 */
public abstract class Campo 
{
    protected boolean ocupado;
    protected tipoDeCarro tipo;
    protected Vehiculo vehiculo;
    public Campo()
    {
        this.ocupado = true; 
    }
    public Campo(tipoDeCarro tipo)
    {
        this.tipo = tipo; 
        ocupado = false; 
    }
    public void setVehiculo(Vehiculo vehiculo)
    {
        this.vehiculo = vehiculo; 
    }
    public void setOcupado(boolean ocupado)
    {
        this.ocupado = ocupado; 
    }
    public boolean sePuedeParquear(Vehiculo vehiculo)
    {
        return !this.ocupado && this.tipo.equals(vehiculo.tipo); 
    }        
}

