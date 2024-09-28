package PEDRO_ACORDI.primeirobi.prova.src.dados;

import PEDRO_ACORDI.primeirobi.prova.src.entidades.Cliente;
import PEDRO_ACORDI.primeirobi.prova.src.util.ArrayUtil;


public class ListaDeClientes {

    private static Cliente[] CLIENTES = new Cliente[0];

    public static void adicionarCliente(Cliente cliente) {
        CLIENTES = ArrayUtil.adicionar(CLIENTES, cliente);
    }

    public static Cliente encontrarClientePorNumero(int numero) {
        if(CLIENTES.length >= numero) {
            return CLIENTES[numero-1];
        }
        return null;
    }


    public static boolean temClientes(){
        return CLIENTES.length > 0;
    }

    public static void listarClientes(){
        if(CLIENTES.length == 0){
            System.out.println("Nenhum cliente encontrado");
            return;
        }
        System.out.println("-------- C L I E N T E S --------");
        for (int i = 0; i < CLIENTES.length; i++) {
            System.out.println( Integer.toString(i+1)
                    .concat(". ")
                    .concat(CLIENTES[i].getNome())
            );
        }
        System.out.println("-------- F I M --------");
    }
}
