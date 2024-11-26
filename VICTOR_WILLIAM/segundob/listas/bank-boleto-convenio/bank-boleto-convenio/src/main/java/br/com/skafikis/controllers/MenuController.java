package br.com.skafikis.controllers;

import br.com.skafikis.services.BoletoService;

import javax.swing.*;

import static br.com.skafikis.services.ConvenioService.listConvenios;

public class MenuController {
    public void menuController() throws Exception {
        ConvenioMenu convenioMenu = new ConvenioMenu();
        BoletoMenu boletoMenu = new BoletoMenu();

        while (true) {
            String[] options = {"Listar Convênios", "Consultar Boleto", "Sair"};

            Integer choice = JOptionPane.showOptionDialog(
                    null, "Escolha uma opção do menu: ", "Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                    options,
                    options[0]
            );

            switch (choice) {
                case 0 -> {
                    System.out.println("Consultando Convênios Patron...");
                    convenioMenu.optionsMenuConvenio();
                }
                case 1 -> {
                    System.out.println("Consultar Boleto Patron");
                    boletoMenu.optionsMenuBoleto();
                }
                case 2 -> {
                    System.out.println("Saindo Patron...");
                    System.exit(0);
                }
                default -> JOptionPane.showMessageDialog(
                        null, "Desculpe, opção invalida", "Erro",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }
}
