package MURILO_WOLFF.primeirob.listas.listaseis;

public class Cliente extends Pessoa{
    private Endereco endereco;

    public Cliente(String nome, int idade, Endereco endereco) {
        super(nome, idade);
        this.endereco = endereco;
    }

    public void apresentarse() {
        super.apresentarse();
        endereco.apresentarLogradouro();
    }
}
