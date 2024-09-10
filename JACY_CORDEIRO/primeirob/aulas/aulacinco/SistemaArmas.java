package JACY_CORDEIRO.primeirob.aulas.aulacinco;

public class SistemaArmas {

    public static void main(String[] args) {
        // Criando uma instância da AWP com a skin Fever Dream
        Arma awpFeverDream = new Arma(
            "AWP",
            "Rifle de Sniper",
            "Fever Dream",
            115,        // Dano típico de um tiro de AWP
            0.98,       // Alta precisão
            10          // Capacidade do pente da AWP
        );

        // Exibindo as informações da arma
        System.out.println(awpFeverDream);
    }
}
