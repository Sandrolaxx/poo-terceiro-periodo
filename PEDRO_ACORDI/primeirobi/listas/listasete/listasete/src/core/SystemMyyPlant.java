package core;
import data.*;
import entities.*;

import java.util.*;

public class SystemMyyPlant {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Criar Loja");
            System.out.println("2. Criar Vendedor");
            System.out.println("3. Criar Cliente");
            System.out.println("4. Criar Gerente");
            System.out.println("5. Criar Item");
            System.out.println("6. Criar Pedido");
            System.out.println("7. Listar Itens");
            System.out.println("8. Procurar por Item");
            System.out.println("9. Listar pedidos");
            System.out.println("10. Consultas");
            System.out.println("11. Confirmar Pagamento de pedido");
            System.out.println("12. Sair");

            int opcao = getNumberInput("Opção");

            switch (opcao) {
                case 1:
                    createStore();
                    break;
                case 2:
                    createSalesPerson();
                    break;
                case 3:
                    createClient();
                    break;
                case 4:
                    createManager();
                    break;
                case 5:
                    createItem();
                    break;
                case 6:
                    createOrder();
                    break;
                case 7:
                    getAllItems();
                    break;
                case 8:
                    searchItem();
                    break;
                case 9:
                    getAllOrders();
                    break;
                case 10:
                    showConsultationMenu();
                    break;
                case 11:
                    confirmPayment();
                    break;
                case 12:
                    continuar = false;
                    System.out.println("Encerrando o sistema.");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    public static void showConsultationMenu() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("Escolha uma opção de consulta:");
            System.out.println("1. Consultar Lojas");
            System.out.println("2. Consultar Vendedores");
            System.out.println("3. Consultar Gerentes");
            System.out.println("4. Consultar Clientes");
            System.out.println("5. Voltar");

            int opcao = getNumberInput("Opção");

            switch (opcao) {
                case 1:
                    getStores();
                    break;
                case 2:
                    getSalesPeople();
                    break;
                case 3:
                    getManagers();
                    break;
                case 4:
                    getClients();
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    private static void createStore() {
        String tradingName = getTextInput("Nome Fantasia da Loja");
        String businessName = getTextInput("Razão Social da Loja");
        String cnpj = getTextInput("CNPJ da Loja");
        Address address = getAddress();

        Store store = new Store(tradingName, businessName, cnpj, address);
        StoresListContainer.add(store);
        System.out.println("Loja criada com sucesso!");
    }

    private static SalesPerson createSalesPerson() {
        String name = getTextInput("Nome do vendedor");
        int age = getNumberInput("Idade do vendedor");

        Store store = selectStore();
        if(store == null){
            System.out.println("Vendedor precisa de uma loja");
            return null;
        }

        Address address = getAddress();
        double grossSalary = getDoubleInput("Salário Base do vendedor");


        SalesPerson salesPerson = new SalesPerson(name, age, address, store, grossSalary);
        store.addSalesPerson(salesPerson);
        System.out.println("Vendedor criado com sucesso!");
        SalesPeopleListContainer.add(salesPerson);
        return salesPerson;
    }

    private static Client createClient() {
        String name = getTextInput("Nome do cliente");
        int age = getNumberInput("Idade do cliente");
        Address address = getAddress();

        Client client = new Client(name, age, address);
        System.out.println("Cliente criado com sucesso!");
        ClientsListContainer.add(client);
        return client;
    }

    private static void createManager() {
        String name = getTextInput("Nome do Gerente");
        int age = getNumberInput("Idade do Gerente");
        Store store = selectStore();
        if(store == null){
            System.out.println("Gerente necessita de uma loja.");
            return;
        }
        Address address = getAddress();
        double grossSalary = getDoubleInput("Salário Base do Gerente");

        Manager manager = new Manager(name, age, address, store, grossSalary);
        System.out.println("Gerente criado com sucesso!");
        ManagersListContainer.add(manager);
    }

    private static Item createItem() {
        int id = ItemsListContainer.getLastId()+1;
        String nome = getTextInput("Nome do Item");
        String tipo = getTextInput("Tipo do Item");
        double valor = getDoubleInput("Valor do Item");

        Item item = new Item(id, nome, tipo, valor);
        System.out.println("Item criado com sucesso!");
        ItemsListContainer.add(item);
        return item;
    }

    private static void createOrder() {
        Client client = selectOrCreateClient();
        if(client == null){
            System.out.println("Pedido necessita de um cliente.");
            return;
        }

        SalesPerson salesPerson = selectSalesPerson();
        if(salesPerson == null){
            System.out.println("Pedido necessita de um vendedor.");
            return;
        }
        Store store = salesPerson.getStore();
        ArrayList<OrderItem> items = new ArrayList<>();
        int opcao;
        do {
            Item item = selectOrCreateItem();
            System.out.println("Qual a quantidade desse item?");
            int qty = getNumberInput("Quantidade do item");
            OrderItem orderItem = new OrderItem(item, qty);
            items.add(orderItem);
            System.out.println("Deseja adicionar mais um item?\n1. Sim\n2. Não");
            opcao = getNumberInput("Opção");
        }while(opcao != 2);

        Order order = OrderProcesser.process( client, salesPerson, store, items );

        System.out.println("Pedido criado com sucesso! Valor total: " + order.getTotalValue() );
    }

    private static void getStores() {
        StoresListContainer.printAllStores();
    }

    private static void getSalesPeople(){
        SalesPeopleListContainer.printAllSalesPeople();
    }

    private static void getManagers(){
        ManagersListContainer.printAllManagers();
    }

    private static void getClients(){
        ClientsListContainer.printAllClients();
    }


    private static void getAllOrders() {
        OrdersListContainer.printAllOrders();
    }

    private static void getAllItems(){
        ItemsListContainer.printAllItems();
    }

    private static Address getAddress() {
        String estado = getTextInput("Estado");
        String cidade = getTextInput("Cidade");
        String bairro = getTextInput("Bairro");
        String complemento = getTextInput("Complemento");

        return new Address(estado, cidade, bairro, complemento);
    }

    private static int getNumberInput(String mensagem) {
        int valor = 0;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print(mensagem + ": ");
                valor = Integer.parseInt(scanner.nextLine());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
            }
        }

        return valor;
    }

    private static double getDoubleInput(String mensagem) {
        double valor = 0;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print(mensagem + ": ");
                valor = Double.parseDouble(scanner.nextLine());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
            }
        }

        return valor;
    }

    private static String getTextInput(String mensagem) {
        String input = "";
        boolean valido = false;

        while (!valido) {
            System.out.print(mensagem + ": ");
            input = scanner.nextLine();
            if (!input.trim().isEmpty()) {
                valido = true;
            } else {
                System.out.println("Entrada inválida. O campo não pode estar vazio.");
            }
        }

        return input;
    }

    private static SalesPerson selectSalesPerson() {
        if(SalesPeopleListContainer.isEmpty())
            return null;

        System.out.println("Selecione o vendedor correspondente:");
        SalesPeopleListContainer.printAllSalesPeople();
        int input = getNumberInput("Número do vendedor");
        return SalesPeopleListContainer.get(input-1);
    }

    private static Store selectStore(){
        if(StoresListContainer.isEmpty())
            return null;

        System.out.println("Selecione a loja correspondente:");
        StoresListContainer.printAllStores();
        int input = getNumberInput("Número da loja");
        return StoresListContainer.get(input-1);
    }

    private static Client selectClient(){
        if(ClientsListContainer.isEmpty())
            return null;

        System.out.println("Selecione o cliente correspondente:");
        ClientsListContainer.printAllClients();
        int input = getNumberInput("Número do cliente");
        return ClientsListContainer.get(input-1);
    }

    private static Client selectOrCreateClient(){
        if(ClientsListContainer.isEmpty())
            return createClient();

        System.out.println("Deseja selecionar ou criar um cliente?\n1. Selecionar\n2. Criar");
        int input;
        Client client = null;
        do{
            input = getNumberInput("Opção");
            switch(input){
                case 1:
                    client = selectClient();
                    break;
                case 2:
                    client = createClient();
                    break;
                default:
                    System.out.println("Opção inválida. Digite novamente: ");
            }
        }while(input != 1 && input != 2);
        return client;
    }

    private static Order selectOpenOrder(){
        if(OrdersListContainer.isEmpty())
            return null;

        System.out.println("Selecione o pedido correspondente:");
        OrdersListContainer.printOpenOrders();
        int input = getNumberInput("Número do Pedido");
        return OrdersListContainer.getOrderById(input);
    }

    private static Item selectItem(){
        if(ItemsListContainer.isEmpty())
            return null;

        System.out.println("Deseja pesquisar ou listar todos?\n1. Pesquisar\n2. Listar todos");
        int input;
        do{
            input = getNumberInput("Opção");
            switch(input){
                case 1:
                    searchItem();
                    break;
                case 2:
                    ItemsListContainer.printAllItems();
                    break;
                default:
                    System.out.println("Opção inválida. Digite novamente: ");
            }
        }while(input != 1 && input != 2);

        System.out.println("Selecione o item correspondente:");
        input = getNumberInput("Número do item");
        return ItemsListContainer.getItemById(input);
    }

    private static void searchItem(){
        System.out.println("Digite o nome ou parte do nome do item: ");
        String input = getTextInput("Nome do item");
        ItemsListContainer.printByName(input);
    }

    private static Item selectOrCreateItem(){
        if(ItemsListContainer.isEmpty())
            return createItem();

        System.out.println("Deseja selecionar ou criar um item?\n1. Selecionar\n2. Criar");
        int input;
        Item item = null;
        do{
            input = getNumberInput("Opção");
            switch(input){
                case 1:
                    item = selectItem();
                    break;
                case 2:
                    item = createItem();
                    break;
                default:
                    System.out.println("Opção inválida. Digite novamente: ");
            }
        }while(input != 1 && input != 2);
        return item;
    }

    private static void confirmPayment(){
        Order order = selectOpenOrder();
        if(order == null){
            System.out.println("Pedido não selecionado.");
            return;
        }

        OrderProcesser.confirmPayment(order);
    }

}

