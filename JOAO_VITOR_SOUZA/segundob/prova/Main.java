package segundob.prova;

import javax.swing.JOptionPane;



public class Main {

public static void main(String[] args) throws Exception  {

    Testemunho testemunho  = new Testemunho();

    while (true) {
        String opcao = JOptionPane.showInputDialog(null,
                    "Escolha uma opção\n 1-Listar Alunos\n 2-Fazer um Testemunho\n 3-Sair",
                    "Menu", JOptionPane.INFORMATION_MESSAGE);

            switch (opcao) { 
                case "1":

                
                        String alunos = testemunho.listarAlunos();
                        JOptionPane.showMessageDialog(null,
                                alunos, "Testemunho", JOptionPane.INFORMATION_MESSAGE);



                
                    return;
            case "2": 
            testemunho.criarTestemunho();                
            }

        }
            }
}




                
            
        
    

