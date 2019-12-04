/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloDomotica;

/**
 *
 * @author pao__
 */
public class DispositivoSensorMovimientoFactory extends DispositivosFactory {
    
    protected Dispositivos creaDispositivo(){
        return new DispositivoSensorMovimiento();
    }
}    
