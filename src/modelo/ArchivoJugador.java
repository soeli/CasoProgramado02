/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author SOFIA ELIZONDO
 */
public class ArchivoJugador {
    
    ObjectOutputStream archivoSalidaJugador;
    ObjectInputStream archivoEntradaJugador;
    
    public ArchivoJugador()
    {
        
    }
    
   public boolean cargarArchivoJugador()
    {
        boolean existe=false;
        try
        {
            archivoEntradaJugador= new ObjectInputStream(new FileInputStream ("archivoJugador.dat"));
            existe=true;
        }
        catch(Exception e)
        {
            System.out.println("Error al cargar el archivo  de Jugador"+e);
        }    
        return existe;
    }
    public void crearArchivoJugador()
    {
        try
        {
            archivoSalidaJugador= new ObjectOutputStream(new FileOutputStream("archivoJugador.dat"));
            System.out.println("Se creo el archivo  de Jugador de forma correcta");
        }
        catch(Exception e)
        {
            System.out.println("Error al crear archivo  de Jugador");
        }   
    }
    

    public void ingresarInformacionArchivoJugador(Jugador jugador)
    {
        try
        {
            System.out.println("Archivos"+jugador.getNombre()+"  "+jugador.getPuntuacion());
            
            archivoSalidaJugador.writeObject(jugador);
            System.out.println("Se escribió la informacion  de estudiantes de forma correcta");
        }
        catch(Exception e)
        {
            System.out.println("Error al ingresar informacion al archivo  de estudiantes"+e);
        }      
    }
    
    public ArrayList<Jugador> devolverInfromacionDelArchivoJugador()
    {
        ArrayList <Jugador> arrayJugador=new ArrayList<Jugador>();
        
        try
        {
          while(true)
          {
              arrayJugador.add((Jugador)archivoEntradaJugador.readObject());
          }
        }
        catch(Exception e)
        {
            System.out.println("Se llego al final del archivo  de Jugador"+e);
        } 
        return arrayJugador;
    }
    
    
    
}
