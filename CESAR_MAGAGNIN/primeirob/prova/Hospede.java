package CESAR_MAGAGNIN.primeirob.prova;

public class Hospede extends Pessoa {
    public Hospede(String nome, int idade, String sexo) {
        super(nome, idade, sexo);
    }

    @Override
    public void apresentarse() {
       System.out.println("Nome: " + getNome() + "\nIdade: " + getIdade() + "\nSexo: " + getSexo());
    }
}

