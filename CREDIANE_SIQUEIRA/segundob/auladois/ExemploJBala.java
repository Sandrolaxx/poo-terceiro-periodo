package segundob.auladois;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ExemploJBala {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Exemplo show!");
        frame.setSize(400, 400);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);

        frame.add(panel);

        frame.setVisible(true);
    }
}
