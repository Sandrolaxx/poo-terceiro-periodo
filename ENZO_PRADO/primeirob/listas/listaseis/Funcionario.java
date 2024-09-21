package ENZO_PRADO.primeirob.listas.listaseis;

import java.text.NumberFormat;
import java.util.Locale;

abstract public class Funcionario extends Pessoa {

    Loja loja;
    double salariBase;
    double[] salarioRecebido = new double[100];


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


    abstract void calcularBonus();


}
