package MURILO_WOLFF.segundob.listas.listaum;
import javax.swing.JOptionPane;
import java.util.List;

public class MainUm {
    public static void main(String[] args) {
        // atividade 1
        atv1();

        // atividade 2
        atv2();

        // atividade 3
        atv3();

        // atividade 4
        atv4();
    }

    public static void atv1() {
        javax.swing.JOptionPane.showMessageDialog(null, "Olá, Mundo!");
    }

    public static void atv2() {
        String nome = JOptionPane.showInputDialog(null, "Digite seu nome:");
        JOptionPane.showMessageDialog(null, "Olá, " + nome + "!");
    }

    public static void atv3() {
        List<Integer> opcoes = List.of(1, 2, 3);

        Integer opcao = (Integer) JOptionPane.showInputDialog(
                null,
                "Selecione uma opção",
                "Selecione opção",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes.toArray(),
                opcoes.toArray()[0]);

        JOptionPane.showMessageDialog(null,
                "Opção selecionada: " + opcao,
                "Opção selecionada",
                0);
    }

    public static void atv4() {
        JOptionPane.showMessageDialog(null, "Erro: Não foi possível realizar a operação", "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
