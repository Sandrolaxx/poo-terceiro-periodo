package primeirob.listas.listacinco;

public class Cliente {

    private String rua; 
    private String nome;
    private String cidade;
    private String bairro;
    private int idade;

    public Cliente(String rua, String nome, String cidade, String bairro,int idade){
        this.bairro = bairro;
        this.rua = rua;
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
    }

    public String getrua(){
        return rua;
    }

    public String getcidade(){
        return cidade;
    }

    public String getbairro(){
        return bairro;
    }
    
    public String getnome(){
        return nome;
    }

    public int getidade(){
        return idade;
    }

    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade);
    }

}