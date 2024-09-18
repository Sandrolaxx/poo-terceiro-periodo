package EDILSON_ALVES.primeirob.listas.listapoo;

import java.util.Arrays;

public class DecimalToRoman {
    public static void main(String[] args) {
        int numero = 245;
        String []valoresDezenas = {"I","II","III","IV","V","VI","VII","VIII","IV","X"};
        String []valoresRomanos = {"M","D","C","L","X"}; 
        int [] numeros = {1000,500,100,50,10};
        int divisao = 0;
        int resto;
        resto = numero;
        String resultado = " ";

        System.out.println("digite um numero");

        for (int i = 0; i < numeros.length; i++) {
            divisao = (resto/numeros[i]);
            if(divisao > 0){
                for (int j = 0; j < numeros.length; j++) {
                    resultado = resultado + valoresRomanos[j];
                 
                }
               
                
            }
        }

    }
}
