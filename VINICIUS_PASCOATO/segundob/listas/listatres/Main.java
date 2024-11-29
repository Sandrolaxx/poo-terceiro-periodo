package segundob.listas.listatres;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) throws Exception {
        Celcoin celcoin = new Celcoin();
        while (true) {
            String opcao = JOptionPane.showInputDialog(null, "[1] Consultar Convenios\n[2] Consultar Boletos\n[3] Sair",
                    "Menu", JOptionPane.DEFAULT_OPTION);
            Integer escolha = Integer.parseInt(opcao);
            switch (escolha) {
                case 1:
                    System.out.println("Consultar convenio");
                    String valores = celcoin.listarConvenios();
                    JOptionPane.showMessageDialog(null, valores, "Opcao", JOptionPane.DEFAULT_OPTION);

                    break;
                case 2:
                    String linhaDigitada = JOptionPane.showInputDialog(null, "Digite um codigo de barras",
                            "Codigo de barra", JOptionPane.DEFAULT_OPTION);

                    String valor = celcoin.consultarBoleto(linhaDigitada);
                    JOptionPane.showMessageDialog(null, valor, "Boleto", JOptionPane.DEFAULT_OPTION);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Saindo", "Saindo", JOptionPane.DEFAULT_OPTION);
                    return;
            }
        }
    }
}
