package JACY_CORDEIRO.primeirob.listas.listaseis;

public class Cliente {
    private String nome;
    private String cpf;
    private Endereco endereco;

    public Cliente(String nome, String cpf, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public void apresentarCliente() {
        System.out.println("Cliente: " + nome + ", CPF: " + cpf);
        endereco.apresentarLogradouro();
    }
}



