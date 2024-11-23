package CREDIANE_SIQUEIRA.segundob.listatres;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        while (true) {
            JFrame frame = new JFrame("Lista tres");

            String opcao = JOptionPane.showInputDialog(frame,
                    "[1] Listagem de convenios: \n [2] Consulta de boletos: \n [3] Sair", "Selecione a opcao ",
                    JOptionPane.QUESTION_MESSAGE);

            Api api = new Api();

            switch (opcao) {
                case "1":
                    JOptionPane.showMessageDialog(frame, api.ListagemDeConvenios(), "Listagem de Convenios", 0);
                    break;

                case "2":
                    String linhadigitavel = JOptionPane.showInputDialog(frame, "Digite o codigo de barras",
                            JOptionPane.QUESTION_MESSAGE);
                    JOptionPane.showMessageDialog(frame, api.ConsultaDeBoletos(linhadigitavel), "Consulta de boletos",
                            0);
                    break;

                case "3":
                    System.exit(0);
                    return;
            }
        }

    }
}
