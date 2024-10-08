package DIONATAN_DARIZ.primeirob.listas.listacinco;

public class Loja {

    String nome;
    String fantasia;
    String cnpj;
    String cidade;
    String bairro;
    String rua;

    Vendedor[] vendedores;
    Cliente[] clientes;

    public void apresentarse(){
        System.out.println("Nome fantasia: " + fantasia);
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Endereço: " + rua + ", " + bairro + ", " + cidade);
    }

    public int contarClientes(){
        int contador = 0;
        for (Cliente cliente : clientes){
            if (cliente != null) {
                contador++;
            }
        }
        return contador;
    }

    public int contarVendedores() {
        int contador = 0;
        for (Vendedor vendedor : vendedores) {
            if (vendedor != null) {
                contador++;
            }
        }
        return contador;
    }
}
