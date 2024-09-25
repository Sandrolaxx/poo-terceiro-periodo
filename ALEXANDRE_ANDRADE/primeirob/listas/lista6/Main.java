package primeirob.listas.lista6;
import java.util.ArrayList;
import java.util.List;

class Gerente {

    private String nome;
    private double salarioBase;
    private List<Double> salariosRecebidos;

    public Gerente(String nome, double salarioBase) {
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.salariosRecebidos = new ArrayList<>();

        salariosRecebidos.add(3000.0);
        salariosRecebidos.add(3200.0);
        salariosRecebidos.add(3500.0);
    }

    public void apresentar() {
        System.out.println("Gerente: " + nome);
    }

    public double calcularMediaSalario() {
        double total = 0;
        for (double salario : salariosRecebidos) {
            total += salario;
        }
        return total / salariosRecebidos.size();
    }

    public double calcularBonus() {
        return salarioBase * 0.35;
    }
}

class Item {
    private String nome;
    private double valor;

    public Item(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}

class Pedido {
    private List<Item> itens;

    public Pedido() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public double calcularValorTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.getValor();
        }
        return total;
    }
}

public class Main {
    public static void main(String[] args) {

        Gerente gerente = new Gerente("João", 5000);
        gerente.apresentar();
        System.out.println("Média de Salário: " + gerente.calcularMediaSalario());
        System.out.println("Bônus: " + gerente.calcularBonus());

        Pedido pedido = new Pedido();
        pedido.adicionarItem(new Item("Produto A", 150.00));
        pedido.adicionarItem(new Item("Produto B", 300.00));


        System.out.println("Valor Total do Pedido: " + pedido.calcularValorTotal());
    }
}

