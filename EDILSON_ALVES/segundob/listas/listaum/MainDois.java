package segundob.listas.listaum;
import javax.swing.JOptionPane;


public class MainDois {
    public static void main(String[] args) {

        boolean continuar = true;
        while(continuar){

        
            String[] tipoOpcao = new String[]{"+", "-", "*", "/"};

           
            int opcao = JOptionPane.showOptionDialog(
                null, 
                "Escolha uma operação:", 
                "Calculadora", 
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, 
                tipoOpcao, 
                tipoOpcao[0]);

            if (opcao >= 0 && opcao < tipoOpcao.length) {
         
                try {
                    String a = JOptionPane.showInputDialog(null, "Digite o primeiro número:", "Entrada", JOptionPane.QUESTION_MESSAGE);
                    double conversao1 = Double.parseDouble(a);

                    String b = JOptionPane.showInputDialog(null, "Digite o segundo número:", "Entrada", JOptionPane.QUESTION_MESSAGE);
                    double conversao2 = Double.parseDouble(b);

                    
                    switch (opcao) {
                        case 0: 
                            soma(conversao1, conversao2);
                            break;
                        case 1: 
                            subtracao(conversao1, conversao2);
                            break;
                        case 2: 
                            multiplicacao(conversao1, conversao2);
                            break;
                        case 3: 
                            divisao(conversao1, conversao2);
                            break;
                        default:
                            break;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, digite um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                continuar = false; 
            }
        }
    }

    // Métodos para as operações
    public static void soma(double a, double b){
        JOptionPane.showMessageDialog(null, "Resultado: " + (a + b), "Resultado da Soma", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void subtracao(double a, double b){
        JOptionPane.showMessageDialog(null, "Resultado: " + (a - b), "Resultado da Subtração", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void multiplicacao(double a, double b){
        JOptionPane.showMessageDialog(null, "Resultado: " + (a * b), "Resultado da Multiplicação", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void divisao(double a, double b){
        if (b != 0) {
            JOptionPane.showMessageDialog(null, "Resultado: " + (a / b), "Resultado da Divisão", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Erro: Divisão por zero não é permitida.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}






































