import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    //Menu
    public static void menu(){
        String[] opcoes = {"Atividade Um", "Atividade Dois", "Atividade Três", "Atividade Quatro", "Atividade Cinco", "Sair"};
        int escolha = 0;
        while(escolha != 5) {
            escolha = JOptionPane.showOptionDialog(null,
                    "Qual atividade você deseja testar?",
                    "Menu",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]
            );
            switch (escolha){
                case 0:
                    atividadeUm();
                    break;
                case 1:
                    atividadeDois();
                    break;
                case 2:
                    atividadeTres();
                    break;
                case 3:
                    atividadeQuatro();
                    break;
                case 4:
                    atividadeCinco();
                    break;
                case 5:
                    break;
            }
        }
    }

    //ATV1
    public static void atividadeUm(){
        JOptionPane.showMessageDialog(null, "Olá, mundo!");
    }

    //ATV2
    public static void atividadeDois(){
        String nome = JOptionPane.showInputDialog(null, "Por favor, insira seu nome:");
        JOptionPane.showMessageDialog(null, "E aí, "+nome+"!");
    }

    //ATV3
    public static void atividadeTres(){
        String[] opcoes = {"As Guerras Acabam", "A Fome Acaba", "PHP e Delphi acabam"};
        int resposta = JOptionPane.showOptionDialog(null,
                "Decide aí",
                "Decisão complicada",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[0]
                );
        switch(resposta){
            case 0:
                JOptionPane.showMessageDialog(null,
                        "Você acabou com as guerras, porém após alguns dias elas voltaram, pois, como disse Rousseau, \"O homem nasce bom, a sociedade o corrompe\". Dessa vez mexer em um ERP com Delphi 7 o corrompeu...",
                        "Resultado",
                        JOptionPane.WARNING_MESSAGE
                );
                break;
            case 1:
                JOptionPane.showMessageDialog(null,
                        "Você acabou com a fome, porém os novos programadores juniores se formando não conseguem emprego porque nenhuma empresa quer contratar um junior. Eles estão ficando cada vez mais famintos...",
                        "Resultado",
                        JOptionPane.WARNING_MESSAGE
                );
                break;
            case 2:
                JOptionPane.showMessageDialog(null,
                        "Agora poderei descansar em um universo agradecido.",
                        "Final feliz",
                        JOptionPane.PLAIN_MESSAGE
                );
                break;
        }
    }
    //ATV 4
    public static void atividadeQuatro(){
        try{
            atividadeQuatroAuxiliar();
        }catch(PedraoException e){
            JOptionPane.showMessageDialog(null,
                    e.getMessage(),
                    "Eita",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private static void atividadeQuatroAuxiliar() throws PedraoException{
        throw new PedraoException("Você caiu numa Exceção do Pedrão");
    }

    //ATV 5
    public static void atividadeCinco(){
        String[] opcoes = {"+", "-", "x", "/"};
        double valor1 = lerValorDouble("Insira o primeiro número para a operação");
        double valor2 = lerValorDouble("Insira o segundo número para a operação");
        int operacao = JOptionPane.showOptionDialog( null,
                "Escolha a operação desejada",
                "Operação",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[0]
        );
        switch (operacao){
            case 0:
                JOptionPane.showMessageDialog( null,
                            "O resultado é: "+(Double.toString(valor1+valor2))
                        );
                break;
            case 1:
                JOptionPane.showMessageDialog( null,
                        "O resultado é: "+(Double.toString(valor1-valor2))
                        );
                break;
            case 2:
                JOptionPane.showMessageDialog( null,
                        "O resultado é: "+(Double.toString(valor1*valor2))
                );
                break;
            case 3:
                JOptionPane.showMessageDialog( null,
                        "O resultado é: "+(Double.toString(valor1/valor2))
                );
                break;
        }
    }

    private static double lerValorDouble(String mensagem){
        boolean valido = false;
        double resultado = 0;
        while(!valido){
            String resposta = JOptionPane.showInputDialog( null,
                    mensagem
            );
            try{
                resultado = Double.parseDouble(resposta);
                valido = true;
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog( null,
                        "Erro: informe um número válido (para pontos flutuantes, utilize como separador decimal o \".\")",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
        return resultado;
    }
}