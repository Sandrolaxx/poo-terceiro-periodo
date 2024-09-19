
package CESAR_MAGAGNIN.primeirob.listas.listaseis;
// Vendedor.java

public class Vendedor extends Funcionario {
    private static final long serialVersionUID = 1L;

    // Construtor
    public Vendedor(String nome, int idade, Loja loja, Endereco endereco, double salarioBase, double[] salarioRecebido) {
        super(nome, idade, loja, endereco, salarioBase, salarioRecebido);
    }

    // Implementação do método calcularBonus específico para Vendedor
    @Override
    public double calcularBonus() {
        return salarioBase * 0.15;
    }

    // Método toString (opcional)
    @Override
    public String toString() {
        return "Vendedor{" +
               "nome='" + nome + '\'' +
               ", idade=" + idade +
               ", loja=" + (loja != null ? loja.getNomeFantasia() : "Nenhuma") +
               ", salarioBase=" + salarioBase +
               ", bonus=" + calcularBonus() +
               '}';
    }
}
