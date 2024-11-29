package segundob.aulas.aulaum.dip;

public class GmailConfirmationEmail implements IEmailSender {

    @Override
    public void sendConfirmationEmail(Order order) {
        //Conecta SMTP
        //Envia o email
        System.out.println("Enviando e-mail com GMAIL");
    }


}
