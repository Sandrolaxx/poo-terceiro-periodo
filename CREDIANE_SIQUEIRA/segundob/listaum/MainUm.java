package segundob.listaum;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainUm {
    
    public static void main(String[] args) {
        
      JFrame frame = new JFrame("JOptionPane - ShowMessageDialog");

      JOptionPane.showMessageDialog(frame, "Olá, Mundo!!!", "Message",
      JOptionPane.INFORMATION_MESSAGE);

      JOptionPane.showMessageDialog(frame, "Qual é o seu nome?", "Seja bem vindo!!!",
      JOptionPane.QUESTION_MESSAGE);

      String opcao = JOptionPane.showInputDialog(frame, "Selecione uma opção: \n [1] Passar direto" 
      + "\n [2] Fazer recuperação \n [3] Ficar em DP", "Selecione a opção",
      JOptionPane.QUESTION_MESSAGE);

      JOptionPane.showMessageDialog(frame, "Usuário selecionou a opção: " + opcao);

      if (true) {
        throw new CredianeException("Erro ao realizar processo!");
      }
}
}
    
