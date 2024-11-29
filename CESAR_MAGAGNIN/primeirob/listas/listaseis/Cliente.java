package primeirob.listas.listaseis;

public class Cliente extends Pessoa {
    private static final long serialVersionUID = 1L;

    public Cliente(String nome, int idade, Endereco endereco) {
        super(nome, idade, endereco);
    }

    @Override
    public void apresentarSe() {
        System.out.println("Cliente: " + getNome());
        System.out.println("Idade: " + getIdade());
        if (getEndereco() != null) {
            getEndereco().apresentarLogradouro();
        }
    }

    @Override
    public String toString() {
        return "Cliente{" +
               "nome='" + getNome() + '\'' +
               ", idade=" + getIdade() +
               ", endereco=" + getEndereco() +
               '}';
    }
}
