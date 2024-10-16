package primeirob.listas.listaseis;

public class Vendedor {

        String nome;
        int idade; 
        String loja;
        String cidade;
        String bairro;
        String rua;
        Double salarioBase;
        Double[] salarioRecebido; 
    
       
        public Vendedor() {
        }
    
        
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
    
        
        public void apresentarse() {
            System.out.println("Nome: " + nome);
            System.out.println("Idade: " + idade);
            System.out.println("Loja: " + loja);
        }
    
       
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
    
        
        public double calcularBonus() {
            if (salarioBase == null) {
                return 0;
            }
            return salarioBase * 0.2;
        }
    }
    