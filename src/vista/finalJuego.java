/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import controlador.Controlador;

/**
 *
 * @author SOFIA ELIZONDO
 */
public class finalJuego extends javax.swing.JPanel {

    /**
     * Creates new form finalJuego
     */
    Controlador controlador;
    public finalJuego() {
        initComponents();
        
    }
    
    public void cambiarNombre(String puntuacion)
     {
      
             jl_Puntuacion.setText(""+puntuacion);
         
         
     }
    
    public void agregarEventos(Controlador controlador)
    {
        this.controlador=controlador;
        panelBotones1.agregarEventos(controlador);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_Puntuacion = new javax.swing.JLabel();
        panelBotones1 = new vista.PanelBotones();
        jLabel1 = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(null);

        jl_Puntuacion.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 100)); // NOI18N
        jl_Puntuacion.setForeground(new java.awt.Color(255, 199, 50));
        jl_Puntuacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_Puntuacion.setText("Punt");
        add(jl_Puntuacion);
        jl_Puntuacion.setBounds(120, 160, 280, 120);
        add(panelBotones1);
        panelBotones1.setBounds(90, 230, 450, 230);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FinDeJuego.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 530, 903);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jl_Puntuacion;
    private vista.PanelBotones panelBotones1;
    // End of variables declaration//GEN-END:variables
}
