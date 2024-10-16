package segundoB.aulas.aulaDois;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class exemploJbala {

public static void main(String[] args) {
    
    JFrame frame = new JFrame("Janela Test!");
    frame.setSize(400,400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel();
    panel.setBackground(Color.red);

    JTextField textField = new JTextField();
    panel.add(textField, BorderLayout.NORTH);

    JTextArea textArea = new JTextArea();
    //panel.add(textArea, BorderLayout.NORTH);
    
    JLabel label = new JLabel("Clique");
    label.setHorizontalAlignment(SwingConstants.CENTER);

    JButton button = new JButton("Clique Aqui");

    button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            boolean isBtnClicado = label.getText().equals("Botao Clicado");
            label.setText(isBtnClicado ? "Clique Aqui": "Botao Clicado");
        }
    });
    panel.add(label,BorderLayout.CENTER);
    panel.add(button, BorderLayout.SOUTH);

    frame.add(panel);

    frame.setVisible(true);


}
}
