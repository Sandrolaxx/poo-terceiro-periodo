package segundoB.aulas.aulaDois;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ExemploJOption {
    public static void main (String[] args){
        JFrame frame = new JFrame("exemplo JOptionPane - ShowMassageDialog");

        JOptionPane.showMessageDialog(frame,
                "Não foi possivel se conectar ao banco, TENTE NOVAMENTE.",
                "IXI MANO DEU BOM NÃO",
                JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(frame,
         "Erro! este aluno Não veio. busque outro!",
        "Erro este nao existe!",
                JOptionPane.WARNING_MESSAGE);

        JOptionPane.showMessageDialog(frame,
                "poxa vida em vocE é insistente em",
                "ERROU , ERROU , ERROU",
                JOptionPane.ERROR_MESSAGE);


        System.exit(0);

    }
}