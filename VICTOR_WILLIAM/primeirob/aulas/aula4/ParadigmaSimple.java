package VICTOR_WILLIAM.primeirob.aulas.aula4;

import java.util.ArrayList;
import java.util.List;

public class ParadigmaSimple {
    public static void main(String[] args) {

        List<String> nome = List.of(
            "Victor William",
            "Lucas",
            "João",
            "Maria"
        );


        List<String> nomeSemEspaco = new ArrayList<>();
        for (String n : nome) {
            if (!n.contains(" ")) {
                nomeSemEspaco.add(n);
            }
        }


        List<String> nomeSemEspacoTwo = new ArrayList<>();
        nomeSemEspacoTwo = nome.stream()
            .filter(n -> !n.contains(" "))
            .toList();


        List<String> nomeComEspaco = new ArrayList<>();
        for (String n : nome) {
            if (n.contains(" ")) {
                nomeComEspaco.add(n);
            }
        }


        List<String> nomeComEspacoTwo = new ArrayList<>();
        nomeComEspacoTwo = nome.stream()
                .filter(n -> n.contains(" "))
                .toList();

        System.out.println(nomeSemEspaco);
        System.out.println(nomeSemEspacoTwo);

        System.out.println(nomeComEspaco);
        System.out.println(nomeComEspacoTwo);
    }
}
