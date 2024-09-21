package ROBSON_DE_LIMA.primeirob.listas.listaSeis;
 
import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Pessoa {
    private String loja;
    private double salarioBase;
    private List<Double> salariosRecebidos = new ArrayList<>();

    public Vendedor(String nome, int idade, Endereco endereco, String loja, double salarioBase) {
        super(nome, idade, endereco);
        this.loja = loja;
        this.salarioBase = salarioBase;
    }

    public void adicionarSalario(double salario) {
        if (salariosRecebidos.size() < 3) {
            salariosRecebidos.add(salario);
        } else {
            System.out.println("Já foram registrados três lançamentos de salário.");
        }
    }

    @Override
    public void apresentarse() {
        super.apresentarse();
        System.out.printf("Loja: %s%n", loja);
    }

    public double calcularMedia() {
        return salariosRecebidos.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
    }
}

