package segundob.aulas.aulaum.dip;

public class OrderProcessor {

    public void execute(Order order) {

        PgRepository pgRepo = new PgRepository();
        GmailConfirmationEmail gmailEmail = new GmailConfirmationEmail();

        pgRepo.save(order);
        gmailEmail.sendConfirmationEmail(order);

    }

}
