/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.util.ArrayList;

/**
 *
 * @author SOFIA ELIZONDO
 */
public class MetodosJugador {
    
    private ArrayList <Jugador> arrayJugador;
    String arregloInformacionConsultada[]=new String[2];
    
    public MetodosJugador()
    {
        arrayJugador=new ArrayList <Jugador>();
        Jugador temporal=new Jugador("Admi","0");
        arrayJugador.add(temporal);
    }
    
    
    
    public void agregarJugador(String informacion[])
    {
        Jugador temporal=new Jugador(informacion[0], informacion[1]);
        arrayJugador.add(temporal);

    }
   
    public boolean consultarJugador(String nombre)
    {
        boolean existe=false;
        
        for(int contador=0;contador<arrayJugador.size();contador++)
        {
            if(arrayJugador.get(contador).getNombre().equals(nombre))
            {
                arregloInformacionConsultada[0]=arrayJugador.get(contador).getNombre();
                arregloInformacionConsultada[1]=arrayJugador.get(contador).getPuntuacion();
                existe=true;
            }
        
        }
        return existe;  
    }
    
    
    public void ordenarJugador()
    {
        Jugador temporal=new Jugador(null, null);
        for(int contador=0;contador<arrayJugador.size()-1;contador++)
        {
            for(int conta=0;conta<arrayJugador.size()-1;conta++)
            {
                if(Integer.parseInt(arrayJugador.get(conta).getPuntuacion())<Integer.parseInt(arrayJugador.get(conta+1).getPuntuacion()))
                {System.out.println("Mejor: Ordenar "+arrayJugador.get(conta).getPuntuacion());
                System.out.println("Mejor +1: Ordenar "+arrayJugador.get(conta+1).getPuntuacion());
                    temporal= new Jugador (arrayJugador.get(conta).getNombre(),arrayJugador.get(conta).getPuntuacion());
                    arrayJugador.get(conta).setNombre(arrayJugador.get(conta+1).getNombre());
                    arrayJugador.get(conta).setPuntuacion(arrayJugador.get(conta+1).getPuntuacion());
                    arrayJugador.get(conta+1).setNombre(temporal.getNombre());
                    arrayJugador.get(conta+1).setPuntuacion(temporal.getPuntuacion());
                    
                    System.out.println("Mejor: Nuevo "+arrayJugador.get(conta).getPuntuacion());
                System.out.println("Mejor +1: Nuevo "+arrayJugador.get(conta+1).getPuntuacion());
                }
            }
        
        }
    }

    
    public boolean getPuntajeMayor(int puntuacion)
    {
        ordenarJugador();
        boolean record=false;
            System.out.println(""+puntuacion);
            
            if(arrayJugador.get(0).getNombre()!=null)
            {              
                if(Integer.parseInt(arrayJugador.get(0).getPuntuacion())<puntuacion)
                {
                    record=true;
                } 
                System.out.print("Mejor: "+arrayJugador.get(0).getPuntuacion());
            }
        
     
       return record; 
    }
    
    public String[] getArregloInformacion()
    {
        ordenarJugador();
       
                arregloInformacionConsultada[0]=arrayJugador.get(0).getNombre();
                arregloInformacionConsultada[1]=arrayJugador.get(0).getPuntuacion();
 
        
    
        return this.arregloInformacionConsultada;
    }    
    
    //Archivos
    public int getTamnio()
    {
        System.out.println(""+arrayJugador.size());
        return arrayJugador.size();  
    }
    
    
    public Jugador getObjeto(int n)
    {
        System.out.println(arrayJugador.get(n).getNombre()+"    "+arrayJugador.get(n).getPuntuacion());
        return this.arrayJugador.get(n);
    }
    
    public void llenarArray(ArrayList<Jugador> jugador)
    {
        this.arrayJugador=jugador;
    }
    
    
}
