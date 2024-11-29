package JOAO_VITOR_NOVAK_GAVA.JOAO_VITOR_NOVAK_GAVA.primeirob.prova.classes;

public class Cliente {
    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "Cliente: " + nome + ", CPF: " + cpf;
    }
}