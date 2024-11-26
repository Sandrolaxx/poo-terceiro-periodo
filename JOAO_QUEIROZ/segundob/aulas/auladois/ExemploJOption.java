package segundob.aulas.auladois;

import javax.swing.JOptionPane;

public class ExemploJOption {
    public static void main(String[] args) {
        //Erro
        JOptionPane.showConfirmDialog(null, "Erro ao realizar determinado fluxo!", "Erro!", JOptionPane.ERROR_MESSAGE);

        //Info
        JOptionPane.showConfirmDialog(null, "Informe seu documento!", "Info!", JOptionPane.INFORMATION_MESSAGE);

        //Atenção
        JOptionPane.showConfirmDialog(null, "Atenção! Não foi possível realizar determinado fluxo!", "Atenção!", JOptionPane.WARNING_MESSAGE);
    }
}
