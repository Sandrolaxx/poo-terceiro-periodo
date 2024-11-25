package segundob.listas.listatres;


import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) throws Exception{
        Celcoin celcoin = new Celcoin();

        while (true) {
            String opcao = JOptionPane.showInputDialog(null,"[1] consultar valor\n[2] recarga\n[3] sair","menu", JOptionPane.DEFAULT_OPTION);
            int escolha = Integer.parseInt(opcao);
            switch (escolha) {
                case 1:
                    System.out.println("consultando valores");
                    String valores = celcoin.consultarValor();
                    JOptionPane.showMessageDialog(null, valores,"opcao" , JOptionPane.DEFAULT_OPTION);

                    break;
                case 2:
                    System.out.println("recargar de valores");
                    String valor = JOptionPane.showInputDialog(null,"Digite um valor valido","Digite um valor",JOptionPane.DEFAULT_OPTION);
                    Double recarga = Double.parseDouble(valor);
                    String comprovante = celcoin.realizarRecarga(recarga);
                    JOptionPane.showMessageDialog(null, comprovante,"opcao" , JOptionPane.DEFAULT_OPTION);
                    break;
                case 3:
                    System.out.println("saindo");
                    return;
                  
            }
        }
    }
}
