package ENZO_PRADO.primeirob.listas.listaseis;

import java.text.NumberFormat;
import java.util.Locale;

abstract public class Pessoa {
    String nome;
    int idade;

    Endereco endereco;
    
    abstract void apresentarse();
}
