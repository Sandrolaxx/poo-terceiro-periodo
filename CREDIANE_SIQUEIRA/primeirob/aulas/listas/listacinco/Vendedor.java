package CREDIANE_SIQUEIRA.primeirob.aulas.listas.listacinco;

public class Vendedor {
    String nome;
    int idade;
    String loja;
    String cidade;
    String bairro;
    String rua;
    Double salarioBase;
    Double [] salarioRecebido;

    public void apresentarSe() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Loja: " + loja);
    }

    public double calcularMedia() {
        double soma = 0;
        for (double salario : salarioRecebido) {
            soma += salario;
        }
        return soma / salarioRecebido.length;
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
    }

void apresentarse() {
    System.out.println(nome);
    System.out.println(idade);
    System.out.println(loja);

}

}
