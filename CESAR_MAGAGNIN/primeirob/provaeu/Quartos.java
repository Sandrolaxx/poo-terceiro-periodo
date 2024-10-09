package primeirob.provaeu;

public class Quartos {
    private int numeroQuarto;
    private String nome;
    private String tipo;
    private double valorDiaria;

    public Quartos(int numeroQuarto, String nome, String tipo, double valorDiaria) {
        this.numeroQuarto = numeroQuarto;
        this.nome = nome; //Executivo, Presidencial...
        this.tipo = tipo; // Casal, Solteiro ..
        this.valorDiaria = valorDiaria; 
    }

    public void gerarDescricao() {
        System.out.println("Quarto " + getNome() + "\nTipo: " + getTipo() + "\nValor diária: R$ " + getValorDiaria() + "\nNúmero do quarto: " + getNumeroQuarto());
        
        //JOptionPane.showMessageDialog(null, "ID: " + id + "\nNome: " + nome + "\nTipo: " + tipo + "\nValor: " + valor);
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

}
