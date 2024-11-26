package com.cellcoinapp.dto;

public class ConvenioDTO {
    private String nome;
    private String uf;
    private String codigo;

    public ConvenioDTO(String nome, String uf, String codigo) {
        this.nome = nome;
        this.uf = uf;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "ConvenioDTO{" +
                "nome='" + nome + '\'' +
                ", uf='" + uf + '\'' +
                ", codigo='" + codigo + '\'' +
                '}';
    }
}
