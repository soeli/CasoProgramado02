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
public class Instrucciones extends javax.swing.JPanel {

    /**
     * Creates new form Instrucciones
     */
    Controlador controlador;
    public Instrucciones() {
        initComponents();
    }

    public void agregarEventos(Controlador controlador)
    {
        this.controlador=controlador;
        this.btn_Vamos.addActionListener(controlador);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_Vamos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(null);

        btn_Vamos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Vamos.png"))); // NOI18N
        btn_Vamos.setActionCommand("Vamos");
        btn_Vamos.setBorderPainted(false);
        btn_Vamos.setContentAreaFilled(false);
        add(btn_Vamos);
        btn_Vamos.setBounds(250, 500, 180, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Instrucciones.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 446, 578);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Vamos;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
