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
public class ParqueoInteligente 
{
    private Campo[][] parqueo;
    private int cantidadDeCamposFilas = 0;
    private int cantidadDeCamposColumnas = 0;
    
    private ParqueoInteligente()
    {
        
    }
    
    public void setCantidadDeCamposFilas(int cantidadDeCamposFilas) 
    {
        this.cantidadDeCamposFilas = cantidadDeCamposFilas;
    }

    public void setCantidadDeCamposColumnas(int cantidadDeCamposColumnas) 
    {
        this.cantidadDeCamposColumnas = cantidadDeCamposColumnas;
    }

    public int getCantidadDeCamposFilas() 
    {
        return cantidadDeCamposFilas;
    }

    public int getCantidadDeCamposColumnas() 
    {
        return cantidadDeCamposColumnas;
    }
    
    public int obtenerTamanio()
    {
        return this.getCantidadDeCamposFilas() * this.getCantidadDeCamposColumnas(); 
    }
    
    /**
     * Metodo que permite buscarle un lugar a un vehiculo y parquearlo. 
     * @param vehiculo objeto vehiculo que se desea parquear. 
     * @return  
     */
    public boolean parquear(Vehiculo vehiculo)
    {
        for(int indiceFilas = 0; indiceFilas < this.cantidadDeCamposFilas; indiceFilas++)
        {
            
            for(int indiceColumnas = 0; indiceColumnas < this.cantidadDeCamposColumnas; indiceColumnas++)
            {
                if(parqueo[indiceFilas][indiceColumnas].sePuedeParquear(vehiculo))
                {
                    parqueo[indiceFilas][indiceColumnas].setOcupado(true);
                    parqueo[indiceFilas][indiceColumnas].setVehiculo(vehiculo);
                    return true; 
                }
            }
        }
        return false; 
    }
    /**
     * 
     */
    public void imprimirParqueo( )
    {
        for(int filas = 0; filas < this.getCantidadDeCamposFilas(); filas++)
        {
            for(int columnas = 0; columnas < this.getCantidadDeCamposColumnas(); columnas++)
            {
                if(this.parqueo[filas][columnas].ocupado)
                {
                    System.out.print("   X,  ");
                }
                else 
                {
                    System.out.print(this.parqueo[filas][columnas].tipo + ", ");
                }
            }
            System.out.println("\n");
        }
        System.out.println("\n");
    }
    
    //------------------------------------------------------------------------------------------------Builders----------------------------------------------------------------------------------------------------------
    /**
     * Este builder se creo con fines de que la inicializacion de los parqueos sea más sencilla para los testers. 
     */
    public static class BuilderParqueoInteligente
    {
        private ParqueoInteligente parqueoInteligente; 
        /**
         * 
         */
        public BuilderParqueoInteligente()
        {
            parqueoInteligente = new ParqueoInteligente(); 
        }
        /**
         * 
         * @param altura
         * @return 
         */
        public BuilderParqueoInteligente establecerAltura(int altura)
        {
            parqueoInteligente.setCantidadDeCamposFilas(altura); 
            return this;
        }
        /**
         * 
         * @param ancho
         * @return 
         */
        public BuilderParqueoInteligente establecerAncho(int ancho)
        {
            parqueoInteligente.setCantidadDeCamposColumnas(ancho);
            return this; 
        }
        /**
         * 
         * @return 
         */
        public BuilderParqueoInteligenteConstruido construirParqueo()
        {
            parqueoInteligente.parqueo = new Campo[parqueoInteligente.cantidadDeCamposFilas][parqueoInteligente.cantidadDeCamposFilas];
            for(int filas = 0; filas < parqueoInteligente.cantidadDeCamposFilas; filas++)
            {
                for(int columnas = 0; columnas < parqueoInteligente.cantidadDeCamposColumnas; columnas++)
                {
                    parqueoInteligente.parqueo[filas][columnas] = new Campo(){ };
                }
            }
            return new BuilderParqueoInteligenteConstruido(this.parqueoInteligente); 
        }
    }
    
    public static class BuilderParqueoInteligenteConstruido
    {
        private int camposConstruidos = 0; 
        private int ultimaFilaVisitada = 0;
        private int ultimaColumnaVisitada = 0; 
        ParqueoInteligente parqueoInteligente;
        
        public BuilderParqueoInteligenteConstruido(ParqueoInteligente parqueoInteligente)
        {
            this.parqueoInteligente = parqueoInteligente; 
        }
        /**
         * Metodo que crea campos de un tipo definido para el parqueo. 
         * @param fabricaCampo fabrica de campos de un tipo x.
         * @param cantidad la cantidad de campos x que deseamos en el parqueo.
         * @return 
         */
        public BuilderParqueoInteligenteConstruido contruirCampos(FabricaCampo fabricaCampo, int cantidad)
        {
            int camposConstruidosActuales = 0; 
            for(int filas = ultimaFilaVisitada; filas < this.parqueoInteligente.parqueo.length; filas++)
            {
                for(int columnas = ultimaColumnaVisitada; columnas < this.parqueoInteligente.getCantidadDeCamposColumnas(); columnas++)
                {
                    if(camposConstruidos + camposConstruidosActuales < parqueoInteligente.obtenerTamanio() && camposConstruidosActuales < cantidad)
                    {
                        this.parqueoInteligente.parqueo[filas][columnas] = fabricaCampo.crea(); 
                        camposConstruidosActuales++; 
                    }
                    else
                    {
                        ultimaFilaVisitada = filas; 
                        ultimaColumnaVisitada = columnas; 
                        camposConstruidos += camposConstruidosActuales; 
                        filas = this.parqueoInteligente.getCantidadDeCamposFilas() + 1;
                        break; 
                    }
                }
            }
            return this;
        }
        public ParqueoInteligente build()
        {
            return this.parqueoInteligente;
        }
    }
}

