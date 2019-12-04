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
 * @author Polina & Paola
 */
public class Apartamento {
 /*
 * Declaracion de las instancias de los componentes del apartamento
 */
    private Dispositivos aireAcondicionado;
    private Dispositivos aspiradora;
    private Dispositivos cocina;
    private Dispositivos equipoDeSonido;
    private Dispositivos extractorDeGrasa;
    private Dispositivos llavin;
    private Dispositivos luz;
    private Dispositivos persianas;
    private Dispositivos refrigerador;
    private Dispositivos sensorHumedad;
    private Dispositivos sensorLuz;
    private Dispositivos sensorMovimiento;
    private Dispositivos sensorRuido;
    private Dispositivos sensorTemperatura;
    private Dispositivos televisor;
    
    private String propietario;
    
    //Comportamiento
    //Hashtable<Dispositivos, Dispositivos> comportamientos = new Hashtable<Dispositivos, Dispositivos>(); 
    ArrayList<ArrayList<Dispositivos> > comportamientos ;
    //ArrayList<ArrayList<Double> > acciones =  new ArrayList<ArrayList<Double>>(); 
    
    ArrayList<Dispositivos> listaDispositivos ;
    
    
    public Apartamento(String nombre){
        propietario = nombre;
    }
    
    
    public ArrayList<Dispositivos> getListaDispositivos(){
        return this.listaDispositivos;
    }
    
    public void addComportamiento(Dispositivos master, Dispositivos slave){
        if(comportamientos.contains(master)){
            int index = comportamientos.indexOf(master);
            comportamientos.get(index).add(slave);
        }
        else{
            ArrayList<Dispositivos> comportamientosSublist = new ArrayList<Dispositivos>();
            comportamientosSublist.add(master);
            comportamientosSublist.add(slave);
            comportamientos.add(comportamientosSublist);
        }
    }
    
    public void realizoActividad(Dispositivos dispositivo, int trigger){
        if(comportamientos.contains(dispositivo)){
            int index = comportamientos.indexOf(dispositivo);
            for(int i= 0; i<comportamientos.get(index).size(); i++){
                comportamientos.get(index).get(i).actuarActuador(trigger);
            }
        }
    }
    
//    public void agregarComportamiento(Dispositivos DispositivoEncendido, Dispositivos DispositivoQueSeApaga){
//        comportamientos.put(DispositivoEncendido, DispositivoQueSeApaga);
//    }
    
    public static class Builder {

        private Apartamento apartamento;

        public Builder(String nombre) {
            apartamento = new Apartamento(nombre);

            ArrayList<Dispositivos> listaDispositivos = new ArrayList<Dispositivos>();
            ArrayList<ArrayList<Dispositivos> > comportamientos =  new ArrayList<ArrayList<Dispositivos>>();
        }

        public Builder addAireAconcionado(Dispositivos aireAcondicionado) {
            //DispositivosFactory factory = new DispositivoAireAcondicionadoFactory();
            //Dispositivos aireAcondicionado = factory.crea();
            apartamento.listaDispositivos.add(aireAcondicionado);
            return this;
        }

        public Builder addAspiradora(Dispositivos aspiradora) {
            //DispositivosFactory factory = new DispositivoAspiradoraFactory();
            //Dispositivos aspiradora = factory.crea();
            apartamento.listaDispositivos.add(aspiradora);
            return this;
        }

        public Builder addCocina(Dispositivos cocina) {
            //DispositivosFactory factory = new DispositivoCocinaFactory();
           // Dispositivos cocina = factory.crea();
            apartamento.listaDispositivos.add(cocina);
            return this;
        }

        public Builder addEquipoDeSonido(Dispositivos equipoDeSonido) {
            //DispositivosFactory factory = new DispositivoEquipoDeSonidoFactory();
            //Dispositivos equipoDeSonido = factory.crea();
            apartamento.listaDispositivos.add(equipoDeSonido);
            return this;
        }

        public Builder addExtractorDeGrasa(Dispositivos extractorDeGrasa) {
            //DispositivosFactory factory = new DispositivoExtractorDeGrasaFactory();
           // Dispositivos extractorDeGrasa = factory.crea();
            apartamento.listaDispositivos.add(extractorDeGrasa);
            return this;
        }

        public Builder addLlavin(Dispositivos llavin) {
            //DispositivosFactory factory = new DispositivoLlavinFactory();
            //Dispositivos llavin = factory.crea();
            apartamento.listaDispositivos.add(llavin);
            return this;
        }

        public Builder addLuz(Dispositivos luz) {
            //DispositivosFactory factory = new DispositivoLuzFactory();
           // Dispositivos luz = factory.crea();
            apartamento.listaDispositivos.add(luz);
            return this;
        }

        public Builder addPersianas(Dispositivos persianas) {
           // DispositivosFactory factory = new DispositivoPersianasFactory();
           // Dispositivos persianas = factory.crea();
            apartamento.listaDispositivos.add(persianas);
            return this;
        }

        public Builder addRefrigerador(Dispositivos refrigerador) {
            //DispositivosFactory factory = new DispositivoRefrigeradoraFactory();
            //Dispositivos refrigerador = factory.crea();
            apartamento.listaDispositivos.add(refrigerador);
            return this;
        }
        
        public Builder addSensorHumedad(Dispositivos sensorHumedad) {
            //DispositivosFactory factory = new DispositivoSensorHumedadFactory();
            //Dispositivos sensorHumedad = factory.crea();
            apartamento.listaDispositivos.add(sensorHumedad);
            return this;
        }

        public Builder SensorLuz(Dispositivos sensorLuz) {
            //DispositivosFactory factory = new DispositivoSensorLuzFactory();
           // Dispositivos sensorLuz = factory.crea();
            apartamento.listaDispositivos.add(sensorLuz);
            return this;
        }

        public Builder addSensorMovimiento(Dispositivos sensorMovimiento) {
            //DispositivosFactory factory = new DispositivoSensorMovimientoFactory();
           // Dispositivos sensorMovimiento = factory.crea();
            apartamento.listaDispositivos.add(sensorMovimiento);
            return this;
        }

        public Builder addSensorRuido(Dispositivos sensorRuido) {
            //DispositivosFactory factory = new DispositivoSensorRuidoFactory();
           // Dispositivos sensorRuido = factory.crea();
            apartamento.listaDispositivos.add(sensorRuido);
            return this;
        }

        public Builder addSensorTemperatura(Dispositivos sensorTemperatura) {
           // DispositivosFactory factory = new DispositivoSensorTemperaturaFactory();
           // Dispositivos sensorTemperatura = factory.crea();
            apartamento.listaDispositivos.add(sensorTemperatura);
            return this;
        }

        public Builder addTelevisor(Dispositivos televisor) {
            //DispositivosFactory factory = new DispositivoTelevisorFactory();
            //Dispositivos televisor = factory.crea();
            apartamento.listaDispositivos.add(televisor);
            return this;
        }

        public Apartamento build() {
            return apartamento;
        }

    }
}
