package JOAO_VITOR_SOUZA.primeirob.listas.listacinco;

public class Vendedor {

        // Atributos
        String nome;
        int idade; // Alterado para int para refletir a idade como um número
        String loja;
        String cidade;
        String bairro;
        String rua;
        Double salarioBase;
        Double[] salarioRecebido; // Array para armazenar os salários recebidos
    
        // Construtor padrão
        public Vendedor() {
        }
    
        // Construtor com parâmetros
        public Vendedor(String nome, int idade, String loja, String cidade, String bairro, String rua, Double salarioBase, Double[] salarioRecebido) {
            this.nome = nome;
            this.idade = idade;
            this.loja = loja;
            this.cidade = cidade;
            this.bairro = bairro;
            this.rua = rua;
            this.salarioBase = salarioBase;
            this.salarioRecebido = salarioRecebido;
        }
    
        // Método para apresentar informações do vendedor
        public void apresentarse() {
            System.out.println("Nome: " + nome);
            System.out.println("Idade: " + idade);
            System.out.println("Loja: " + loja);
        }
    
        // Método para calcular a média dos salários recebidos
        public double calcularMedia() {
            if (salarioRecebido == null || salarioRecebido.length == 0) {
                return 0;
            }
            double soma = 0;
            for (double salario : salarioRecebido) {
                soma += salario;
            }
            return soma / salarioRecebido.length;
        }
    
        // Método para calcular o bônus
        public double calcularBonus() {
            if (salarioBase == null) {
                return 0;
            }
            return salarioBase * 0.2;
        }
    }
    