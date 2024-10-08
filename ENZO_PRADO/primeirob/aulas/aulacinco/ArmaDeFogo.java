package ENZO_PRADO.primeirob.aulas.aulacinco;

public class ArmaDeFogo {
    String cor;
    String tamanho;
    String peso;
    String tipo;
    String modelo;
    String recoil;
    String tipoDeDisparo;
    String forcaDeDisparo;
    String som;
    String preco;

public void apresentarArma(){
    String msg = "Modelo: "
    .concat(modelo)
    .concat("\nTipo: ")
    .concat(tipo)
    .concat("\nCor: ")
    .concat(cor)
    .concat("\ntamanho: ")
    .concat(tamanho)
    .concat("\npeso: ")
    .concat(peso)
    .concat("\nPreço: ")
    .concat(preco);

    System.out.println(msg);
}

}

