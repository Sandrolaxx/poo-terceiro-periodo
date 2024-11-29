package segundob.aulas.auladois;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ExemploJBala {
    public static void main(String[] args) {    
    
    JFrame frame = new JFrame("Exemplo bala do JFrame e JPanel");
    frame.setSize(400,300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel();
    panel.setBackground(Color.BLUE);

    frame.add(panel);

    frame.setVisible(true);
    }

}
