package primeirob.listas.listasete;

public abstract class Funcionario extends Pessoa {
    private static final long serialVersionUID = 1L;

    private Loja loja;
    private double salarioBase;
    private double[] salarioRecebido; // Pelo menos três valores

    public Funcionario(String nome, int idade, Loja loja, Endereco endereco, double salarioBase, double[] salarioRecebido) {
        super(nome, idade, endereco);
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salarioRecebido = salarioRecebido;
    }

    public abstract double calcularBonus();

    @Override
    public void apresentarSe() {
        System.out.println("Funcionário: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("Loja: " + (loja != null ? loja.getNomeFantasia() : "Nenhuma"));
        if (getEndereco() != null) {
            getEndereco().apresentarLogradouro();
        }
    }

    public double calcularMedia() {
        double total = 0;
        for (double salario : salarioRecebido) {
            total += salario;
        }
        return total / salarioRecebido.length;
    }

    // Getters e Setters
    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double[] getSalarioRecebido() {
        return salarioRecebido;
    }

    public void setSalarioRecebido(double[] salarioRecebido) {
        this.salarioRecebido = salarioRecebido;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
               "nome='" + getNome() + '\'' +
               ", idade=" + getIdade() +
               ", loja=" + (loja != null ? loja.getNomeFantasia() : "Nenhuma") +
               ", salarioBase=" + salarioBase +
               ", mediaSalarial=" + calcularMedia() +
               '}';
    }
}
