package uniandes.dpoo.taller7.interfaz4;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;


public class PanelDerecho extends JPanel
{
    JButton nuevo;
    JButton reiniciar;
    JButton top10;
    JButton cambiarJugador;

    public PanelDerecho(VentanaPrincipal primera)
    {
        GridLayout layout = new GridLayout(4, 1, 5, 5); 
        this.setLayout(layout);
        
 

		// Crear  título
        TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), "Menu");
        titledBorder.setTitleColor(Color.WHITE); 
        this.setBorder(titledBorder);

       
        nuevo = new JButton("NUEVO");
        reiniciar = new JButton("REINICIAR");
        top10 = new JButton("TOP-10");
        cambiarJugador = new JButton("CAMBIAR JUGADOR");

        Font buttonFont = new Font("Arial", Font.PLAIN, 16);
        nuevo.setFont(buttonFont);
        reiniciar.setFont(buttonFont);
        top10.setFont(buttonFont);
        cambiarJugador.setFont(buttonFont);

        nuevo.addActionListener(primera);
		cambiarJugador.addActionListener(primera);
		reiniciar.addActionListener(primera);
		top10.addActionListener(primera);

        // Añade botones al panel
        this.add(nuevo);
        this.add(reiniciar);
        this.add(top10);
        this.add(cambiarJugador);
     
        Color colorDeFondo = new Color(20, 21, 64 );
        this.setBackground(colorDeFondo);

        Color botonColor = new Color(118, 145, 198 ); 
        nuevo.setBackground(botonColor);
        reiniciar.setBackground(botonColor);
        top10.setBackground(botonColor);
        cambiarJugador.setBackground(botonColor);

      
        Border buttonBorder = BorderFactory.createLineBorder(Color.GRAY, 1);
        nuevo.setBorder(buttonBorder);
        reiniciar.setBorder(buttonBorder);
        top10.setBorder(buttonBorder);
        cambiarJugador.setBorder(buttonBorder);
    }
}