package segundob.listas.listaum;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main extends RuntimeException{

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lista 1");

        // Atv1
        JOptionPane.showMessageDialog(frame, "Olá Mundo!", "Atividade 1", JOptionPane.INFORMATION_MESSAGE);

        // Atv2
        String name = JOptionPane.showInputDialog(frame, "Qual seu nome?", "Atividade 2", JOptionPane.QUESTION_MESSAGE);
        JOptionPane.showMessageDialog(frame, "Olá,  " + name, "Atividade 2", JOptionPane.INFORMATION_MESSAGE);

        // Atv3
        String option = JOptionPane.showInputDialog(frame,
                "Selecione uma Opção: \n 1 - Opção 1\n 2 - Opção 2\n 3 - Opção 3", "Atividade 3",
                JOptionPane.QUESTION_MESSAGE);
        JOptionPane.showMessageDialog(frame, "Opção selecionada: " + option, "Atividade 3",
                JOptionPane.INFORMATION_MESSAGE);


        // Atv4
        showName(name);
        showName(null);
        
        System.exit(0);
    }

    private static void showName(String name){
        try {
            System.out.println(name.toUpperCase());
        } catch (Exception e) {
            throw new exeptionError("Erro na Atividade 4");
        }
    }
}

