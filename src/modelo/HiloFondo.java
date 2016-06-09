/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import static java.lang.Thread.sleep;
import vista.VentanaPrincipal;

/**
 *
 * @author SOFIA ELIZONDO
 */
public class HiloFondo extends Thread {
    
     VentanaPrincipal sandia;
    public HiloFondo(VentanaPrincipal sandia)
            
    {
       this.sandia=sandia; 
       
    }
    
    public void run()
    {
        try{
            while(true)
            {
                sleep(9);
                sandia.moverFondo(); 
            }
        }
        catch(Exception e)
        {
            System.out.println("Error en la ejecución Fondo: "+e);
        }
    }
    
}
