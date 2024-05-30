package uniandes.dpoo.taller7.interfaz4;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;


public class PanelSuperior extends JPanel
{
	JRadioButton easy;
	JRadioButton medium;
	JRadioButton hard;

	JComboBox<String> cb;

	public PanelSuperior(VentanaPrincipal primera)
	{

		GridLayout layout = new GridLayout(0, 6, 10, 0); 
		this.setLayout(layout);
		Color colorDeFondo = new Color(255,255,255);

		Border borde = BorderFactory.createTitledBorder("Opciones del juego");
		this.setBorder(borde);

		JLabel tamanio = new JLabel("Tamaño:");
		tamanio.setAlignmentX(LEFT_ALIGNMENT);
		this.add(tamanio);
        

		String[] opciones = { "4x4", "5x5", "6x6", "7x7", "8x8", "9x9" };
		
		
		cb = new JComboBox<String>(opciones);
		cb.setMaximumSize(getPreferredSize());
		cb.setAlignmentX(LEFT_ALIGNMENT);
		cb.addActionListener(primera);

		this.add(cb);

		JLabel dificultadLbl = new JLabel("Dificultad:");
		this.add(dificultadLbl);
		
		
		
		easy = new JRadioButton("Fácil", true); 
		medium = new JRadioButton("Medio", false);
		hard = new JRadioButton("Difícil", false);
		
		ButtonGroup group = new ButtonGroup();
		group.add(easy);
		group.add(medium);
		group.add(hard);

		easy.addActionListener(primera);
		medium.addActionListener(primera);
		hard.addActionListener(primera);
	
		
		this.add(easy);
		this.add(medium);
		this.add(hard);
		this.setBackground(colorDeFondo);
	}

}
