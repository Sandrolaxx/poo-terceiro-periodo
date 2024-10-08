//package poo_terceiro_periodo.JACY_CORDEIRO.primeirob.listas.listasete; // Descomente e ajuste conforme necessário

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        try {
            // Criar um gerente
            Gerente gerente = new Gerente("Carlos", 40, "Loja Exemplo", 5000.0);
            gerente.apresentarSe();

            // Criar um endereço
            Endereco endereco = new Endereco("SP", "São Paulo", "Centro", "123", "Apto 101", "Rua dos Testes");
            endereco.apresentarLogradouro();

            // Criar um cliente e vendedor
            Cliente cliente = new Cliente("Ana", "123.456.789-00");
            Vendedor vendedor = new Vendedor("Roberto", "V001");

            // Criar itens
            Item item1 = new Item(1, "Produto A", "tipo1", 100.00);
            Item item2 = new Item(2, "Produto B", "tipo2", 150.00);

            // Criar um pedido
            Pedido pedido = new Pedido(1, new Date(), cliente, vendedor, gerente.getLoja());
            pedido.adicionarItem(item1);
            pedido.adicionarItem(item2);

            // Gerar descrição da venda
            System.out.println(pedido.gerarDescricaoVenda());

            // Processar o pedido
            ProcessaPedido processaPedido = new ProcessaPedido();
            Pedido novoPedido = processaPedido.processar(2, new Date(), cliente, vendedor, gerente.getLoja());

            // Confirmar pagamento (Simulando que a reserva não está vencida)
            boolean pagamentoConfirmado = processaPedido.confirmarPagamento(novoPedido);
            if (pagamentoConfirmado) {
                System.out.println("Pagamento confirmado com sucesso!");
            } else {
                System.out.println("Falha ao confirmar pagamento.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ocorreu um erro ao processar o pedido.");
        }
    }
}
