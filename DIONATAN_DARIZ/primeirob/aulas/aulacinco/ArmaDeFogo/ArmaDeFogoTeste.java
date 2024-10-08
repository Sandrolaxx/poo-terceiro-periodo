package DIONATAN_DARIZ.primeirob.aulas.aulacinco.ArmaDeFogo;

public class ArmaDeFogoTeste {
    public static void main(String[] args) {
        
        ArmaDeFogo armaExemplo = new ArmaDeFogo();

        armaExemplo.cor = " Fever Dream";
        armaExemplo.peso = " 4,3kg";
        armaExemplo.modelo = " AWP";
        armaExemplo.tipo = " Rifle de Precisão";
        armaExemplo.tamanho = " 152 cm";
        armaExemplo.preco = " 4750 ";
    
        armaExemplo.apresentarArma();
    }

}
