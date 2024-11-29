package br.com.skafikis.idetities;

public class BarCodeRequest {
    private String externalTerminal;
    private Long externalNSU;
    private BarCode barCode;

    public BarCodeRequest(String externalTerminal, Long externalNSU, BarCode barCode) {
        this.externalTerminal = externalTerminal;
        this.externalNSU = externalNSU;
        this.barCode = barCode;
    }
}
