package primeirob.aulas.aula2;

public class EstruturaControle {
    public static void main(String[] args) {
        int valor = 9;

        // Estrutura de controle if-else
        if (valor > 6) {
            System.out.println("Yess!");
        }

        if (valor > 12) {
            System.out.println("Yess 1!");
        } else if (valor > 14) {
            System.out.println("Yess 2!");
        } else if (valor > 16) {
            System.out.println("Yess 3!");
        } else if (valor > 17) {
            System.out.println("Yess 4!");
        } else {
            System.out.println("Não é maior que nada!");
        }

        // Estrutura de controle switch
        switch (valor) {
            case 9:
            case 3:
                System.out.println("É nove ou três!");
                break;
            case 4:
                System.out.println("É quatro!");
                break;
            default:
                System.out.println("Padrão!");
                break;
        }
    }
}
