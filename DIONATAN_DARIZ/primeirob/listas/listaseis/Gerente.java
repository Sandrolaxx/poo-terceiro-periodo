package DIONATAN_DARIZ.primeirob.listas.listaseis;

public class Gerente extends Humano {
    private String loja;
    private double salarioBase;
    private double[] salarioRecebido = new double[3]; 

    public Gerente(String nome, int idade, String loja, String rua, String bairro, String estado, String complemento, int numero, double salarioBase, double[] salarios) {
        super(nome, idade, rua, bairro, estado, complemento, numero);
        this.loja = loja;
        this.salarioBase = salarioBase;
        
        if (salarios.length >= 3) {
            System.arraycopy(salarios, 0, salarioRecebido, 0, 3);
        }
    }

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public void apresentarse() {
        System.out.println("Nome: " + getNome() + ", Idade: " + getIdade() + ", Loja: " + loja);
        apresentarLogradouro(); 
    }

    public void calcularMedia() {
        double soma = 0;
        for (double salario : salarioRecebido) {
            soma += salario;
        }
        double media = soma / salarioRecebido.length;
        System.out.println("Média dos salários: " + media);
    }

    public void calcularBonus() {
        double bonus = salarioBase * 0.35;
        System.out.println("Bônus: " + bonus);
    }
}
