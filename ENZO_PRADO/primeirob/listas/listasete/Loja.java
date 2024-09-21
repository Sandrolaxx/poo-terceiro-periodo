package ENZO_PRADO.primeirob.listas.listasete;

public class Loja{

    Endereco endereco;

    String nomeFantasia;

    String razaoSocial;

    String cnpj;

    Vendedor[] vendedores = new Vendedor[100];
    Cliente[] cliente = new Cliente[1000];
    Gerente[] gerente = new Gerente[1000];


    void apresentarse(){
        System.out.println("Nome fantasia: ".concat(nomeFantasia).concat("\n CNPJ: ".concat(cnpj)));
        endereco.apresentarLogradouro();
    }

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

    void contarGerentes(){
        int contador = 0;

        for(int i = 0; i < gerente.length; i++){

            if(gerente[i] != null){
            contador++;
            }
        }
        System.out.println("A quantidade de gerentes da loja são: " + contador);
    }

}
