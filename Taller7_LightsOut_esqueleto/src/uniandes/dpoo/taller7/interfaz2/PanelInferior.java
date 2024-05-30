package uniandes.dpoo.taller7.interfaz2;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelInferior extends JPanel{
	private JLabel jugadasLabel;
    private JTextField jugadasTextField;
    private JLabel jugadorLabel;
    private JTextField jugadorTextField;

    public PanelInferior() {
        // Configurar el panel inferior
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Espacio horizontal y vertical entre componentes

        // Crear componentes
        jugadasLabel = new JLabel("Jugadas:");
        jugadasTextField = new JTextField("0",10); // Tamaño del campo de texto (10 caracteres)
        jugadorLabel = new JLabel("Jugador:");
        jugadorTextField = new JTextField(15); // Tamaño del campo de texto (15 caracteres)

        // Agregar componentes al panel
        add(jugadasLabel);
        add(jugadasTextField);
        add(jugadorLabel);
        add(jugadorTextField);
    }

}
