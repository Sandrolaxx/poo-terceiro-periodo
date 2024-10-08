package ENZO_PRADO.primeirob.listas.listaseis;

import java.text.NumberFormat;
import java.util.Locale;

public class Vendedor extends Funcionario  {

    Endereco endereco;    

    @Override
    void apresentarse(){
        System.out.println("Sou o vendedor ".concat(nome).concat("\nTenho: ") + idade + " anos"
        .concat("\nE sou da loja: " ).concat(loja.nomeFantasia)); 

    }

    @Override
    void calcularBonus(){
        Locale locale = new Locale("pt", "BR");  
        double bonus;

        bonus = salariBase * 0.2;

        NumberFormat formatador = NumberFormat.getCurrencyInstance(locale);
        System.out.println("Bonus recebido: " + formatador.format(bonus));

    }
}
