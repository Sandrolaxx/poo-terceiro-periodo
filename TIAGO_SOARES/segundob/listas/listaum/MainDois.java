package segundob.listas.listaum;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainDois {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lista 1");
    
        // Atv2
        String numeroUm = JOptionPane.showInputDialog(frame, "Informe o primeiro numero!", "Atividade 5 - Calculadora", JOptionPane.QUESTION_MESSAGE);
        String numeroDois = JOptionPane.showInputDialog(frame, "Informe o segundo numero!", "Atividade 5 - Calculadora", JOptionPane.QUESTION_MESSAGE);
        
        int numUm = Integer.parseInt(numeroUm);
        int numDois = Integer.parseInt(numeroDois);
        
       String option = JOptionPane.showInputDialog(frame, "Selecione uma Opção: \n 1 - Soma\n 2 - Subtração\n 3 - Multiplicação\n 4 - Divisão", "Atividade 5 - Calculadora", JOptionPane.QUESTION_MESSAGE);
       int op = Integer.parseInt(option);
       
       switch (op) {
            case 1:
                JOptionPane.showMessageDialog(frame, "A soma dos dois valores e: " + (numUm + numDois), "Atividade 5 - Calculadora", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 2:
                JOptionPane.showMessageDialog(frame, "A subtracao dos dois valores e: " + (numUm - numDois), "Atividade 5 - Calculadora", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 3:
                JOptionPane.showMessageDialog(frame, "A multiplicacao dos dois valores e: " + (numUm * numDois), "Atividade 5 - Calculadora", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 4:
                JOptionPane.showMessageDialog(frame, "A divisão dos dois valores e: " + (numUm / numDois), "Atividade 5 - Calculadora", JOptionPane.INFORMATION_MESSAGE);
                break;
            default:
                JOptionPane.showMessageDialog(frame, "Opção Invalida!", "Atividade 5 - Calculadora", JOptionPane.ERROR_MESSAGE);
                break;
        }

        System.exit(0);
       
    }

}
