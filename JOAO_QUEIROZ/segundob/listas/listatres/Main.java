package segundob.listas.listatres;

import javax.swing.JOptionPane;

public class Main {
    
    public static void main(String[] args) throws Exception {
        CelcoinIntegration celcoinIntegration = new CelcoinIntegration();
        
        while (true) {

            String option = JOptionPane.showInputDialog(null,
            "Escolha uma opção\n[1] Consultar valores\n[2] Realizar recarga\n [3] Sair",
            "Menu", JOptionPane.INFORMATION_MESSAGE);

            switch (option) {
                case "1":
                    System.out.println("Consulta valores provedores");
                    break;
                case "2":

                    String valor = JOptionPane.showInputDialog(null,
                    "Informe o valor da recarga",
                    "Informe", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("Recarga");
                    String comprovante = celcoinIntegration.realizarRecarga(Double.parseDouble(valor));

                    JOptionPane.showMessageDialog(null,
                comprovante,
                "Comprovante", JOptionPane.INFORMATION_MESSAGE);
                    //System.out.println(CelcoinIntegration.genToken());
                    
                    break;
                case "3":
                    System.out.println("Obrigado por utilizar a aplicação!");

                    return;
                default:
                    break;
            }
        }
    }
}
