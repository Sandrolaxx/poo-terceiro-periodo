package com.cellcoinapp.dto;

public class BoletoDTO {
    private String status;
    private String vencimento;
    private String valor;

    public BoletoDTO(String status, String vencimento, String valor) {
        this.status = status;
        this.vencimento = vencimento;
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "BoletoDTO{" +
                "status='" + status + '\'' +
                ", vencimento='" + vencimento + '\'' +
                ", valor='" + valor + '\'' +
                '}';
    }
}
