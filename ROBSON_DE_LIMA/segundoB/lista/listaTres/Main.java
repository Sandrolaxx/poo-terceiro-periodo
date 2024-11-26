package segundoB.lista.listaTres;




import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) throws Exception{
        CelcoinIntegration celcoin = new CelcoinIntegration();

        while (true) {
            String opcao = JOptionPane.showInputDialog(null,
            "[1] Consultar Valores\n[2] Relizar Recarrega\n[3] sair",
            "Menu", JOptionPane.DEFAULT_OPTION);

            int escolha = Integer.parseInt(opcao);
            switch (escolha) {
                case 1:
                    System.out.println("consultando valores");
                    String valores = celcoin.consultarValor();
                    JOptionPane.showMessageDialog(null,
                    valores,"Valores" , JOptionPane.DEFAULT_OPTION);

                    break;
                case 2:
                    System.out.println("recargar de valores");
                    String valor = JOptionPane.showInputDialog(null,
                    "Digite um valor valido","valor",JOptionPane.DEFAULT_OPTION);
                    Double recarga = Double.parseDouble(valor);
                    String comprovante = celcoin.realizarRecarga(recarga);
                    JOptionPane.showMessageDialog(null,
                    comprovante,"Comprovante" , JOptionPane.DEFAULT_OPTION);
                    break;
                case 3:
               System.out.println("Saindo, Obrigado e até Mais!");
                
                return;
                  
            }
        }
    }
}