package segundob.auladois;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.runtime.SwitchBootstraps;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ExemploBala {

    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Exemplo show");
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLUE);

        JLabel label = new JLabel("Clique aqui");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        JButton button = new JButton("Clique aqui");
        button.setVerticalAlignment(SwingConstants.CENTER);

        button.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e){
                boolean isBtnClicado = label.getText().equals("Botão clicado");
                label.setText(isBtnClicado ? "Clique aqui" : "Botão clicado");
                System.out.println("botão clicado");
            }
        });

       
       panel.add(label);
       panel.add(button);
        frame.add(panel);
       
        
        

        frame.setVisible(true);
    }
    
}
