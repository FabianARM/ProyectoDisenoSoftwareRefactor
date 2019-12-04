/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloAutomotionParkingSystem;

/**
 *
 * @author b66236
 */
public class FabricaDeCampoPesado extends FabricaCampo{

    @Override
    protected Campo creaCampo() 
    {
        return new CampoVehiculoPesado(); 
    }
    
}
