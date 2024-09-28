package JOAO_QUEIROZ.primeirob.prova;

public class Cliente {

    private String nome;
    private String cpf;

    public Cliente(String nome, String rua){ 
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome(){
        return nome;
    }
    public String getCpf() {
        return cpf;
    }

    public void cadastro() {
        System.out.println("Nome: " + nome + "\nCPF: " + cpf);
    }    
}
