
public class Vendedor {
    private String nome;
    private int idade;
    private double[] salarioRecebido;
    private Loja loja;
    
    private double salarioBase;
    
    private Endereco enderco;

    public Vendedor(String nome, int idade, double[] salarioRecebido, double salarioBase, Endereco endereco){
        this.nome = nome;
        this.idade = idade;
        this.salarioRecebido = salarioRecebido;
        this.salarioBase = salarioBase;
        this.enderco = endereco;
    }

    public void apresentarse(){
        System.out.println("Nome:" + nome + "\nidade:" + idade);
        enderco.apresentarLogradouro();
        if (this.loja != null){    
            this.loja.apresentarse();
        }
    }
    public double calcularMedia(){
        double soma = 0;
        for(double salario : salarioRecebido){
            soma += salario;
        }
        return soma / salarioRecebido.length;
    }
    public double calcularBonus(){
        return salarioBase * 0.2;
    }

    public double getSalarioBase() {
        return salarioBase;
    }
    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }
    public String getNome() {
        return nome;
    }

}