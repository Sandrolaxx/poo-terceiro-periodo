package segundob.aula.auladois;



import javax.swing.JOptionPane;

public class ExemploJOption {

    public static void main(String[] args) {

        //Erro
        JOptionPane.showMessageDialog(null,
                "Erro ao realizar determinado fluxo!",
                "Erro!",
                JOptionPane.ERROR_MESSAGE);

        //Info
        JOptionPane.showMessageDialog(null,
                "Informe seu documento!",
                "Info!",
                JOptionPane.INFORMATION_MESSAGE);

        //Atenção
        JOptionPane.showMessageDialog(null,
                "Atenção não foi possível realizar determinado fluxo!",
                "Atenção!",
                JOptionPane.WARNING_MESSAGE);

    }

}