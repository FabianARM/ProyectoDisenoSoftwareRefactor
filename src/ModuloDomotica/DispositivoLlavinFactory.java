/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloDomotica;

/**
 *
 * @author Paola & Polina
 */
public class DispositivoLlavinFactory extends DispositivosFactory {
    
    protected Dispositivos creaDispositivo(){
        return new DispositivoLlavin();
    }
}    

