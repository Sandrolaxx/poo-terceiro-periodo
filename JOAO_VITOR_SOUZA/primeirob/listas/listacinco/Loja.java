package JOAO_VITOR_SOUZA.primeirob.listas.listacinco;

import java.util.List;

public class Loja {

    
    String nomeFantasia;
    String razaoSocial;
    String cnpj;
    String cidade;
    String bairro;
    String rua;
    Vendedor[] vendedores;
     List<Cliente> clientes; // Alterado para List para maior flexibilidade

    
    public int contarClientes() {
        return clientes != null ? clientes.size() : 0;
    }

    public void apresentarse() {
        String msg = "Bem-vindo à nossa loja Myy Plant"
                .concat(nomeFantasia)
                .concat("Dona Gabrielinha Comércio de Plantas e Jardinagem Ltda")
                .concat(razaoSocial)

                .concat("50.138.228/0001-10")
                .concat(cnpj)

                .concat("Avenida Tancredo Neves")
                .concat(rua)

                .concat("Centro")
                .concat(bairro)

                .concat("Cascavel")
                .concat(cidade);

                
        System.out.println(msg);
    }
}

