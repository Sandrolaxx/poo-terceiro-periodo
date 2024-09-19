package EDILSON_ALVES.primeirob.listas.listaseis;

public class Menu {
    public static void main(String[] args) {
        System.out.println("\n\n---Criar pedido---\n");
        


        ProcessaPedido processa = new ProcessaPedido();
        Endereco endereco = new Endereco("parana", "cascavel", "pioneiro", 231, "casa");
        int []salario = new int[]{1222, 525};
        Gerente gerente = new Gerente("edilson", 14, "lojinha feliz", endereco, 4500, salario);

        System.out.println("---Gerente---");
        gerente.imprime();
        System.out.println();
        System.out.println("---Pedido---");
        processa.processar();
        System.out.println("---------------");
    }
}
