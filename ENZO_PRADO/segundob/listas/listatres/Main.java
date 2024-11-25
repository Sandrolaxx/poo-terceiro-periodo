package segundob.listas.listatres;

import java.awt.Dimension;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Main {

    public static void main(String[] args) throws Exception {
        SwingUserInterface swing = new SwingUserInterface();
        CelcoinBassRepository celcoin = new CelcoinBassRepository();

        BankingService bankingService = new BankingService(swing);

        while (true) {
            Integer opcao = bankingService.showMenu();

            System.out.println("Opção escolhida: " + opcao);
switch (opcao) {
    case 1:
        String convenios = celcoin.listarConvenios();
        JTextArea conveniosArea = new JTextArea(convenios);
        conveniosArea.setEditable(false);
        conveniosArea.setLineWrap(true);
        conveniosArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(conveniosArea);
        scrollPane.setPreferredSize(new Dimension(500, 300)); 

        JOptionPane.showMessageDialog(
            null,
            scrollPane,
            "Lista de Convênios",
            JOptionPane.INFORMATION_MESSAGE
        );
        break;

    case 2:
        String linha = JOptionPane.showInputDialog(
            null,
            "Informe a linha do boleto:",
            "Linha do Boleto",
            JOptionPane.INFORMATION_MESSAGE
        );

        if (linha != null && !linha.trim().isEmpty()) {
            try {
                String boleto = celcoin.consultarBoleto(linha);
                JTextArea boletoArea = new JTextArea(boleto);
                boletoArea.setEditable(false);
                boletoArea.setLineWrap(true);
                boletoArea.setWrapStyleWord(true);
                JScrollPane boletoScrollPane = new JScrollPane(boletoArea);
                boletoScrollPane.setPreferredSize(new Dimension(500, 300)); 

                JOptionPane.showMessageDialog(
                    null,
                    boletoScrollPane,
                    "Detalhes do Boleto",
                    JOptionPane.INFORMATION_MESSAGE
                );
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                    null,
                    "Erro ao consultar o boleto: " + ex.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        } else {
            JOptionPane.showMessageDialog(
                null,
                "A linha do boleto não pode estar vazia.",
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        }
        break;

    case 3:
        System.out.println("Saindo...");
        return;

    default:
        System.out.println("Opção inválida. Por favor, escolha novamente.");
        break;
}
        }
    }
}




