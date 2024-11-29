package segundob.prova;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) throws Exception {
            while (true) {
                String option = JOptionPane.showInputDialog(null, 
                "Escolha uma opção:\n[1] Listar alunos\n[2] Enviar testemunho por RA\n[3] Sair", 
                "Menu", 
                JOptionPane.INFORMATION_MESSAGE);
    
                switch (option) {
                    case "1":
                        System.out.println("Listando alunos por RA ...");
                        String alunos = Swagger.consultarAlunos();
                        System.out.println(alunos);
                        JOptionPane.showMessageDialog(null, alunos,"Alunos" , JOptionPane.INFORMATION_MESSAGE);
                    break;

                    case "2": 
                        String testemunhoLoad = new String();
                        String testemunho = Swagger.realizarTestemunho(testemunhoLoad);
                        System.out.println(testemunho);
                        JOptionPane.showMessageDialog(null, "Obrigado pelo testemunho","Testemunho" , JOptionPane.INFORMATION_MESSAGE);
                    break;

                    case "3":
                        System.out.println("Obrigado por utilizar nosso app");
                        JOptionPane.showMessageDialog(null, "Obrigado por utilizar nosso app","Saindo ..." , JOptionPane.INFORMATION_MESSAGE);
                    
                    return;
            }

        }
    }
}