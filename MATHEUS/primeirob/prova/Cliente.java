package MATHEUS.primeirob.prova;

public class Cliente {
    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }
    public static Cliente buscarPornome(Cliente[] clientes, String busca){
        for (Cliente cliente : clientes) {
            if(cliente != null){
                if (cliente.getNome().contains(busca)) {
                    return cliente;
                }
            }
        }
        System.out.println("este item não foi encontrado, por favor refaça a sua busca");
        return null;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
