package segundob.aulas.aulaum.dip;

public class PgRepository implements IDataBase {

    @Override
    public boolean save(Order order) {
        System.out.println("Salvando pedido PG");

        return true;
    }

}
