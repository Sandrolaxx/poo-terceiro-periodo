import javax.swing.JOptionPane;
import java.util.List;

public class mainUm {

    public static void main(String[] args) {
        //descomente para testar
        //olamundo();
        //coloqueSeuNome();
        //opções();
        //erro(null);

    }
    //Codigo da atividade um
    public  static void olamundo() {
        JOptionPane.showMessageDialog(null,
                "Olá Mundo",
                "Info!",
                JOptionPane.INFORMATION_MESSAGE);
    }
    //codigo da atividade dois
    public static void coloqueSeuNome() {

            String opcao = JOptionPane.showInputDialog(
                    null,
                    "insira o seu nome",
                    "insita seu nome",
                    JOptionPane.QUESTION_MESSAGE);
    
            JOptionPane.showMessageDialog(null,
                    "Boas vindas " + opcao,
                    "Mensagem de boas vindas",
                    JOptionPane.INFORMATION_MESSAGE);
    }
    //codigo da atividade três
    public static String opcoes() {
            
        
        List<String> operacoes = List.of("+", "-", "*", "/");
        
                
                String operacao = (String) JOptionPane.showInputDialog(
                        null,
                        "Selecione uma operação:",
                        "Calculadora",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        operacoes.toArray(),
                        operacoes.get(0));
    
        JOptionPane.showMessageDialog(null,
        "Opção selecionada " + operacao,
        "Opção selecionada",
        JOptionPane.INFORMATION_MESSAGE);

        return operacao;
    }
        
    
    public static void MinhamensagemDeErro(Exception e){
        JOptionPane.showMessageDialog(null,
        e.toString(),
        "Erro!",
        JOptionPane.ERROR_MESSAGE);
    }
    //codigo da atividade quatro
    public static void erro(String numero) {
        try{
            int numeroConvertido = Integer.parseInt(numero);

            System.out.println(numeroConvertido);

        }catch(Exception e){
            MinhamensagemDeErro(e);
        }
    }
}