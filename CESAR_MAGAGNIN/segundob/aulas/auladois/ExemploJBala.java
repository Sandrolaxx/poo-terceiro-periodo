package segundob.aulas.auladois;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ExemploJBala {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Primeiro GUI raiz");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLUE);

        frame.add(panel);

        frame.setVisible(true);

        JLabel label = new JLabel("Clique no botão");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        JButton button = new JButton("Clique aqui");
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isBtnClicado = label.getText().equals("Botão clicado");
                label.setText(isBtnClicado ? "Clique aqui" : " Botão clicado");
            }            
        });
        frame.add(panel);
        panel.add(button);
        panel.add(label);

        frame.add(panel);
        frame.setVisible(true);
    }    
}
