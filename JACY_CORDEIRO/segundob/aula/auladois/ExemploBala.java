package segundob.aula.auladois;

import java.awt.Color; // Import necessário
import java.awt.event.ActionEvent; // Import da classe ActionEvent
import java.awt.event.ActionListener; // Import da interface ActionListener
import javax.swing.JButton; // Import do JButton
import javax.swing.JFrame; // Import do JFrame
import javax.swing.JLabel; // Import do JLabel
import javax.swing.JPanel; // Import do JPanel
import javax.swing.SwingConstants; // Import de SwingConstants

public class ExemploBala {

    public static void main(String[] args) { 
        // Criando um JFrame
        JFrame frame = new JFrame("Exemplo com JButton e JLabel");
        
        frame.setSize(600, 300); // Tamanho da janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Comportamento padrão ao fechar a janela

        // Criando um JPanel
        JPanel panel = new JPanel(); // Instanciando o painel
        panel.setBackground(Color.LIGHT_GRAY); // Definindo uma cor de fundo para o painel

        // Criando um JLabel
        JLabel label = new JLabel("Clique no botão", SwingConstants.CENTER); // Centralizando o texto
        panel.add(label); // Adicionando o JLabel ao painel

        // Criando um JButton
        JButton button = new JButton("Clique aqui"); // Criando o botão
        panel.add(button); // Adicionando o botão ao painel
        
        // Adicionando um ActionListener ao botão
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Botão clicado!"); // Mudando o texto do JLabel quando o botão é clicado
            }
        });

        // Adicionando o JPanel ao JFrame
        frame.add(panel);
        
        // Exibindo o JFrame
        frame.setVisible(true);
    }
}
