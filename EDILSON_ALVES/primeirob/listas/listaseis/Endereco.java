package EDILSON_ALVES.primeirob.listas.listaseis;

public class Endereco {
    public String estado;
    public String cidade; 
    public String bairro;
    public int numero;
    public String complemento;
    
    public Endereco(String estado, String cidade, String bairro, int numero, String complemento) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
    }
}
