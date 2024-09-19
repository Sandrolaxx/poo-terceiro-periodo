package JOAO_QUEIROZ.primeirob.listas.listaseis;

/*- Com os atributos nome, idade, Loja, cidade, bairro, rua, salarioBase e salarioRecebido.
- Atributo salarioRecebido DEVE armazenar no mínimo três valores de lançamentos de salário.(Pode colocar no código os valores*)
- Métodos apresentarse calcularMedia e calcularBonus.
- Método apresentarse deve printar o nome, idade e Loja.
- calcularMedia deve trazer a média dos salários.
- calcularBonus onde a fórmula é [salarioBase * 0.35]. */

public class Gerente {
    public String nome;
    public int idade;
    public String loja;
    public String cidade;
    public String bairro;
    public String rua;
    public double salarioBase;
    public double[] salarioRecebido = new double[3];

    public void GerenteUm() {
        nome = "Sandro";
        idade = 35;
        loja = "Sandro Company";
        cidade = "Cascavel";
        bairro = "Country";
        rua = "Avenida Company";
        salarioBase = 4000.00;
        salarioRecebido[0] = 1000.00;
        salarioRecebido[1] = 1000.00;
        salarioRecebido[2] = 1000.00;

    }

    public void apresentarSe() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja);
    }
    public double calcularMedia() {
        double soma = 0;
        for (double salario : salarioRecebido) {
            soma += salario;
        }
        return soma / salarioRecebido.length;

    }

    public double calcularBonus() {
        return salarioBase * 0.35;
    }
    /*public Gerente(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase, double salarioRecebido) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
        this.salarioRecebido = salarioRecebido;
    }*/
    
}
