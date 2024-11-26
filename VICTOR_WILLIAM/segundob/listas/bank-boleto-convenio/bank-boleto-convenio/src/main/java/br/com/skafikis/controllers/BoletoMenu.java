package br.com.skafikis.controllers;

import br.com.skafikis.services.BoletoService;

import javax.swing.*;

public class BoletoMenu {
    public void optionsMenuBoleto() throws Exception {
        try {
            // Solicitando externalTerminal
            String externalTerminal = JOptionPane.showInputDialog("Informe o externalTerminal: ");
            if (externalTerminal == null) {
                JOptionPane.showMessageDialog(null, "Identificador externalTerminal não informado!", "Erro",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            // Solicitando externalNSU
            String externalNSUInput = JOptionPane.showInputDialog("Informe o externalNSU: ");
            if (externalNSUInput == null) {
                JOptionPane.showMessageDialog(null, "Identificador externalNSU não informado!", "Erro",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            Long externalNSU;

            try {
                externalNSU = Long.parseLong(externalNSUInput);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "O identificador externalNSU deve ser numérico!", "Erro",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            // Solicitando type
            String typeInput = JOptionPane.showInputDialog("Informe o externalNSU: ");
            if (typeInput == null) {
                JOptionPane.showMessageDialog(null, "O type deve ser numerico!", "Erro",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            Integer type;

            try {
                type = Integer.parseInt(typeInput);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "O type deve ser numerico!", "Erro",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            // Solicitando barCode
            String digitable = JOptionPane.showInputDialog("Informe o codigo de barras do boleto:");
            if (digitable == null) {
                JOptionPane.showMessageDialog(null, "O codigo de barras do boleto não informado", "Erro",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            // Efetuando consulta
            String value = BoletoService.consultBoleto(externalTerminal,externalNSU,type,digitable);

            //Apresentando resultado formatado
            JOptionPane.showMessageDialog(null, formatValue(value), "Consulta de Boleto",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao consultar o boleto",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // Method formatter(Princess Touch)
    private String formatValue(String value) {
        return value.replace(",", ",\n").replace("{","{\n")
                .replace("}","\n}");
    }
}
