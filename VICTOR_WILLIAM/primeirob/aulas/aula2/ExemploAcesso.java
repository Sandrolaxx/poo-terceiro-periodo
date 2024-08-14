package VICTOR_WILLIAM.primeirob.aulas.aula2;

public class ExemploAcesso {
    // private eh o mais restritivo, so pode ser acessado dentro da propria classe
    private int idade;
    // protected pode ser acessado por classes do mesmo pacote e classes filhas
    protected int idadeDois = 20;
    // protected final nao pode ser alterado, mas pode ser acessado por classes do mesmo pacote e classes filhas
    protected final int VALOR_IMUTAVEL = 666;
    // protected final static nao pode ser alterado, mas pode ser acessado por classes do mesmo pacote e classes filhas
    protected final static int VALOR_IMUTAVEL_STATIC = 616;
}
