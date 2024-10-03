package segundob.aulas.aulaum.isp;

public class Main {
    
    public static void main(String[] args) {
        
        Financeiro financeiro = new Financeiro();

        financeiro.gerarPDF();
        financeiro.gerarPlanilha();
        
        DateScience dateScience = new DateScience();

        dateScience.gerarPlanilha();
    }

}
