package MATHEUS.primeirob.atividades.listacinco;
public class Testaobjeto {
        public static void main(String[] args) {
            Endereco enderecoGenerico = new Endereco("esmeralda", "tupiti", "Rua jostelei");    
        
            Loja loja1 = new Loja("Loja 1", "Razão Social 1", "45.789.348/0001-54",enderecoGenerico);
            
            Vendedor vendedor1 = new Vendedor("Vendedor 1", 20, new double[]{1000, 2000,4900}, 2000, enderecoGenerico);
            
            Vendedor vendedor2 = new Vendedor("Vendedor 2", 25, new double[]{1500},2000, enderecoGenerico);
        
            vendedor1.loja = loja1;
            vendedor2.loja = loja1;
        
            loja1.vendedores = new Vendedor[]{vendedor1, vendedor2};
        
            Cliente cliente1 = new Cliente("ian", 40, enderecoGenerico);
        
            loja1.clientes = new Cliente[]{cliente1};
            vendedor2.apresentarse();
    }
    
}
