package uniandes.dpoo.taller7.interfaz1;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {
    public VentanaPrincipal() {
        setSize(800, 600); 
        setTitle("Juego de LightsOut"); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }

    public static void main(String[] args) {
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setVisible(true);
    }
}
