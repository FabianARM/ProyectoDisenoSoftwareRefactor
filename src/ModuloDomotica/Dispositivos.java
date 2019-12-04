/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloDomotica;
import java.util.ArrayList;
import java.util.*; 
/**
 *
 * @author Paola & Polina
 */

public abstract class Dispositivos {
    
    //variables generales
    protected double estado;
    protected ArrayList<Double> listaTriggers ;
    protected ArrayList<Double> listaAcciones ;
    protected String tipoDeDispositivo;   
    protected Apartamento apartamento;
    
    
    
    public void setMediator(Apartamento mediator) {
        this.apartamento = mediator;
    }    
    
/*
 * Este metodo existe para poder simular el cambio del estado de
 * los dispositivos. Para manejar los dispositivos reales no se ocupa.
 */
    
    public void setEstado(double estado){
        this.estado = estado;
        for(int i=0; i<listaTriggers.size(); i++){
            if(listaTriggers.get(i)==estado){
                apartamento.realizoActividad(this, i);
            }
        }
    }
    
    public double getEstado(){
        return estado;
    }
    
    public String getEstadoActuador(){
        String estadoActuador = "";
        if(estado==1.0){
            estadoActuador = "Escendido";
        }
        else{
            estadoActuador = "Apagado";
        }
        return estadoActuador;
    }
    
    public void addTrigger(int index, double trigger) {
        listaTriggers.add(index, trigger);
    }
    
    public void addAccion(int index, double accion){
        listaAcciones.add(index, accion);
    }

//    public double getTriggerLow() {
//        return triggerLow;
//    }
//
//    public void setTriggerHigh(double triggerHigh) {
//        this.triggerHigh = triggerHigh;
//    }
//
//    public double getTriggerHigh() {
//        return triggerHigh;
//    }
//
//    public void setAcction1(double acction1) {
//        this.acction1 = acction1;
//    }
//
//    public double getAcction1() {
//        return acction1;
//    }
//
//    public void setAcction2(double acction2) {
//        this.acction2 = acction2;
//    }
//
//    public double getAcction2() {
//        return acction2;
//    }
//    
//    public void actuarSensor(double valor){
//        if(valor == 0.0){
//            
//        }
//    }
    
    public void actuarActuador(int triggerIndex){
        estado = listaAcciones.get(triggerIndex);
    }

    
    //---Aire Acondicionado---
    protected double grados;    
    
    public void cambiarGrados(double grados) {
        this.grados = Math.round(grados * 10) / 10.0;
    }
    //---Aire Acondicionado---

    
    //---Aspiradora---
    protected int bateria;
    
    public void cambiarCargaDeBateria(int bateria) {
        this.bateria = bateria;
    }
    //---Aspiradora---
    
    
    //---EquipoDeSonido---
    protected int volumen;
    protected double estacion;
    
    public void cambiarVolumen(int volumen) {
        this.volumen = volumen;
    }    
    
    public void cambiarEstacion(double estacion) {
        this.estacion = Math.round(estacion * 10) / 10.0;
    }    
    //---Equipo de Sonido---
    
    //---Llavin---
    protected ArrayList<String> personas = new ArrayList<String>();
    
    public void agregarAutorizado(String persona){
        personas.add(persona);
    }    
    
    public void quitarAutorizado(String persona){
        personas.remove(persona);
    }   
    //---Llavin---
    
    
    //---Luz---
    protected String color;
    
    public void cambiarColor(String color) {
        this.color = color;
    }    
    //---Luz---
    
    
    //---Persianas---
    protected int apertura;
    
    public void cambiarPorcentajeDeApertura(int porcentaje) {
        this.apertura = porcentaje;
    }    
    //---Persianas---
    
    //---Refrigerador---
    protected double temperatura;
    protected boolean hacerHielo;
    ArrayList<String> listaAlimentos = new ArrayList<String>();
    
    public void cambiarTemperatura(double temperatura) {
        this.temperatura = Math.round(temperatura * 10) / 10.0;;
    }

    public void hacerHielo() {
        this.hacerHielo = true;
    }
    
    public void dejarDeHacerHielo() {
        this.hacerHielo = false;
    }

    public void agregarAlimento(String alimento) {
       this.listaAlimentos.add(alimento);
    }
    
    public void quitarAlimento(String alimento) {
       this.listaAlimentos.remove(alimento);
    }
    //---Refrigerador---
    
    //---SensorHumedad---
    protected double humedad;
    
    public void asignarHumedad(double humedad) {
        this.humedad = humedad;
    }
    //---SensorHumedad---
    
    //---SensorLuz---
    protected boolean deteccion;
    
    public void deteccionDeLuz(boolean deteccionDeLuz) {
        this.deteccion = deteccionDeLuz;
    }
    //---SensorLuz---
    
    //---SensorMovimiento---
    public void deteccionDeMovimiento(boolean deteccionDeMovimiento) {
        this.deteccion = deteccionDeMovimiento;
    } 
    //---SensorMovimiento---
    
    //---SensorRuido---
    public void deteccionDeRuido(boolean deteccionDeRuido) {
        this.deteccion = deteccionDeRuido;
    }     
    //---SensorRuido---  
    
}

