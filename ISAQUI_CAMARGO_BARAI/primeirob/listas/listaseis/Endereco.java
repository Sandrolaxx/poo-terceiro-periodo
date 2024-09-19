package ISAQUI_CAMARGO_BARAI.primeirob.listas.listaseis;

class Endereco {
    String estado;
    String cidade;
    String bairro;
    String rua;
    int numero;
    String complemento;

    Endereco(String estado, String cidade, String bairro, String rua, int numero, String complemento) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }

    void apresentarLogradouro() {
        System.out.println("Endereço: " + rua + ", " + numero + " - " + bairro + ", " + cidade + " - " + estado + " (" + complemento + ")");
    }
}
