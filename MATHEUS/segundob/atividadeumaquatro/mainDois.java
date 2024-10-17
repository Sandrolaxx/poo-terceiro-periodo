import javax.swing.JOptionPane;
public class mainDois extends mainUm {
    public static void main(String[] args) {
        String opcao = opcoes();
        double result = 0;
        double num1 = adicionaNumero();
        double num2 = adicionaNumero();

        try{
        switch (opcao) {
            case "+":
            result = num1 + num2;
                break;
            case "-":
            result = num1 - num2;
                break;
            case "*":
            result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            }
            exibeResultdado(result);

        }catch(Exception e){
            MinhamensagemDeErro(e);
        }
    }
    public static double adicionaNumero() {
        try{
        double numRecebido = 0;
        String opcao = JOptionPane.showInputDialog(
            null,
            "insira um numero",
            "insira um numero",
            JOptionPane.QUESTION_MESSAGE);
        numRecebido = Double.parseDouble(opcao);
        return numRecebido;
        }catch(Exception e){
            MinhamensagemDeErro(e);
            throw e;
        }
    }
    public  static void exibeResultdado(double result) {
        JOptionPane.showMessageDialog(null,
                "Resultado: " + result,
                "Resultado: ",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
