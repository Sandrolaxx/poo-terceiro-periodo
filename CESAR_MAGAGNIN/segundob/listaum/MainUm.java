package segundob.listaum;
import java.util.List;
import javax.swing.JOptionPane;


public class MainUm {
    public static void main(String[] args) {
        // Atividade 1 - Exibir Mensagem
            JOptionPane.showMessageDialog(null, "Olá mundo!","Bem vindo", JOptionPane.INFORMATION_MESSAGE); 
        // Fim Atividade 1
      
        //Atividade 2 - Leitura de dados do usuário
        String opcao = JOptionPane.showInputDialog(
            null,
            "Qual o seu nome?",
            null,
            JOptionPane.QUESTION_MESSAGE);    
            JOptionPane.showMessageDialog(null,"Seja bem vindo " + opcao + "!");
        // Fim atividade 2

        //Atividade 3 - Selecionar opção da Array List
        List<String> Dev=List.of("Leigo","Junior","Pleno","Sênior");
        String nivelDev = (String) JOptionPane.showInputDialog(null,
        "Selecione seu nivel de desenvolvimento de software",
        "Deus te ama " + opcao+ "!",
        JOptionPane.QUESTION_MESSAGE, 
        null,
        Dev.toArray(),
        Dev.toArray()[0]);
        JOptionPane.showMessageDialog(null,"Seu nível de programador é " + nivelDev);
        //Fim atividade 3

        // Atividade 4 - Exceção personalizada
        try {
            String indiceVazio = Dev.get(5);
            System.out.println(indiceVazio);
        } catch (IndexOutOfBoundsException e) {
            new ErrorException("Erro ao acessar o índice 5 da lista Dev: " + e.getMessage());
        }
        //Fim Atividade 4
    }
}