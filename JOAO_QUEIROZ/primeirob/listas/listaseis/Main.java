package primeirob.listas.listaseis;

public class Main {
    public static void main(String[] args) {
        
        Gerente gerente = new Gerente();
        gerente.GerenteUm();
        gerente.apresentarSe();
        System.out.println("Média dos salários: " + gerente.calcularMedia());
        System.out.println("Bônus: " + gerente.calcularBonus());

        Endereco endereco = new Endereco();
        endereco.inicializarEndereco();
        endereco.apresentarLogradouro();

        Item item1 = new Item();
        item1.inicializarItem();
        item1.gerarDescricao();

        Pedido pedido = new Pedido();
        pedido.inicializarPedido();
        pedido.itens.add(item1);
        pedido.gerarDescricaoVenda();

        ProcessaPedido processaPedido = new ProcessaPedido(); 
        processaPedido.confirmarPagamento(pedido);
    }
}