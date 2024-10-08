package ENZO_PRADO.primeirob.listas.listacinto;

public class TestObjects {
    
    public static void main(String[] args) {
        
        Loja loja = lojaCadastradaUm();

         Vendedor vendedorUm = vendedorCadastradoUm();
         loja.vendedores[0] = vendedorCadastradoUm();

         Vendedor vendedor2 = vendedorCadastradoDois();
         loja.vendedores[1] = vendedorCadastradoDois();

         Cliente clienteUm = clienteCadastradoUm();
         loja.cliente[0] = clienteCadastradoUm();


         System.out.println("------------Informações vendedores------------");
         vendedorUm.apresentarse();
         vendedorUm.calcularMedia();
         vendedorUm.calcularBonus();
         System.out.println("------------------------");
         vendedor2.apresentarse();
         vendedor2.calcularMedia();
         vendedor2.calcularBonus();
        
         System.out.println("------------Informações da Loja------------");
         loja.apresentarse();;
         loja.contarClientes();
         loja.contarVendedores();
         System.out.println("------------Informações Cliente------------");
         clienteUm.apresentarse();

    }


    public static Loja lojaCadastradaUm(){

        Loja loja = new Loja();

        loja.nomeFantasia = "My Planty";
        loja.cidade = "Cascavel";
        loja.razaoSocial = "Plantas dona Gabrielinha LTDA";
        loja.cnpj = "26.880.836/0001-11";
        loja.bairro = "Universitarios";
        loja.rua = "AV. Das Torres";
        loja.numero = 232;
       
       
        return loja;
    }

    public static Vendedor vendedorCadastradoUm(){

        Vendedor vendedor = new Vendedor(); 
        vendedor.nome = "Enzo";
        vendedor.idade = 19;
        vendedor.loja = lojaCadastradaUm();
        vendedor.cidade = "Cascavel";
        vendedor.bairro = " Jardim Paulista ";
        vendedor.rua = "Cuiaba ";
        vendedor.salariBase = 5000;
        vendedor.salarioRecebido = new double[ ]{5000, 5323, 5432};

        return vendedor;
    }


    public static Vendedor vendedorCadastradoDois(){

        Vendedor vendedor2 = new Vendedor(); 
        vendedor2.nome = "Barbara";
        vendedor2.idade = 19;
        vendedor2.loja = lojaCadastradaUm();
        vendedor2.cidade = "Cascavel";
        vendedor2.bairro = " Ciro Nard";
        vendedor2.rua = "Carlos Gomes ";
        vendedor2.salariBase = 8000;
        vendedor2.salarioRecebido = new double[ ]{8000, 8900, 8500};

        return vendedor2;
    }

    public static Cliente clienteCadastradoUm(){

        Cliente clienteum = new Cliente();

        clienteum.nome = "Camille";

        clienteum.idade = 20;
    
        clienteum.cidade = "Cascavel";
    
        clienteum.bairro = "Universitarios";
    
        clienteum.rua = "Carlos dias";
    
        clienteum.numero = 332;

        return clienteum;
    }
}
