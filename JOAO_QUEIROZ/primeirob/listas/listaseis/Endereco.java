public class Endereco {
    public String estado;
    public String cidade;
    public String bairro;
    public int numero;
    public String complemento;

    public void inicializarEndereco() {
        estado = "PR";
        cidade = "Maringa";
        bairro = "Centro";
        numero = 123;
        complemento = "Apartamento 45";
    }
    public void apresentarLogradouro() {
        System.out.println("Endereço: " + bairro + ", " + cidade + ", " + estado + ", Número: " + numero + " (" + complemento + ")");
    }
}
