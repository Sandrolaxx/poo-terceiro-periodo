package primeirob.aulas.aula2;

public class ExemploAcesso {

    // Campos da classe
    private int idade;
    protected int idadeDois;
    protected static final int VALOR_IMUTAVEL = 20; // Constante imutável

    // Construtor padrão
    public ExemploAcesso() {
        // Inicialização padrão, se necessário
    }

    // Construtor com parâmetros
    public ExemploAcesso(int idade, int idadeDois) {
        this.idade = idade;
        this.idadeDois = idadeDois;
    }

    // Métodos getter e setter para idade (opcional)
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getIdadeDois() {
        return idadeDois;
    }

    public void setIdadeDois(int idadeDois) {
        this.idadeDois = idadeDois;
    }

    // Método para exibir informações
    public void exibirInformacoes() {
        System.out.println("Idade: " + idade);
        System.out.println("Idade Dois: " + idadeDois);
        System.out.println("Valor Imutável: " + VALOR_IMUTAVEL);
    }

    // Método principal para testar a classe
    public static void main(String[] args) {
        ExemploAcesso exemplo = new ExemploAcesso(30, 40);
        exemplo.exibirInformacoes();
    }
}
