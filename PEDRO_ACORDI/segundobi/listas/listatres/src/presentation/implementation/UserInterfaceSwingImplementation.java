package presentation.implementation;

import domain.DTO.ConsultBillsDTO;
import domain.entities.BarCode;
import domain.usecases.ICheckBills;
import domain.usecases.ICheckInstitutions;
import presentation.usecases.IUserInterface;

import javax.swing.*;

public class UserInterfaceSwingImplementation implements IUserInterface {
    private final ICheckBills checkBills;
    private final ICheckInstitutions checkInstitutions;

    public UserInterfaceSwingImplementation(ICheckBills checkBills, ICheckInstitutions checkInstitutions) {
        this.checkBills = checkBills;
        this.checkInstitutions = checkInstitutions;
    }

    @Override
    public void showMenu() {
        String[] options = {
                "Sair",
                "Ver convênios disponíveis (apenas no estado do PR)",
                "Consultar boleto"
        };

        while (true) {
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "O que você deseja fazer?",
                    "Menu",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            if (choice == JOptionPane.CLOSED_OPTION || choice == 0) {
                // Opção 0: Sair ou fechar a janela
                int confirm = JOptionPane.showConfirmDialog(
                        null,
                        "Você realmente deseja sair?",
                        "Confirmação",
                        JOptionPane.YES_NO_OPTION
                );
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
                continue;
            }

            switch (choice) {
                case 1:
                    showInstitutions();
                    break;
                case 2:
                    showBills();
                    break;
                default:
                    JOptionPane.showMessageDialog(
                            null,
                            "Opção inválida. Por favor, tente novamente.",
                            "Erro",
                            JOptionPane.ERROR_MESSAGE
                    );
            }
        }
    }

    @Override
    public String getStringValue(String message) {
        String input;
        do {
            input = JOptionPane.showInputDialog(null, message, "Entrada de Texto", JOptionPane.QUESTION_MESSAGE);
            if (input == null) { // Usuário cancelou
                int confirm = JOptionPane.showConfirmDialog(
                        null,
                        "Deseja cancelar a operação?",
                        "Confirmação",
                        JOptionPane.YES_NO_OPTION
                );
                if (confirm == JOptionPane.YES_OPTION) {
                    return null;
                }
            }
        } while (input != null && (input.trim().isEmpty()));

        return (input != null) ? input.trim() : null;
    }

    @Override
    public void showBills() {
        try {
            String line = getStringValue("Insira a linha digitável do boleto:");
            if (line == null) {
                // Operação cancelada pelo usuário
                return;
            }

            BarCode barCode = new BarCode(0, line.trim());
            ConsultBillsDTO dto = new ConsultBillsDTO(barCode);
            String result = checkBills.checkBills(dto);

            JOptionPane.showMessageDialog(
                    null,
                    result,
                    "Resultado da Consulta de Boleto",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    @Override
    public int getIntegerValue(String message) {
        while (true) {
            String input = JOptionPane.showInputDialog(
                    null,
                    message,
                    "Entrada Numérica",
                    JOptionPane.QUESTION_MESSAGE
            );

            if (input == null) { // Usuário cancelou
                int confirm = JOptionPane.showConfirmDialog(
                        null,
                        "Deseja cancelar a operação?",
                        "Confirmação",
                        JOptionPane.YES_NO_OPTION
                );
                if (confirm == JOptionPane.YES_OPTION) {
                    return -1; // Valor especial para indicar cancelamento
                }
                continue;
            }

            try {
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Entrada inválida. Por favor, insira um número válido.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    @Override
    public void showInstitutions() {
        try {
            String institutions = checkInstitutions.seeInstitutions();
            JOptionPane.showMessageDialog(
                    null,
                    institutions,
                    "Convênios Disponíveis",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
