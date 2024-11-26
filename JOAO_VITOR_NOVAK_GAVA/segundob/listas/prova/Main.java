package segundob.listas.prova;

import javax.swing.*;

public class Main {
   
    public static void main(String[] args) {
        // Loop para mostrar o menu até o usuário escolher sair
        while (true) {
            // Exibindo o menu
            String[] options = {"Listar alunos", "Enviar testemunho", "Sair"};
            int choice = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (choice == -1 || choice == 2) {
                System.exit(0); // Sair
            }

            switch (choice) {
                case 0:
                    Podre.listarAlunos(); // Listar alunos
                    break;
                case 1:
                //minha Ra para teste
                //201600142
                    Podre.enviarTestemunho(); // Enviar testemunho
                    break;
                default:
                    break;
            }
        }
    }
}
