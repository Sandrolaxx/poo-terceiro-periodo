package segundob.listas.listatres;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        while (true) {
            JFrame frame = new JFrame("Lista Tres");

            Celcoin celcoin = new Celcoin();
        
            String opcao = JOptionPane.showInputDialog(frame, 
                "Selicione uma opcão: \n [1] Listagem de convênios" + "\n[2]Consulta de Boletos\n[3]Sair", JOptionPane.QUESTION_MESSAGE);

                switch (opcao) {
                    case "1":
                    JOptionPane.showMessageDialog(frame, celcoin.listarConvenio());
                        
                        break;

                    case "2":
                    String codigodebarra = JOptionPane.showInputDialog(frame, "Informe o codigo de barra");
                    JOptionPane.showMessageDialog(frame, celcoin.consultarBoleto(codigodebarra));

                        break;
                
                    case "3":

                    System.exit(0);
                        break;
                }
            }
    }
}
