package com.fag.infra.console;

import java.util.Scanner;

import com.fag.domain.repositories.IUserInterface;

public class ConsoleUserInterface implements IUserInterface{

    private Scanner input = new Scanner(System.in);

    @Override
    public Integer showInitalScreenMenu() {
        System.out.println("Banking DaMassa");
        System.out.println("[1] - Login");
        System.out.println("[2] - Cadastro");
        System.out.println("[3] - Sair");

        Integer escolha = input.nextInt();
        
        return escolha;
    }
    
}
