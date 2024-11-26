package segundob.listas.lista_tres;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) throws Exception {
        
        CelcoinIntegration celcoinIntegration = new CelcoinIntegration();
        while(true) {

            String opcao = JOptionPane.showInputDialog(null,
            "Escolha uma opção\n[1] Consultar boleto\n[2]Realizar recarga\n[3]Sair",
            "Menu", JOptionPane.INFORMATION_MESSAGE);

            switch (opcao) {
                case "1":
                String linhaDigitavel = JOptionPane.showInputDialog("Insira o número do boleto:");
                String resultadoBoleto = celcoinIntegration.consultarBoleto(linhaDigitavel);
                JOptionPane.showMessageDialog(null, resultadoBoleto, "Resultado da Consulta", JOptionPane.INFORMATION_MESSAGE);
                break;
                case "2":
                    String comprovante = celcoinIntegration.realizarRecarga(53d);

                    JOptionPane.showMessageDialog(null,
                        comprovante,
                        "Comprovante", JOptionPane.INFORMATION_MESSAGE);

                    break;
                case "3":
                    System.err.println("Obrigado por utilizar a aplicação!");

                    return;
            }
        }
    }
    
}
