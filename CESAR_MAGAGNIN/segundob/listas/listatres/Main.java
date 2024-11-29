package segundob.listas.listatres;

import javax.swing.JOptionPane;

public class Main {

    static CelcoinIntegration celcoinIntegration = new CelcoinIntegration();
    
        public static void main(String[] args) throws Exception {
            while (true) {
                String option = JOptionPane.showInputDialog(null, 
                "Escolha uma opção:\n[1] Consultar valores\n[2] Realizar recarga\n[3] Sair", 
                "Menu", 
                JOptionPane.INFORMATION_MESSAGE);
    
                switch (option) {
                    case "1":
                        System.out.println("Consultando valores provedores ...");
                        String valores = celcoinIntegration.consultarValor();
                        System.out.println(valores);
                        JOptionPane.showMessageDialog(null, valores,"Valores" , JOptionPane.INFORMATION_MESSAGE);
                    break;

                    case "2": 
                        System.out.println("Recarregando...");
                        String valor = JOptionPane.showInputDialog(null,"Digite um valor valido","Digite um valor",JOptionPane.INFORMATION_MESSAGE);
                        Double recarga = Double.parseDouble(valor);
                        String comprovante = celcoinIntegration.realizarRecarga(recarga);
                        System.out.println(comprovante);
                        JOptionPane.showMessageDialog(null, comprovante,"Opção" , JOptionPane.INFORMATION_MESSAGE);
                    break;

                    case "3":
                        System.out.println("Obrigado por utilizar nosso app");
                    
                    return;
            }

        }

    }

}
