package DIONATAN_DARIZ.primeirob.aulas.aulacinco.ArmaDeFogo;

public class ArmaDeFogo {
    
    String cor;
    String peso;
    String modelo;
    String tipo;
    String tamanho;
    String preco;

    public void apresentarArma() {
        String mensagem1 = "Essa é um"
        .concat(tipo);

        String mensagem2 = "\nMais conhecida como"
        .concat(modelo);

        String mensagem3 = "\nSua cor é"
        .concat(cor);

        String mensagem4 = "\nCom um peso de"
        .concat(peso);

        String mensagem5 = "\nSeu tamanho"
        .concat(tamanho);

        String mensagem10 = "\nE por apenas"
        .concat(preco);

        System.out.println(mensagem1 + mensagem2 + mensagem3 + mensagem4 + mensagem5 + mensagem10);

    }
}
