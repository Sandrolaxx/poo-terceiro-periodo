package presentation.implementation;

import domain.DTO.ConsultBillsDTO;
import domain.entities.BarCode;
import domain.usecases.ICheckBills;
import domain.usecases.ICheckInstitutions;
import presentation.usecases.IUserInterface;

import java.util.Scanner;


public class UserInterfaceConsoleImplementation implements IUserInterface {

    private final ICheckBills checkBills;
    private final ICheckInstitutions checkInstitutions;
    private Scanner scanner;

    public UserInterfaceConsoleImplementation(ICheckBills checkBills, ICheckInstitutions checkInstitutions) {
        this.checkBills = checkBills;
        this.checkInstitutions = checkInstitutions;
        scanner = new Scanner(System.in);
    }

    @Override
    public void showMenu() {
        while(true){
            System.out.println("\n=== Menu Principal ===");
            System.out.println("0. Sair.");
            System.out.println("1. Ver convênios disponíveis (apenas no estado do PR).");
            System.out.println("2. Consultar boleto.");
            int option = getIntegerValue("Insira sua opção:");
            switch (option){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    showInstitutions();
                    break;
                case 2:
                    showBills();
                    break;
            }
        }
    }

    @Override
    public String getStringValue(String message) {
        boolean isValid = false;
        String result = null;
        while(!isValid){
            System.out.println(message);
            result = scanner.nextLine();
            if(!result.isEmpty() && !result.isBlank()) isValid = true;
        }
        return result;
    }

    @Override
    public void showBills() {
        try{
            String line = getStringValue("Insira a linha digitável do boleto:");
            BarCode barCode = new BarCode(0, line);
            ConsultBillsDTO dto = new ConsultBillsDTO(barCode);
            System.out.println( checkBills.checkBills(dto) );
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public int getIntegerValue(String message) {
        boolean isValid = false;
        int result = 0;
        while(!isValid){
            System.out.println(message);
            try {
                result = scanner.nextInt();
                scanner.nextLine();
                isValid = true;
            }catch (NumberFormatException e){
                System.out.println("Insira um valor válido para continuar.");
            }
        }
        return result;
    }

    @Override
    public void showInstitutions() {
        try{
            System.out.println( checkInstitutions.seeInstitutions() );
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
