/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import controlador.Controlador;
import java.applet.AudioClip;
import javax.swing.ImageIcon;
import modelo.Hilo;

/**
 *
 * @author SOFIA ELIZONDO
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    
    Hilo hilo;
    Controlador controlador;
    String estado="";
    ImageIcon fondo = new ImageIcon(getClass().getResource("/imagenes/Fondo.png"));
    ImageIcon fondoDia = new ImageIcon(getClass().getResource("/imagenes/FondoDia.png"));
    ImageIcon fondoDiaNoche = new ImageIcon(getClass().getResource("/imagenes/FondoDiaNoche.png"));
    ImageIcon fondoNoche = new ImageIcon(getClass().getResource("/imagenes/FondoNoche.png"));
    ImageIcon fondoNocheEspacio = new ImageIcon(getClass().getResource("/imagenes/FondoNocheEspacio.png"));
    ImageIcon fondoEspacioLuna = new ImageIcon(getClass().getResource("/imagenes/FondoEspacioLuna.png"));
    ImageIcon fondoEspacio = new ImageIcon(getClass().getResource("/imagenes/FondoEspacio.png"));
    
    ImageIcon globoImagenDerecha = new ImageIcon(getClass().getResource("/imagenes/derecha.gif"));
    ImageIcon globoImagenIzquierda = new ImageIcon(getClass().getResource("/imagenes/IzquierdaBien.gif"));
    ImageIcon globoCentro = new ImageIcon(getClass().getResource("/imagenes/gifglobo.gif"));
    
    ImageIcon astronauta = new ImageIcon(getClass().getResource("/imagenes/astronauta.png"));
    ImageIcon satelite = new ImageIcon(getClass().getResource("/imagenes/satelite.png"));
    ImageIcon cohete = new ImageIcon(getClass().getResource("/imagenes/cohete.png"));
    ImageIcon planeta = new ImageIcon(getClass().getResource("/imagenes/planeta.png"));
    
    
    
    ImageIcon tresVidas = new ImageIcon(getClass().getResource("/imagenes/tresVidas.png"));
    ImageIcon dosVidas = new ImageIcon(getClass().getResource("/imagenes/dosVidas.png"));
    ImageIcon unaVida = new ImageIcon(getClass().getResource("/imagenes/unaVida.png"));
    ImageIcon ceroVidas = new ImageIcon(getClass().getResource("/imagenes/ceroVidas.png"));
    
    
    AudioClip sonidoIni=java.applet.Applet.newAudioClip(getClass().getResource("/audios/LightCaves.wav"));
    AudioClip sonidoVida=java.applet.Applet.newAudioClip(getClass().getResource("/audios/MirrorShattering.wav"));
    AudioClip sonidoGato=java.applet.Applet.newAudioClip(getClass().getResource("/audios/shooting_star.wav"));


    
    int distanciaObstaculos=0;
    int movimiento=0;
    int cambioFondo=0;
    boolean movimientoDerecha=false;
    boolean movimientoIzquiersda=false;
    int velocidad=2;
    int velocidadGato=1;
    int velocidadObs1=1;
    int velocidadObs2=1;
    int velocidadObs3=1;
    int velocidadObs4=1;
    
    boolean visibleGato=true;
    boolean visibleObs1=true;
    boolean visibleObs2=true;
    boolean visibleObs3=true;
    boolean visibleObs4=true;
    
    boolean choqueGato=false;
    boolean choqueObs1=false;
    boolean choqueObs2=false;
    boolean choqueObs3=false;
    boolean choqueObs4=false;
    boolean pantallaFinal=false;
    
    int movimientos=0;
    int puntuacion=0;
     
    
    public VentanaPrincipal(Controlador controlador) {
        initComponents();
        this.controlador=controlador;
        finalJuego1.setVisible(false);
        nuevoRecord1.setVisible(false);
        mejoresPuntuaciones1.setVisible(false);
        setVisible(false);
        this.setLocation(550, 100);
        colocarObstaculosInicial();
        colocarCorazones();
        finalJuego1.agregarEventos(controlador);
        nuevoRecord1.agregarEventos(controlador);
        mejoresPuntuaciones1.agregarEventos(controlador);
        sonidoIni.play();
        
    }
    
    
    public void detenerMusica()
    {
        sonidoIni.stop();
    }
    
    public void cambiarNombre()
     {
         if(jl_Vidas.getIcon()!=ceroVidas)
         {
             jl_Puntuacion.setText(""+puntuacion);
         }
         
     }
    
    public void setMejoresPuntuaciones(String[] informacion)
    {
        mejoresPuntuaciones1.mejoresPuntuaciones(informacion);
    }
    
    public void setVisiblePuntuaciones()
    {
        mejoresPuntuaciones1.setVisible(true);
    }
    
    public void setFalsePuntuaciones()
    {
        mejoresPuntuaciones1.setVisible(false);
    }
    
    
    
    public String[] enviarInformacion()
    {
        return nuevoRecord1.enviarInformacion();
    }
    
  
    
    public void colocarFondo()
    {   
        jl_Fondo.setIcon(fondo);
        jl_Fondo.setLocation(0,-2320);
        jl_Globo.setLocation(220, jl_Globo.getY());
    }
    
    public void resetearPanel()
    {
        nuevoRecord1.resetearPanel();
    }
    
    public void iniciarValores()
    {
        distanciaObstaculos=0;
        movimiento=0;
        cambioFondo=0;
        movimientoDerecha=false;
        movimientoIzquiersda=false;
        velocidadGato=1;
        velocidadObs1=1;
        velocidadObs2=1;
        velocidadObs3=1;
        velocidadObs4=1;
    }
    
   
    
    public void finDelJuego()
    {
        System.out.println("metodo finDelJuegoVentana");
        if(controlador.finDelJuego(puntuacion))
        {
            System.out.println("5");
            nuevoRecord1.cambiarNombre(""+puntuacion);
            nuevoRecord1.setVisible(true);
        }
        else
        {
            finalJuego1.cambiarNombre(""+puntuacion);
            finalJuego1.setVisible(true);
        }
    }
    
    public void finalJuego()
    {
        System.out.println("metodo donde lo llama ventana");
        finDelJuego();
        jl_Globo.setVisible(false);
        jl_GatoCafe.setVisible(false);
        jl_Obs1.setVisible(false);
        jl_Obs2.setVisible(false);
        jl_Obs3.setVisible(false);
        jl_Obs4.setVisible(false);
        visibleGato=false;
        visibleObs1=false;
        visibleObs2=false;
        visibleObs3=false;
        visibleObs4=false;
    }
    public void colocarObstaculosInicial()
    {
        jl_GatoCafe.setLocation(300,-600);
        jl_Obs1.setLocation(400,-200);
        jl_Obs2.setLocation(100,-400);
        jl_Obs3.setLocation(300,-1000);
        jl_Obs4.setLocation(100,-1500);
    }
    public void colocarCorazones()
    {
        jl_Vidas.setIcon(tresVidas);
    }

    
    public int xRandom()
    {
      int radom=(int)(Math.random() *450+ + 10);
      return radom;
    }
    
    public int yRandom()
    {
      int radom=(int)(Math.random() *500 + 100);
      return radom;
    }
    
    public int yRandom2Obs1()
    {
      int radom=(int)(Math.random() *300 + 100);
      return radom;
    }
    
    
    public int yRandom2Obs2()
    {
      int radom=(int)(Math.random() *600 + 400);
      return radom;
    }

    
    public int yRandom2Obs3()
    {
      int radom=(int)(Math.random() *900 + 700);
      return radom;
    }

    
    public int yRandom2Obs4()
    {
      int radom=(int)(Math.random() *1200 + 1000);
      return radom;
    }
    
    public void comenzarHilo()
    {
        hilo.start();
    }
    
    public void pausarHilo()
    {
        hilo.suspend();
    }
    
    public void puntuacion()
    {
        if((movimientos%14)==0)
        {
            
           puntuacion++;
            cambiarNombre(); 
        }     
        
    }
    
    

    public void moverFondo()
    {
       
            //System.out.println("Fondo X: "+jl_Globo.getX()+"Fondo Y: "+jl_Globo.getY());
            if(jl_Fondo.getY()<-10)
        {
            jl_Fondo.setLocation(jl_Fondo.getX(), jl_Fondo.getY()+velocidad);
            movimientos++;
        }
        else
        {
                System.out.println("Cambio");
                if(cambioFondo==0)
                {
                   jl_Fondo.setIcon(fondoDia);
                   cambioFondo++;
                   velocidad+=1;
                   velocidadGato+=1;
                   velocidadObs1+=1;
                   velocidadObs2+=1;
                   velocidadObs3+=1;
                   velocidadObs4+=1;
                   
                   System.out.println(cambioFondo);
                }
                    else
                    {
                       if(cambioFondo==1)
                       {
                       jl_Fondo.setIcon(fondoDiaNoche);
                       cambioFondo++;
                       velocidad+=1;
                       velocidadGato+=1;
                       velocidadObs1+=1;
                       velocidadObs2+=1;
                       velocidadObs3+=1;
                       velocidadObs4+=1;
                       System.out.println(cambioFondo);
                        }
                            else
                            {
                                if(cambioFondo==2)
                                {
                                    jl_Fondo.setIcon(fondoNoche);
                                    cambioFondo++;
                                    velocidad+=1;
                                    velocidadGato+=2;
                                   velocidadObs1+=2;
                                   velocidadObs2+=2;
                                   velocidadObs3+=2;
                                   velocidadObs4+=2;
                                    System.out.println(cambioFondo);
                                }
                                else
                                {
                                    if(cambioFondo==3)
                                    {
                                        jl_Fondo.setIcon(fondoNocheEspacio);
                                        cambioFondo++;
                                        velocidad+=1;
                                        velocidadGato+=1;
                                       velocidadObs1+=1;
                                       velocidadObs2+=1;
                                       velocidadObs3+=1;
                                       velocidadObs4+=1;
                                        System.out.println(cambioFondo);
                                    }
                                    else
                                    {
                                        if(cambioFondo==4)
                                        {
                                            jl_Fondo.setIcon(fondoEspacioLuna);
                                           cambioFondo++;
                                           velocidad+=1;
                                           velocidadGato+=2;
                                           velocidadObs1+=2;
                                           velocidadObs2+=2;
                                           velocidadObs3+=2;
                                           velocidadObs4+=2;
                                           System.out.println(cambioFondo);
                                        }
                                        else
                                        {
                                            jl_Fondo.setIcon(fondoEspacio);
                                           cambioFondo++;
                                           velocidadGato+=1;
                                           velocidadObs1+=1;
                                           velocidadObs2+=1;
                                           velocidadObs3+=1;
                                           velocidadObs4+=1;
                                           System.out.println(cambioFondo);
                                        }
                                    }
                                }
                            } 
                }
                jl_Fondo.setLocation(0,-2320);
        }
 
    }
    
    public void verificarEstado()
        {
            if(estado.equals("Derecha"))
            {
                if(jl_Globo.getX()+50<=500)
                {
                    if(movimiento<=30)
                    {
                        jl_Globo.setIcon(globoImagenDerecha);
                        jl_Globo.setLocation(jl_Globo.getX()+2, jl_Globo.getY());
                        movimiento++;
                    }
                    else
                    {
                        estado="Centro";
                    }
                }
                else{
                    estado="Centro";
                }
            }
            
            if(estado.equals("Izquierda"))
            {
                if(jl_Globo.getX()>=0)
                {
                    if(movimiento<=30)
                    {
                        jl_Globo.setIcon(globoImagenIzquierda);
                        jl_Globo.setLocation(jl_Globo.getX()-2, jl_Globo.getY());
                        movimiento++;
                    }
                    else
                    {
                        estado="Centro";
                    }
                }
                else{
                    estado="Centro";
                }
            }
            if(estado.equals("Centro"))
            {
                jl_Globo.setIcon(globoCentro);
            }
      }
    
  
    public void moverObstaculo()
    {
        //System.out.println("X del gato: "+jl_GatoCafe.getX()+"Y del Gato: "+jl_GatoCafe.getY());
        //System.out.println("X del Globo: "+jl_Globo.getX()+" Y del Globo: "+jl_Globo.getY());
        

        if(jl_GatoCafe.getY()<770)
            {
                jl_GatoCafe.setLocation(jl_GatoCafe.getX(), jl_GatoCafe.getY()+velocidadGato);
            }
            else
            {
                if(cambioFondo%4==0)
                {
                   jl_GatoCafe.setVisible(true);
                   visibleGato=true;
                    jl_GatoCafe.setLocation(xRandom(),-yRandom());
                    choqueGato=false;  
                }
                
            }
        
        // Obstaculo 1
        if(jl_Obs1.getY()<770)
            {
                jl_Obs1.setLocation(jl_Obs1.getX(), jl_Obs1.getY()+velocidadObs1);
            }
            else
            {
                if(cambioFondo>=2)
                {
                    if(cambioFondo==2){jl_Obs1.setIcon(cohete);}
                    jl_Obs1.setLocation(xRandom(),-yRandom2Obs1());
                    choqueObs1=false; 
                }
                else
                {
                    jl_Obs1.setLocation(xRandom(),-yRandom2Obs1());
                    choqueObs1=false; 
                }
                 
            }
        
        
        // Obstaculo 2
        if(jl_Obs2.getY()<770)
            {
                jl_Obs2.setLocation(jl_Obs2.getX(), jl_Obs2.getY()+velocidadObs2);
            }
        else 
            {
                if(cambioFondo>=2)
                {
                    if(cambioFondo==2){jl_Obs2.setIcon(satelite);}
                    jl_Obs2.setLocation(xRandom(),-yRandom2Obs2());
                    choqueObs2=false; 
                }
                else
                {
                    jl_Obs2.setLocation(xRandom(),-yRandom2Obs2());
                    choqueObs2=false; 
                }
            }
        
        // Obstaculo 3
        if(jl_Obs3.getY()<770)
            {
                jl_Obs3.setLocation(jl_Obs3.getX(), jl_Obs3.getY()+velocidadObs3);
            }
            else
            {
                if(cambioFondo>=2)
                {
                    if(cambioFondo==2){jl_Obs3.setIcon(planeta);}
                    jl_Obs3.setLocation(xRandom(),-yRandom2Obs3());
                    choqueObs3=false; 
                }
                else
                {
                    jl_Obs3.setLocation(xRandom(),-yRandom2Obs3());
                    choqueObs3=false; 
                }  
            }
        
        // Obstaculo 4
        if(jl_Obs4.getY()<770)
            {
                jl_Obs4.setLocation(jl_Obs4.getX(), jl_Obs4.getY()+velocidadObs4);
            }
        else 
            {
                if(cambioFondo>=2)
                {
                    if(cambioFondo==2){jl_Obs4.setIcon(astronauta);}
                    jl_Obs4.setLocation(xRandom(),-yRandom2Obs4());
                    choqueObs4=false; 
                }
                else
                {
                    jl_Obs4.setLocation(xRandom(),-yRandom2Obs4());
                    choqueObs4=false; 
                }  
            }
        
    }
    

    
    public void verificarChoque()
    {
     
        if(jl_Globo.getY()<jl_GatoCafe.getY()+50&&jl_Globo.getY()+240>jl_GatoCafe.getY() &&jl_GatoCafe.getX()+124>jl_Globo.getX()&& jl_GatoCafe.getX()<jl_Globo.getX()+119)
        {
            if(visibleGato==true)
            {
                jl_GatoCafe.setVisible(false);
                visibleGato=false;
                sonidoGato.play();
            }
            
            if(choqueGato==false)
            {
                if(jl_Vidas.getIcon()==tresVidas)
                {
                    choqueGato=true;
                }
                else
                {
                   if(jl_Vidas.getIcon()==dosVidas)
                    {
                        jl_Vidas.setIcon(tresVidas);
                        choqueGato=true;
                    } 
                   else
                   {
                      if(jl_Vidas.getIcon()==unaVida)
                        {
                            jl_Vidas.setIcon(dosVidas);
                            choqueGato=true;
                        } 
                      else
                      {
                          
                      }
                   }
                }             
            }
            
        }
        
        if(jl_Globo.getY()<jl_Obs1.getY()+140&&jl_Globo.getY()+240>jl_Obs1.getY() &&jl_Obs1.getX()+50>jl_Globo.getX()&& jl_Obs1.getX()<jl_Globo.getX()+119)
        {
            if(choqueObs1==false)
            {
                if(visibleObs1==true)
                {
                sonidoVida.play();
                }
                if(jl_Vidas.getIcon()==tresVidas)
                {
                    jl_Vidas.setIcon(dosVidas);
                    choqueObs1=true;
                }
                else
                {
                   if(jl_Vidas.getIcon()==dosVidas)
                    {
                        jl_Vidas.setIcon(unaVida);
                        choqueObs1=true;
                    } 
                   else
                   {
                      if(jl_Vidas.getIcon()==unaVida)
                        {
                            jl_Vidas.setIcon(ceroVidas);
                            choqueObs1=true;
                            finalJuego();
                        } 
                      else
                      {
                          
                      }
                   }
                }             
            }
        }
        
        if(jl_Globo.getY()<jl_Obs2.getY()+50&&jl_Globo.getY()+240>jl_Obs2.getY() &&jl_Obs2.getX()+85>jl_Globo.getX()&& jl_Obs2.getX()<jl_Globo.getX()+119)
        {
            if(choqueObs2==false)
            {
                if(visibleObs2==true)
                {
                sonidoVida.play();
                }
                if(jl_Vidas.getIcon()==tresVidas)
                {
                    jl_Vidas.setIcon(dosVidas);
                    choqueObs2=true;
                }
                else
                {
                   if(jl_Vidas.getIcon()==dosVidas)
                    {
                        jl_Vidas.setIcon(unaVida);
                        choqueObs2=true;
                    } 
                   else
                   {
                      if(jl_Vidas.getIcon()==unaVida)
                        {
                            jl_Vidas.setIcon(ceroVidas);
                            choqueObs2=true;
                            finalJuego();
                        } 
                      else
                      {
                          
                      }
                   }
                }             
            }
        }
        
        if(jl_Globo.getY()<jl_Obs3.getY()+55&&jl_Globo.getY()+240>jl_Obs3.getY() &&jl_Obs3.getX()+95>jl_Globo.getX()&& jl_Obs3.getX()<jl_Globo.getX()+119)
        {
            if(choqueObs3==false)
            {
              if(visibleObs3==true)
                {
                sonidoVida.play();
                }
                if(jl_Vidas.getIcon()==tresVidas)
                {
                    jl_Vidas.setIcon(dosVidas);
                    choqueObs3=true;
                }
                else
                {
                   if(jl_Vidas.getIcon()==dosVidas)
                    {
                        jl_Vidas.setIcon(unaVida);
                        choqueObs3=true;
                    } 
                   else
                   {
                      if(jl_Vidas.getIcon()==unaVida)
                        {
                            jl_Vidas.setIcon(ceroVidas);
                            choqueObs3=true;
                            finalJuego();
                        } 
                      else
                      {
                          
                      }
                   }
                }             
            }
        }
        
        if(jl_Globo.getY()<jl_Obs4.getY()+45&&jl_Globo.getY()+240>jl_Obs4.getY() &&jl_Obs4.getX()+85>jl_Globo.getX()&& jl_Obs4.getX()<jl_Globo.getX()+119)
        {
            if(choqueObs4==false)
            {
              if(visibleObs4==true)
                {
                 sonidoVida.play();
                }
                if(jl_Vidas.getIcon()==tresVidas)
                {
                    jl_Vidas.setIcon(dosVidas);
                    choqueObs4=true;
                }
                else
                {
                   if(jl_Vidas.getIcon()==dosVidas)
                    {
                        jl_Vidas.setIcon(unaVida);
                        choqueObs4=true;
                    } 
                   else
                   {
                      if(jl_Vidas.getIcon()==unaVida)
                        {
                            jl_Vidas.setIcon(ceroVidas);
                            choqueObs4=true;
                           finalJuego();
                        } 
                      else
                      {
                          
                      }
                   }
                }             
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_Puntuacion = new javax.swing.JLabel();
        mejoresPuntuaciones1 = new vista.MejoresPuntuaciones();
        nuevoRecord1 = new vista.NuevoRecord();
        finalJuego1 = new vista.finalJuego();
        jl_Globo = new javax.swing.JLabel();
        jl_Vidas = new javax.swing.JLabel();
        jl_GatoCafe = new javax.swing.JLabel();
        jl_Obs1 = new javax.swing.JLabel();
        jl_Obs2 = new javax.swing.JLabel();
        jl_Obs3 = new javax.swing.JLabel();
        jl_Obs4 = new javax.swing.JLabel();
        jl_Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 36)); // NOI18N
        setMinimumSize(new java.awt.Dimension(580, 803));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);

        jl_Puntuacion.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 48)); // NOI18N
        jl_Puntuacion.setText("Punt");
        getContentPane().add(jl_Puntuacion);
        jl_Puntuacion.setBounds(40, 0, 200, 120);
        getContentPane().add(mejoresPuntuaciones1);
        mejoresPuntuaciones1.setBounds(0, 180, 520, 480);
        getContentPane().add(nuevoRecord1);
        nuevoRecord1.setBounds(10, 120, 540, 750);
        getContentPane().add(finalJuego1);
        finalJuego1.setBounds(10, 120, 550, 770);

        jl_Globo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/gifglobo.gif"))); // NOI18N
        getContentPane().add(jl_Globo);
        jl_Globo.setBounds(220, 430, 160, 270);

        jl_Vidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tresVidas.png"))); // NOI18N
        getContentPane().add(jl_Vidas);
        jl_Vidas.setBounds(400, 20, 130, 60);

        jl_GatoCafe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/GifGato1.gif"))); // NOI18N
        getContentPane().add(jl_GatoCafe);
        jl_GatoCafe.setBounds(330, 0, 130, 60);

        jl_Obs1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ObstaculoAmarillo.png"))); // NOI18N
        getContentPane().add(jl_Obs1);
        jl_Obs1.setBounds(380, 0, 90, 180);

        jl_Obs2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Pajaro1.png"))); // NOI18N
        getContentPane().add(jl_Obs2);
        jl_Obs2.setBounds(140, 10, 100, 90);

        jl_Obs3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Globo.png"))); // NOI18N
        getContentPane().add(jl_Obs3);
        jl_Obs3.setBounds(30, 60, 110, 100);

        jl_Obs4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/avion.png"))); // NOI18N
        getContentPane().add(jl_Obs4);
        jl_Obs4.setBounds(270, 10, 140, 80);

        jl_Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo.png"))); // NOI18N
        getContentPane().add(jl_Fondo);
        jl_Fondo.setBounds(0, -2320, 571, 3088);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
      
        if(evt.getKeyCode()==39)
        {
            movimiento=0;
            estado="Derecha";
            
        }
        if(evt.getKeyCode()==37)
        {
            movimiento=0;
            estado="Izquierda";
        }
    }//GEN-LAST:event_formKeyPressed

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private vista.finalJuego finalJuego1;
    private javax.swing.JLabel jl_Fondo;
    private javax.swing.JLabel jl_GatoCafe;
    private javax.swing.JLabel jl_Globo;
    private javax.swing.JLabel jl_Obs1;
    private javax.swing.JLabel jl_Obs2;
    private javax.swing.JLabel jl_Obs3;
    private javax.swing.JLabel jl_Obs4;
    private javax.swing.JLabel jl_Puntuacion;
    private javax.swing.JLabel jl_Vidas;
    private vista.MejoresPuntuaciones mejoresPuntuaciones1;
    private vista.NuevoRecord nuevoRecord1;
    // End of variables declaration//GEN-END:variables
}
