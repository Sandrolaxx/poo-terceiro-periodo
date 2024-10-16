public class Cliente {
    private String nome;
    private int idade;
    private String cpf;
    private int sexo;

    public Cliente(String nome, int idade, String cpf, int sexo){
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.sexo = sexo;
    }


    public String getNome(){
        return nome;
    }

    public int getIdade(){
        return idade;
    }

    public String getCpf(){
        return cpf;
    }

    public int getSexo(){
        return sexo;
    }


    public void setNome(String nome){
        this.nome = nome;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void setSexo(int sexo){
        this.sexo = sexo;
    }
    
}
