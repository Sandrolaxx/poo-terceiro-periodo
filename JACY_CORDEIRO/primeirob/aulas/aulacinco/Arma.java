package JACY_CORDEIRO.primeirob.aulas.aulacinco;

public class Arma {
    private String nome;
    private String tipo;
    private String skin;
    private int dano;
    private double precisao;
    private int capacidadePente;

    public Arma(String nome, String tipo, String skin, int dano, double precisao, int capacidadePente) {
        this.nome = nome;
        this.tipo = tipo;
        this.skin = skin;
        this.dano = dano;
        this.precisao = precisao;
        this.capacidadePente = capacidadePente;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public double getPrecisao() {
        return precisao;
    }

    public void setPrecisao(double precisao) {
        this.precisao = precisao;
    }

    public int getCapacidadePente() {
        return capacidadePente;
    }

    public void setCapacidadePente(int capacidadePente) {
        this.capacidadePente = capacidadePente;
    }

    @Override
    public String toString() {
        return "Arma: " + nome + "\n" +
               "Tipo: " + tipo + "\n" +
               "Skin: " + skin + "\n" +
               "Dano: " + dano + "\n" +
               "Precisão: " + precisao + "\n" +
               "Capacidade do Pente: " + capacidadePente + "\n";
    }
}