package ISAQUI_CAMARGO_BARAI.segundob.aulas.auladois;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ExemploJBala {

    public static void main(String[] args) {
        JFrame frame = new JFrame ("Exemplo show!");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);


        JTextField textField = new JTextField();
        panel.add(textField, BorderLayout.NORTH);


        JTextArea textArea = new JTextArea();


        JLabel label = new JLabel("Valor textField: ");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        
        JButton button = new JButton("Clique Aqui");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerfomed(ActionEvent e) {
                label.setText("Valor textField: " + textField.getText());
            }
        });

        frame.add(panel); //adcionando o JPanel ao JFrame
        panel.add(label, BorderLayout.CENTER); //adicionando o JLabel ao JPanel
        panel.add(button, BorderLayout.SOUTH); //adicionando o JPanel ao JFrame

        frame.add(panel); //adicionando o JPanel ao JFrame

        frame.setVisible(true); //exebindo o JFrame
    }
    
}
