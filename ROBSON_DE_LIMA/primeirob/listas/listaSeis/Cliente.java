package ROBSON_DE_LIMA.primeirob.listas.listaSeis;
public class Pessoa {
    protected String nome;
    protected int idade;
    protected Endereco endereco;

    public Pessoa(String nome, int idade, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade);
        endereco.apresentarLogradouro();
    }
}

public class Cliente extends Pessoa {
    private String email;

    public Cliente(String nome, int idade, Endereco endereco, String email) {
        super(nome, idade, endereco);
        this.email = email;
    }
}

public class Vendedor extends Pessoa {
    private double salario;

    public Vendedor(String nome, int idade, Endereco endereco, double salario) {
        super(nome, idade, endereco);
        this.salario = salario;
    }
}

