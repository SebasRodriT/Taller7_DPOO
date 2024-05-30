package uniandes.dpoo.taller7.interfaz4;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;

import com.formdev.flatlaf.FlatLightLaf;
public class IngresarNombre extends JFrame implements ActionListener
{
	
	
	JButton boton; 
	JTextField texto; 
	String nombreJugador;

	public IngresarNombre()
	{
		this.setTitle("Ingresar");
		JLabel nombre = new JLabel("Ingrese su nombre para iniciar el juego");

		// Boton de jugar
		boton = new JButton("Jugar");
		boton.addActionListener(this);
		// Crear 16 columnas 
		texto= new JTextField(16);
		texto.addActionListener(this);
		// Crear un panel para añadir las opciones y el texto  
		JPanel panel = new JPanel();
		panel.add(nombre);
		panel.add(texto);
		panel.add(boton);
		// Añadir el panel al frame 
		add(panel);
		// Decidir el tamaño del frame
		setSize(400, 100);
		Color colorDeFondo = new Color(255,255,255);
		this.setBackground(colorDeFondo);


		
		setLocationRelativeTo(null);
		setResizable(true); 		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setVisible(true);
	}

	
	
	@Override
	

	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == boton)
		{
			nombreJugador = texto.getText();
			new VentanaPrincipal(nombreJugador);
			this.dispose(); 
			                
		}

	}
	
	

	public static void main(String[] args)
	{
		FlatLightLaf.install(); 
		new IngresarNombre();

	}

}
