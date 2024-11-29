package domain.entities;

public class BarCode {
    int type;
    String digitable;

    public BarCode(int type, String digitable) {
        this.type = type;
        this.digitable = digitable;
    }
}
