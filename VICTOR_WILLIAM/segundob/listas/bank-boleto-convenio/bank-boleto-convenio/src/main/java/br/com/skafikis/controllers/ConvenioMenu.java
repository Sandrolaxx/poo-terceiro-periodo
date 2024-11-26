package br.com.skafikis.controllers;

import br.com.skafikis.services.ConvenioService;

import javax.swing.*;

public class ConvenioMenu {
    public void optionsMenuConvenio() throws Exception {
        try {
            // Escolhendo o tipo convênio
            String[] types = {"NACIONAL", "ESTADUAL"};

            // Interface
            Integer choice = JOptionPane.showOptionDialog(
                    null,"Escolha um tipo de convênio: ", "Tipo de Convênio",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null,
                    types,types[0]
            );

            if (choice == -1) return;
            String type = types[choice];

            // Garantindo que quando selecionar estadual seja solicitado o UF
            String uf = null;
            if ("ESTADUAL".equalsIgnoreCase(type)) {
                uf = JOptionPane.showInputDialog("Digite a sigla do estado (UF) ou deixe vazio para listar todos: ");
                if (uf == null) {
                    JOptionPane.showMessageDialog(
                            null, "UF não informado!", "Erro",
                            JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }
            }

            // Listando conforme
            String convenios = ConvenioService.listConvenios(type, uf);
            JOptionPane.showMessageDialog(null, convenios, "Convênios", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage(), "Erro ao listar Convênios", JOptionPane.ERROR_MESSAGE);
        }
    }
}
