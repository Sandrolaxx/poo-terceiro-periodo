package segundob.listas.listaum;

import java.util.List;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MainUm {

    public static void main(String[] args) {

        atvQuatro("5");
        atvQuatro("oi");
        
    }
    

    public static void atvum(){

        JFrame frame = new JFrame("Exibindo mensagem");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);

        JLabel label = new JLabel("Olá, Mundo");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.GREEN);

        panel.add(label);
        frame.add(panel);
        
        frame.setVisible(true);
    }

    public static void atvdois(){

        JFrame frame = new JFrame("Mensagem de boas vindas");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.GRAY);

        JTextField textField = new JTextField();
        panel.add(textField, BorderLayout.NORTH); 

        JTextArea textArea = new JTextArea();

        JLabel label = new JLabel("Digite seu nome");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.GREEN);


        JButton button = new JButton("Clique após digitar seu nome");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                label.setText("Bem vindo(a): " + textField.getText());
            }
        });

        panel.add(label, BorderLayout.CENTER);
        panel.add(button, BorderLayout.SOUTH);

        frame.add(panel);
        
        frame.setVisible(true);
    }

    public static void atvtres(){

        JFrame frame = new JFrame("Mensagem de boas vindas");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         List<String> selecoes = List.of("Argentia", "Colômbia", "Uruguai", "Brasil", "Equador", "Bolívia", "Venezuela", "Paraguai", "Chile", "Peru");

         List<Integer> posicoes = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9 ,10);
        
        JComboBox<String> comboBox = new JComboBox<>(selecoes.toArray(new String[0]));

        int option = JOptionPane.showConfirmDialog(frame, comboBox, "Selecione uma seleção", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);



        if (option == JOptionPane.OK_OPTION) {
            String selecaoEscolhida = (String) comboBox.getSelectedItem();
            int index = selecoes.indexOf(selecaoEscolhida);
            int posicao = posicoes.get(index);

            JOptionPane.showMessageDialog(frame, "A seleção " + selecaoEscolhida + " está na posição: " + posicao + " nas eliminatorias para copa do Mundo.");
        } else {
            JOptionPane.showMessageDialog(frame, "Nenhum time foi escolhido.");

    }
}


    public static class MinhaException extends RuntimeException {
        private final JFrame frame = new JFrame();

        public MinhaException(String message){
            JOptionPane.showMessageDialog(frame, message, "Erro errado", JOptionPane.ERROR_MESSAGE);
        }
        
    } 
    
    public static void atvQuatro(String numero){
        try{

            int numeroconvertido =  Integer.parseInt(numero);

            System.out.println("O numero é: " + numero);

        } catch (NumberFormatException e){
            throw new MinhaException("Você não colocou um numero");
        }


    }

}