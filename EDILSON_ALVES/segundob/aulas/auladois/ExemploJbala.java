package segundob.aulas.auladois;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ExemploJbala {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Exemplo show");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.CYAN);

        System.out.println("oi");

        frame.add(panel);
        frame.setVisible(true);

        JLabel label = new JLabel("Clique aqui");

        label.setHorizontalAlignment(SwingConstants.CENTER);

        JButton button = new JButton("clique aqui");

        JTextField textoField = new JTextField();
        panel.add(textoField, BorderLayout.NORTH);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                boolean isBtnClicado = label.getText().equals("Botão clicado");

                label.setText(isBtnClicado ? "clirque" : " botão clicado");
            }
        });

        //frame.add(panel);
        panel.add(label, BorderLayout.CENTER);
        panel.add(button, BorderLayout.SOUTH);
        
        frame.add(panel);

        frame.setVisible(true);
    }
    
  
}
