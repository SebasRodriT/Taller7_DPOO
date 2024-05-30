package uniandes.dpoo.taller7.interfaz3;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {
	private PanelSuperior arriba;
	private PanelInferior abajo;
	private PanelDerecho derecha;
	private TableroPanel tablero;
	
    public VentanaPrincipal() {
        setSize(800, 600); 
        setTitle("Juego de LightsOut"); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        arriba = new PanelSuperior();
        derecha = new PanelDerecho();
        abajo = new PanelInferior();
        tablero = new TableroPanel(5,5);
        
        setLayout(new BorderLayout());
        add(arriba, BorderLayout.NORTH);
        add(derecha, BorderLayout.EAST);
        add(abajo, BorderLayout.SOUTH);
        add(tablero, BorderLayout.CENTER);
        
        setVisible(true);
        
        repaint();
    }

    public static void main(String[] args) {
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setVisible(true);
    }
} 
