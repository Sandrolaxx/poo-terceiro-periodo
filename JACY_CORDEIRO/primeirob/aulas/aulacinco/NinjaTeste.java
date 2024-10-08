package JACY_CORDEIRO.primeirob.aulas.aulacinco;

import JACY_CORDEIRO.primeirob.aulas.aulaseis.Ninja;

public class NinjaTeste {
    public static void main(String[] args) {
        // Criando uma instância para o primeiro ninja
        Ninja primeiroNinja = new Ninja(
            "Naruto Uzumaki",
            16,
            "Folha",
            "Shuriken",
            "Rasengan"
        );

        // Criando uma instância para o segundo ninja
        Ninja segundoNinja = new Ninja(
            "Sasuke Uchiha",
            16,
            "Folha",
            "Shuriken",
            "Chidori"
        );

        // Exibindo informações sobre o primeiro ninja
        System.out.println("Informações sobre o primeiro ninja:");
        primeiroNinja.exibirInfo();

        System.out.println("\nInformações sobre o segundo ninja:");
        segundoNinja.exibirInfo();
    }
}
