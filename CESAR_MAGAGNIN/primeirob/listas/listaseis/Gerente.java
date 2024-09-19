
package CESAR_MAGAGNIN.primeirob.listas.listaseis;
// Gerente.java

public class Gerente extends Funcionario {
    private static final long serialVersionUID = 1L;

    // Construtor
    public Gerente(String nome, int idade, Loja loja, Endereco endereco, double salarioBase, double[] salarioRecebido) {
        super(nome, idade, loja, endereco, salarioBase, salarioRecebido);
    }

    // Implementação do método calcularBonus específico para Gerente
    @Override
    public double calcularBonus() {
        return salarioBase * 0.35;
    }

    // Método toString (opcional)
    @Override
    public String toString() {
        return "Gerente{" +
               "nome='" + nome + '\'' +
               ", idade=" + idade +
               ", loja=" + (loja != null ? loja.getNomeFantasia() : "Nenhuma") +
               ", salarioBase=" + salarioBase +
               ", bonus=" + calcularBonus() +
               '}';
    }
}
