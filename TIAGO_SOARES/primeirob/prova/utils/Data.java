package TIAGO_SOARES.primeirob.prova.utils;

import java.util.Date;

public class Data {
    @SuppressWarnings("deprecation")
    public static void main(String[] args){
        Long umDiaEmMs = 86400000l;
        Date agora = new Date();
        Date dataSemHora = new Date(agora.getYear(), agora.getMonth(), agora.getDate());
        // Year começa em 1900
        Date vinteFevereiro = new Date(124, 01, 20);
        Long vinteFevEpoch = vinteFevereiro.getTime();

        System.out.println(agora.toString());

        System.out.println(dataSemHora.toString());
        
        System.out.println(vinteFevereiro.toString());

        System.out.println(vinteFevEpoch);

        System.out.println(dataSemHora.getTime());

        System.out.println(vinteFevEpoch - dataSemHora.getTime());

        System.out.println((vinteFevereiro.getTime() - dataSemHora.getTime()) / umDiaEmMs);
    }
}
