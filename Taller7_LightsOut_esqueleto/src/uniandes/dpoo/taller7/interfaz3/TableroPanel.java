package uniandes.dpoo.taller7.interfaz3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class TableroPanel extends JPanel {
	private int filas;
    private int columnas;

    public TableroPanel(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
    }
    
    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Calcula el tamaño de cada celda
        int anchoCelda = getWidth() / columnas;
        int altoCelda = getHeight() / filas;

        // Dibuja el tablero
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                int x = columna * anchoCelda;
                int y = fila * altoCelda;
                g.setColor(Color.YELLOW);
                g.fillRect(x, y, anchoCelda, altoCelda);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, anchoCelda, altoCelda);
            }
       }
        
       
    }
    
    public void setDimensions(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        repaint(); // Redibujar el tablero con las nuevas dimensiones
    }
    
}
