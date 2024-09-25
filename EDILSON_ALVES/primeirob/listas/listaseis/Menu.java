package EDILSON_ALVES.primeirob.listas.listaseis;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ProcessaPedido processa = new ProcessaPedido();
        Endereco[] enderecos = new Endereco[3];
        Gerente[] gerentes = new Gerente[2];
        Item[] items = new Item[2];
        double[] salarioRecebido = new double[2];
        int opcao = 0;
        int enderecoCount = 0;
        int gerenteCount = 0;
        int itemCount = 0;

        do {
            System.out.println("[1] Adicionar o endereco [2] Adicionar Gerente [3] Cadastrar item [4] Listar items [5] Listar por nome [0] Sair"); 
            opcao = input.nextInt();
            input.nextLine(); 

            switch (opcao) {
                case 1: 
                    if (enderecoCount < enderecos.length) {
                        Endereco endereco = new Endereco();
                        System.out.println("Digite a cidade: ");
                        endereco.setCidade(input.nextLine());

                        System.out.println("Digite um estado: ");
                        endereco.setEstado(input.nextLine());

                        System.out.println("Digite um bairro: ");
                        endereco.setBairro(input.nextLine());
        
                        System.out.println("Digite o número da casa: ");
                        endereco.setNumero(input.nextInt());
                        input.nextLine(); // Consumir a nova linha
        
                        System.out.println("Digite um complemento: ");
                        endereco.setComplemento(input.nextLine());
        
                        enderecos[enderecoCount++] = endereco; 
                        System.out.println("Endereço adicionado com sucesso!");
                    } else {
                        System.out.println("Limite de endereços atingido!");
                    }
                    break;

                case 2:
                    if (gerenteCount < gerentes.length) {
                        Gerente gerente = new Gerente();
                        System.out.println("Digite nome: ");
                        gerente.setNome(input.nextLine());

                        System.out.println("Digite idade: ");
                        gerente.setIdade(input.nextInt());
                        input.nextLine(); 

                        System.out.println("Digite nome da loja: ");
                        gerente.setLoja(input.nextLine());

                        System.out.println("Salário base: ");
                        gerente.setSalarioBase(input.nextDouble());

                        for (int i = 0; i < salarioRecebido.length; i++) {
                            System.out.println("Salário recebido " + (i + 1) + ": ");
                            salarioRecebido[i] = input.nextDouble();
                        }
                        gerente.setSalarioRecebido(salarioRecebido);
                        gerentes[gerenteCount++] = gerente; 
                        System.out.println("Gerente adicionado com sucesso!");
                    } else {
                        System.out.println("Limite de gerentes atingido!");
                    }
                    break;

                case 3:
                    if (itemCount < items.length) {
                        Item item = new Item();
                        System.out.println("--- Cadastro de item --- ");
                        
                        System.out.println("Nome do item: ");
                        item.setNome(input.nextLine());

                        System.out.println("ID do item: ");
                        item.setId(input.nextInt());
                        input.nextLine(); 

                        System.out.println("Tipo do item: ");
                        item.setTipo(input.nextLine());
             
                        System.out.println("Valor do item: ");
                        item.setValor(input.nextDouble());
                        input.nextLine(); 

                        items[itemCount++] = item; 
                        System.out.println("Item cadastrado com sucesso!");
                    } else {
                        System.out.println("Limite de itens atingido!");
                    }
                    break;

                case 4:
                    System.out.println("Lista de Itens:");
                    for (int i = 0; i < itemCount; i++) {
                        System.out.println("--------------");
                        System.out.println("Item nº " + (i + 1) + ":");
                        System.out.println("Nome: " + items[i].getNome());
                        System.out.println("ID: " + items[i].getId());
                        System.out.println("Tipo: " + items[i].getTipo());
                        System.out.println("Valor: " + items[i].getValor());
                        System.out.println("--------------");
                    }
                    break;

                case 5:
                    System.out.println("Digite o nome do item para que ele seja listado: ");
                    String nomeDoItem = input.nextLine();
                    boolean found = false;
                    for (int i = 0; i < itemCount; i++) {
                        if (items[i].getNome().equals(nomeDoItem)) {
                            System.out.println("Item encontrado:");
                            System.out.println("Nome: " + items[i].getNome());
                            System.out.println("ID: " + items[i].getId());
                            System.out.println("Tipo: " + items[i].getTipo());
                            System.out.println("Valor: " + items[i].getValor());
                            found = true;
                            break; 
                        }
                    }
                    if (!found) {
                        System.out.println("Item não encontrado.");
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        input.close();
    }
}



