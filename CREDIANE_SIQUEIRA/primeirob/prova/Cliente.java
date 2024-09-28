package CREDIANE_SIQUEIRA.primeirob.prova;

public class Cliente {
    private String nome;
    private String numerodeTelefone;
    private String cpf;

    public Cliente(String nome, String numeroTelefone, String cpf, String endereco) {
        this.nome = nome;
        this.numerodeTelefone = numeroTelefone;
        this.cpf = cpf;

    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getnumeroTelefone(String numeroDeTelefone){
        return numeroDeTelefone;
    }

    public void setnumeroDeTelefone(String numeroDeTelefone){
        this.numerodeTelefone = numeroDeTelefone;
    }

    public String getcpf(){
        return cpf;
    }

    public void setcpf(String cpf){
        this.cpf = cpf;
    }

    public void apresentarse() {
        System.out.println(", Nome: " + nome + ", Numero de telefone: " + numerodeTelefone + ", CPF: " + cpf);
}
}