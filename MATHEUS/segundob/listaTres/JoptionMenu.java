import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import javax.swing.JOptionPane;

public class JoptionMenu {
    public static String opcoes() throws URISyntaxException, IOException, InterruptedException {
        CelCoinIntegration integracao = new CelCoinIntegration();
        Main.token = integracao.getToken();
        System.out.println(Main.token);    
                String escolha = JOptionPane.showInputDialog(null,"Selecione uma opção: \n" + //
                                        " [0] - Sair \n [1] - Listagem de convênios \n [2] - Consulta de Boletos:","Calculadora",JOptionPane.QUESTION_MESSAGE);

             
        if (escolha == null) {
            JOptionPane.showMessageDialog(null, "Operação cancelada.");
            return null;
        }

        switch (escolha) {
            case "1":
                JOptionPane.showMessageDialog(null, "Você escolheu a Opção 1 Listagem de convênios.");
                List<String> operacoes = List.of("ESTADUAL", "FEDERAL(NÃO IMPLEMENTADO)");
                List<String> UF = List.of("AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO");

                
                String operacao = (String) JOptionPane.showInputDialog(
                        null,
                        "Selecione uma operação:",
                        "Calculadora",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        operacoes.toArray(),
                        operacoes.get(0));

                String UfSelecionada = (String) JOptionPane.showInputDialog(
                    null,
                    "Selecione uma operação:",
                    "Calculadora",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    UF.toArray(),
                    UF.get(0));

                JOptionPane.showMessageDialog(null, integracao.listarConvenios(operacao,UfSelecionada));
                break;

            case "2":
                JOptionPane.showMessageDialog(null, "Você escolheu a Opção 2 Consulta de Boletos.");
                String numeroDoBoleto = JOptionPane.showInputDialog(
                    null,
                    "insira no numero do belo a ser consultado",
                    "insira no numero do belo a ser consultado",
                    JOptionPane.QUESTION_MESSAGE);

                JOptionPane.showMessageDialog(null, integracao.consultarBoleto(numeroDoBoleto));
                break;

            case "0":
                JOptionPane.showMessageDialog(null, "Encerrando o programa.");
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                opcoes();
                break;
        }
        return escolha;
    }
}
