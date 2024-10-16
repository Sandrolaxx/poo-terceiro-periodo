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

import segundob.listas.listaum.MainUm.MinhaException;
public class MainDois {

    public static void main(String[] args) {

        atvCinco();
        
    }

    public static void atvCinco(){
        JFrame frame = new JFrame("Calculadora");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        List<String> operacoes = List.of("+", "-", "*", "/");

        
        String operacao = (String) JOptionPane.showInputDialog(
                frame,
                "Selecione uma operação:",
                "Calculadora",
                JOptionPane.QUESTION_MESSAGE,
                null,
                operacoes.toArray(),
                operacoes.get(0) 
        );

        if (operacao != null) {
            
            String numUm = JOptionPane.showInputDialog(frame, "Digite o primeiro número:");
            String numDois = JOptionPane.showInputDialog(frame, "Digite o segundo número:");

            try {
                double convertUm = Double.parseDouble(numUm);
                double convertDois = Double.parseDouble(numDois);
                
                double resultado = 0;

                switch (operacao) {
                    case "+":
                        resultado = convertUm + convertDois;
                        break;
                    case "-":
                        resultado = convertUm - convertDois;
                        break;
                    case "*":
                        resultado = convertUm * convertDois;
                        break;
                    case "/":
                        if (convertDois == 0) {
                            throw new MainUm.MinhaException("Divisão por zero não é permitida!");
                        }
                        resultado = convertUm / convertDois;
                        break;
                }

                JOptionPane.showMessageDialog(frame, "O resultado é: " + resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
} catch (NumberFormatException e) {
     throw new MinhaException("Você não colocou um numero");
}
}
    }
}