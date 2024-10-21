package segundob.listas.listaum;

import javax.swing.JOptionPane;


public class MainUm {
    public static void main(String[] args) {
      
        //ATV1
        olaMundo();

        //ATV2
        boasVindas();

        //ATV3
        opcoes();

        //ATV4
        exececaoPersonalizada();

    }

    public static void olaMundo(){
        JOptionPane.showMessageDialog(null, "Olá, Mundo!", "Olá, Mundo!", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void boasVindas(){
        String boasVindas = JOptionPane.showInputDialog(null,"Digite seu nome","boas vindas",JOptionPane.QUESTION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Bem vindo "+boasVindas, boasVindas, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void opcoes(){
        boolean continuar = true;
        while(continuar){
        

            String[] opcoes = {"Cafe da manha", "Almoço", "Janta", "sair"};
          
            int escolha = JOptionPane.showOptionDialog(
                    null, 
                    "Escolha seu cardapio", 
                    "Cardapio", 
                    JOptionPane.WARNING_MESSAGE, 
                    JOptionPane.QUESTION_MESSAGE, 
                    null, 
                    opcoes, 
                    JOptionPane.QUESTION_MESSAGE);

            switch (escolha) {
                

                case 0:
              JOptionPane.showMessageDialog(null, "Pão|Mortadela|Queijo|Suco|Leite", "Cafe da manha", JOptionPane.INFORMATION_MESSAGE);
                  

                    break;

                case 1:
                JOptionPane.showMessageDialog(null, "Arroz|Feijão|Carne|Batata", "Almoço", JOptionPane.INFORMATION_MESSAGE);
                
                break;

                case 2:
                JOptionPane.showMessageDialog(null, "Macarrão|Lasanha", "Janta", JOptionPane.INFORMATION_MESSAGE);
                break;
                case 3:
                continuar = false;
                break;

            }
        }


    }

    
    public static void exececaoPersonalizada(){
      
       
       try {
            String input = JOptionPane.showInputDialog(null,"Digite algo (não digite nada para execeção)", "EXECEÇÃO", JOptionPane.QUESTION_MESSAGE);
         
            if (input.isEmpty()) {
                throw new ExececaoCustomizada("Nenhuma entrada foi fornecida!");
            }
            System.out.println("Você digitou: " + input);
            } catch (ExececaoCustomizada e) {
            e.printStackTrace();
            }  
   

    }   
}