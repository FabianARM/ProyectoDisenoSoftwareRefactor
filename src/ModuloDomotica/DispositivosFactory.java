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
public abstract class DispositivosFactory {

    public Dispositivos crea() {
        Dispositivos dispositivos = creaDispositivo();
        // dispositivos.encender();
        return dispositivos;
    }

    protected abstract Dispositivos creaDispositivo();

}
