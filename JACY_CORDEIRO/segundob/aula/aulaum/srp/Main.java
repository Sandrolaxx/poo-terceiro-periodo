package segundob.aula.aulaum.srp;


public class Main {

    public static void main(String[] args) {
        Pedido pedido = new Pedido();
        ProcessaPedido processaPedido = new ProcessaPedido();
        PgBanco banco = new PgBanco();
        EnviaEmailConfirmacao enviarEmail = new EnviaEmailConfirmacao();

        pedido = processaPedido.processa(pedido);

        banco.salvar(pedido);

        enviarEmail.executar(pedido);
    }

}