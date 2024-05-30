package uniandes.dpoo.taller7.interfaz2;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

class PanelDerecho extends JPanel {
    private JButton nuevoButton;
    private JButton reiniciarButton;
    private JButton top10Button;
    private JButton cambiarJugadorButton;

    public PanelDerecho() {
    	
        setLayout(new GridLayout(16, 1, 0, 10)); 


        nuevoButton = new JButton("NUEVO");
        reiniciarButton = new JButton("REINICIAR");
        top10Button = new JButton("TOP_10");
        cambiarJugadorButton = new JButton("CAMBIAR JUGADOR");

        // Ajustar el tamaño de los botones
        Dimension buttonSize = new Dimension(200, 1); // Tamaño personalizado (ancho x alto)
        nuevoButton.setPreferredSize(buttonSize);
        reiniciarButton.setPreferredSize(buttonSize);
        top10Button.setPreferredSize(buttonSize);
        cambiarJugadorButton.setPreferredSize(buttonSize);
        
        
        // Agregar botones al panel
        add(nuevoButton);
        add(reiniciarButton);
        add(top10Button);
        add(cambiarJugadorButton);
    }
}
