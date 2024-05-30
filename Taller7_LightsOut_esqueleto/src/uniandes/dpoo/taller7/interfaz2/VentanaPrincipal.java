package uniandes.dpoo.taller7.interfaz2;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {
	private PanelSuperior arriba;
	private PanelInferior abajo;
	private PanelDerecho derecha;
	
    public VentanaPrincipal() {
        setSize(800, 600); 
        setTitle("Juego de LightsOut"); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        arriba = new PanelSuperior();
        derecha = new PanelDerecho();
        abajo = new PanelInferior();
        
        setLayout(new BorderLayout());
        add(arriba, BorderLayout.NORTH);
        add(derecha, BorderLayout.EAST);
        add(abajo, BorderLayout.SOUTH);
        
        setVisible(true);
    }

    public static void main(String[] args) {
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setVisible(true);
    }
}
