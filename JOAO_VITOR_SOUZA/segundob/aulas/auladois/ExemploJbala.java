package segundob.aulas.auladois;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExemploJbala {

    public static void main(String[] args) {
        
        JFrame frame = new JFrame( "Exemplo Show");

        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLUE);

        JLabel label = new JLabel("Nome");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        

        JButton button = new JButton("Clique Aqui");

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Cliquei no btn");
            }
            
        });

        frame.add(panel);
        panel.add(label);
        panel.add(button);

        frame.setVisible(true);
    }
}
