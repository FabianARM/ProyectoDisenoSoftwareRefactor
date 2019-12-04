/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloAutomotionParkingSystem;

/**
 *
 * @author Fabian y Mayquely
 */
public abstract class FabricaCampo 
{
    /**
     * 
     * @return 
     */
    public Campo crea()
    {
        Campo parqueo;
        parqueo = creaCampo(); 
        return parqueo; 
    }
    protected abstract Campo creaCampo();  
}
