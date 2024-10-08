package CESAR_MAGAGNIN.primeirob.provaeu;

import java.util.List;
public class Hotel {
    private String nomeFantasia;
    private String cnpj;
    private Endereco endereco;
    private List<Quartos> quartos;
    private List<Hospede> hospedes;

    public Hotel(String nomeFantasia, String cnpj, Endereco endereco) { 
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }
    public String getNomeFantasia() {
        return nomeFantasia;
    }
    public String getCnpj(){
        return cnpj;
    }
    public Endereco getEndereco(){
        return endereco;
    }
    public List<Quartos> getQuartos(){
        return quartos;
    }
    public List<Hospede> hospedes(){
        return hospedes;
    }

}
