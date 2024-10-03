package segundob.aulas.aulaum.isp;

public class Financeiro implements IGerarRelatorioPlanilha, IGerarRelatorioPDF {

    @Override
    public void gerarPDF() {
        System.out.println("Financeiro gerando PDF");
    }

    @Override
    public void gerarPlanilha() {
        System.out.println("Financeiro gerando Planilha");
    }

}
