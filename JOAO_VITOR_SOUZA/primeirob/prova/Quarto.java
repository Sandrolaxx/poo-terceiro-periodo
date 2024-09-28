import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Quarto {
    private String numeroquarto;

    private LocalDate Diarias;

    public Quarto(String numeroquarto) {
        this.numeroquarto = numeroquarto;
    }


    public String getNumeroquarto() {
        return numeroquarto;
    }


    public void setNumeroquarto(String numeroquarto) {
        this.numeroquarto = numeroquarto;
    }


}
public long calcularDiarias() {
    LocalDate hoje = LocalDate.now();
    if (hoje.isAfter(Diarias)) {
        return ChronoUnit.DAYS.between(Diarias, hoje);
    }
    return 0;
}

public double calcularDiarias() {
    long Diarias = calcularDiarias();
    return Diarias  *7;  
}



    



