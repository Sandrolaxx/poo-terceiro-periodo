package com.fag.infra.swing;

import javax.swing.JOptionPane;

import com.fag.domain.repositories.IUserInterface;

public class SwingUserInterface implements IUserInterface {

    @Override
    public Integer showInitalScreenMenu() {
        String menu = "Banking DaMassa\n" +
                      "[1] - Login\n" +
                      "[2] - Cadastro\n" +
                      "[3] - Sair\n";

        String escolha = JOptionPane.showInputDialog(
            null,
            menu,
            "Menu Inicial do Banco DaMassa",
            JOptionPane.INFORMATION_MESSAGE
            );
            
        return Integer.parseInt(escolha);
    }
    
}
