package ENZO_PRADO.primeirob.listas.listacinto;

import java.text.NumberFormat;
import java.util.Locale;

public class Vendedor {
    String nome;
    int idade;
    Loja loja;
    String cidade; 
    String bairro;
    String rua;

    double salariBase;

    double[] salarioRecebido = new double[100];

    void apresentarse(){
        System.out.println("Sou o vendedor ".concat(nome).concat("\nTenho: ") + idade + " anos".concat("\nE sou da loja: " ).concat("Nome fantasia: ").concat(loja.nomeFantasia).concat("\nEndereço: Rua ").concat(loja.rua).concat(", Bairro ".concat(loja.bairro).concat(", ") + loja.numero + (", Cidade ").concat(loja.cidade)));
        
    }

    void calcularMedia() {
        Locale locale = new Locale("pt", "BR");  
        double soma = 0;
        int count = 0;  
        double media;
    
     
        for (int i = 0; i < salarioRecebido.length; i++) {
            if (salarioRecebido[i] > 0) {
                soma += salarioRecebido[i];
                count++;
            }
        }
       
            media = soma / count;
        NumberFormat formatador = NumberFormat.getCurrencyInstance(locale);
        System.out.println("A média de salários é: " + formatador.format(media));
    }
    void calcularBonus(){
        Locale locale = new Locale("pt", "BR");  
        double bonus;

        bonus = salariBase * 0.2;

        NumberFormat formatador = NumberFormat.getCurrencyInstance(locale);
        System.out.println("Bonus recebido: " + formatador.format(bonus));

    }

    
}
