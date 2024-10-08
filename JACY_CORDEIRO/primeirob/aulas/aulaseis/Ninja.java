package JACY_CORDEIRO.primeirob.aulas.aulaseis;

public class Ninja {
    private String nome;
    private int idade;
    private String aldeia;
    private String equipamento;
    private String nomeJusto;

    // Construtor
    public Ninja(String nome, int idade, String aldeia, String equipamento, String nomeJusto) {
        this.nome = nome;
        this.idade = idade;
        this.aldeia = aldeia;
        this.equipamento = equipamento;
        this.nomeJusto = nomeJusto;
    }

    // Métodos getters
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getAldeia() {
        return aldeia;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public String getNomeJusto() {
        return nomeJusto;
    }

    // Método para exibir informações do ninja
    public void exibirInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Aldeia: " + aldeia);
        System.out.println("Equipamento: " + equipamento);
        System.out.println("Nome Justo: " + nomeJusto);
    }
}
