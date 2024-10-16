package segundob.aulas.listas.listaum;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class OpcoesAtv3 {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Atividade 3 - Opções");
        List<String> opcoesLista = List.of("Opção 1", "Opção 2", "Opção 3");

        String opcaoSelecionada = (String) JOptionPane.showInputDialog(frame,
                "Selecione uma das opções",
                "Atividade 3",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoesLista.toArray(),
                opcoesLista.get(0));

        if (opcaoSelecionada != null) {
            JOptionPane.showMessageDialog(frame, "A Opção selecionada é a " + opcaoSelecionada);
        } else {
            JOptionPane.showMessageDialog(frame, "Nenhuma opção foi selecionada");
        }
    }
}

