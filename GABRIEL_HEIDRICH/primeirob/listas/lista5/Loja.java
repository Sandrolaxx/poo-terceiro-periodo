package lista5;

public class Loja {
    private String nomeFantasia;
    private String cnpj;
    private Vendedor[] vendedores;
    private Cliente[] clientes;

    public Loja(String nomeFantasia, String cnpj, Vendedor[] vendedores, Cliente[] clientes) {
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.vendedores = vendedores;
        this.clientes = clientes;
    }

    public int contarClientes() {
        return clientes.length;
    }

    public int contarVendedores() {
        return vendedores.length;
    }

    public void apresentarSe() {
        System.out.println("Nome Fantasia: " + nomeFantasia + ", CNPJ: " + cnpj);
        System.out.println("Endereço da Loja: ");
        for (Cliente cliente : clientes) {
            cliente.apresentarSe(); 
        }
    }
}
