package PEDRO_ACORDI.primeirobi.prova.src.util;

import java.util.Arrays;

import PEDRO_ACORDI.primeirobi.prova.src.entidades.Cliente;
import PEDRO_ACORDI.primeirobi.prova.src.entidades.Quarto;
import PEDRO_ACORDI.primeirobi.prova.src.entidades.Reserva;

public class ArrayUtil {

    //Array de quartos
    public static Quarto[] adicionar(Quarto[] array, Quarto quarto) {
        if(Arrays.stream(array).count() == array.length ){
            array = expandirArray(array);
        }
        for(int i = 0; i< array.length; i++){
            if(array[i] == null){
                array[i] = quarto;
                break;
            }
        }
        return array;
    }

    private static Quarto[] expandirArray(Quarto[] array){
        return Arrays.copyOf(array, array.length + 1);
    }


    //Array de reservas
    public static Reserva[] adicionar(Reserva[] array, Reserva reserva) {
        Reserva[] novoArray = Arrays.copyOf(array, array.length + 1);
        novoArray[array.length] = reserva;
        return novoArray;
    }

    //Array de Clientes
    public static Cliente[] adicionar(Cliente[] array, Cliente cliente) {
        if(Arrays.stream(array).count() == array.length ){
            array = expandirArray(array);
        }
        for(int i = 0; i< array.length; i++){
            if(array[i] == null){
                array[i] = cliente;
                break;
            }
        }
        return array;
    }

    private static Cliente[] expandirArray(Cliente[] array){
        return Arrays.copyOf(array, array.length + 1);
    }
}
