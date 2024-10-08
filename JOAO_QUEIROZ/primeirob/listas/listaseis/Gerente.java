package primeirob.listas.listaseis;


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
    
}
