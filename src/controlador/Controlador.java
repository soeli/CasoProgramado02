/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ArchivoJugador;
import modelo.Hilo;
import modelo.HiloFondo;
import modelo.MetodosJugador;
import vista.MenuInicio;
import vista.VentanaPrincipal;

/**
 *
 * @author SOFIA ELIZONDO
 */
public class Controlador implements ActionListener{

    VentanaPrincipal ventanaPrincipal;
    Hilo hilo;
    HiloFondo hiloFondo;
    MenuInicio menu;
    ArchivoJugador archivo;
    MetodosJugador metodos;
    public Controlador(MenuInicio menu)
    {
        this.menu=menu;  
        menu.setVisible(true);
        archivo=new ArchivoJugador();
        metodos= new MetodosJugador();
              
        if(this.archivo.cargarArchivoJugador())
        {
            metodos.llenarArray(archivo.devolverInfromacionDelArchivoJugador());
            
        }
        else
        {
            
        }
    }
    public void actionPerformed(ActionEvent e) {
       
        if(e.getActionCommand().equals("Jugar"))
        {
            System.out.println("Jugar");
            ventanaPrincipal=new VentanaPrincipal(this); 
            hilo=new Hilo(ventanaPrincipal);
            hiloFondo=new HiloFondo(ventanaPrincipal);
            ventanaPrincipal.setVisible(true);
            menu.setVisible(false);
            menu.detenerMusica();
            hilo.start();
            hiloFondo.start();
        }
        if(e.getActionCommand().equals("Instrucciones"))
        {
            menu.setVisibleTrue();
            System.out.println("Instrucciones");
        }
        if(e.getActionCommand().equals("Record"))
        {
            ventanaPrincipal.setMejoresPuntuaciones(metodos.getArregloInformacion());
            ventanaPrincipal.setVisiblePuntuaciones();
            System.out.println("Record");
        }
        if(e.getActionCommand().equals("VolverJugar"))
        {
            ingresarInfo();
            hilo.suspend();
            hiloFondo.suspend();
            ventanaPrincipal.detenerMusica();
            ventanaPrincipal=new VentanaPrincipal(this); 
            hilo=new Hilo(ventanaPrincipal);
            hiloFondo=new HiloFondo(ventanaPrincipal);
            ventanaPrincipal.setVisible(true);
            hilo.start();
            hiloFondo.start();
            System.out.println("VolverJugar");
        }
        if(e.getActionCommand().equals("Home"))
        {
            hilo.suspend();
            hiloFondo.suspend();
            menu.setVisible(true);
            ventanaPrincipal.detenerMusica();
            ventanaPrincipal.setVisible(false);
            System.out.println("Home");
        }
        
        if(e.getActionCommand().equals("Aceptar"))
        {
            metodos.agregarJugador(ventanaPrincipal.enviarInformacion());
            ingresarInfo();
            ventanaPrincipal.resetearPanel();
            System.out.println("Aceptar");
        }
        
        if(e.getActionCommand().equals("Vamos"))
        {
            System.out.println("Vamos");
            menu.setVisibleFalse();
        }
        
        if(e.getActionCommand().equals("ok"))
        {
            System.out.println("pl");
            ventanaPrincipal.setFalsePuntuaciones();
        }
        
        if(e.getActionCommand().equals("Salir"))
        {
            System.out.println("Salir");
             System.exit(0);
        }        
    }
    
    
    public boolean finDelJuego(int puntuacion)
    {
        System.out.println("controlador");
        boolean record=false;
        metodos.ordenarJugador();
        System.out.println("primerMetodo");
        if(metodos.getPuntajeMayor(puntuacion))
        {
            System.out.println("mayor");
            record=true;
        }
        else
        {
            System.out.println("menor");
            record=false;
        }
        System.out.println("4");
        return record;
    }
    
    public void ingresarInfo()
    {
        archivo.crearArchivoJugador();
        for(int contador=0;contador<this.metodos.getTamnio();contador++)
        {
            this.archivo.ingresarInformacionArchivoJugador(this.metodos.getObjeto(contador));
        }
    }
    
}
