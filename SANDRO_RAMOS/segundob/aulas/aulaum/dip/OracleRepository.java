package segundob.aulas.aulaum.dip;

public class OracleRepository implements IDataBase {

    @Override
    public boolean save(Order order) {
        System.out.println("Salvando pedido Oracle");

        return true;
    }

}
