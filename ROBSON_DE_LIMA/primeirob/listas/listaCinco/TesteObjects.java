package ROBSON_DE_LIMA.primeirob.listas.listaCinco;

public class TesteObjects {
    
    public static void main(String[] args) {
        
        Loja loja = criarLoja();
        Vendedor vendedor1 = criarVendedor1();
        Vendedor vendedor2 = criarVendedor2();
        Cliente cliente = criarCliente();

        loja.adicionarVendedor (vendedor1);
        loja.adicionarVendedor (vendedor2);
        loja.adicionarCliente (cliente);

        loja.apresentarse();
        vendedor1.apresentarse();
        vendedor2.apresentarse();
        cliente.apresentarse();

        System.out.println("Total de Vendedores:  "+ loja.contarVendedores());
        System.out.println("Total de Clientes:  "+ loja.contarClientes());

        System.out.println("Media de Salário do Vendedor 1 :  "+ vendedor1.calcularMedia());
        System.out.println("Bonus do Vendedor 1 :  "+ vendedor1.calcularBonus());


        public static Loja criarLoja(){
            return new Loja("Myy Plant", "Dona Gabrielinha LTDA", "12.345.678/0001-09","Cascavel - PR", "Centro", "Rua das Plantas, 112233");
            
        }
        
    }
}
