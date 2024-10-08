package ENZO_PRADO.primeirob.listas.listasete;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

abstract public class Funcionario extends Pessoa {

    Loja loja;
    double salariBase;
     public List<Double> salarioRecebido = new ArrayList<>();

        public Funcionario(String nome, Integer idade, Endereco endereco, Loja loja, double salariBase, List<Double> salarioRecebido){
            super(nome, idade, endereco);
            this.loja = loja;
            this.salariBase = salariBase;
            this.salarioRecebido = salarioRecebido;
        }
        
        public Loja getloja(){

            return loja;
        }

        public double getsalariBase(){
            return salariBase;
        }

        public List<Double> getsalarioRecebido(){
            return salarioRecebido;
        }

        public void setloja(Loja loja){

            this.loja = loja;
        }

        public void setsalariBase(double salariBase){
            this.salariBase = salariBase;
        }

        public void salarioRecebido(List<Double> salarioRecebido){
            this.salarioRecebido = salarioRecebido;
        }


     void calcularMedia() {
        Locale locale = new Locale("pt", "BR");  
        double soma = 0;
        int count = 0;  
        double media;

    
        for (Double salario : salarioRecebido) {
            soma += salario;
            count++;
        }

            media = soma / count;
        NumberFormat formatador = NumberFormat.getCurrencyInstance(locale);
        System.out.println("A média de salários é: " + formatador.format(media));
    }


    abstract void calcularBonus();


}
