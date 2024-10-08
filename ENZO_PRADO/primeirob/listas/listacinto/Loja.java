package ENZO_PRADO.primeirob.listas.listacinto;

public class Loja {

    String nomeFantasia;

    String razaoSocial;

    String cnpj;

    String cidade;

    String bairro;
    
    int numero;

    String rua;

    Vendedor[] vendedores = new Vendedor[100];
    Cliente[] cliente = new Cliente[1000];

    void contarClientes(){

        int contador = 0;

        for(int i = 0; i < cliente.length; i++){
            
            if (cliente[i] != null) {
                contador++;  
            }
           
        }
        System.out.println("A quantidade de clientes da loja são: " + contador);
    }

    void contarVendedores(){
        int contador = 0;

        for(int i = 0; i < vendedores.length; i++){

            if(vendedores[i] != null){
            contador++;
            }
        }
        System.out.println("A quantidade de vendedores da loja são: " + contador);
    }

    void apresentarse(){
        System.out.println("Nome fantasia: ".concat(nomeFantasia).concat("\n CNPJ: ".concat(cnpj).concat("\nEndereço: Rua ".concat(rua).concat(", Bairro ".concat(bairro).concat(", ")+numero + (", Cidade ").concat(cidade)))));
    }
}
