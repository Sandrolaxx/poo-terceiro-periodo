package segundob.aulas.aulaum.dip;

public class Main {
    
    public static void main(String[] args) {
        
        Order order = new Order();

        PgRepository pg = new PgRepository();
        OracleRepository oracle = new OracleRepository();


        GmailConfirmationEmail gmailSender = new GmailConfirmationEmail();
        OrderProcessor orderProcessor = new OrderProcessor();
        OrderProcessorDIP orderProcessorDIP = new OrderProcessorDIP(oracle, gmailSender);

        // orderProcessor.execute(order);
        orderProcessorDIP.execute(order);

    }

}
