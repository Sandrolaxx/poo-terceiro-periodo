package ERICK_SCUR.primeirob.listas.lista7;

import javax.swing.*;

class Item {
    private int id;
    private String nome;
    private String tipo;
    private double valor;

    public Item(int id, String nome, String tipo, double valor) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    public void gerarDescricao() {
        JOptionPane.showMessageDialog(null, "ID: " + id + "\nNome: " + nome + "\nTipo: " + tipo + "\nValor: " + valor);
    }

    public double getValor() {
        return valor;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }
}