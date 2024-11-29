package primeirob.listas.listasete;

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

    public String getRua(){
        return rua;
    }

    public String getCidade(){ 
        return cidade;
    }

    public String getBairro(){
        return bairro;
    }
    
    public String getNome(){
        return nome;
    }

    public int getIdade(){
        return idade;
    }

    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade);
    }

}