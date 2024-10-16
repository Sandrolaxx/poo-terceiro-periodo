package ISAQUI_CAMARGO_BARAI.segundob.listas.listaum;

import javax.swing.JOptionPane;

//ATIVIDADE 01
public class MainUm {

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Olá, Mundo!");
    }
}

//ATIVIDADE 02
class AtvDois {
        public static void main(String[] args) {
            
            String nome = JOptionPane.showInputDialog("Por favor, digite seu nome: ");
    
            JOptionPane.showMessageDialog(null, "Bem-vindo, " + nome + "!");
        }

}

//ATIVIDADE 03
class AtvTres {
    public static void main(String[] args) {
        String[] opcoes = {"Opção 01", "Opção 02", "Opção 03"};

        String escolha = (String) JOptionPane.showInputDialog(null,
        "Escolha uma opção",
        "Menu de Opções",
        JOptionPane.QUESTION_MESSAGE,
        null,
        opcoes,
        opcoes[0]);

        if(escolha != null) {
            switch (escolha) {
                case "Opção 01":
                    JOptionPane.showMessageDialog(null, "Você escolheu a Opção 01!");
                    break;
                case "Opção 02":
                    JOptionPane.showMessageDialog(null, "Você escolheu a Opção 02!");
                    break;
                case "Opção 03":
                    JOptionPane.showMessageDialog(null, "Você escolheu a Opção 03!");
                    break;
            }
        }else{
            JOptionPane.showMessageDialog(null, "Nenhuma opção foi escolhida.");
        }
    }
}
    
//ATIVIDADE 04
class Excecao extends Exception{
    public Excecao(String mensagem){
        super(mensagem);
    }
    public void mostrarErro(){
        JOptionPane.showMessageDialog(null, this.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
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