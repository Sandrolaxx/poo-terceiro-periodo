package ISAQUI_CAMARGO_BARAI.segundob.listas.listaum;

import javax.swing.JOptionPane;


//ATIVIDADE 04
class Excecao extends Exception{
    public Excecao(String mensagem){
        super(mensagem);
    }
    public void mostrarErro(){
        JOptionPane.showMessageDialog(null, this.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
    }
}

class Main{
    public static void main(String[] args) {
        try{

            throw new Excecao("Ocorreu um erro personalizado!");
        }catch(Excecao e){
            e.mostrarErro();
        }
        
    }
}


class Calculadora{
    public static void main(String[] args) {
        try{
            String[] opcoes = {"Adição", "Subtração", "Multiplicação", "Divisão"};
            String operacao = (String) JOptionPane.showInputDialog(null, "Escolha a operação:",
                "Calculadora", JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

                if(operacao == null) {
                    throw new Excecao("Nenhuma operação foi selecionada.");
                }

                double num1 = numUm("Digite o primeiro número: ");
                double num2 = numUm("Digite o segundo número: ");

                double resultado = 0;

                switch (operacao) {
                    case "Adição":
                        resultado = num1 + num2;
                        break;
                    case "Subtração":
                        resultado = num1 - num2;
                        break;
                    case "Multiplicação":
                        resultado = num1 * num2;
                        break;
                    case "Divisão":
                        if(num2 == 0){
                            throw new Excecao("Erro: Divisão por zero não é permitida.");
                        }
                        resultado = num1 / num2;
                        break;
                    default:
                        throw new Excecao("Operação inválida.");
                }
                JOptionPane.showMessageDialog(null, "O resultado da " + operacao + " é: " + resultado,
                "Resultado", JOptionPane.INFORMATION_MESSAGE);

        } catch (Excecao e) {
            e.mostrarErro();
        }
    }

    private static double numUm(String mensagem) throws Excecao{
        try{
            String input = JOptionPane.showInputDialog(null, mensagem);
            if (input == null || input.isEmpty()){
                throw new Excecao("ERRO: nenhum número foi digitado.");
            }
            return Double.parseDouble(input);
        }catch(NumberFormatException e){
            throw new Excecao("ERRO: Entrada inválida. Por favor, insira um número válido.");
        }
    }
}

