package uniandes.dpoo.taller7.interfaz4;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import uniandes.dpoo.taller7.modelo.Tablero;

public class TableroPanel extends JPanel implements MouseListener
{
    private VentanaPrincipal primera;
    private int[][] matriz;
    private int largo;
    private boolean[][] tablero;
    public int cantidadJugadas;
    private Image luzImagen;

    public TableroPanel(VentanaPrincipal primera){
        setSize(700,700);
        this.primera = primera;
        this.addMouseListener(this);
        this.luzImagen = new ImageIcon("data/luz.png").getImage().getScaledInstance(50, 49, Image.SCALE_SMOOTH); 
    }

    public void nuevoPanel(Tablero tableroC){
        this.removeAll();
        this.tablero = tableroC.darTablero();
        this.largo = tablero.length;
        this.matriz = new int[largo][largo];
        cantidadJugadas = 1;
        GridLayout l = new GridLayout(largo,largo);
        setLayout(l);
        actualizarPanel();
    }

    public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2d = (Graphics2D) g;
            int la = Math.min(this.getWidth()/largo, this.getHeight()/largo);
            int ancho = (getWidth()-la*largo)/2;
            int alto = (getHeight()-la*largo)/2;
            for (int i = 0; i < largo; i++) {
                int anchx = ancho;
                for (int ii = 0; ii < largo; ii++) {
                    if (tablero[i][ii]) {
                        g2d.setColor(Color.YELLOW); // Color cuando el estado es true
                    } else {
                        g2d.setColor(Color.BLACK); // Color cuando el estado es false
                    }
                    g2d.fillRoundRect(anchx, alto, la, la, 20, 20);
                    int imgX = anchx + (la - 50) / 2; // Centrar la imagen en la casilla
                    int imgY = alto + (la - 49) / 2;
                    g2d.drawImage(luzImagen, imgX, imgY, this); // Dibuja la imagen en cada casilla
                    g2d.setColor(Color.BLACK); // Color del texto
                    g2d.drawString(String.valueOf(matriz[i][ii]), anchx + (int)(la*0.1), alto + (int)(la*0.1));

                    anchx += la;
                }
                alto += la;
            }
        }
    public void actualizarPanel(){
        repaint();
    }
    @Override
    public void mouseClicked(MouseEvent click) {
         int click_x = click.getX();
         int click_y = click.getY();
         int[] casilla = convertirCoordenadasACasilla(click_x, click_y);

         matriz[casilla[0]][casilla[1]]++;
         primera.Jugar(casilla[0], casilla[1]);
         cantidadJugadas +=1;
         
         repaint();
    }
    private int[] convertirCoordenadasACasilla(int x, int y){
        int ladoTablero = tablero.length; 
        int altoPanelTablero = getHeight(); 
        int anchoPanelTablero = getWidth();
        int altoCasilla = altoPanelTablero / ladoTablero; 
        int anchoCasilla = anchoPanelTablero / ladoTablero; 
        int fila = (int) (y / altoCasilla);
        int columna = (int) (x / anchoCasilla);
        return new int[] { fila, columna };
    }
    @Override
    public void mousePressed(MouseEvent click) {}
    @Override
    public void mouseReleased(MouseEvent click) {}
    @Override
    public void mouseEntered(MouseEvent click) {}
    @Override
    public void mouseExited(MouseEvent click) {}
}
