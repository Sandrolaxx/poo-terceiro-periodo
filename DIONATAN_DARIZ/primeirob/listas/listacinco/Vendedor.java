package DIONATAN_DARIZ.primeirob.listas.listacinco;

public class Vendedor {
    
    String nome;
    int idade;
    double salarioBase;
    String loja;

    double[] salarioRecebido = new double[100];

    void apresentarse(){
        System.out.println("Sou o vendedor " + nome + ", tenho " + idade + " anos e trabalho na " + loja);
    }

    void calcularMedia(){
        double soma = 0;
        double media;

        for(int i = 0; i < salarioRecebido.length; i++){
            soma += salarioRecebido[i];
        }

        media = soma / salarioRecebido.length;

        System.out.println("A média de salários é: " + media);
    }

    void calcularBonus(){
        double bonus = salarioBase * 0.2;
        System.out.println("Seu bônus é: " + bonus);
    }
}
