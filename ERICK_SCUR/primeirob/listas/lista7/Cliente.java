package ERICK_SCUR.primeirob.listas.lista7;

import javax.swing.*;

class Cliente extends Pessoa {

    public Cliente(String nome, int idade, Endereco endereco) {
        super(nome, idade, endereco);
    }

    @Override
    public void apresentarse() {
        JOptionPane.showMessageDialog(null, "Nome: " + getNome() + "\nIdade: " + getIdade());
    }
}