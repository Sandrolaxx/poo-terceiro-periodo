package com.cellcoinapp.controller;

import com.cellcoinapp.service.ConvenioService;
import com.cellcoinapp.service.BoletoService;
import com.cellcoinapp.dto.ConvenioDTO;
import com.cellcoinapp.dto.BoletoDTO;
import javax.swing.*;
import java.util.List;

public class MainController {
    public static void main(String[] args) {
        while (true) {
            String menu = "Escolha uma opção:\n1. Listar Convênios\n2. Consultar Boleto\n3. Sair";
            String option = JOptionPane.showInputDialog(menu);

            if (option == null || option.equals("3")) {
                break;
            }

            if (option.equals("1")) {
                ConvenioService convenioService = new ConvenioService();
                List<ConvenioDTO> convenios = convenioService.listarConvenios();
                StringBuilder convInfo = new StringBuilder();
                for (ConvenioDTO convenio : convenios) {
                    convInfo.append(convenio.toString()).append("\n");
                }
                JOptionPane.showMessageDialog(null, convInfo.toString(), "Convênios", JOptionPane.INFORMATION_MESSAGE);
            } else if (option.equals("2")) {
                String linhaDigitavel = JOptionPane.showInputDialog("Informe a linha digitável:");
                BoletoService boletoService = new BoletoService();
                BoletoDTO boleto = boletoService.consultarBoleto(linhaDigitavel);
                if (boleto != null) {
                    String boletoInfo = "Status: " + boleto.getStatus() + "\n" +
                                        "Vencimento: " + boleto.getVencimento() + "\n" +
                                        "Valor: " + boleto.getValor();
                    JOptionPane.showMessageDialog(null, boletoInfo, "Informações do Boleto", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Boleto não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
