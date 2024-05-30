package uniandes.dpoo.taller7.interfaz2;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


class PanelSuperior extends JPanel {
    private JLabel tamañoLabel;
    private JLabel dificultadLabel;
    private JComboBox<String> tamañoComboBox;
    private JRadioButton fácilRadioButton;
    private JRadioButton medioRadioButton;
    private JRadioButton difícilRadioButton;

    public PanelSuperior() {
    	
        setLayout(new FlowLayout());
     
        tamañoLabel = new JLabel("Tamaño");
        tamañoComboBox = new JComboBox<>(new String[]{"5x5", "6x6", "7x7"}); 
        dificultadLabel = new JLabel("Dificultad");
        fácilRadioButton = new JRadioButton("Fácil");
        medioRadioButton = new JRadioButton("Medio");
        difícilRadioButton = new JRadioButton("Difícil");


        ButtonGroup dificultadGroup = new ButtonGroup();
        dificultadGroup.add(fácilRadioButton);
        dificultadGroup.add(medioRadioButton);
        dificultadGroup.add(difícilRadioButton);

 
        add(tamañoLabel);
        add(tamañoComboBox);
        add(dificultadLabel);
        add(fácilRadioButton);
        add(medioRadioButton);
        add(difícilRadioButton);
    }
}

