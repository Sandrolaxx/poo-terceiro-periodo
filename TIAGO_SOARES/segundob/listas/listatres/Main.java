package segundob.listas.listatres;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        
        while (true) {
            String choice = JOptionPane.showInputDialog(null, "Selecione uma opção: \n[1] Listagem de convênios\n[2] Consulta de Boletos\n[3] Sair", JOptionPane.QUESTION_MESSAGE);
            
            int choiceInt = Integer.parseInt(choice);
            
            Cellcoin cellcoin = new Cellcoin();
            
            switch (choiceInt) {
                case 1:
                JOptionPane.showMessageDialog(null, cellcoin.getConvenants());
                break;
                case 2:
                    String barcode = JOptionPane.showInputDialog(null, "Informe o codigo de barras para ser consultado", JOptionPane.QUESTION_MESSAGE);
                    JOptionPane.showMessageDialog(null, cellcoin.getAccountData(barcode));
                    break;
                case 3:
                    System.exit(0);
                    return;
            }
        }
    }
}
