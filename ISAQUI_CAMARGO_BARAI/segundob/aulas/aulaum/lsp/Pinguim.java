package segundob.aulas.aulaum.lsp;

public class Pinguim extends Ave {

    @Override
    public void bicar() {
        System.out.println("Pinguim bicando!");
    }

    @Override
    public void voar() {
        throw new RuntimeException("Não sei voar!");
    }
    
}
