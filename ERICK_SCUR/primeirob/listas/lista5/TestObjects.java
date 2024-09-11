package ERICK_SCUR.primeirob.listas.lista5;

import javax.swing.*;

public class TestObjects {

    public static void main(String[] args) {
        Loja loja = criaLoja();
        Vendedor vendedor1 = criaVendedor1(loja);
        Vendedor vendedor2 = criaVendedor2(loja);
        Cliente cliente = criaCliente();

        loja.adicionaVendedor(vendedor1);
        loja.adicionaVendedor(vendedor2);
        loja.adicionaCliente(cliente);

        loja.apresentarse();
        loja.contarClientes();
        loja.contarVendedores();

        vendedor1.apresentarse();
        vendedor1.adicionaSalarioRecebido(2600);
        vendedor1.adicionaSalarioRecebido(2700);
        vendedor1.adicionaSalarioRecebido(2800);
        JOptionPane.showMessageDialog(null, "Média de salários: " + vendedor1.calcularMedia());
        JOptionPane.showMessageDialog(null, "Bônus: " + vendedor1.calcularBonus());

        vendedor2.apresentarse();
        vendedor2.adicionaSalarioRecebido(3200);
        vendedor2.adicionaSalarioRecebido(3300);
        vendedor2.adicionaSalarioRecebido(3400);
        JOptionPane.showMessageDialog(null, "Média de salários: " + vendedor2.calcularMedia());
        JOptionPane.showMessageDialog(null, "Bônus: " + vendedor2.calcularBonus());

        cliente.apresentarse();
    }

    public static Loja criaLoja() {
        return new Loja("Myy Plant", "Myy Plant LTDA", "00.123.456/0001-78", "Centro", "Bairro Central", "Rua Principal");
    }

    public static Vendedor criaVendedor1(Loja loja) {
        return new Vendedor("João", 25, loja, "Cidade A", "Bairro X", "Rua Y", 2500);
    }

    public static Vendedor criaVendedor2(Loja loja) {
        return new Vendedor("Maria", 30, loja, "Cidade B", "Bairro W", "Rua Z", 3000);
    }

    public static Cliente criaCliente() {
        return new Cliente("Carlos", 40, "Cidade A", "Bairro X", "Rua Y");
    }
}
