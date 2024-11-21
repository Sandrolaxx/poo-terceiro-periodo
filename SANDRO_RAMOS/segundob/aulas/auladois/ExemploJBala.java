package segundob.aulas.auladois;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ExemploJBala {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Exemplo show!");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());//New Layout
        panel.setBackground(Color.LIGHT_GRAY);

        JLabel label = new JLabel("Clique no botão");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);

        JTextField textField = new JTextField();

        JButton button = new JButton("Clique aqui");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Cliquei!!" + textField.getText());
            }
        });
        
        //ADICIONAR NO CONTAINER
        panel.add(textField, BorderLayout.NORTH);
        panel.add(label, BorderLayout.CENTER);
        panel.add(button, BorderLayout.SOUTH);

        frame.add(panel);

        frame.setVisible(true);
    }

}
