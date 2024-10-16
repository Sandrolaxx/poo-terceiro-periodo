package DIONATAN_DARIZ.segundob.aulas.auladois;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ExemploJBala {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Exemplo"); //nova janela
        frame.setSize(1366, 768); //tamanho da janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//comportamento padrão ao fechar janela

        JPanel panel = new JPanel(); //cria um JPanel
        panel.setBackground(Color.GRAY); //colocar cor de fundo
        JLabel label = new JLabel("Clique no botão"); //criando JLabel
        label.setHorizontalAlignment(SwingConstants.CENTER); //centralizando

        JButton button = new JButton("Clique Aqui"); //criando o JButton

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                boolean isBtnClicado = label.getText().equals("Botão clicado"); //adicionar
                label.setText(isBtnClicado ? "Clique aqui" : "Botão clicado");
            }
        });


        frame.add(panel); //adiciona o JPanel ao JFrame
        panel.add(label); //adiociona o JLabel ao JPanel
        panel.add(button);//adiciona o JBUtton ao JPanel
        frame.setVisible(true); //exibe o JFrame

        
    }
}
