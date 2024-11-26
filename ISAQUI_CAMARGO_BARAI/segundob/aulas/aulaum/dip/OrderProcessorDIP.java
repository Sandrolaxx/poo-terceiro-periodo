package segundob.aulas.aulaum.dip;

public class OrderProcessorDIP {

    private IDataBase dataBase;

    private IEmailSender emailSender;

    public OrderProcessorDIP(IDataBase dataBase, IEmailSender emailSender) {
        this.dataBase = dataBase;
        this.emailSender = emailSender;
    }

    public void execute(Order order) {

        dataBase.save(order);
        
        emailSender.sendConfirmationEmail(order);

    }

}
