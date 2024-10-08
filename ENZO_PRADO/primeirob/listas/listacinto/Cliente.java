package ENZO_PRADO.primeirob.listas.listacinto;

public class Cliente {
    String nome;

    int idade;

    String cidade;

    String bairro;

    String rua;

    int numero;

    void apresentarse(){
            System.out.println("Sou o cliente ".concat(nome).concat(" E tenho " + idade + " anos"));
    }
}
