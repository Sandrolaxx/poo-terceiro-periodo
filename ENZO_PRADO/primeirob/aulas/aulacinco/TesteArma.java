package ENZO_PRADO.primeirob.aulas.aulacinco;

public class TesteArma {

    public static void main(String[] args) {
        ArmaDeFogo armaExeplo = new ArmaDeFogo();
        armaExeplo.cor = "preto e vermelho";
        armaExeplo.tamanho = " 152cm";
        armaExeplo.peso = "4,3kg";
        armaExeplo.tipo = "Rifle de precisão";
        armaExeplo.modelo = "AWP 3-900";
        armaExeplo.preco = "5000";


        armaExeplo.apresentarArma();
        
    }
   
}
