package PEDRO_ACORDI.primeirobi.prova.src.dados;

import PEDRO_ACORDI.primeirobi.prova.src.entidades.Quarto;
import PEDRO_ACORDI.primeirobi.prova.src.entidades.Reserva;
import PEDRO_ACORDI.primeirobi.prova.src.util.ArrayUtil;

public class ListaDeQuartos {

    private static Quarto[] QUARTOS = new Quarto[0];

    public static void adicionarQuarto(Quarto quarto) {
        QUARTOS = ArrayUtil.adicionar(QUARTOS, quarto);
    }

    public static Quarto encontrarQuartoPorNumero(int numero) {
        for (int i = 0; i < QUARTOS.length; i++) {
            if (QUARTOS[i].getNumero() == numero) {
                return QUARTOS[i];
            }
        }
        return null;
    }

    public static boolean reservarQuarto(Quarto quarto, Reserva reserva){
        if(quarto == null) return false;

        return quarto.reservarQuarto(reserva);
    }

    public static boolean temQuartos(){
        return QUARTOS.length > 0;
    }

    public static void listarQuartos(){
        if(QUARTOS.length == 0){
            System.out.println("Nenhum quarto encontrado");
            return;
        }
        System.out.println("-------- Q U A R T O S --------");
        for (int i = 0; i < QUARTOS.length; i++) {
            System.out.println( Integer.toString(QUARTOS[i].getNumero())
                    .concat(". ")
                    .concat(QUARTOS[i].getDescricao())
            );
        }
        System.out.println("-------- F I M --------");
    }
}
