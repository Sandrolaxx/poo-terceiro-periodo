package segundob.aulas.listas.listaum;

import javax.swing.JOptionPane;

public class Mensagem {
    public static void main(String[] args) {
        
        String nome = JOptionPane.showInputDialog(null, "Digite seu Nome:");
        JOptionPane.showMessageDialog(null, "Bem Vindo, " + nome + "!");
    }
    
}

