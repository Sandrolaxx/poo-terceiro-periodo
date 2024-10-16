package primeirob.listas.listacinco;
import java.util.ArrayList;

public class Vendedor {
    String nome;
    Integer idade;
    Loja loja;
    String cidade;
    String bairro;
    String rua;
    Double salarioBase;
    ArrayList<Double> salarioRecebido = new ArrayList<>();

    void apresentarse() {
        System.out.println("Olá! Me chamo " + nome + ", tenho " + idade + " anos, e sou vendedor na loja " + loja.nomeFantasia + ".");
    }

    Double calcularMedia() {
        Double soma = 0.0;
        for (Double salario : salarioRecebido) {
            soma += salario;
        }
        return soma / salarioRecebido.size();
    }

    Double calcularBonus() {
        return salarioBase * 0.2;
    }
}
