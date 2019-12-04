/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloSeguridadLogAcceso;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author b66236
 */
public class Log 
{
    String ruta = "C:\\Users\\User\\Desktop\\ProyectoDisenoSoftware\\tarjetasRegistradas.txt"; 
    File tarjetasRegistradas; 
    BufferedWriter bw; 
    FileReader fr; 
    BufferedReader br; 
    
    public Log() throws IOException
    {
       
         
         
    }
    
    public void escribirLog(String mensaje) throws IOException
    {
        tarjetasRegistradas = new File(ruta); 
        bw = new BufferedWriter(new FileWriter(tarjetasRegistradas)); 
        bw.write(mensaje + "\n");
        bw.close();
    }
    
    public String getLog() throws IOException
    {
        fr = new FileReader(tarjetasRegistradas); 
        br = new BufferedReader(fr);
        String log = "";  
        String line;
        while((line = br.readLine()) != null){
            log += line;
        }
        return log; 
    }
}
