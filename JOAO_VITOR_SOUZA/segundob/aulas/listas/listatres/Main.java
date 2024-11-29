package segundob.aulas.listas.listatres;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) throws Exception {
        Integracao integracao = new Integracao();

        while (true) {
            String opcao = JOptionPane.showInputDialog(null,
                    "Escolha uma opção\n 1-Consultar valores\n 2-Realizar Recarga\n 3-Sair",
                    "Menu", JOptionPane.INFORMATION_MESSAGE);

            switch (opcao) { 
                case "1":
                    try {
                        String valores = integracao.consultarValores();
                        JOptionPane.showMessageDialog(null,
                                "Informações da Consulta:\n" + valores,
                                "Consulta de Valores", 
                                JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null,
                                "Erro ao consultar valores: " + e.getMessage(),
                                "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case "2":
                    String valor = JOptionPane.showInputDialog(null,
                            "Digite o valor da recarga", "Informe", JOptionPane.INFORMATION_MESSAGE);

                    try {
                        String comprovante = integracao.realizarRecarga(Double.parseDouble(valor));
                        JOptionPane.showMessageDialog(null,
                                comprovante, "Comprovante", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null,
                                "Erro ao realizar recarga: " + e.getMessage(),
                                "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case "3":
                    JOptionPane.showMessageDialog(null,
                            "Obrigado por utilizar a aplicação!",
                            "Encerrando", JOptionPane.INFORMATION_MESSAGE);
                    return;

                default:
                    JOptionPane.showMessageDialog(null,
                            "Opção inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
