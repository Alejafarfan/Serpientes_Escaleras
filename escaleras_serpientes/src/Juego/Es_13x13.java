/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Juego;

import Clases.Jugador;
import Clases.Tablero;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author farfa
 */
public class Es_13x13 extends javax.swing.JFrame {

    Tablero tablero = new Tablero("13x13");
    private JLabel[][] vector = new JLabel[169][4]; // Permitir hasta 4 jugadores por casilla
    private List<Jugador> jugadores;
    private int idjugadoractual = 0;
    private String nombre = "";
    private String players;

    /**
     * Creates new form Escaleras_serpientes
     */
    public Es_13x13(String players) {
        initComponents();
        setLocationRelativeTo(null);
        this.players = players;
        tablero.crearJugador(Integer.parseInt(players));
        jugadores = tablero.getJugadores();



        for (int row = 12; row >= 0; row--) {
            for (int cl = 0; cl < 13; cl++) {
                int num;

                if (row % 2 == 0) {
                    num = row * 13 + (12 - cl) + 1;
                } else {
                    num = row * 13 + cl + 1;
                }

                JPanel subPanel = new JPanel();
                subPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                String panelName = "Casilla" + num;
                subPanel.setName(panelName);

                JLabel label = new JLabel(String.valueOf(num));
                label.setFont(label.getFont().deriveFont(Font.ROMAN_BASELINE, 15));
                label.setHorizontalAlignment(JLabel.LEFT);//
                label.setVerticalAlignment(JLabel.TOP);

                JPanel colorPanel = new JPanel(new GridLayout(2, 2, 0, 0));
                colorPanel.setOpaque(false);

                for (int i = 0; i < 4; i++) {
                    JLabel colorLabel = new JLabel("  ");
                    colorLabel.setPreferredSize(new Dimension(15, 15)); //Tamaño de las fichas
                    colorLabel.setOpaque(true);
                    vector[num - 1][i] = colorLabel; // Asignar el JLabel al
                    colorPanel.add(colorLabel);
                }

                //serpientes

                if (num == 161 || num == 57) {
                    subPanel.setBorder(BorderFactory.createLineBorder(Color.RED)); // Borde naranja
                }
                if (num == 141 || num == 111) {
                    subPanel.setBorder(BorderFactory.createLineBorder(Color.RED)); // Borde naranja
                } 
                if (num == 81 || num == 50) {
                    subPanel.setBorder(BorderFactory.createLineBorder(Color.RED)); // Borde naranja
                }
                 if (num == 19|| num == 7) {
                    subPanel.setBorder(BorderFactory.createLineBorder(Color.RED)); // Borde naranja
                }
                 
                 //escaleras
                 
                  if (num == 3 || num == 68) {
                    subPanel.setBorder(BorderFactory.createLineBorder(Color.YELLOW)); // Borde naranja
                }
                   if (num == 80 || num == 108) {
                    subPanel.setBorder(BorderFactory.createLineBorder(Color.YELLOW)); // Borde naranja
                } if (num == 15 || num == 66) {
                    subPanel.setBorder(BorderFactory.createLineBorder(Color.YELLOW)); // Borde naranja
                }
                 if (num == 120 || num == 153) {
                    subPanel.setBorder(BorderFactory.createLineBorder(Color.YELLOW)); // Borde naranja
                }

                subPanel.add(label, BorderLayout.SOUTH);
                subPanel.add(colorPanel, BorderLayout.EAST);

                jPanelJuego.add(subPanel);

            }

        }
        // Inicializar posiciones de los jugadores
        for (Jugador jugador : jugadores) {
            vector[0][jugadores.indexOf(jugador)].setBackground(jugador.getColor());
        }
    }

    public void moverJugadores(int espacios) {
        Jugador jugadoractual = jugadores.get(idjugadoractual);
        int posicionAnterior = jugadoractual.getPosicion();
        int actualPosicion = posicionAnterior + espacios;

        if (actualPosicion >= 169) {
            actualPosicion = 168;
        }
        int comprobar = actualPosicion;

        vector[jugadoractual.getPosicion()][jugadores.indexOf(jugadoractual)].setOpaque(false);
        vector[jugadoractual.getPosicion()][jugadores.indexOf(jugadoractual)].repaint();

        actualPosicion = tablero.verificarSerpiente(actualPosicion);
        actualPosicion = tablero.verificarEscalera(actualPosicion);

        vector[actualPosicion][jugadores.indexOf(jugadoractual)].setOpaque(true);
        vector[actualPosicion][jugadores.indexOf(jugadoractual)].setBackground(jugadoractual.getColor());
        vector[actualPosicion][jugadores.indexOf(jugadoractual)].repaint();

        jugadoractual.setPosicion(actualPosicion);

        idjugadoractual = (idjugadoractual + 1) % jugadores.size();

        if (players == "2") {
            switch (idjugadoractual) {
                case 1:
                    nombre = "J. Rosado:";
                    lblJugador.setText("Sigue el Jugador Naranjado");
                    break;
                case 0:
                    nombre = "J. Naranjado:";
                    lblJugador.setText("Sigue el Jugador Rosado");
                    break;
            }
        } else {
            if (players == "3") {
                switch (idjugadoractual) {
                    case 1:
                        nombre = "J. Rosado:";
                        lblJugador.setText("Sigue el Jugador Naranjado");

                        break;
                    case 2:
                        nombre = "J. Naranjado:";
                        lblJugador.setText("Sigue el Jugador Azul");
                        break;
                    case 0:
                        nombre = "J. Azul:";
                        lblJugador.setText("Sigue el Jugador Rosado");
                        break;
                }
            } else {
                switch (idjugadoractual) {
                    case 1:
                        nombre = "J. Rosado:";
                        lblJugador.setText("Sigue el Jugador Naranjado");
                        break;
                    case 2:
                        nombre = "J. Naranjado:";
                        lblJugador.setText("Sigue el Jugador Azul");
                        break;
                    case 3:
                        nombre = "J. Azul:";
                        lblJugador.setText("Sigue el Jugador Verde");
                        break;
                    case 0:
                        nombre = "J. Verde:";
                        lblJugador.setText("Sigue el Jugador Rosado");
                        break;
                }
            }
        }
        if (comprobar != actualPosicion) {

            String mensaje = nombre + " a subido a la posicion " + (comprobar + 1);
            if (actualPosicion < posicionAnterior) {
                mensaje += " y abajado a la posicion  " + (actualPosicion + 1);
            } else if (actualPosicion > posicionAnterior) {
                mensaje += " y subido a la posicion  " + (actualPosicion + 1);
            }
            txtHistorialMovimientos.append(mensaje + "\n");
        } else {
            txtHistorialMovimientos.append(nombre + " se desplazo a la posición " + (actualPosicion + 1) +" con un tiro de "+espacios+ "\n");
        }


        if (actualPosicion >= 168) {
            JOptionPane.showMessageDialog(null, "¡" + nombre + " ha ganado !");
            // Deshabilitar el botón de tirar el dado
            cmdDado.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelInicio = new javax.swing.JPanel();
        jPanelJuego = new javax.swing.JPanel();
        cmdDado = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtDado = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtHistorialMovimientos = new javax.swing.JTextArea();
        lblJugador = new javax.swing.JLabel();
        cmdDado1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelInicio.setBackground(new java.awt.Color(255, 204, 153));

        jPanelJuego.setBackground(new java.awt.Color(255, 255, 255));
        jPanelJuego.setLayout(new java.awt.GridLayout(14, 14, 2, 2));

        cmdDado.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        cmdDado.setText("Lanza el dado");
        cmdDado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDadoActionPerformed(evt);
            }
        });

        txtDado.setBackground(new java.awt.Color(255, 153, 0));
        txtDado.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        txtDado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDado.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtDado, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtDado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
        );

        txtHistorialMovimientos.setColumns(20);
        txtHistorialMovimientos.setRows(5);
        jScrollPane1.setViewportView(txtHistorialMovimientos);

        lblJugador.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        lblJugador.setText("Comienza el jugador Rosado:");

        cmdDado1.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        cmdDado1.setText("Volver");
        cmdDado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDado1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelInicioLayout = new javax.swing.GroupLayout(jPanelInicio);
        jPanelInicio.setLayout(jPanelInicioLayout);
        jPanelInicioLayout.setHorizontalGroup(
            jPanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInicioLayout.createSequentialGroup()
                .addGroup(jPanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInicioLayout.createSequentialGroup()
                        .addGap(967, 967, 967)
                        .addComponent(cmdDado1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelInicioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelInicioLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelInicioLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanelInicioLayout.createSequentialGroup()
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmdDado)))))))
                .addGap(51, 51, 51))
        );
        jPanelInicioLayout.setVerticalGroup(
            jPanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblJugador)
                .addGroup(jPanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInicioLayout.createSequentialGroup()
                        .addGroup(jPanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelInicioLayout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(cmdDado))
                            .addGroup(jPanelInicioLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInicioLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addComponent(cmdDado1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdDadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDadoActionPerformed
        int espacios = tablero.tirarDado();
        txtDado.setText(Integer.toString(espacios));
        moverJugadores(espacios);
            }//GEN-LAST:event_cmdDadoActionPerformed

    private void cmdDado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDado1ActionPerformed
        menu volver = new menu();
        volver.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cmdDado1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Es_13x13.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Es_13x13.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Es_13x13.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //   new Es_10x10().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdDado;
    private javax.swing.JButton cmdDado1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelInicio;
    private javax.swing.JPanel jPanelJuego;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblJugador;
    private javax.swing.JLabel txtDado;
    private javax.swing.JTextArea txtHistorialMovimientos;
    // End of variables declaration//GEN-END:variables
}
