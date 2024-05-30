package uniandes.dpoo.taller7.interfaz4;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import uniandes.dpoo.taller7.modelo.Tablero;
import uniandes.dpoo.taller7.modelo.Top10;

public class VentanaPrincipal extends JFrame implements ActionListener
{
	private Tablero tablero;
	/**
	 * Empieza la ejecución de la aplicación
	 */

	PanelSuperior superior;
	PanelInferior inferior;
	PanelDerecho derecho;
	TableroPanel izquierdo;

	JButton Nuevo;
	JButton Reiniciar;
	JButton Top_10;
	JButton CambiarJugador;

	JRadioButton easy;
	JRadioButton medium;
	JRadioButton hard;

	JComboBox<String> cb;
	Integer size = 4;
	Integer dificultad = 1;

	Top10Ventana ventanaTop10;
	static Top10 top10;
	JLabel cantidadJugadas;

	/*
	 * CONSTRUCTOR
	 */
	public VentanaPrincipal(String nombreJugador)
	{
		tablero = new Tablero(size);
		setLayout(new BorderLayout());
		pack();
		setTitle("Lights Out");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(true);

		setSize(800, 700);

		/*
		 * Window listener para cuando se cierre la ventana.
		 */
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				try
				{
					salvarTop10();
				} catch (FileNotFoundException e1)
				{
					System.err.println("\nNo se encontró el archivo.\n");
					e1.printStackTrace();
				} catch (UnsupportedEncodingException e1)
				{
					System.err.println("\nUnsupportedEncoding!\n");
					e1.printStackTrace();
				}
			}
		});

		//cargan los TOP-10 y crea ventana del mismo
		top10 = new Top10();
		this.cargarTop10();
		ventanaTop10 = new Top10Ventana(top10);

		// Panel de arriba
		superior = new PanelSuperior(this);
		add(superior, BorderLayout.NORTH);
		
		// Panel de abajo

		inferior = new PanelInferior(this);
		inferior.nombreJugador.setText(nombreJugador);
		add(inferior, BorderLayout.SOUTH);

		derecho = new PanelDerecho(this);
		add(derecho, BorderLayout.EAST);

		izquierdo = new TableroPanel(this);

		add(izquierdo, BorderLayout.CENTER);

		int PanelX = (getWidth() - izquierdo.getWidth() - getInsets().left - getInsets().right) / 2;
		int PanelY = (getHeight() - izquierdo.getHeight() - getInsets().top - getInsets().bottom) / 2;

		izquierdo.setLocation(PanelX, PanelY);

		setLocationRelativeTo(null);
		setVisible(true);

		nuevoJuego();
	
	}

	/**
	 * Se inicia un nuevo juego.
	 */

	public void nuevoJuego()
	{

		inferior.cantidadJugadas.setText("0");
		tablero = new Tablero(size);
		tablero.desordenar(dificultad);
		izquierdo.nuevoPanel(tablero);
		

	}

	/**
	 * Se cargan los top 10 del archivo en data.
	 */
	public void cargarTop10()
	{
		String dataDirectory = System.getProperty("user.dir") + "/data/top10.csv";
		File archivoFile = new File(dataDirectory);
		top10.cargarRecords(archivoFile);
	}

	/**
	 * Se guarda el top10 en el CSV.
	 * 
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	@SuppressWarnings("static-access")
	public void salvarTop10() throws FileNotFoundException, UnsupportedEncodingException
	{
		String dataDirectory = System.getProperty("user.dir") + "/data/top10.csv";
		File archivoFile = new File(dataDirectory);
		this.top10.salvarRecords(archivoFile);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{

		// Botones panel de la derecha

		Nuevo = derecho.nuevo;
		Reiniciar = derecho.reiniciar;
		Top_10 = derecho.top10;
		CambiarJugador = derecho.cambiarJugador;

		// Botones panel de arriba

		easy = superior.easy;
		medium = superior.medium;
		hard = superior.hard;

		cb = superior.cb;

		// Panel de la derecha

		if (e.getSource() == Nuevo)
		{
			nuevoJuego();
		}

		else if (e.getSource() == Reiniciar)
		{
			tablero.reiniciar();
			izquierdo.nuevoPanel(tablero);
			inferior.cantidadJugadas.setText("0");
		}

		else if (e.getSource() == Top_10)
		{
			ventanaTop10.changeVisibility();
		}

		else if (e.getSource() == CambiarJugador)
		{
			new IngresarNombre();
		}

		// Panel de arriba

		else if (e.getSource() == easy)
		{
			dificultad = 3;
			nuevoJuego();
		}

		else if (e.getSource() == medium)
		{
			dificultad = 5;
			nuevoJuego();
		}

		else if (e.getSource() == hard)
		{
			dificultad = 7;
			nuevoJuego();
		}

		else if (e.getSource() == cb)
		{
			String selectedSize = (String) cb.getSelectedItem();
			if (selectedSize.equals("4x4"))
			{
				size = 4;
				nuevoJuego();
			}

			else if (selectedSize.equals("5x5"))
			{
				size = 5;
				nuevoJuego();
			}

			else if (selectedSize.equals("6x6"))
			{
				size = 6;
				nuevoJuego();
			}

			else if (selectedSize.equals("7x7"))
			{
				size = 7;
				nuevoJuego();
			}

			else if (selectedSize.equals("8x8"))
			{
				size = 8;
				nuevoJuego();
			}

			else if (selectedSize.equals("9x9"))
			{
				size = 9;
				nuevoJuego();
			}

		}

	}

	public void Jugar(int i, int j)
	{
		tablero.jugar(i, j);
		Integer cantidad = izquierdo.cantidadJugadas;
		inferior.cantidadJugadas.setText(cantidad.toString());

		int puntaje = tablero.calcularPuntaje();
		int jugadas = Integer.parseInt(inferior.cantidadJugadas.getText());

		if (tablero.tableroIluminado() == true)
		{
			if (top10.esTop10(puntaje))
			{
				top10.agregarRegistro(inferior.nombreJugador.getText(), puntaje);
			
			}
			new VentanaFinal(jugadas, puntaje, this);
		}

	}

}