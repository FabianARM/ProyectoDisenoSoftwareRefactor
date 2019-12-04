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
public class DispositivoRefrigeradora extends Dispositivos{
    
    public DispositivoRefrigeradora(){
        this.tipoDeDispositivo = "refrigerador";
        this.estado = 0.0;
        this.hacerHielo = false;
        this.temperatura = 2.5;
    }
}    
