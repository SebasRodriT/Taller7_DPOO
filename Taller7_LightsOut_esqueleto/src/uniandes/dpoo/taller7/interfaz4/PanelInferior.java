package uniandes.dpoo.taller7.interfaz4;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class PanelInferior extends JPanel
{
	private VentanaPrincipal primera;
	
	
	public VentanaPrincipal getPrimera() {
		return primera;
	}

	public void setPrimera(VentanaPrincipal primera) {
		this.primera = primera;
	}

	
	JLabel cantidadJugadas;
	JLabel nombreJugador;
	
	//Constructor

	public PanelInferior(VentanaPrincipal primera)
	{
		this.primera = primera;
		GridLayout layout = new GridLayout(0, 4, 10, 0);
		this.setLayout(layout);
		Border borderPrincipal = BorderFactory.createTitledBorder("Actividades del juego");
		this.setBorder(borderPrincipal);
		Border border = BorderFactory.createLineBorder(Color.BLUE, 3);
		JLabel jugadasLabel = new JLabel("Jugadas hechas");
		add(jugadasLabel);
		cantidadJugadas = new JLabel("0");
		cantidadJugadas.setBorder(border);
		add(cantidadJugadas);
		JLabel jugadorLabel = new JLabel("Jugador");
		add(jugadorLabel);
		nombreJugador = new JLabel("Null");
		nombreJugador.setBorder(border);
		add(nombreJugador);
		Color colorDeFondo = new Color(255,255,255);
		this.setBackground(colorDeFondo);
				
	}
}

