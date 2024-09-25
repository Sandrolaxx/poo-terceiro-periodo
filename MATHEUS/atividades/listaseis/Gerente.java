public class Gerente extends Vendedor {

    public Gerente(String nome, int idade, double[] salarioRecebido, double salarioBase, Endereco endereco) {
        super(nome, idade, salarioRecebido, salarioBase, endereco);
    }

    
    @Override
    public double calcularBonus() {
        return salarioBase * 0.35;
    }
    
}
